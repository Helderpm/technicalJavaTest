package com.company.main;

public enum Color {
    /*
        * Couleur, valeurs possibles : 'R' = Rouge; 'G' = Vert; 'B' = Bleu
   */

    R("Rouge"), G("Vert"), B("Bleu");

    private final String couleur;

    Color(final String color) {
        this.couleur = color;
    }
}
