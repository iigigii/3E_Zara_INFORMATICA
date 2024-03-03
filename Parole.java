//zara luigi
//classe 3E

/*
Realizzare un programma che permetta, data una stringa contenente delle parole divise da uno spazio, di caricarle all'interno
di un vettore utilizzando un metodo.
Stampare a video il contenuto della parole.
*/

//importazione librerie
import java.util.Scanner;

public class Parole{
    public static void main(String[] args) {
        //dichiarazione scanner
        Scanner keyboard = new Scanner(System.in);

        //dichiarazione variabili
        String stringInput;

        //Chiedo all'utente di inserire una stringa di paorle separate da uno spazio
        System.out.println("inserisci una stringa di paorle separate da uno spazio");
        stringInput = keyboard.nextLine();

        //array di stringhe
        String[] parole = loadWords(stringInput);

        //invoco il metodo per mostrare le parole che sono state caricate nel vettore
        System.out.println("Ecco le parole che sono state caricate nel vettore:");
        showWords(parole);

    }
    //metodo loadWords
    private static String[] loadWords (String stringInput) {
        String[] parole = stringInput.split(" ");
        return parole;
    }

    //metodo showWords
    private static void showWords (String[] parole) {
        for(int i = 0; i < parole.length; i++){
            System.out.println(parole[i]);
        }
    }
}