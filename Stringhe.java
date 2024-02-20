//zara luigi
//3E
//data: 20/2/2024

//importazione librerie
import java.util.Scanner;

public class Stringhe {
    public static void main(String[] args) {
        //dichiarazione scanner
        Scanner keyboard = new Scanner(System.in);

        //dichiarazione variabili
        int numeroStringhe;

        //chiedo all'utente di inserire il numero di stringhe che desidera inserire
        System.out.println("inserisci il numero di stringhe che vuoi inserire: ");
        numeroStringhe = keyboard.nextInt();

        //dichiarazione array stringhe
        String[] disney = new String[numeroStringhe];

        for(int i=0; i<numeroStringhe; i++){
            System.out.println("inserisci la " + (i+1) + " stringa");
            disney[i]=keyboard.next();
        }

        //invoco il metodo stampa
        show(GetUpperWord(disney));
        show1(GetUpperWord1(disney));
    }

    //getUpperWord method
    private static String[] GetUpperWord(String[] disney) {
        String[] maiuscola = new String[disney.length];
        for(int i=0; i< disney.length; i++){
            if(disney[i].charAt(0) >= 'A' && disney[i].charAt(0) <= 'Z'){
                maiuscola[i] = disney[i];
            }
        }
        return maiuscola;
    }

    //show method
    private static void show(String[] up){
        System.out.println("Le stringhe che iniziano con l'iniziale Maiuscola sono: ");
        for(int i = 0; i < up.length; i++){
            if(up[i]!=null){
                System.out.println(up[i]);
            }
        }
    }

    private static String[] GetUpperWord1(String[] disney) {
        String[] minuscola = new String[disney.length];
        for(int i=0; i< disney.length; i++){
            if(disney[i].charAt(0) >= 'a' && disney[i].charAt(0) <= 'z'){
                minuscola[i] = disney[i];
            }
        }
        return minuscola;
    }
    private static void show1(String[] up){
        System.out.println("Le stringhe che iniziano con l'iniziale minuscola sono: ");
        for(int i = 0; i < up.length; i++){
            if(up[i]!=null){
                System.out.println(up[i]);
            }
        }
    }
}
