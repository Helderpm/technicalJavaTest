package com.company.test;

import com.company.main.InternalException;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InternalExceptionTest {
    @Test
    void toJsonObject() {

        InternalException internalException = new InternalException(1, "Incorrect value for color", "1462100403;A;100.1;9");

        JSONObject jsonObject = internalException.toJsonObject();
        String strResult = "{\"Line\":1,\"size\":\"Incorrect value for color\",\"value\":\"1462100403;A;100.1;9\"}";
        assertEquals( strResult, jsonObject.toString());
    }
}