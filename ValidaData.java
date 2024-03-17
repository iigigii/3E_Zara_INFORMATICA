//Zara Luigi
//classe 3E
//data 17-03-2024

/*
* Modificare l’esercizio precedente in modo
tale che l’utente tramite un menù possa aggiungere o togliere giorni alla data
precedentemente inserita.
* Per la risoluzione dell’esercizio creare
due metodi:
* "data_up "e "data_down" che ricevuti in input il n° di giorni da
aggiungere o togliere ritornino
la nuova data.
 */

//importazione librerìe
import java.util.Scanner;

public class ValidaData {
    public static void main(String[] args) {
        //dichiarazione scanner
        Scanner keyboard = new Scanner(System.in);

        //Dichiarazione e inizializzazione delle variabili
        int numero = 0;
        char scelta;
        Boolean dataValida;
        boolean bisestile;
        boolean continua = true;
        boolean dataNonValida = false;
        int giorniDaAggiungere, giorniDaTogliere;

        dataValida = false;
        do {
            //chiedo all'utente di inserire una data nel formato ggmmaaaa in input
            System.out.println("Inserisci un numero intero nel formato ggmmaaaa per determinare la data: ");

            //controllo la data con l'utilizzo di un try-catch
            try {
                //l'utente digita la data in input
                numero = keyboard.nextInt();
                //suddivido la data per giorno, mese e anno
                int[] dataSeparata = separazioneData(numero); //istanzio un vettore che contiene la data separata

                //se la data NON è corretta:
                if (!giornoOk(dataSeparata[0], dataSeparata[1], dataSeparata[2])) {
                    dataValida = true;
                    System.out.println("DATA ERRATA");
                } else { //se è giusta:
                    System.out.println("DATA CORRETTA");

                    //mostro all'utente un menù con queste opzioni:
                    System.out.println("Cosa desideri fare:");
                    System.out.println("A) Aggiungere giorni ");
                    System.out.println("B) Togliere giorni");
                    scelta = keyboard.next().charAt(0);

                    //seithc case
                    switch (scelta) {
                        //case aggiungere giorni
                        case 'A':
                            //chiedo all'utente di inserire la qta di giorni che desidera aggiungere
                            System.out.println("Quanti giorni desideri aggiungere? ");
                            giorniDaAggiungere = keyboard.nextInt();

                            //istanzio un vettore che conterrà la nuova data con i giorni aggiunti
                            int[] nuovaDataUp = dataUp(dataSeparata, giorniDaAggiungere);

                            //mostri in output la nuova data
                            System.out.println("la nuova data con i giorni aggiunti è: " + dataToString1(nuovaDataUp));
                            break;
                        //case togliere giorni
                        case 'B':
                            //chiedo all'utente di inserire la qta di giorni che desidera togliere
                            System.out.println("Quanti giorni desideri togliere? ");
                            giorniDaTogliere = keyboard.nextInt();

                            //istanzio un vettore che conterrà la nuova data con i giorni tolti
                            int[] nuovaDataDown = dataDown(dataSeparata, giorniDaTogliere);

                            //mostri in output la nuova data
                            System.out.println("la nuova data con i giorni tolti è: " + dataToString1(nuovaDataDown));
                            break;
                        default:
                            System.out.println("Opzione non valida.");
                    }
                }
            } catch (Exception x) {
                System.out.println("Errore: il valore inserito non è valido");
                dataNonValida = true;
                keyboard.nextLine();
            }
        } while (dataValida);
    }

    /* Separazione della data inserita in giorno, mese ed anno*/
    //12042024
    //12
    //04
    //2024:
    //Si ottiene dal resto della divisione della data per 10000
    //12042024 / 10000 = 1204 Resto 2024
    //12042024 / 10000 = 1204 Salviamo il risultato dentro data
    //1204 / 100 = 12 Resto 04
    //1204 / 100 = 12 Salviamo il risultato dentro data

