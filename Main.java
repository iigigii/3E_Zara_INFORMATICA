//Zara Luigi
//Classe 3E
//data 12/05/2024

/*
Realizzare un esercizio in cui un array  viene prima duplicato, poi uno viene ordinato con selection sort,  l'altro con
bubble sort.
Contare il numero di operazioni svolte, tramite un contatore che deve essere stampato alla fine di ognuna delle due
esecuzioni.
*/

//importazione librerie
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //dichirazione dimensione array
        int[] dimensioni = {10, 100, 1000, 1000, 10000, 100000, 1000000};

        for(int i = 0; i < dimensioni.length; i++){
            int dimensione = dimensioni[i];
            int[] array = new int[dimensione];
            //creazione di un oggetto random
            Random casuale = new Random();

            //popolo il vettore con numeri casuali
            for(int j = 0; j < dimensione; j++){
                array[j] = casuale.nextInt(100);
            }

            //creo due copie dell'array da riordinare con selection-bubble sort
            int[] arraySelectionSort = new int[dimensione];
            int[] arrayBubbleSort = new int[dimensione];


            //popolo i due nuovi vettori con i numeri presenti nel vettore originale
            for(int k = 0; k < dimensione; k++){
                arraySelectionSort[k] = array[k];
                arrayBubbleSort[k] = array[k];
            }

            int operazioniSelection = selectionSort(arraySelectionSort);
            int operazioniBubble = bubbleSort(arrayBubbleSort);

            //output
            System.out.println("[1] - Dimensione dell'array: " + dimensione);
            System.out.println("[2] - Operazioni con Selection Sort -> " + operazioniSelection);
            System.out.println("[3] - Operazioni con Bubble Sort -> " + operazioniBubble);
            //new paragraph
            System.out.println();
        }
    }

    //algorito di ordinamento selection sort
    public static int selectionSort(int[] array) {
        int operazioni = 0;

        for(int i = 0; i < array.length - 1; i++){
            int indexMin = i;

            for(int j = i+1; j < array.length; j++){
                operazioni++;
                if(array[j] < array[indexMin]){
                    indexMin = j;
                }
            }

            if(indexMin != i){
                int temp = array[indexMin];
                array[indexMin] = array[i];
                array[i] = temp;
                operazioni++;
            }
        }

        return operazioni;
    }

    //algoritmo di ordinamento bubble sort
    public static int bubbleSort(int[] array) {
        int operazioni = 0;

        for(int i = 0; i < array.length - 1; i++){
            for(int j = 0; j < array.length - 1 - i; j++){
                operazioni++;
                if(array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    operazioni++;
                }
            }
        }

        return operazioni;
    }
}