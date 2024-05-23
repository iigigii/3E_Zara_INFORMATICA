import java.util.Scanner;

public class ValidaData {
    public static void main(String[] args) {
        //declaration and initialization of variables/arrays

        int numero = 0;
        Scanner scanner = new Scanner(System.in);
        boolean continua = true;
        char scelta;
        Boolean  dataValida;
        boolean bisestile;
        boolean dataNonValida = false;


        dataValida = false;
        do{
            //output for enter the date
            System.out.println("Inserisci un numero intero nel formato ggmmaaaa per determinare la data: ");
            //Check for non valid user input
            try {
                //insertion of the date
                numero = scanner.nextInt();
                //Separare la data in giorno, mese, anno
                int[] dataSeparata = separazioneData(numero);
                if(!dataOk(dataSeparata[0], dataSeparata[1], dataSeparata[2])){
                    dataValida=true;
                    System.out.println("DATA ERRATA");
                } else{
                    System.out.println("DATA CORRETTA");
                }
            } catch(Exception x) {
                System.out.println("Errore : il valore inserito non e' valido");
                dataNonValida = true;
                scanner.nextLine();
            }


        } while(dataValida);




        /*
        System.out.println("Conversione stringa 1 : " + dataToString1(dataSeparata));
        System.out.println("Conversione stringa 2 : " + dataToString2(dataSeparata));
        System.out.println("Conversione stringa 3 : " + dataToString3(dataSeparata));
        */
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
    private static int[] separazioneData (int data) {
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

    private static String dataToString1(int[] data) {
        String output;

        output = String.valueOf(data[0]) + "/" + String.valueOf(data[1]) + "/" + String.valueOf(data[2]);

        return output;
    }

    private static String dataToString2(int[] data) {
        String output;

        output = Integer.toString(data[0]) + "/" + Integer.toString(data[1]) + "/" + Integer.toString(data[2]);

        return output;
    }

    private static String dataToString3(int[] data) {
        Integer boxing = data[0];
        String output = boxing.toString() + "/";

        boxing = data[1];
        output += boxing.toString() + "/";

        boxing = data[2];
        output += boxing.toString();

        return output;
    }



    //anno: 31129999
    //01010001
    private static boolean validadata(int numero){
        return (numero>31129999 || numero<01010001);
    }

    //private static int validata()
    //-1 : No error
    //1 : Out of range
    //2 : Domain incorrect

    //metodo bisestile
    private static boolean bisestile(int anno){
        return((anno % 4 == 0 &&anno % 100 != 0) || anno % 400 == 0); //l'if ritorna un valore booleano
    }

    //metodo giornoOk
    private static boolean dataOk(int giorno, int mese, int anno){
        //return(data[1]==2 && data[0]>=29);
        boolean valida = false;
        /*
        switch (mese){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                valida=(giorno<32 && giorno>0);
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                valida=(giorno<31 && giorno>0);
            case 2:
                if(bisestile(anno) && giorno>0 && giorno<30){
                    valida= true;
                } else if (giorno>0 && giorno < 29){
                    valida= true;
                }
                break;

        }
         */


        /*
        if(mese==2){
            if(bisestile(anno) && giorno>0 && giorno<30){
                valida= true;
            } else if (giorno>0 && giorno < 29){
                valida= true;
            }
        } else {
            valida = switch (mese) {
                case 1, 3, 5, 7, 8, 10, 12 -> (giorno < 32 && giorno > 0);
                case 4, 6, 9, 11 -> (giorno < 31 && giorno > 0);
                default -> false;
            };
        }
         */




        valida = switch (mese) {
            case 1, 3, 5, 7, 8, 10, 12 -> (giorno < 32 && giorno > 0);
            case 4, 6, 9, 11 -> (giorno < 31 && giorno > 0);
            case 2 -> (bisestile(anno) && giorno > 0 && giorno < 30) || (giorno > 0 && giorno < 29);
            default -> false;
        };
        return valida;
    }





}