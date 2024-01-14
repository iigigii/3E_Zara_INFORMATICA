//Zara Luigi
//Class: 3E
//Date:  10/01/2024

//importazione librerie 
import java.util.Random;
public class Statistica {
    public static void main(String[] args)
    {
	//dichiarazione e inizializzazione delle variabili 
        int faccia1=0;
        int faccia2=0;
        int faccia3=0;
        int faccia4=0;
        int faccia5=0;
        int faccia6=0;

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
                    faccia1++;
                }
                case 2: {
                    faccia2++;
                }
                case 3: {
                    faccia3++;
                }
                case 4: {
                    faccia4++;
                }
                case 5: {
                    faccia5++;
                }
                case 6: {
                    faccia6++;
                }

            }
        }

	//Mostro in output i risultati
            System.out.printf(" Faccia1: %d,Faccia2: %d,Faccia3: %d,Faccia4: %d,Faccia5: %d,Faccia6: %d ",faccia1,faccia2,faccia3,
                    faccia4,faccia5,faccia6);


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