//zara luigi
//classe 3E
//28/02/2024

/*
* Modificare l’esercizio precedente in modo da
verificare se la data inserita è corretta
* Segnalare all’utente l’inserimento della data errata,
strutturando il programma in modo da consentire
un reinserimento della stessa.
* Il programma si dovrà ripetere su richiesta dell’utente.
*/

//importazione librerie
import java.util.Scanner;

public class anno2 {
    public static void main(String[] args) {
        //dichiarazione scanner
        Scanner keyboard = new Scanner(System.in);
        //dichiarazione varibili
        int dataInput;
        boolean dataCorretta = false;
        String inputRisposta;

        //ciclo do-while
        do{
            //chiedo all'utente di inserire una stringa di interi in input
            System.out.println("Inserisci la data in formato ggmmaaaa: ");
            dataInput = keyboard.nextInt();

            //controllo che l'utente non abbia inserito una data non valida
            do{
                if(verificaData(dataInput)){
                    dataCorretta = true;
                }else{
                    System.out.println("data non valida! reinserisci:");
                    dataInput = keyboard.nextInt();
                }
            }while(!dataCorretta);

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

            //chiedo all'utente se desidera inserire un'altra data
            System.out.println("vuoi inserire un'altra data?");
            inputRisposta = keyboard.next();

        }while(inputRisposta.equals("si"));

    }

    //metodo data gg-(nomeMese)-aaaa
    private static void GMAs(int[] data, String[] dataStringa, int dataInput) {
        // Calcolo giorno e anno e li inserisco nel vettore
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

    //metodo per verificare che la data inserita sia giusta
    private static boolean verificaData(int data) {
        //dichiarazione variabili
        int giorno, mese, anno;

        //trovo il giorno, il mese e l'anno
        giorno = data / 1000000;
        mese = (data / 10000)  % 100;
        anno = data % 10000;

        //switch case
        if(mese >= 1 && mese <= 12){
            switch(mese){
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    return giorno >= 1 && giorno <= 31;
                case 4:
                case 6:
                case 9:
                case 11:
                    return giorno >= 1 && giorno <= 30;
                case 2:
                    if((anno % 4 == 0 && anno % 100 != 0) || anno % 400 == 0){
                        return giorno >= 1 && giorno <= 29;
                    } else {
                        return giorno >= 1 && giorno <= 28;
                    }
            }
        }
        return false;
    }
}