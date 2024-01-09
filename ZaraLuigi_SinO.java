//Zara Luigi
//Classe 3E
//Data 6 Dicembre 2023
/*
Inserire un numero intero che rappresenta i secondi trascorsi dall’inizio di oggi e mostra in
uscita l’ora attuale espressa in hh:mm:ss (ore:minuti:secondi).
Se l’utente inserisce un valore nullo o un valore superiore ad un giorno chiedere il
reinserimento.
 */

//Importazione librerie
import java.util.Scanner;
public class SinO {
    public static void main(String[] args) {
        //dichiarazione scanner
        Scanner Keyboard = new Scanner(System.in);

        //Dichiarazione variabili
        int secondi;
        int ore;
        int minuti;
        int secondiRimanenti;

        //Chiedo all'utente di fornire in ingresso i secondi
        System.out.print("Inserisci i secondi: ");
        secondi = Keyboard.nextInt();

        //Ciclo while: se l'utente inserisce un numero superioe a 86400 secondi il programma esce
        while (secondi <= 0 || secondi > 86400) {
            System.out.println("numero non valido! Il numero di secondi deve essere compreso tra 1 e 86400.");
            System.out.print("Reinserisci il numero di secondi: ");
            secondi = Keyboard.nextInt();
        }

        //inizializzazione variabili
        ore = secondi / 3600;
        minuti = (secondi % 3600) / 60;
        secondiRimanenti = secondi % 60;

        //Output secondi-ore-minuti-secondiRimanenti
        System.out.printf("%d(secondi) = %d(ore):%d(minuti):%d(secondi)%n",  secondi,  ore , minuti , secondiRimanenti);
    }

}
