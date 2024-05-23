//Zara Luigi
//Classe 3E

/*
Dividere un stringa di max 80char contenente delle parole in più stringhe di max 40 char
senza troncare le parole.
*/

public class DividiStringa {
    public static void main(String[] args) {
        //dichiarazione e inizializzazione delle variabili
        final int lunghezzaMax = 40;
        
        String frase = "la mamma di Martina va al mercato a comprare le fragole per fare la macedonia";

        //mostro in output la quantità di lettere che contiene la frase
        System.out.println("[1] La frase contine: " + frase.length() + " caratteri");

        //divido la frase in parole separande da uno "spazio" -> .split(" ");
        String[] parole = frase.split(" ");

        //dichiaro una stringa temporanea per memorizzare le parole di una riga
        String riga = "";

        //ciclo for
        for(int i = 0; i < parole.length; i++) {
            String parola = parole[i];
            if((riga + parola).length() > lunghezzaMax) {
                System.out.println(riga);
                riga = "";
            }

            //aggiungo la parola alla riga corrente
            riga += parola + " ";
        }

        System.out.println(riga);
    }
}