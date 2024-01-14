//Zara Luigi
//Class: 3E
//Date:  10/01/2024
//Caso 2

//importazione librerie 
import java.util.Random;
public class Statistica {
    public static void main(String[] args)
    {
	//dichiarazione e inizializzazione delle variabili
        int [] frequenze  = new int[6];   //Il vettore è una collezione di dati dello stesso tipo.


        /*for(int i=0; i<frequenze.length;i++)
         {
             System.out.println(frequenze[i]);
         }
        */

        int valore=0;
        for( int i=0; i<100; i++) {
            valore = valoreRandom(0, 6);
            // System.out.printf("Valore %d \n ",valore);  //%d vuoldire variabile di tipo intero.
            //%f vuoldire float
            // %s vuoldire stringa
            // %c vuoldire char (carattere)
            // Printf serve per formattare il testo.
            FacceDado(valore);
            switch (valore) {
                case 1: {
                    frequenze[0]++;
                }
                case 2: {
                    frequenze[1]++;
                }
                case 3: {
                    frequenze[2]++;
                }
                case 4: {
                    frequenze[3]++;
                }
                case 5: {
                    frequenze[4]++;
                }
                case 6: {
                    frequenze[5]++;
                }


            }
            for(int index=0; index<frequenze.length; index++)
            {
                System.out.println("Faccia"+(index+1)+"="+frequenze[index]);
            }
        }
	//Mostro in output i risultati 
          /* System.out.printf(" Faccia1: %d,Faccia2: %d,Faccia3: %d,Faccia4: %d,Faccia5: %d,Faccia6: %d ",faccia1,faccia2,faccia3,
                    faccia4,faccia5,faccia6);*/


    }

    private static int valoreRandom(int minValue, int maxValue)
    {
        Random casuale = new Random(); //Metodo che non ha nessun parametro, si chiama costruttore.

        return  casuale.nextInt(minValue,maxValue)+1;

    }
    private static void FacceDado(int valoreFaccia1)
    {

        switch (valoreFaccia1) {
            case 1 : {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t ║    O    ║");
                System.out.println("\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t ╚═════════╝");

                break;
            }

            case 2 : {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O      ║");
                System.out.println("\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t ║      O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");

                break;
            }

            case 3 : {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O      ║");
                System.out.println("\t\t\t\t ║    O    ║");
                System.out.println("\t\t\t\t ║      O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }

            case 4 : {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }

            case 5 : {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ║    O    ║");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }

            case 6 : {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }
        }
    }
}