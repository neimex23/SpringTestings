package com.eze.demo.service;

import org.springframework.stereotype.Service;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class FirebaseService {
    public void testConnection() {
        Firestore db = FirestoreClient.getFirestore();

        db.collection("test")
        .document("doc1");
        //.set(new TestModelPC("Hola Firebase"));
    }
}
