//Zara Luigi
//Classe 3E
//Data: 5 dicembre 2023
/*
Consegna: convertire il valore binario "Stringa di caratteri" in un valore decimale.
 */

//importazione librerie
import java.util.Scanner;
import java.lang.Math;
public class BinDec {
    public static void main(String[] args) {
        //Dichiarazione Scanner
        Scanner keyboard = new Scanner(System.in);

        //Dichiarazione e inizializzazione variabili
        String numeroBinario = "";
        double numeroDecimale = 0;

        // variabili di calcolo
        double carattere = 0;
        double pow = 0; //pow è l'esponente
        boolean flagBinario = true;

        //Il programma esegue una conversione di un numero binario in decimale
        System.out.println("Conversione di un numero binario in un numero decimale");

        // Chiedo all'utente di fornire in ingresso un numero binario
        System.out.println("Inserisci un numero binario: (ricorda deve contenere solo 0-1) ");
        numeroBinario = keyboard.next();

        //ciclo for
        for (int i = numeroBinario.length(); i > 0; i--) {

            carattere = (double)numeroBinario.charAt(i - 1) - 48;

            // Controllo se il carattere inserito contiene  0 o 1
            if (numeroBinario.charAt(i - 1) == '1' || numeroBinario.charAt(i - 1) == '0') {

                //charAt restituisce il carattere situato in una specifica posizione all'interno della stringa.

                // FORMULA: numeroDecimale = numeroDecimale + (int)char * 10**pow
                numeroDecimale = numeroDecimale + carattere * Math.pow(2.0, pow);
            }

            // se il carattere non contiene 0 o 1 dico all'utente che ha inserito un numero non valido
            else {
                System.out.println("Il numero che hai inserito non è valido!");
                System.out.println("I numeri binari possono contenere solo 0 e 1!!!");
                flagBinario= false;
                break;
            }

            // Aggiorno l'esponente
            pow++;
        }

        // se il numero è valido do in output il numero convertito in decimale
        if (flagBinario){
            System.out.println("Il numero binario in decimale e': " + numeroDecimale);
        }

    }
}
