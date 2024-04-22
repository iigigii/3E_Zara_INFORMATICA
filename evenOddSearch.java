//Zara Luigi
//Classe 3E
/*
Creare il metodo evenOddSearch che dato un vettore, ordini i numeri pari in modo crescente e i dispari in modo decrescente, disposti nella sequenza:
- pari crescente
- dispari decrescente
Esempio del contenuto dell'array: 3, 4, 2, 5, 6, 1, 7, 8, 9 --> 2, 4, 6, 8, 9, 7, 5, 3, 1
*/

//importazione delle librerie
import java.util.Scanner;

public class evenOddSearch {
    public static void main(String[] args) {
        //dichiarazione scanner
        Scanner keyboard = new Scanner(System.in);

        //dichiarazione e inizializzazione delle variabili
        int qtaNumeri = 0;

        //chiedo all'utente la quantità di numeri che vuole inserire
        System.out.println("Quanti numeri desidera inserire? ");
        qtaNumeri = keyboard.nextInt();

        //istanzio un vettore con i numeri da riordinare con la dimensiore scelta dall'utente
        int[] array = new int[qtaNumeri];

        //popolo il vettore
        for (int i = 0; i < qtaNumeri; i++) {
            System.out.println("inserisci il " + (i + 1) + "° numero");
            array[i] = keyboard.nextInt();
        }

        //invoco il metodo evenOddSearch
        evenOddSearch(array);

        //output
        for(int i = 0; i < array.length;  i++){
            System.out.print(array[i] + " ");
        }
    }

    //metodo evenOddSearch
    public static void evenOddSearch(int[] arrayOrdinato) {
        //dichiarazione e inizialozzazione delle variabili
        int n = arrayOrdinato.length;
        //int sx = indice sinistro // int dx = indice destro
        int sx = 0, dx = n - 1;

        //questo ciclo continua fino a quando l'indice sinistro (sx) è minore di quello destro (dx)
        while(sx < dx){
            //questo ciclo scorre gli elementi dell'array a partire dall'indice sinistro fino a quando non trova un numero dispari
            while(arrayOrdinato[sx] % 2 == 0 && sx < dx){
                sx++;
            }
            //questo ciclo scorre gli elementi dell'array a partire dall'indice destro  fino a quando non trova un numero pari
            while(arrayOrdinato[dx] % 2 == 1 && sx < dx){
                dx--;
            }
            //se un numero pari e un numero dispari sono in posizioni diverse, scambio i numeri
            if(sx < dx){
                int temp = arrayOrdinato[sx];
                arrayOrdinato[sx] = arrayOrdinato[dx];
                arrayOrdinato[dx] = temp;
            }
        }

        //ordino i numeri dispari in ordine crescente
        for(int i = 0; i < sx; i++){
            for(int j = i + 1 ; j < sx; j++){
                /*
                il ciclo for: for(int j = i + 1 ; j < n; j++) confronta l'elemento attuale
                con l'elemento succesivo [(i+1)], se il numero successivo è minore di quello
                attuale, eseguo lo scambio
                 */
                if(arrayOrdinato[j] < arrayOrdinato[i]){
                    //scambio degli elementi se il numero successivo è minore di quello attuale
                    int temp = arrayOrdinato[i];
                    arrayOrdinato[i] = arrayOrdinato[j];
                    arrayOrdinato[j] = temp;
                }
            }
        }

        //ordino i numeri dispari in ordine decrescente
        for(int i = sx; i < n; i++){
            for(int j = i + 1 ; j < n; j++){
                /*
                il ciclo for:  for(int j = i + 1 ; j < n; j++) confronta l'elemento attuale
                con l'elemento succesivo [(i+1)], se il numero successivo è maggiore di quello
                attuale, eseguo lo scambio
                 */
                if(arrayOrdinato[j] > arrayOrdinato[i]){
                    //scambio degli elementi se il numero successivo è maggiore di quello attuale
                    int temp = arrayOrdinato[i];
                    arrayOrdinato[i] = arrayOrdinato[j];
                    arrayOrdinato[j] = temp;
                }
            }
        }
    }
}