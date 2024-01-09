//Zara Luigi
//Classe 3E
/*Realizzare un software che funzioni in questo modo:
- Menu con scelta se eseguire lavoro 1, lavoro 2 o lavoro 3
- Lavoro 1: cuocere tante uova di natale finché l'utente non è stanco
- Lavoro 2: pagare il conto relativo ad hamburger vegani ed hamburger di renna (costano il doppio) e bevande natalizie analcoliche ed alcoliche (costano il doppio), comunicato dal singolo utente. Se si superano i 10 euro c'è lo sconto del 15% per le cifre oltre i 10 euro.
- Lavoro 3: Stampare l'intero incasso del giorno.*/

//Importazione librerie
import java.util.Scanner;

public class Main {
    private double incassoTotale = 0;

    public void lavoro1() {
        //Dichiarazione scanner
        Scanner keyboard = new Scanner(System.in);
        
        //Dichiarazione e inizializzazione delle variabili
        int uovaCucinate = 0;

        while (true) {
            //Chiedo all'utente se vuole cuciare un'altro uovo
            System.out.print("Vuoi cuocere un'altro uovo di Natale? (sì/no): ");
            String risposta = keyboard.nextLine().toLowerCase();

            if (risposta.equals("no")) {
                break;
            }
            
            //contatore uova
            uovaCucinate++;
        }
    }

    //lavoro 2
    public void lavoro2() {
        //Dichiarazione Scanner
        Scanner keyboard = new Scanner(System.in);
        
        //Dichiarazione variabili
        double totaleAcquisti = 0;

        while (true) {
            //Chiedo all'utente di inserire il tipo di prodotto
            System.out.print("Inserisci il tipo di prodotto (hamburger/bibita/fine): ");
            String tipoProdotto = keyboard.nextLine();

            if (tipoProdotto.equals("fine")) {
                break;
            }

            //chiedo all'utente di insereire la quantita dei prodotti
            System.out.print("Inserisci la quantità: ");
            int quantita = Integer.parseInt(keyboard.nextLine());   //perseInt trasforma una stringa in Int
    
            double costoUnitario = tipoProdotto.contains("renna") ? 2 : 1;
            totaleAcquisti += quantita * costoUnitario;
        }

        //Se si superano i 10 euro c'è lo sconto del 15% per le cifre oltre i 10 euro.
        if (totaleAcquisti > 10) {
            double sconto = totaleAcquisti * 0.15;
            totaleAcquisti -= sconto;
            System.out.printf("Totale spesa: %.2f euro (sconto applicato: %.2f euro)%n", totaleAcquisti, sconto);
        } else {
            System.out.printf("Totale spesa: %.2f euro%n", totaleAcquisti);
        }

        incassoTotale = incassoTotale + totaleAcquisti;
    }

    //lavoro 3
    public void lavoro3() {
        //stampo in output l'incasso totale
        System.out.printf("Incasso totale del giorno: %.2f euro%n", incassoTotale);
    }

    public static void main(String[] args) {
        Main software = new Main();  
        Scanner keyboard = new Scanner(System.in);

        while (true) {
            //Stampo in output il menù
            System.out.println("Menu:");
            System.out.println("1. Lavoro 1: Cuocere uova di Natale");
            System.out.println("2. Lavoro 2: pagare il conto ");
            System.out.println("3. Lavoro 3: Stampare incasso del giorno");
            System.out.println("0. Uscire");

            //Chiedo all'utente di inserire la scelta
            System.out.print("Scegli un'opzione: ");
            String scelta = keyboard.nextLine();

            switch (scelta) {
                case "1":
                    software.lavoro1();
                    break;
                case "2":
                    software.lavoro2();
                    break;
                case "3":
                    software.lavoro3();
                    break;
                case "0":
                    keyboard.close();
                    System.exit(0);
                default:
                    System.out.println("Scelta non valida!. Inserisci un'altra scekta. ");
            }
        }
    }
}