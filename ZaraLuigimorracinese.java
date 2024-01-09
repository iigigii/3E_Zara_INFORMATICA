//Zara Luigi
//Classe 3E
//Data 10 Dicembre 2023
//Realizzare il programma della morra cinese.

//Importazione librerie
import java.util.Scanner;

public class morracinese {
    public static void main(String[] args) {

        //Dichiarazione Scanner
        Scanner keyboard = new Scanner(System.in);

        //Dichiarazione variabili
        char giocatore1Scelta, giocatore2Scelta;

        //introduzione programma
        System.out.println("Benvenuto nel gioco della Morra Cinese!");

        //procedimento
        //uso del ciclo do-while
        do {
            //Chiedo al primo giocatore di inserire una delle seguenti scelte:
            System.out.println("Giocatore 1: A (Carta) - S (Sasso) - D (Forbici)");
            giocatore1Scelta = keyboard.next().toUpperCase().charAt(0);
            /*
            Se il primo giocatore ha inserito un valore diverso da quelli proposti il
            suo input è errato e quindi dovra rinserirlo nuovamente
             */
            while (giocatore1Scelta != 'A' && giocatore1Scelta != 'S' && giocatore1Scelta != 'D') {
                System.out.println("Hai inserito un valore esterno al range consentito! Scegli tra: ASD");
                giocatore1Scelta = keyboard.next().toUpperCase().charAt(0);
            }

            //.toUpperCase() è un comando che mi consente di digitare anche lettere minuscole e accertarle ugualmente

            //Chiedo al secondo giocatore di inserire una delle seguenti scelte:
            System.out.println("Giocatore 2: J (Carta) - K (Sasso) - L (Forbici)");
            giocatore2Scelta = keyboard.next().toUpperCase().charAt(0);
            /*
            Se il secondo giocatore ha inserito un valore diverso da quelli proposti il
            suo input è errato e quindi dovra rinserirlo nuovamente
             */
            while (giocatore2Scelta != 'J' && giocatore2Scelta != 'K' && giocatore2Scelta != 'L') {
                System.out.println("Hai inserito un valore esterno al range consentito! Scegli tra: JKL");
                giocatore2Scelta = keyboard.next().toUpperCase().charAt(0);
            }

            //se il giocatore 1 ha scelto A(Carta) e il giocatore 2 ha scelto J(Carta) allora è pareggio idem per gli altri valori
            if ((giocatore1Scelta == 'A' && giocatore2Scelta == 'J') ||
                    (giocatore1Scelta == 'S' && giocatore2Scelta == 'K') ||
                    (giocatore1Scelta == 'D' && giocatore2Scelta == 'L')) {
                System.out.println("Pareggio");

            } else if ((giocatore1Scelta == 'A' && giocatore2Scelta == 'S') ||
                       (giocatore1Scelta == 'S' && giocatore2Scelta == 'L') ||
                       (giocatore1Scelta == 'D' && giocatore2Scelta == 'A') ||
                       (giocatore1Scelta == 'A' && giocatore2Scelta == 'J')) {
                System.out.println("Ha vinto il 1° giocatore");
            } else {
                System.out.println("Ha vinto il 2° giocatore");
            }

            //importazione schermo non visibile
            Clear();

            //la condizione del do-while è che il ciclo deve ripetersi fino a quando uno dei due  giocatori non metta X come input
        } while (giocatore1Scelta != 'X' && giocatore2Scelta != 'X');

    }

    //La digitazione dei tasti non deve essere visibile
    private static void Clear(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
