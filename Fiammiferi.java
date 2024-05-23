//Zara Luigi
//Classe 3E
/*
Il gioco dei 21 fiammiferi è una gara tra due
giocatori che, a turno, possono prelevare,
dall’insieme iniziale dei 21 fiammiferi, da 1 a 3
fiammiferi.
Il gioco e vinto dal giocatore che preleva l’ultimo
fiammifero.
*/

//importazione librerie
import javax.swing.plaf.metal.MetalRootPaneUI;
import static Utility.Tools.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Fiammiferi {
    public static void main(String[] args) {
        //dichiarazione scanner
        Scanner keyboard = new Scanner(System.in);

        // dichiarazione e inizializzazione variabhili
        String strErrore = "InsertData";
        boolean quit = true;
        final int numeroFiammiferi = 21;

        //menù opzioni
        String[] opzioni = {
                "GIOCO FIAMMIFERI",
                "[1] - Giocatore contro Giocatore",
                "[2] - Giocatore contro PC",
                "[3] - PC vince sempre",
                "[4] - Quit"
        };

        //stampo i fiammieri
        for(int i = 0; i < numeroFiammiferi; i++){
            System.out.print("* ");
        }
        System.out.println();
        for(int i = 0; i < numeroFiammiferi; i++){
            System.out.print("| ");
        }

        //switch-case
        do {
            switch (printMenu(opzioni, keyboard)) {
                case 1:
                    //istanzio il vettore
                    boolean[] fiammieriPresenti = new boolean[numeroFiammiferi];


                    //giocatore 1
                    System.out.println("==== Giocatore 1 ====");
                    System.out.println("Quanti fiammiferi vuoi togliere? (MAX 3)");
                    int qtaFiammireri1 = keyboard.nextInt();

                    //controllo
                    if(qtaFiammireri1 > 3){
                        do {
                            System.out.println("Attenzione!! NON puoi togliere più di 3 fiammiferi");
                            qtaFiammireri1 = keyboard.nextInt();
                        }while(qtaFiammireri1 > 3);
                    }
                    //fiammieri rimanenti
                    int fiammiferiRimanenti = numeroFiammiferi - qtaFiammireri1;

                    System.out.println("fiammiferi rimanenti:");
                    //stampo i fiammieri rimanenti
                    for(int i = 0; i < fiammiferiRimanenti; i++){
                        System.out.print("* ");
                    }
                    System.out.println();
                    for(int i = 0; i < fiammiferiRimanenti; i++){
                        System.out.print("| ");
                    }

                    //new paragraph
                    System.out.println("\n");

                    //giocatore 1
                    System.out.println("==== Giocatore 2 ====");
                    System.out.println("Quanti fiammiferi vuoi togliere? (MAX 3)");
                    int qtaFiammireri2 = keyboard.nextInt();

                    //controllo
                    if(qtaFiammireri2 > 3){
                        do {
                            System.out.println("Attenzione!! NON puoi togliere più di 3 fiammiferi");
                            qtaFiammireri2 = keyboard.nextInt();
                        }while(qtaFiammireri2 > 3);
                    }

                    //fiammieri rimanenti
                    int fiammiferiRimanenti2 = 0;
                    while(numeroFiammiferi == 0){
                        fiammiferiRimanenti =  numeroFiammiferi - qtaFiammireri1 - qtaFiammireri2;
                    }

                    System.out.println("fiammiferi rimanenti:");
                    //stampo i fiammieri rimanenti
                    for(int i = 0; i < fiammiferiRimanenti2; i++){
                        System.out.print("* ");
                    }
                    System.out.println();
                    for(int i = 0; i < fiammiferiRimanenti2; i++){
                        System.out.print("| ");
                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("arrivederciZ");
                    break;
            }
        } while (true);
    }


    //metodo giocatore vs giocatore
    private static void giocatoreVsGiocatore(Scanner keyboard, int numeroFiammiferi) {

    }

    //metodo giocatore vs computer
    private static void giocatoreVscomputer(Scanner keyboard, int numeroFiammiferi) {

    }

    //metodo computer vince sempre
    private static void computerVscomputer(Scanner keyboard, int numeroFiammiferi) {

    }
}