//Surname and name: Zara Luigi
//Class 3E
//Date: 4 December 2023

import java.util.Scanner;

public class Sequenza {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        int numero;
        int numeroCalcoli;

        int cifra0 = 0;
        int cifra1 = 0;
        int cifra2 = 0;
        int cifra3 = 0;
        int cifra4 = 0;
        int cifra5 = 0;
        int cifra6 = 0;
        int cifra7 = 0;
        int cifra8 = 0;
        int cifra9 = 0;

        int cifraCorrente;


        /*
        Metodo 1
        int qtaNumeri = 0;

        do {
            System.out.print(":");
            numero = keyboard.nextInt();
            qtaNumeri++;
        } while(numero != 0);

        if(qtaNumeri == 1)
            System.out.println("Sequenza vuota.");
        */

        System.out.println("Inserire una sequenza di numeri chiusa da uno 0");
        numero = keyboard.nextInt();

        if(numero == 0)
            System.out.println("Sequenza vuota.");
        else {
            do {
                cifra0 = 0;
                cifra1 = 0;
                cifra2 = 0;
                cifra3 = 0;
                cifra4 = 0;
                cifra5 = 0;
                cifra6 = 0;
                cifra7 = 0;
                cifra8 = 0;
                cifra9 = 0;

                numeroCalcoli = numero;

                while(numeroCalcoli > 0){
                    cifraCorrente = numeroCalcoli % 10;
                    numeroCalcoli = numeroCalcoli / 10;

                    if(cifraCorrente == 0)
                        cifra0++;
                    else if(cifraCorrente == 1)
                        cifra1++;
                    else if(cifraCorrente == 2)
                        cifra2++;
                    else if(cifraCorrente == 3)
                        cifra3++;
                    else if(cifraCorrente == 4)
                        cifra4++;
                    else if(cifraCorrente == 5)
                        cifra5++;
                    else if(cifraCorrente == 6)
                        cifra6++;
                    else if(cifraCorrente == 7)
                        cifra7++;
                    else if(cifraCorrente == 8)
                        cifra8++;
                    else if(cifraCorrente == 9)
                        cifra9++;

                    if(cifra0 > 0)
                        System.out.println("Frequenza cifra 0 : " + cifra0);
                    if(cifra1 > 0)
                        System.out.println("Frequenza cifra 1 : " + cifra1);
                    if(cifra2 > 0)
                        System.out.println("Frequenza cifra 2 : " + cifra2);
                    if(cifra3 > 0)
                        System.out.println("Frequenza cifra 3 : " + cifra3);
                    if(cifra4 > 0)
                        System.out.println("Frequenza cifra 4 : " + cifra4);
                    if(cifra5 > 0)
                        System.out.println("Frequenza cifra 5 : " + cifra5);
                    if(cifra6 > 0)
                        System.out.println("Frequenza cifra 6 : " + cifra6);
                    if(cifra7 > 0)
                        System.out.println("Frequenza cifra 7 : " + cifra7);
                    if(cifra8 > 0)
                        System.out.println("Frequenza cifra 8 : " + cifra8);
                    if(cifra9 > 0)
                        System.out.println("Frequenza cifra 9 : " + cifra9);
                }

                numero = keyboard.nextInt();
            } while(numero != 0);
        }
    }
}
