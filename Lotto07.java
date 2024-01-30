//Zara Luigi
//classe 3E
//Data 30 Gennaio 2024

/* Giocata utente: l'utente punta 5 numeri sulla ruota di Venezia
 * realizzare estrazioni ruota usando v. booleane
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

public class Lotto07 {
    public static void main(String[] args) {
        //dichiarazione scanner
        Scanner tastiera = new Scanner(System.in);

        //Dichiarazione e inizializzazione varaibili
        int scelta = 0;
        boolean exit = true;

        //string menu'
        String[] opzioni = {"======= Estrazioni Lotto ======= ",
                "[1] Estrazioni ruota di Venezia",
                "[2] Estrazioni ruota di Venezia con v. booleana",
                "[3] Giocata utente",
                "[4] Verifica vincita",
                "[5] Visualizza giocate",
                "[6] exit"};

        //dichiarazione e inizializzazione vettori
        int[] numeriEstratti = new int[5];  // Array per memorizzare i numeri che sono stati estratti
        int[] numeriGiocati = new int[5];   // Array per memorizzare i numeri che sono stati giocati

        //chiamo il metodo menu'
        System.out.println(Menu(opzioni, tastiera));
        Wait(2500);

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
                    numeriEstratti = EstrazioneRuota2();
                    System.out.println(" I numeri estratti sono: ");
                    for (int numero : numeriEstratti) {
                        System.out.print(numero + " ");
                    }
                    //wait 2 secondi
                    Wait(2000);
                    break;
                case 3:
                    numeriGiocati = giocaUtente(tastiera);
                    System.out.println("Hai giocato questi numeri: ");
                    for (int numero : numeriGiocati) {
                        System.out.print(numero + " " );
                    }
                    //wait 2 secondi
                    Wait(2000);
                    break;
                case 4:
                    verificaVincita(numeriEstratti, numeriGiocati);
                    break;
                case 5:
                    visualizzaGiocata(numeriEstratti, numeriGiocati);
                    Wait(2000);
                    break;
                case 6:
                    exit = false;
                    break;
            }
        } while(exit);
    }

    //metodo menu'
    private static int Menu (String opzioni[], Scanner tastiera)
    {
        int scelta;

        do {
            //clear screen
            ClrScr();
            System.out.println("\n");
            System.out.println("---------------------------------");
            System.out.println(opzioni[0]); //(opzioni[0]) shows what the string contains
            System.out.println("---------------------------------");
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

    //estrazioneRuota
    private static int[] EstrazioneRuota() {
        //dichiarazione e inizializzazione variabili e vettori
        int extratnumeri[] = new int[5];

        //dichiarazione random
        Random casuale = new Random();

        //popolo il vettore con numeri casuali
        for (int i = 0; i < extratnumeri.length; i++) {
            extratnumeri[i] = casuale.nextInt(90) + 1;
        }
        return extratnumeri;
    }


    //estrazione ruota con v. booleane
    private static int[] EstrazioneRuota2() {
        // Dichiarazione e inizializzazione vettori
        int extractnumbers[] = new int[5];
        boolean numeriEstratti[] = new boolean[91]; // Array booleano per tracciare i numeri già estratti

        // Dichiarazione di una variabile random
        Random casuale = new Random();

        for (int i = 0; i < extractnumbers.length; i++) {
            int numeroEstratto;
            do {
                numeroEstratto = casuale.nextInt(90) + 1;
            } while (numeriEstratti[numeroEstratto]); // Ripeti finché il numero è già stato estratto

            extractnumbers[i] = numeroEstratto;
            numeriEstratti[numeroEstratto] = true; // Segna il numero come estratto
        }
        return extractnumbers;
    }

    //metodo gioca utente
    private static int[] giocaUtente(Scanner tastiera) {
        // Dichiarazione e inizializzazione variabili e vettori
        int playernumber[] = new int[5];

        for (int i = 0; i < playernumber.length; i++) {
            // Dichiarazione di una variabile flag per controllare la validità del numero
            boolean numeroValido = false;

            do {
                //chiedo all'utente di inserire 5 numeri
                System.out.println("Inserisci il " + (i + 1) + "° numero compreso nella ruota di Venezia");
                playernumber[i] = tastiera.nextInt();

                //verifico se il numero è compreso tra 1 e 90
                if (playernumber[i] >= 1 && playernumber[i] <= 90 && !numeroGiaInserito(playernumber, i)) {
                    numeroValido = true;
                } else {
                    //chiedo all'utente di reinserire un numero in output
                    System.out.println("Hai inserito un numero non valido o duplicato.");
                    System.out.println("Reinserisci un numero compreso tra 1 e 90 e che non sia già stato inserito: ");
                }
            } while (!numeroValido);
        }
        return playernumber;
    }

    // Metodo per verificare se il numero è già stato inserito
    private static boolean numeroGiaInserito(int[] array, int posizioneAttuale) {
        for (int i = 0; i < posizioneAttuale; i++) {
            if (array[i] == array[posizioneAttuale]) {
                return true; // Il numero è già stato inserito
            }
            //se array[i] è uguale a array[posizioneAttuale]),il numero è già stato
            // inserito in una posizione precedente.
        }
        return false; // Il numero non è duplicato
    }

    //metodo verifica vincita
    private static void verificaVincita(int[] numeriEstratti, int[] numeriGiocati) {
        //dichiarazione e inizializzazione variabili
        int numeriIndovinati = 0;
        for (int numeroGiocato : numeriGiocati) { // : semplifica l'iterazione attraverso un array o una collezione
            for (int numeroEstratto : numeriEstratti) {
                if (numeroGiocato == numeroEstratto) {
                    numeriIndovinati++;
                    break;
                }
            }
        }
        //mostro in ouput i numeri che l'utente ha indovinato
        System.out.println("Hai indovinato " + numeriIndovinati + " numeri della ruota di Venezia");
        Wait(2000);
    }

    //metodo visualizza
    private static void visualizzaGiocata(int[] numeriEstratti, int[] numeriGiocati) {
        System.out.println("Numeri estratti: ");
        for (int numero : numeriEstratti) {
            System.out.print(numero + " ");
        }
        System.out.println("\nNumeri giocati: ");
        for (int numero : numeriGiocati) {
            System.out.print(numero + " ");
        }
        Wait(2000);
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