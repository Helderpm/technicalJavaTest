package com.company.main;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/*
 * La class 'References' inicialize la lecture du fichiers et
 * organize les objects qui result de la lecture dans une estrure JSON
 * cette estruture va etre ecrite dans un fichiers avec le noms fournie
 * */

public class References {

    private final String fileNameIn;
    private final String fileNameOut;

    public References(final String filename, final String fileNameOut) {
        this.fileNameIn = filename;
        this.fileNameOut = fileNameOut;
    }

    private String getFileNameIn() {
        return fileNameIn;
    }

    public File init(){
        FileIO fileIO = new FileIO();

        List<String> list = fileIO.lectureFile(fileNameIn);

        List<InternalException> internalExceptionList = new ArrayList<>();
        List<Produit> produitList = getProduitList(internalExceptionList, list);

        return fileIO.writeJsonToFile(getJSONObjectFormated(internalExceptionList, produitList), fileNameOut);
    }

    private List<Produit> getProduitList(final List<InternalException> internalExceptionList, final List<String> list) {
        return list.stream().map(str -> {
            try{
                String[] splitted = str.split(";");
                long reference = Long.parseLong(splitted[0]);
                Color color = Color.valueOf(splitted[1]);
                Double price = Double.valueOf(splitted[2]);
                int size = Integer.parseInt(splitted[3]);
                return new Produit(reference, color, price, size);
            } catch (java.lang.Exception e) {
                internalExceptionList.add(new InternalException(list.indexOf(str)+1, " Incorrect value for color", list.get(list.indexOf(str))));
            }
            return null;
        }).filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private JSONObject getJSONObjectFormated(final List<InternalException> internalExceptionList, final List<Produit> produitList) {
        JSONObject jsonObject = new JSONObject();
        //Inserting key-value pairs into the json object
        jsonObject.put("inputFile", this.getFileNameIn());
        jsonObject.put("references", getReferenceJsonArray(produitList));
        jsonObject.put("errors", getErrorJsonArray(internalExceptionList));

        return jsonObject;
    }

    private JSONArray getErrorJsonArray(final List<InternalException> internalExceptionList) {
        JSONArray errorList = new JSONArray();
        for(InternalException internalException : internalExceptionList){
            errorList.add(internalException.toJsonObject());
        }
        return errorList;
    }

    private JSONArray getReferenceJsonArray(final List<Produit> produitList) {
        JSONArray referenceList = new JSONArray();
        for(Produit produit : produitList){
            referenceList.add(produit.toJsonObject());
        }
        return referenceList;
    }


}
