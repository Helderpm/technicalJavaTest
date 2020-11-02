package com.company.main;


import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * La class 'FileIO' a la fonction de lire le fichier dans le chemin '.app'/../resources
 * avec le noms indiquer.
 * Et écrire dans le chemin '.dir/tmp' avec le resulta reçu avec le nom transmi
 * */

public class FileIO {

    private static final Logger LOGGER = Logger.getLogger( FileIO.class.getName() );


    public List<String> lectureFile(final String filename) {
        ClassLoader classLoader = FileIO.class.getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource(filename)).getFile());
        if (file.exists() && file.canRead()) {
            try (Stream<String> stream = Files.lines(Path.of(file.getPath()))) {
                return stream.collect(Collectors.toList());
            } catch (IOException e) {
                String msgError = "Error to read file: "+filename;
                LOGGER.log( Level.SEVERE,  msgError);
            }
        } else {
            String msgIOError = "File does not exist or it cannot be read.";
            LOGGER.log( Level.SEVERE, msgIOError);

        }
        return new ArrayList<>();
    }

    public File writeJsonToFile(final JSONObject jsonObject, final String fileName) {
        // uses .dir/tmp
        String tempDirectoryPath = System.getProperty("java.io.tmpdir");
        String pathFile = tempDirectoryPath + fileName;
        try {
            FileWriter file = new FileWriter(pathFile);
            file.write(jsonObject.toJSONString());
            file.close();
            return new File(pathFile);
        } catch (IOException e) {
            String msgError = "Can't white/or create file on path : "+ pathFile;
            LOGGER.log( Level.SEVERE,  msgError);
        }

        return null;
    }

}
