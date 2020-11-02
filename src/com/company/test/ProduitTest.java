package com.company.test;

import com.company.main.Color;
import com.company.main.Produit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProduitTest {

    @Test
    void toJsonObject() {

        Produit produit = new Produit((long) 1460100040, Color.B,45.12,27);
        String strResult = "{\"size\":27,\"price\":45.12,\"numReference\":1460100040,\"type\":\"B\"}";

        assertEquals( strResult, produit.toJsonObject().toString());
    }
}