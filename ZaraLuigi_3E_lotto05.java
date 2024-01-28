//Zara Luigi
//classe 3E
//Data 28 Gennaio 2024

/* Giocata utente: l'utente punta 5 numeri sulla ruota di Venezia
 * lista spesa: array di 5 elementi
 * controllo se valori inseriti sono compresi tra 1 e 90
 * controllo che un numero venga inserito una sola volta
 * controllo che vengano inseriti 5 valori, non di più non di meno
 * Visualizza giocate: lista della spesa
 * menu di scelta, opzioni2 (Venezia, Giocatore)
 */

//importazione librerie
import java.util.Scanner;
import java.util.Random;

public class Lotto05 {
    public static void main(String[] args) {
        //dichiarazione scanner
        Scanner tastiera = new Scanner(System.in);

        //Dichiarazione e inizializzazione varaibili
        int scelta = 0;

        String[] opzioni = {"=== Gioco Dadi === ",
                "[1] Estrazioni ruota di Venezia",
                "[2] Giocata utente",
                "[3] Verifica vincita",
                "[4] Visualizza giocate"};

        int[] numeriEstratti = new int[5];  // Array per memorizzare i numeri che sono stati estratti
        int[] numeriGiocati = new int[5];   // Array per memorizzare i numeri che sono stati giocati

        //menu' output
        System.out.println(Menu(opzioni, tastiera));
        Wait(5000);

        do {
            scelta = Menu(opzioni, tastiera);
            switch (scelta) {
                case 1:
                    numeriEstratti = EstrazioneRuota();
                    System.out.println(" I numeri estratti sono: ");
                    for (int numero : numeriEstratti) {
                        System.out.print(numero + " ");
                    }
                    //wait 2 secondi
                    Wait(2000);
                    break;
                case 2:
                    numeriGiocati = giocaUtente(tastiera);
                    System.out.println("Hai giocato questi numeri: ");
                    for (int numero : numeriGiocati) {
                        System.out.print(numero + " " );
                    }
                    //wait 2 secondi
                    Wait(2000);
                    break;
                case 3:
                    verificaVincita(numeriEstratti, numeriGiocati);
                    break;
                case 4:
                    visualizza(numeriEstratti, numeriGiocati);
                    Wait(2000);
                    break;
            }
        } while(scelta !=0);
    }

    //menu'
    private static int Menu (String opzioni[], Scanner tastiera)
    {
        int scelta;

        do {
            //clear screen
            ClrScr();
            System.out.println("------------------");
            System.out.println(opzioni[0]); //(opzioni[0]) shows what the string contains
            System.out.println("------------------");
            for (int i=1; i < opzioni.length; i++) {
                System.out.println(opzioni[i]);
            }
            scelta = tastiera.nextInt();

            //if the user choose a number < 1 or > opzioni.lenght, the choose is invalid
            if ((scelta < 1 ) || (scelta > opzioni.length -1 ))
            {
                //the option is innvalid, try again
                System.out.println("Opzione Sbagliata");
                Wait(1000);
            }
        }
        while ((scelta < 1 ) || (scelta > opzioni.length -1 ));
        return scelta;
    }
    private static int[] EstrazioneRuota() {
        //dichiarazione e inizializzazione variabili
        int extractnumbers[] = new int[5];

        //dichiarazione random
        Random casuale = new Random();
        for (int i = 0; i < extractnumbers.length; i++) {
            extractnumbers[i] = casuale.nextInt(90) + 1;
        }
        return extractnumbers;
    }

    //metodo gioca utente
    private static int[] giocaUtente(Scanner tastiera) {
        //dichiarazione e inizializzazione variabili
        int playernumber[] = new int[5];
        int countNumber=1;
        for (int i = 0; i < playernumber.length; i++) {
            do {
                System.out.println("Inserisci il " + countNumber + "°  numero compreso nella ruota di Venezia");
                playernumber[i] = tastiera.nextInt();
                //se il numero del giocatore è < di 90 e/o > 1 : countnumber++
                if(playernumber[i] <= 90 && playernumber[i] >= 1) {
                    countNumber++;
                }
                else{
                    System.out.println("Hai inserito un numero non valido.");
                    System.out.println("Reinserisci un numero compreso tra 1 e 90: ");
                }
            }while(playernumber[i]>90||playernumber[i]<1);
        }
        return playernumber;
    }

    //metodo verifica vincita
    private static void verificaVincita(int[] numeriEstratti, int[] numeriGiocati) {
        //dichiarazione e inizializzazione variabili
        int numeriIndovinati = 0;
        for (int numeroGiocato : numeriGiocati) {
            for (int numeroEstratto : numeriEstratti) {
                if (numeroGiocato == numeroEstratto) {
                    numeriIndovinati++;
                    break;
                }
            }
        }
        //mostro in ouput i numeri che l'utente ha indovinato sulla ruota di venezia
        System.out.println("Hai indovinato " + numeriIndovinati + " numeri della ruota di Venezia");
    }

    //metodo visualizza
    private static void visualizza(int[] numeriEstratti, int[] numeriGiocati) {
        System.out.println("Numeri estratti: ");
        for (int numero : numeriEstratti) {
            System.out.print(numero + " ");
        }
        System.out.println("\nNumeri giocati: ");
        for (int numero : numeriGiocati) {
            System.out.print(numero + " ");
        }
    }

    //clear screen
    private static void ClrScr() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //wait
    private static void Wait(int attesa) {
        try {
            Thread.sleep(attesa);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}