package com.company.main;

import org.json.simple.JSONObject;

public class Produit {

    /*
    Produit est :
    * Numéro de la référence (10 chiffres)
    * Couleur, valeurs possibles : R = Rouge G = Vert B = Bleu
    * Prix, valeur en euros (ex : 5.23)
    * Taille, valeur entière
    */
    private final Long reference;
    private final Color color;
    private Double price = 0.0;
    private int size = 0;

    public Produit(final Long reference, final Color color, final Double price, final int size) {
        this.reference = reference;
        this.color = color;
        this.price = price;
        this.size = size;
    }

    private Long getReference() {
        return reference;
    }

    private Color getColor() {
        return color;
    }

    private Double getPrice() {
        return price;
    }

    private int getSize() {
        return size;
    }

  public JSONObject toJsonObject() {
    // Creating a JSONObject object
    JSONObject jsonObject = new JSONObject();
    // Inserting key-value pairs into the json object
    jsonObject.put("numReference", this.getReference());
    jsonObject.put("size", this.getSize());
    jsonObject.put("price", this.getPrice());
    jsonObject.put("type", this.getColor().toString());

    return jsonObject;
    }

}


