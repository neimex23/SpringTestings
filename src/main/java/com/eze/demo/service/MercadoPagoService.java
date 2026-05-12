package com.eze.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.eze.demo.entity.MPResponse;
import com.eze.demo.entity.PruebaConcepto.OrdenPC;
import com.eze.demo.entity.PruebaConcepto.ProductoPC;
import com.eze.demo.entity.PruebaConcepto.DTOs.DTOProductoPC;
import com.mercadopago.client.preference.PreferenceBackUrlsRequest;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;

@Service
public class MercadoPagoService {

    private final OrdenesService ordenesService;

    public MercadoPagoService(OrdenesService ordenesService) {
        this.ordenesService = ordenesService;
    }

    public MPResponse crearOrden(List<DTOProductoPC> products) {
          
        List<PreferenceItemRequest> items = products.stream()
            .map(dto -> PreferenceItemRequest.builder()
                .currencyId("UYU")
                .title(dto.getDescription())  
                .description(dto.getDescription())
                .quantity(dto.getCantidad())
                .unitPrice(dto.getPrecio())  
                .pictureUrl(dto.getPictureUrl())
                .categoryId(dto.getCategoryId())
                .build())
            .toList();
        
        PreferenceBackUrlsRequest backUrls = PreferenceBackUrlsRequest.builder()
            .success("http://localhost:3000/success")
            .failure("http://localhost:3000/failure")
            .pending("http://localhost:3000/pending")
            .build();


        PreferenceRequest preferenceRequest = PreferenceRequest.builder()
            .items(items)
            .notificationUrl("https://webhook.site/d843dc6e-6757-413c-adc0-36bdc5616d8d")
            //.backUrls(backUrls)
            .build();

        
        try {
            PreferenceClient client = new PreferenceClient();
            Preference preference = client.create(preferenceRequest);
            
            OrdenPC newOrden = new OrdenPC(
                preference.getId(),
                items.stream().map(item -> new ProductoPC(
                    item.getTitle(),
                    item.getUnitPrice(),
                    item.getQuantity(),
                    item.getPictureUrl(),
                    item.getCategoryId()
                )).toList()
            );
            ordenesService.guardar(newOrden);

            return new MPResponse(
                preference.getId(),
                preference.getInitPoint(),
                preference.getSandboxInitPoint()
            );
        } catch (MPApiException e) {
        throw new RuntimeException(
            "MP ERROR: " + e.getApiResponse().getContent(),
            e
        );
        } catch (MPException e) {

            throw new RuntimeException(
                "MP GENERAL ERROR: " + e.getMessage(),
                e
            );
        }
    }
    
}
