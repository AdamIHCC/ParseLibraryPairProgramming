/*
    Library pair programming assignment
    Andrea Rottman and Syl Carnicle-Maile
    Completed 12/4/23
 */

package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ParseLibrary parseLibrary = new ParseLibrary("library.xml");
        ArrayList<Author> authors = parseLibrary.getAuthors();
        for (Author a: authors){
            System.out.println(a);
        }
    }
}