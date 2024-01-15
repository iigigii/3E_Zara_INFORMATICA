//Zara Luigi
//classe 3E
//Data: 15/01/2024

/*
* estrarre 5 numeri nell'intevallo 5-90
* realizzare un programma che permette di estrarre questi valori in modo casuale
* le ruote sono 11, vogliamo un metodo che ritorni un array di valori per una delle ruote
*/

//importazione librerie
import java.util.Scanner;
import java.util.Random;
public class lotto {
    public static void main(String[] args) {
        //Scanner
        Scanner keyboard = new Scanner(System.in);
        //Dichiarazione e inizializzazione delle variabili
        int minValue = 1, maxValue = 90;
        int valore = 0;

        //Dichiarazione array
        int [] estrazione = new int[5];

        //chiamo la funzione random 5 volte
        for(int i = 0; i < 5; i++){
            valore = valoreRandom(0, 90);
            estrazione[i]=valore;
        }

        System.out.println("Risultati:");
        //mostro in output i risultati
        for(int i = 0; i < 5; i++){
            System.out.println("Estrazione "+ (i+1));
            System.out.println(estrazione[i]);
        }
    }
    //metodo Random
    private static int valoreRandom(int minValue, int maxValue) {
        Random casuale = new Random(); //Metodo che non ha nessun parametro, si chiama costruttore.
        return  casuale.nextInt(minValue,maxValue)+1;
    }
}