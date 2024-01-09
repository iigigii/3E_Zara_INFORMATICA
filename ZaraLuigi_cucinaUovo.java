//Zara Luigi
//Classe 3E
//Data 12 Dicembre 2023
/*
Realizzare un programma che permetta di
temporizzare la cottura dell'uovo simulandone le fasi di cottura con delle figure realizzate
utilizzando dei caratteri ascii.
 */
public class CucinaUovo {
    public static void main(String[] args) {

        //Dichirazaione e inizializzazione delle variabili
        timerUovo();
        Wait();
        uovoCotto();
    }

    //wait
    private static void Wait() {
        try{
            Thread.sleep(2000); //2000 millessimi = 2 secondi
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //uovoCotto
    private static void uovoCotto() {
        System.out.print("  _______\n" +
                " /       \\\n" +
                "|         |\n" +
                " \\       /\n" +
                "  '-----'\n");
        System.out.println("L'uovo è cotto");
    }

    //Timer uovo
    private static void timerUovo() {

        //Dichiarazione e inizializzazione delle variabili
        int timerMax2 = 3 * 60;
        int tempoCostante = timerMax2;
        int i;

        //Ciclo for che parte dal tempo inserito e finisce quando arriva a 0
        for (i = tempoCostante; i >=0; i--){

            //stampo in output i secondi rimanenti
            System.out.println("Tempo rimanente: " + tempoCostante + "secondi");
            tempoCostante = tempoCostante -1;

            //uovo crudo
            System.out.print("                       \n" +
                    "            crudo               \n" +
                    "            .-~-.               \n" +
                    "          .'      '.            \n" +
                    "         /           |           \n" +
                    "        :             ;          \n" +
                    "        |             |         \n" +
                    "       :               |         \n" +
                    "        |             |          \n" +
                    "         `.        . `            \n" +
                    "            `~` ~ `                \n\n");

            try{
                Thread.sleep(500); //500 millessimi = 0.5 secondi
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //uovo in padella
            System.out.print("                      \n" +
                    "         in padella             \n" +
                    "            .-~-.               \n" +
                    "          .'      '.             \n" +
                    "         /          |            \n" +
                    "        :            ;           \n" +
                    "        |     _ _     |            \n" +
                    "       :     |    |    |            \n" +
                    "         | |          |             \n" +
                    "          `.         .               \n" +
                    "             `~~~~~ `                \n "+
                    "      __________________-\"-\"_\n" +
                    "      \\                     /   \n" +
                    ".   --\\_________________/_--.\n" +
                    " \"\"--------------------------\n\n");

            //linea di separazione
            System.out.print("_________________________________\n");

            try{
                Thread.sleep(500); //500 millessimi = 0.5 secondi
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //impostazione pulizia schermo
            ClrScr();
        }
    }

    //pulisci schermo
    private static void ClrScr() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}