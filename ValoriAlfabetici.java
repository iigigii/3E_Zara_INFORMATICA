//Zara Luigi
//classe 3E
//Data: 30/01/2024

/*
* Realizzare un programma che, utilizzando la strategia del vettore dei booleani,
* che permetta, data una stringa di valori alfabetici, di stampare caratteri presenti
* e non presenti nella stringa.
*/

//importazione librerie
import java.util.Scanner;

public class ValoriAlfabetici {
    public static void main(String[] args) {
        //Dichiarazione scanner
        Scanner tastiera = new Scanner(System.in);

        // Dichiarazione e inizializzzaione variabili per la scelta e l'uscita
        int scelta;
        boolean exit = true;

        // Dichiarazione di un array di stringhe per il menu
        String[] opzioni = {"===== Gioco Alfabeto ===== ", "[1]- Gioca", "[2]- Exit "};

        while (exit) {
            // wait
            wait(2500);
            //mostro in input il menu
            System.out.println(menu(opzioni, tastiera));
            //wait
            wait(2500);
            //l'utente digita la sua scelta
            scelta = tastiera.nextInt();

            //switch case (scelta)
            switch (scelta) {
                case 1:
                    gioca();
                    wait(200);
                    break;
                case 2:
                    exit = false;
                    wait(200);
                    break;
                default:
                    //se l'utente inserisce una scelta non presente nel swith case:
                    System.out.println("Scelta errata! ");
                    wait(200);
            }
        }
    }

    //Menù
    private static int menu(String[] opzioni, Scanner tastiera) {
        int scelta;

        do {
            //Clear screen
            clrScr();
            System.out.println("---------------------------");
            System.out.println(opzioni[0]);
            System.out.println("---------------------------");

            //output menu options
            for (int i = 1; i < opzioni.length; i++) {
                System.out.println(opzioni[i]);
            }

            //user choose
            scelta = tastiera.nextInt();

            //if the user choose a number < 1 or > opzioni.lenght, the choose is invalid
            if ((scelta < 1) || (scelta > opzioni.length - 1)) {
                //the option is innvalid, try again
                System.out.println("Opzione Sbagliata");
                wait(1000);
            }
        } while ((scelta < 1) || (scelta > opzioni.length - 1));

        return scelta;
    }

    //metodo per verificara se la stringa Fornita in input contiene solo caratteri alfabetici
    private static boolean isInputValid(String input) {
        // Verifica se l'input contiene solo caratteri alfabetici minuscoli o maiuscoli
        return input.matches("[a-zA-Z]+");
        //[a-zA-Z]: Questo specifica un intervallo di caratteri da 'a' a 'z' e da 'A' a 'Z'
    }

    //metodo Gioca
    private static void gioca() {
        //dichiarazione scanner
        Scanner keyboard = new Scanner(System.in);

        //Chiedo all'utente di fornine in ingresso una stringa in input
        System.out.println("Inserisci una stringa di valori alfabetici:");
        String stringa = keyboard.next();

        //verifico che la stringa fornita in input dall'utente contenga solo caratteri
        while (!isInputValid(stringa)) {
            System.out.println("Input non valido. Puoi inserire solo caratteri alfabetici.");
            stringa = keyboard.next();
            clrScr();
        }

        //Dichiarazione e inizializzazione vettore booleano
        boolean[] presenti = new boolean[26];
        for (int i = 0; i < presenti.length; i++) {
            presenti[i] = false; //pongo tutti i caratteri = false
        }

        // Itera sulla stringa
        for (int i = 0; i < stringa.length(); i++) {
            // Ottieni il carattere corrente
            char carattere = stringa.charAt(i);     //Per ogni iterazione del ciclo, viene ottenuto il carattere
                                                    // corrispondente alla posizione i nella stringa

            // Se il carattere è alfabetico, aggiorna il vettore
            if (carattere >= 'a' && carattere <= 'z') {   //condizione verifica se il carattere corrente è
                                                          // un carattere alfabetico minuscolo.
                presenti[carattere - 'a'] = true;     //Se il carattere è una lettera dell'alfabeto,
                                                      // viene aggiornato il vettore presenti
            }
        }

        //mostro in output i caratteri presenti
        System.out.println("Caratteri presenti nella stringa:");
        for (int i = 0; i < presenti.length; i++) {
            if (presenti[i]) {
                System.out.print((char) (i + 'a') + " ");
            }
        }

        //wait
        wait(2500);

        //mostro in output i caratteri non presenti
        System.out.println("\nCaratteri non presenti nella stringa:");
        for (int i = 0; i < presenti.length; i++) {
            if (!presenti[i]) {
                System.out.print((char) (i + 'a') + " ");
            }
        }

        //new paragraph
        System.out.println("\n");

    }

    // Clear Screen
    private static void clrScr() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Wait
    private static void wait(int attesa) {
        try {
            Thread.sleep(attesa);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}