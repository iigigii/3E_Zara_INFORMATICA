//Zara Luigi
//Class 3E
//Date: 22/01/2024
/*
* Modificare l'esercizio in modo da inserire il menù visto in classe.
* Eliminare eventuali ridondanze presenti all'interno dell'esercizio.
* Apportare una miglioria "piacere" all'esercizio.
*/

//Importing libraries
import java.util.Random;
import java.util.Scanner;

public class FacceDado {
    public static void main(String[] args) {
        //Scanner declaration
        Scanner keyboard = new Scanner(System.in);
        Scanner tastiera = new Scanner(System.in);

        //scelta & exit variable declaration
        int scelta = 0;
        boolean exit = true;

        //String array declaration
        String [] opzioni = {"=== Gioco Dadi === ", "[1]-Sfida tra due giocatori", "[2] Sfida contro il computer", "[3] Exit "};

        while(exit){
            //wait
            Wait(2500);
            //menu' output
            System.out.println(Menu(opzioni, tastiera));
            //wait
            Wait(2500);

            scelta = tastiera.nextInt();

            //switch case (scelta)
            switch (scelta) {
                case 1:
                    SfidaGiocatori();
                    Wait(200);
                    break;
                case 2:
                    GiocatoreVSComputer();
                    Wait(200);
                    break;
                case 3:
                    exit = false;
                    Wait(200);
                    break;
                default:
                    System.out.println("Scelta errata! ");
                    Wait(200);
            }
        }
    }

    //menu'
    private static int Menu (String opzioni[], Scanner tastiera)
    {
        int scelta;

        do {
            //clear screen
            ClrScr();
            System.out.println("------------------");
            System.out.println(opzioni[0]); //(opzioni[0]) shows what the string contains
            System.out.println("------------------");
            for (int i=1; i < opzioni.length; i++) {
                System.out.println(opzioni[i]);
            }
            scelta = tastiera.nextInt();

            //if the user choose a number < 1 or > opzioni.lenght, the choose is invalid
            if ((scelta < 1 ) || (scelta > opzioni.length -1 ))
            {
                //the option is innvalid, try again
                System.out.println("Opzione Sbagliata");
                Wait(1000);
            }
        }
        while ((scelta < 1 ) || (scelta > opzioni.length -1 ));
        return scelta;
    }

    //player 1 vs player 2
    private static void SfidaGiocatori () {
        //Scanner declaration
        Scanner keyboard = new Scanner(System.in);

        //Declaration of the variable 'faccia' as a random number generator
        Random faccia = new Random();

        //Declaration of variables for player 1 and player 2
        int giocatore1 = 0, giocatore2 = 0;
        int giocatoreNumero1 = 1, giocatoreNumero2 = 2;

        //string variables name declaration
        String name1 = new String();
        String name2 = new String();

        //I ask user 1 to enter his/her nickname
        System.out.println("Primo giocatore, inserisci il tuo username: ");
        name1 = keyboard.nextLine();

        //I ask user 2 to enter his/her nickname
        System.out.println("Ora tocca al secondo giocatore, inserisci il tuo username: ");
        name2 = keyboard.nextLine();

        do {
            //user 1
            System.out.println(name1 + ", premi [1] per lanciare il tuo dado: ");
            giocatore1 = keyboard.nextInt();

            //while user 1 put in input a number < 1 or > 2 the number is invalid
            while(giocatore1 < 1 || giocatore1 >2){
                //clear screen
                ClrScr();
                System.out.println(name1+ " hai digitato un numero invalido! Devi digitare 1");
                giocatore1 = keyboard.nextInt();
            }
            if (giocatoreNumero1 == 1) {
                //player 1
                for (int i = 1; i <= 7; i++) {
                    if (i == 7) {
                        Wait1();
                        ClrScr();
                        System.out.println("A " + name1 + " è uscito:");
                        giocatore1 = faccia.nextInt(6) + 1;
                    } else {
                        Wait1();
                        ClrScr();
                        giocatore1 = i;
                    }
                    FacceDado(giocatore1);
                }
            }
        } while (giocatoreNumero1 != 1);

        do {
            //user 2
            System.out.println(name2 + ", premi [2] per lanciare il tuo dado: ");
            giocatore2 = keyboard.nextInt();

            //while user 2 put in input a number < 2 or > 3 the number is invalid
            while(giocatore2 < 2 || giocatore2 > 3){
                //clear screen
                ClrScr();
                System.out.println(name2+ " hai digitato un numero invalido! Devi digitare 2");
                giocatore2 = keyboard.nextInt();
            }
            if (giocatoreNumero2 == 2) {
                //player 1
                for (int i = 1; i <= 7; i++) {
                    if (i == 7) {
                        Wait1();
                        ClrScr();
                        System.out.println("A " + name2 + " è uscito:");
                        giocatore2 = faccia.nextInt(6) + 1;
                    } else {
                        Wait1();
                        ClrScr();
                        giocatore2 = i;
                    }
                    FacceDado(giocatore2);
                }
            }
        } while (giocatoreNumero2 != 2);

        //Determine who the winner is
        //If the number rolled for Player 1 is greater than the number rolled for Player 2, Player 1 wins
        if (giocatore1 > giocatore2) {
            System.out.println("Il Giocatore 1(" + name1+ ") è il vincitore!");
            //If the number rolled for player 2 is greater than the number rolled for player 1, player 2 wins
        } else if (giocatore1 < giocatore2) {
            System.out.println("Il Giocatore 2(" + name2 +") è il vincitore!");
            //If the number rolled by player 1 is equal to the number rolled by player 2, it's a tie
        } else {
            System.out.println("È un pareggio!");
        }
    }

