package com.company.main;

public class Main {
/*
* La class 'Main' contint les noms des fichier de entrer et de sortie
* Inicialization de class 'References' avec les params des noms de fichiers et
* inicialization du traitement du fichier entré
* */
    public static final String FILENAME = "inputFile.txt";
    public static final String OUTPUT_FILE = "outputJSonFile.json";

    public static void main(String[] args) {
	// write your code here
        References references = new References(FILENAME, OUTPUT_FILE);
        references.init();
    }//End Main
}
