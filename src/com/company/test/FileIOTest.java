package com.company.test;

import com.company.main.Color;
import com.company.main.FileIO;
import com.company.main.Produit;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileIOTest {

    public static final String FILENAME = "testFile/inputFile.txt";
    public static final String FILENAMETEST = "inputFileTest.txt";

    @Test
    public void testLectureFile() {
        FileIO fileIO = new FileIO();
        int lines = fileIO.lectureFile(FILENAME).size();
        assertEquals(5, lines);
    }

    @Test
    public void testWriteJsonToFile() {

        Produit produit = new Produit((long) 1460100040, Color.B,45.12,27);
        JSONObject jsonObject = produit.toJsonObject();

        FileIO fileIO = new FileIO();
        // size of a file (in bytes)
        int result = (int) fileIO.writeJsonToFile(jsonObject, FILENAMETEST).length();
        assertEquals( 62, result);
        fileIO.writeJsonToFile(jsonObject, FILENAMETEST).deleteOnExit();
    }

}