    //player vs computer
    private static void GiocatoreVSComputer ()
    {
        //Scanner declaration
        Scanner keyboard = new Scanner(System.in);

        //Declaration of the variable 'faccia' as a random number generator
        Random faccia = new Random();

        //Declaration of variables for player 1 and computer
        int giocatore = 0, computer = 0;
        int giocatore1 = 1;

        //string variables name declaration
        String name = new String();

        //I ask user 1 to enter his/her nickname
        System.out.println("giocatore, inserisci il tuo username: ");
        name = keyboard.nextLine();

        do {
            //user 1
            System.out.println(name + ", premi [1] per lanciare il tuo dado: ");
            giocatore = keyboard.nextInt();

            //while user 1 put in input a number < 1 or > 2 the number is invalid
            while(giocatore < 1 || giocatore >2){
                //clear screen
                ClrScr();
                System.out.println(name+ " hai digitato un numero invalido! Devi digitare 1");
                giocatore = keyboard.nextInt();
            }
            if (giocatore1 == 1) {
                //player 1
                for (int i = 1; i <= 7; i++) {
                    if (i == 7) {
                        Wait1();
                        ClrScr();
                        System.out.println("A " + name + " è uscito:");
                        giocatore = faccia.nextInt(6) + 1;
                    } else {
                        Wait1();
                        ClrScr();
                        giocatore = i;
                    }
                    FacceDado(giocatore);
                }
            }
        } while (giocatore1 != 1);

        //clear screen
        ClrScr();
        Wait(2050);

        //
        System.out.println("il computer sta lanciando il dado..");

        //computer
        for(int i = 1; i <= 7; i++){
            if (i == 7) {
                Wait1();
                ClrScr();
                System.out.println("al Computer è uscito : ");
                computer = faccia.nextInt(6) + 1;
            } else {
                Wait1();
                ClrScr();
                computer = i;
            }
            FacceDado(computer);
        }

        //Determine who the winner is
        //If the number rolled for Player is greater than the number rolled for computer, Player  wins
        if (giocatore > computer) {
            System.out.println("Il Giocatore 1(" + name+ ") è il vincitore!");
            //If the number rolled for computer is greater than the number rolled for player , computer wins
        } else if (giocatore < computer) {
            System.out.println("Il Computer è il vincitore!");
            //If the number rolled by player  is equal to the number rolled by computer, it's a tie
        } else {
            System.out.println("È un pareggio!");
        }
    }

    //Dice roll
    private static void FacceDado(int valoreFaccia) {

        switch (valoreFaccia) {
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


    //clear screen
    private static void ClrScr(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //wait
    private static void Wait(int attesa) {
        try{
            Thread.sleep(attesa);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //wait 1
    private static void Wait1() {
        try{
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}