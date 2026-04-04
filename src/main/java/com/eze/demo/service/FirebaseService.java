package com.eze.demo.service;

import org.springframework.stereotype.Service;

import com.eze.demo.entity.TestModel;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class FirebaseService {
    public void testConnection() {
        Firestore db = FirestoreClient.getFirestore();

        db.collection("test")
        .document("doc1")
        .set(new TestModel("Hola Firebase"));
    }
}
