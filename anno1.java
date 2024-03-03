//zara luigi
//classe 3E
//28/02/2024

/*
Modificare l’esercizio precedente in modo
che il mese venga scritto in formato
stringa.
Es: 30112011
giorno=30
mese=NOVEMBRE
anno=2011
*/

//importazione librerie
import java.util.Scanner;

public class anno1 {
    public static void main(String[] args) {
        //dichiarazione scanner
        Scanner keyboard = new Scanner(System.in);

        //chiedo all'utente di inserire una stringa di interi in input
        System.out.println("Inserisci la data in formato ggmmaaaa: ");
        int dataInput = keyboard.nextInt();

        //istanzio il vettore di dimensione 3
        int[] data = new int[3];                //int per data gg-mm-aaaa
        String[] dataStringa = new String [3];  //String per data gg-(nomeMese)-aaaa

        //output data gg-(nomeMese)-aaaa
        System.out.println("*********************");
        System.out.println("DATA: 01/GENNAIO/2024");
        System.out.println("*********************");

        //invoco il metodo giorno - mese(stringa) - anno
        GMAs(data, dataStringa, dataInput);
        System.out.println("Giorno: "+ data[0]);
        System.out.println("Mese: " + dataStringa[1]);
        System.out.println("Anno: " + data[2]);
    }

    //metodo data gg-(nomeMese)-aaaa
    private static void GMAs(int[] data, String[] dataStringa, int dataInput) {
        //Calcolo giorno e anno e li inserisco nel vettore
        data[0] = dataInput / 1000000;
        data[2] = dataInput % 10000;

        //trovo il mese e lo inserisco nel vettore
        int numeroMese = (dataInput / 10000) % 100;
        String[] nomiMesi = {
                " ", "Gennaio", "Febbraio", "Marzo", "Aprile", "Maggio", "Giugno",
                "Luglio", "Agosto", "Settembre", "Ottobre", "Novembre", "Dicembre"
        };

        //ciclo if per definire il nome del mese in base al numero
        if (numeroMese >= 1 && numeroMese <= 12) {
            dataStringa[1] = nomiMesi[numeroMese];
        } else {
            dataStringa[1] = "Mese non valido";
        }
    }
}