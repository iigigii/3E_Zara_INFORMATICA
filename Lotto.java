import java.util.Scanner;
import java.util.Random;

public class Lotto {
    public static void main(String[] args)
    {
        // int [] ruota2 = null;
        int [] ruota = null;
        int scelta = 0;
        boolean exit = true;
        Scanner scanner = new Scanner(System.in);

        do {
            ClrScr();
            Menù();

            scelta = scanner.nextInt();

            switch (scelta) {
                case 1:
                    ruota = estraiNumeri();
                    System.out.println("I numeri sono stati estratti: ");
                    Wait(2000);
                    break;
                case 2:
                    System.out.println("Visualizazione ruota Venezia: ");
                    Visualizza(ruota);
                    Wait(2000);
                    break;
                case 3:
                exit = false;
                Wait(2000);
                    break;
                default:
                    System.out.println("Scelta errata ");
                    Wait(200);

            }

        }while (exit);


    }
    private static void Menù ()
    {
        System.out.println("=== App lotto === ");
        System.out.println("[1] Estrazioni ruota Venezia ");
        System.out.println("[2] Visualizazione ruota Venezia ");
        System.out.println("[3] Exit ");
    }
    private static void ClrScr(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void Wait(int attesa) {
        try
        {
            Thread.sleep(attesa);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private static int[] estraiNumeri()
    {

        // Dichiarazione array e variabile estratto
        int [] ruota = new int[5];
        Random num = new Random();
        int estratto;

        //ciclo che estrai i 5 numeri
        /* for (int i = 0; i < 5; i++)
        {
            // Generazione dei cinque numeri
            estratto = num.nextInt(0, 90) + 1;

            // Ogni numero estratto andrà inserito in una delle celle dell'array
            ruota[i] = estratto;
        } */ // versione tomasello

        boolean check;
        for (int i = 0; i < ruota.length; i++)
        {
            do
            {
                check=false;
                ruota[i] = num.nextInt(0, 90) + 1;
                for(int j=0;i<j && !check;i++)
                {
                    check=ruota[i]==ruota[j];
                }
            }while(check);
        }

        return ruota;
    }
    private static void Visualizza(int [] ruota)
    {
        for (int numero : ruota)
        {
            System.out.print(numero +" ");
        }
        System.out.println();

    }

}