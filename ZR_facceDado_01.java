//Zara Luigi
//Class 3E
//Date: 09/01/2024
//"Complete the exercise done remotely so that a competition can take place between two players, determining the winner."
//Importing libraries
import java.util.Random;
import java.util.Scanner;

public class FacceDado {
    public static void main(String[] args) {
        //Scanner declaration
        Scanner keyboard = new Scanner(System.in);
        //Declaration of the variable 'faccia' as a random number generator
        Random faccia = new Random();

        //Declaration of variables for player 1 and player 2
        int giocatore1 = 0, giocatore2 = 0;

        //player 1
        for(int i = 1; i <= 7; i++){
            if (i == 7) {
                Wait();
                ClrScr();
                System.out.println("Giocatore 1 : ");
                giocatore1 = faccia.nextInt(0, 6) + 1;
            } else {
                Wait();
                ClrScr();
                giocatore1 = i;
            }

            FacceDado(giocatore1);
        }

        //player 2
        for(int i = 1; i <= 7; i++){
            if (i == 7) {
                Wait();
                ClrScr();
                System.out.println("Giocatore 2 : ");
                giocatore2 = faccia.nextInt(0, 6) + 1;
            } else {
                Wait();
                ClrScr();
                giocatore2 = i;
            }

            FacceDado(giocatore2);
        }

        //Determine who the winner is
        //If the number rolled for Player 1 is greater than the number rolled for Player 2, Player 1 wins
        if (giocatore1 > giocatore2) {
            System.out.println("Il Giocatore 1 è il vincitore!");
            //If the number rolled for player 2 is greater than the number rolled for player 1, player 2 wins
        } else if (giocatore1 < giocatore2) {
            System.out.println("Il Giocatore 2 è il vincitore!");
            //If the number rolled by player 1 is equal to the number rolled by player 2, it's a tie
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
    private static void Wait() {
        try{
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}