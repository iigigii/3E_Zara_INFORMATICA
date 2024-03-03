//zara luigi
//classe 3E
//28/02/2024

/*
Dato un valore numerico intero che
rappresenta la data odierna nel formato
ggmmaaaa determinare i valori che
rappresentano il giorno, mese e anno.
Es: 30112011
giorno=30
mese=11
anno=2011
*/

//importazione librerie
import java.util.Scanner;

public class anno {
    public static void main(String[] args) {
        //dichiarazione scanner
        Scanner keyboard = new Scanner(System.in);

        //chiedo all'utente di inserire una stringa di interi in input
        System.out.println("Inserisci la data in formato ggmmaaaa: ");
        int dataInput = keyboard.nextInt();

        //istanzio il vettore di dimensione 3
        int[] data = new int[3];  //int per data gg-mm-aaaa

        //output data gg-mm-aaaa
        System.out.println("*********************");
        System.out.println("DATA: 01/01/2024");
        System.out.println("*********************");
        //invoco il metodo giorno - mese - anno
        GMA(data, dataInput);
        System.out.println("Giorno: "+ data[0]);
        System.out.println("Mese: " + data[1]);
        System.out.println("Anno: " + data[2]);

    }

    //metodo data gg-mm-aaaa
    private static void GMA(int[] data, int dataInput){
        //dichiarazione e inizializzazione variabili
        int giorni, mesi, anni;
        data[0] = dataInput / 1000000;
        data[1] = (dataInput / 10000)  % 100;
        data[2] = dataInput % 10000;
    }
}