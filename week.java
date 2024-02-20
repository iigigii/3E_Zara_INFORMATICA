
//importo librerie
import java.net.SocketOption;
import java.util.Scanner;
public class week {
    public static void main(String[] args) {
        //dichiarazione scanner
        Scanner keyboard = new Scanner(System.in);

        //array string giorni
        String[] week = {"Lunedì", "Martedì", "Mercoledì", "Giovedì", "Venerdì", "Sabato", "Domenica"};

        //dichiarazione variabili
        String giorno;
        int continua = 0;


        do{
            //chiedo all'utente di inserire il giorno in input:
            System.out.println("Inserisci giorno: ");
            giorno = keyboard.next();

            if(!giorno.equalsIgnoreCase("Lunedì") && !giorno.equalsIgnoreCase("Martedì")
                    && !giorno.equalsIgnoreCase("Mercoledì") && !giorno.equalsIgnoreCase("Giovedì")
                    && !giorno.equalsIgnoreCase("Venerdì") && !giorno.equalsIgnoreCase("Sabato")
                    && !giorno.equalsIgnoreCase("Domenica")){
                do{
                    System.out.println("giorno non valido! Ritenta:");
                    giorno = keyboard.next();

                }while(!giorno.equalsIgnoreCase("Lunedì") && !giorno.equalsIgnoreCase("Martedì")
                        && !giorno.equalsIgnoreCase("Mercoledì") && !giorno.equalsIgnoreCase("Giovedì")
                        && !giorno.equalsIgnoreCase("Venerdì") && !giorno.equalsIgnoreCase("Sabato")
                        && !giorno.equalsIgnoreCase("Domenica"));
            }

            //switch case
            switch(giorno){
                case "Lunedì":
                case "Mercoledì" :
                case "Venerdì":
                case "Domenica" :
                    System.out.println("giorno dispari");
                    break;

                case "Martedì", "Giovedì", "Sabato":
                    System.out.println("giorno pari");
                    break;

                default: System.out.println("giorno non valido");
            }

            System.out.println("Vuoi continuare? ");
            System.out.println("[1] - Si \n[2] - No ");
            continua = keyboard.nextInt();

            if(continua < 1 || continua > 2){
                do{
                    System.out.println("Scelta non valida! Puoi scegliere tra [1] e [2]");
                    continua = keyboard.nextInt();
                }while(continua < 1 || continua > 2);
            }

        }while(continua==1);
    }
}