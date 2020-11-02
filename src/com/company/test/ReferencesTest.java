package com.company.test;

import com.company.main.References;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReferencesTest {

    public static final String OUTPUT_JSON_FILE_JSON = "outputJSonFileTest.json";

    @Test
    void init() {
        References references = new References("testFile/inputFile.txt", OUTPUT_JSON_FILE_JSON);

        File fileWriter = references.init();

        if (fileWriter.exists()) {
            // size of a file (in bytes)
            int result = (int) fileWriter.length();
            assertEquals( 395, result);
            fileWriter.deleteOnExit();
        }
    }
}