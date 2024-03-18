//Zara Luigi
//Class 3E
//Date: 18/03/2024

//importazione delle librerie
import javax.swing.plaf.metal.MetalRootPaneUI;
import static Utility.Tools.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public class DataValida {
    public static void main(String[] args) {
        //dichiarazione scanner
        Scanner keyboard = new Scanner(System.in);

        //dichiarazione e inizializzazione delle variabili
        boolean dataValida = false;
        boolean dataFormat = false;
        boolean quit = true;
        int data;
        int[] dataSeparata = new int[3];
        String strErrore = "InsertData";
        int giorniDaAggiungere, giorniDaTogliere;

        //menu opzioni
        String[] opzioni = {
                "Cosa vuoi fare",
                "[1] - Leggi data",
                "[2] - Controlla data",
                "[3] - Visualizza ggmmaaaa",
                "[4] - Visualizza gg < mese > aaaa",
                "[5] - errore",
                "[6] - quit",
                "[7] - Aggiungi giorni",
                "[8] - Rimuovi giorni"
        };

        do {
            switch (printMenu(opzioni, keyboard)) {
                case 1:
                    System.out.println("Inserisci un numero intero nel formato ggmmaaaa per determinare la data: ");
                    try {
                        data = Integer.parseInt(keyboard.nextLine());
                        if (lunghezza(data)) {
                            dataSeparata = separazioneData(data);
                            dataFormat = true;
                        } else {
                            errore(1);
                            Wait(1000);
                        }
                    } catch (Exception x) {
                        errore(2);
                        keyboard.nextLine();
                    }
                    break;
                case 2:
                    if (dataFormat) {
                        dataValida = dataOk(dataSeparata[0], dataSeparata[1], dataSeparata[2]);
                        if (!dataValida) {
                            System.out.println(errore(3));
                        }
                    } else {
                        strErrore = errore(2);
                        System.out.println(strErrore);
                        Wait(2000);
                    }
                    break;
                case 4:
                    if(dataValida){
                        System.out.println(dataStringa(dataSeparata));
                        Wait(1000);
                    }
                    break;
                case 5:
                    System.out.println(strErrore);
                    break;
                case 6:
                    quit = false;
                    break;
                case 7:
                    //chiedo all'utente di inserire la qta di giorni che desidera aggiungere
                    System.out.println("Quanti giorni desideri aggiungere? ");
                    giorniDaAggiungere = keyboard.nextInt();

                    //istanzio un vettore che conterrà la nuova data con i giorni aggiunti
                    int[] nuovaDataUp = dataUp(dataSeparata, giorniDaAggiungere);

                    //mostri in output la nuova data
                    System.out.println("la nuova data con i giorni aggiunti è: " + dataToString1(nuovaDataUp));
                    break;
                case 8:
                    //chiedo all'utente di inserire la qta di giorni che desidera togliere
                    System.out.println("Quanti giorni desideri togliere? ");
                    giorniDaTogliere = keyboard.nextInt();

                    //istanzio un vettore che conterrà la nuova data con i giorni tolti
                    int[] nuovaDataDown = dataDown(dataSeparata, giorniDaTogliere);

                    //mostri in output la nuova data
                    System.out.println("la nuova data con i giorni tolti è: " + dataToString1(nuovaDataDown));
                    break;
            }
        } while (quit);

        /*
        do {
            dataValida = false;
            //output for enter the date
            System.out.println("Inserisci un numero intero nel formato ggmmaaaa per determinare la data: ");
            //Check for non valid user input
            try {
                //insertion of the date
                numero = scanner.nextInt();
                int[] dataSeparata = separazioneData(numero);
                if (!dataOk(dataSeparata[0], dataSeparata[1], dataSeparata[2])) {
                    dataValida = true;
                    System.out.println("DATA ERRATA");
                } else {
                    System.out.println("DATA CORRETTA");
                }
            } catch (Exception x) {
                System.out.println("DATA ERRATA");
                dataValida = true;
                scanner.nextLine();
            }
        } while (dataValida);
       */
    }

    //metodo per la conversione della data
    private static String dataStringa(int[] data){
        String[] mesi = {"Gennaio", "Febbrario", "Marzo", "Aprile", "Maggio", "Giugno", "Luglio", "Agosto", "Settembre", "Ottobre", "Novembre", "Dicembre"};
        return data[0] + "/" + mesi[data[1] - 1] + "/" + data[2];
    }

    //metodo dataToString1
    private static String dataToString1(int[] data) {
        return String.valueOf(data[0]) + "/" + String.valueOf(data[1]) + "/" + String.valueOf(data[2]);
    }

    //metodo che gestisce i vari errori
    private static String errore(int codice){
        final String[] errori = {"OutOfRange", "InvalidDataType", "InvalidData"};

        return errori[codice - 1];
    }

    //metodo lunghezza
    private static boolean lunghezza(int data){
        return (data >= 01010001 && data <= 31129999);
    }

    //metodo per la separazione della data
    private static int[] separazioneData(int data) {
        //Contiene il valore d'uscita
        int[] output = new int[3];

        //Anno
        output[2] = data % 10000;
        //Rimuovere l'anno dalla data
        data /= 10000;
        //Mese
        output[1] = data % 100;
        //Rimuovere il mese dalla data
        data /= 100;
        //Giorno
        output[0] = data;

        //Ritornare i valori separati
        return output;
    }

    //metodo dataOk (controllo della data)
    private static boolean dataOk(int giorno, int mese, int anno) {
        boolean valida = false;

        valida = switch (mese) {
            case 1, 3, 5, 7, 8, 10, 12 -> (giorno > 0 && giorno < 32);
            case 4, 6, 9, 11 -> (giorno > 0 && giorno < 31);
            case 2-> (Bisestile(anno) && giorno > 0 && giorno < 30) || (giorno > 0 && giorno < 29);
            default -> false;
        };

        return valida;
    }

    //metodo anno bisestile
    private static boolean Bisestile(int anno) {
        return ((anno % 4 == 0 && anno % 100 != 0) || anno % 400 == 0);
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
        if (mese == 2 && Bisestile(anno)) {
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
}