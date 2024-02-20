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
        int sceltaMoN=0;

        //chiedo all'utente di inserire il numero di stringhe che desidera inserire
        System.out.println("inserisci il numero di stringhe che vuoi inserire: ");
        numeroStringhe = keyboard.nextInt();

        //controllo
        if(numeroStringhe <= 0){
            do {
                System.out.println("Attenzione! Devi inserire un numero positivo");
                numeroStringhe = keyboard.nextInt();
            }while(numeroStringhe <= 0);
        }

        //dichiarazione array stringhe
        String[] disney = new String[numeroStringhe];

      //l'utente inserisce le stringhw
        for(int i=0; i<numeroStringhe; i++){
            System.out.println("inserisci la " + (i+1) + " stringa");
            disney[i]=keyboard.next();
        }

        //chiedo all'utente se desidera le stringhe  minuscole o maiuscole
        System.out.println("Cosa desideri visualizzare?");
        System.out.println("[1] - Stringhe Maiuscole");
        System.out.println("[2] - Stringhe Minuscole");
        sceltaMoN = keyboard.nextInt();

        //controllo
        if(sceltaMoN <1 || sceltaMoN > 2){
            do {
                System.out.println("Attenzione! Puoi scegliere tra 1 e 2");
                sceltaMoN = keyboard.nextInt();
            }while(sceltaMoN <1 || sceltaMoN > 2);
        }

        //swith case
        switch(sceltaMoN){
            case 1: //stringhe con iniziale Maiuscola
                //invoco il metodo stampa
                show(GetUpperWord(disney));
                break;
            case 2: //stringhe con iniziale Minuscola
                //invoco il metodo stampa
                show1(GetUpperWord1(disney));
                break;
            default: System.out.println("scelta non valida");
        }
    }

    //getUpperWord method (str maiuscole)
    private static String[] GetUpperWord(String[] disney) {
        String[] maiuscola = new String[disney.length];
        for(int i=0; i< disney.length; i++){
            if(disney[i].charAt(0) >= 'A' && disney[i].charAt(0) <= 'Z'){
                maiuscola[i] = disney[i];
            }
        }
        return maiuscola;
    }

    //show method (str maiuscole)
    private static void show(String[] up){
        System.out.println("Le stringhe che iniziano con l'iniziale Maiuscola sono: ");
        for(int i = 0; i < up.length; i++){
            if(up[i]!=null){
                System.out.println(up[i]);
            }
        }
    }

    //getUpperWord method (str minuscole)
    private static String[] GetUpperWord1(String[] disney) {
        String[] minuscola = new String[disney.length];
        for(int i=0; i< disney.length; i++){
            if(disney[i].charAt(0) >= 'a' && disney[i].charAt(0) <= 'z'){
                minuscola[i] = disney[i];
            }
        }
        return minuscola;
    }

    //show method (str minuscole)
    private static void show1(String[] up){
        System.out.println("Le stringhe che iniziano con l'iniziale minuscola sono: ");
        for(int i = 0; i < up.length; i++){
            if(up[i]!=null){
                System.out.println(up[i]);
            }
        }
    }
}