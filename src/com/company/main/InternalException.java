package com.company.main;

import org.json.simple.JSONObject;
/*
 * La class 'InternalException' gestion des exption lors de la lecture du fichiers
 * */
public class InternalException extends Exception {

    private final int numLine;
    private final String messageError;
    private final String value;

    public InternalException(final int value, final String messageError, final String line) {
        this.numLine = value;
        this.messageError = messageError;
        this.value = line;
    }

    private int getNumLine() {
        return numLine;
    }

    private String getMessageError() {
        return messageError;
    }

    private String getValue() {
        return value;
    }

    public JSONObject toJsonObject() {
        // Creating a JSONObject object
        JSONObject jsonObject = new JSONObject();
        // Inserting key-value pairs into the json object
        jsonObject.put("Line", this.getNumLine());
        jsonObject.put("size", this.getMessageError());
        jsonObject.put("value", this.getValue());

        return jsonObject;
    }
}
