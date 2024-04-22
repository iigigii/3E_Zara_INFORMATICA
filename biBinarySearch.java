//Zara Luigi
//Classe 3E
/*
Creare il metodo biBinarySearch che, applicato dopo aver invocato evenOddSearch sia in grado di verificare velocemente la presenza di un dato valore restituendone la posizione.
Dal nome del metodo si evince la necessità di dover modificare il metodo della ricerca dicotomica (detta anche ricerca binaria, per gli amici)
Esempio:2, 4, 6, 8, 9, 7, 5, 3, 1 - Cerco 0' restituisce -1
2, 4, 6, 8, 9, 7, 5, 3, 1 - Cerco 6 restituisce 2
*/

//importazione delle librerie
import java.util.Scanner;

public class biBinarySearch {
    public static void main(String[] args) {
        //dichiarazione scanner
        Scanner keyboard = new Scanner(System.in);

        //dichiarazione e inizializzazione delle variabili
        int qtaNumeri = 0;
        int numeroDaCercare;
        int posizione;

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

        //new paragraph
        System.out.println("\n");

        //chiedo all'utente di inserire il numero che desidera cercare
        System.out.println("inserisci il numero che desideri cercare: ");
        numeroDaCercare = keyboard.nextInt();

        //inizializzo la variabile posizione con il risultato di:
        posizione = biBinarySearch(array, numeroDaCercare);

        //output
        if(posizione != -1){ //se il valore della posizione è != 1: il numero si trova nella X posizione
            System.out.println("Il numero " + numeroDaCercare + " si trova nella posizione: " + posizione);
        } else { //altrimenti il numero non è presente nel vettore
            System.out.println("Il numero " + numeroDaCercare + " non è presente nell'array :/");
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

    //metodo biBynarySearch
    public static int biBinarySearch(int[] array, int numeroDaCercare){
        //dichiarazione e inizializzazione delle variabili
        int sx = 0;
        int dx = array.length - 1;
        int Imedio;

        //ciclo while
        while(sx <= dx){
            Imedio = (sx + dx) / 2; //calcolo l'indice medio sommmando sx + dx e poi dividdndo * 2

            //se il numero nell'indice kedio è uguale a quello cercato, restituisco la posizione
            if(array[Imedio] == numeroDaCercare){
                return Imedio;
            } else if(array[Imedio] < numeroDaCercare){
                sx = Imedio + 1; //"sposto" in avanti di una cella l'indice sx
            } else {
                dx = Imedio - 1; //"sposto" in avanti di una cella l'indice dx
            }
        }

        //se il numero cercato non è presente nell'array, return -1
        return -1;
    }
}