    // Separazione della data inserita in giorno, mese ed anno
    private static int[] separazioneData(int data) {
        //istanzio un vettore di dimensione 3
        int[] output = new int[3];
        output[2] = data % 10000; // Anno
        data /= 10000;
        output[1] = data % 100; // Mese
        data /= 100;
        output[0] = data; // Giorno
        return output;
    }

     /*System.out.println("Conversione stringa 1 : " + dataToString1(dataSeparata));
        System.out.println("Conversione stringa 2 : " + dataToString2(dataSeparata));
        System.out.println("Conversione stringa 3 : " + dataToString3(dataSeparata));
    */

    //metodo dataToString1
    private static String dataToString1(int[] data) {
        return String.valueOf(data[0]) + "/" + String.valueOf(data[1]) + "/" + String.valueOf(data[2]);
    }

    //metodo dataUp (permette di aggiungere giorni)
    private static int[] dataUp(int[] data, int giorni) {
        //instanzio un array di dimensine 3 che conterà la nuova data
        int[] nuovaData = new int[3];

        //giorno
        nuovaData[0] = data[0] + giorni;
        //mese
        nuovaData[1] = data[1];
        //anno
        nuovaData[2] = data[2];

        while (nuovaData[0] > giorniInMese(nuovaData[1], nuovaData[2])) {
            nuovaData[0] -= giorniInMese(nuovaData[1], nuovaData[2]);
            nuovaData[1]++;
            //se supero il numero di mesi (12) incremeto l'anno
            if (nuovaData[1] > 12) {
                nuovaData[1] = 1;
                nuovaData[2]++;
            }
        }
        return nuovaData;
    }

    //metodo dataDown (permette di togliere giorni)
    private static int[] dataDown(int[] data, int giorni) {
        //instanzio un array di dimensine 3 che conterà la nuova data
        int[] nuovaData = new int[3];

        //giorno
        nuovaData[0] = data[0] - giorni;
        //mese
        nuovaData[1] = data[1];
        //anno
        nuovaData[2] = data[2];

        while (nuovaData[0] < 1) {
            nuovaData[1]--;
            //se il mese diventa negativo, verifo l'anno
            if (nuovaData[1] < 1) {
                nuovaData[1] = 12;
                nuovaData[2]--;
            }
            //Aggiungo i giorni del mese precedente al giorno negativo
            nuovaData[0] += giorniInMese(nuovaData[1], nuovaData[2]);
        }
        return nuovaData;
    }

    //metodo giorniInMese
    private static int giorniInMese(int mese, int anno) {
        if (mese == 2 && bisestile(anno)) {
            return 29; //return 29 nel caso in cui l'anno è bisestile
        } else {
            switch (mese) {
                case 4:
                case 6:
                case 9:
                case 11:
                    return 30;
                default:
                    return 31;
            }
        }
    }

    //metodo giornoOk
    private static boolean giornoOk(int giorno, int mese, int anno) {
          /*switch (mese) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                valida = (giorno > 0 && giorno < 32);
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                valida = (giorno > 0 && giorno < 31);
                break;
            case 2:
                if (Bisestile(anno) && giorno > 0 && giorno < 30) {
                    valida = true;
                } else if (giorno > 0 && giorno < 29) {
                    valida = true;
                }
                break;
        }
         */
        boolean valida = switch (mese) {
            case 1, 3, 5, 7, 8, 10, 12 -> (giorno < 32 && giorno > 0);
            case 4, 6, 9, 11 -> (giorno < 31 && giorno > 0);
            case 2 -> (bisestile(anno) && giorno > 0 && giorno < 30) || (giorno > 0 && giorno < 29);
            default -> false;
        };
        return valida;
    }

    //Metodo bisestile (controlla se l'anno inserito è bisestile)
    private static boolean bisestile(int anno) {
        return ((anno % 4 == 0 && anno % 100 != 0) || anno % 400 == 0);
    }

    //private static int validata()
    //-1 : No error
    //1 : Out of range
    //2 : Domain incorrect
}

