//Zara Luigi
//Classe 3E
/*
wrongIndexSearch tale che il suo funzionamento sia:
- di partenza identico a ricercaIndex, già realizzato a scuola oggi
- in un numero variabile tra le 3 e 5 ricerche rispetto al malfunzionamento antecedente, restituisca la risposta data al quesito precedentemente chiesto (tra le 3 e le 5 ricerche deve dare l'indice sbagliato, che però deve essere uguale a quello della ricerca fatta la volta prima).
A seguito dell'errore, il sistema deve continuare a rispondere correttamente, quindi, per 2, 3 o 4 volte.
Piccola analogia: se questo metodo dovesse svolgere una somma, la situazione potrebbe essere questa:
2+3 = 5
3+ 6 = 9
4+4 = 8
1+4 = 8 **** (sbaglia al 4 giro)
1+1 = 2
2+2 = 4
1+ 4 = 5
15 + 18 = 36 (è ovviamente corretto)
1 + 1 = 36 ****  (sbaglia al 5 giro)
1+1 = 2
1+ 2 = 3
1+ 1 = 3 ****
*/

//importazione librerie
import java.util.Random;

public class WrongIndexSearch {
    public static void main(String[] args) {
        //dichiarazione e inizializzazione delle variabili
        int risultato = 0;
        int a, b;
        int sommaCorretta, sommaGenerata;

        //ciclo for
        for (int i = 0; i < 10; i++) {
            //Genero un numero randomicamnete  fra 1 e 10
            a = new Random().nextInt(10) + 1;
            b = new Random().nextInt(10) + 1;

            //Calcolo della somma corretta e generata in modo errato
            sommaCorretta = a + b;
            sommaGenerata = sommaErrata(a, b);

            //output
            System.out.print(a + " + " + b + " = " + sommaGenerata);

            // Verifica se la somma generata è errata
            if (sommaCorretta != sommaGenerata) {
                System.out.println(" ****** (errore al " + (i + 1) + "° tentativo)");
                risultato = risultato + sommaCorretta;
            } else {
                //new paragraph
                System.out.println();
                risultato = risultato + sommaGenerata;
            }
        }
    }

    //Metodo wrongIndexSearch
    public static int sommaErrata(int a, int b) {
        //dichiarazione numero random
        Random numeroRandom = new Random();

        //dichiarazione e inizializzazione delle variabili
        int sommaCorretta = a + b;
        int sommaSbagliata = sommaCorretta;
        int numeroSommeErrate = 0;

        // Decide casualmente se restituire la somma corretta o errata
        if (numeroRandom.nextBoolean()) {
            //genero un numero di somme errate comprese fra le 3 le 5 volte
            numeroSommeErrate = numeroRandom.nextInt(3) + 3;

            //ciclo for i=0 to i < del n° volte numero somme errate
            for (int i = 0; i < numeroSommeErrate; i++) {
                //Genero una somma diversa da quella effettiva
                do {
                    int x = numeroRandom.nextInt(10) + 1; //Genera un numero casuale fra 1 e 10
                    int y = numeroRandom.nextInt(10) + 1; //Genera un numero casuale fra 1 e 10
                    sommaSbagliata = x + y; //Calcolo la somma errata
                } while (sommaSbagliata == sommaCorretta);
            }

            //restituisco la somma sbagliata
            return sommaSbagliata;
        } else {

            //restituisco la somma giusta
            return sommaCorretta;
        }
    }
}