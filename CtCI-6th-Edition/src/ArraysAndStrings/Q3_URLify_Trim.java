package ArraysAndStrings;

import java.sql.SQLOutput;
import java.util.Scanner;

class Q3_URLify1 {
    static class Trim {
        public static void main(String[] args) {
            String str = "Mr John Smith   ";

            // Trim the given string
            str = str.trim();

            // Replace All space (unicode is \\s or \u0020) to %20
            str = str.replaceAll("\\u0020", "%20");

            // Display the result
            System.out.println("\""+ str + "\"");
        }
    }
}