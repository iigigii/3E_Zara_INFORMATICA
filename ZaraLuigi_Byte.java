//Surname and name: Zara Luigi
//Class 3E
//Date: 4 December 2023

import javax.swing.*;
import java.util.Scanner;

public class Byte {
    public static void main(String[] args) {

        Scanner tastiera = new Scanner(System.in);

        String numero = "";
        boolean flagByte = true;
        int valChar = (int)'0';
        char valInt = (char)49;


        System.out.println(valChar);
        System.out.println(valInt);
        valChar = valInt - '0';
        System.out.println(valChar);
        // per casa convertire il valore binario in decimale

        System.out.println("inserisci un byte: ");
        numero = tastiera.nextLine();

        if (numero.length() != 8) {
            System.out.println("Non e' un byte");
        }
        else {
            for (int indice = 0; indice < numero.length(); indice++) {
                System.out.println(numero.charAt(indice));

                if (!(numero.charAt(indice) == '1' || numero.charAt(indice) == '0')) {
                    flagByte = false;
                }
            }

            if (flagByte) {
                System.out.println("E' un byte");
            }else {
                System.out.println("Non e' un byte");
            }
        }
    }
}
