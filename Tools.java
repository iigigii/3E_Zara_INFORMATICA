package Utility;

//importazione librerie
import java.util.Scanner;

public class Tools {

    //metodo menù
    public static int printMenu (String opzioni[], Scanner tastiera)
    {
        int scelta;
        do {
            //ClrScr();
            System.out.println();
            System.out.println("------------------");
            System.out.println(opzioni[0]);
            System.out.println("------------------");
            for (int i=1; i < opzioni.length; i++)
            {
                System.out.println(opzioni[i]);
            }

            scelta = Integer.parseInt(tastiera.nextLine());

            if ((scelta < 1 ) || (scelta > opzioni.length -1 ))
            {
                System.out.println("Opzione Sbagliata");
                Wait(2000);
            }
        }
        while ((scelta < 1 ) || (scelta > opzioni.length -1 ));
        return scelta;
    }

    //metodo pulisci schermo
    /*public static void ClrScr(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     */

    //metodo wait
    public static void Wait(int attesa) {
        try{
            Thread.sleep(attesa);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}