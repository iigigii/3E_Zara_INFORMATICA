//Zara Luigi
//Classe 3E
//Data: 14/01/2024
//Semplificare, con l'utilizzo  dei vettori, il codice visto in classe.

//importazione librerie
import java.util.Random;
public class Statistica {
    public static void main(String[] args) {
        //Dichiarazione e inizializzazione delle variabili
        int [] frequenze = new int[6]; //Vettore
        int valore=0;

        //ciclo for
        for( int i = 0; i < 100; i++) { //100 è il numero di volte che il ciclo si ripete
            valore = valoreRandom(0, 6);
            FacceDado(valore);
            //anzichè usare lo switch-case utilizzo:
            frequenze[valore - 1]++;
        }

        //ciclo for che mostra in output il risulato:
        for(int index = 0; index < frequenze.length; index++){
            System.out.println("Faccia "+(index+1)+" = "+frequenze[index]);
            //(index+1) incrementa di 1 Faccia fino a 6 (numero di facce del dado)
        }
    }

    //metodo random (dadi)
    private static int valoreRandom(int minValue, int maxValue)
    {
        Random casuale = new Random(); //Metodo che non ha nessun parametro, si chiama costruttore.
        return  casuale.nextInt(minValue,maxValue)+1;

    }

    //metodo FacceDado
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