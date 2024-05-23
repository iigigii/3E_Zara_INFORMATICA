//Zara Luigi
//Classe 3E
//Data: 14-04-2024

//importazione librerie
import static Utility.Tools.*;
import java.util.Scanner;

public class Photomath
{
    public static void main(String[] args)
    {
        //dichiarazione scanner
        Scanner keyboard = new Scanner(System.in);

        //dichiarazione e inizializzazione delle variabili
        double a = 0, b = 0, c = 0;
        boolean quit = false;

        //menù
        String[] opzioni = {
                "PHOTOMATH",
                "[1] - equazioni di primo grado ",
                "[2] - equazioni di secondo grado",
                "[3] - fine"
        };

        do {
            switch (printMenu(opzioni, keyboard)) {
                case 1:
                    break;
                case 2:
                    //chiedo all'utente di inserire un'uquazione di 2° grado
                    System.out.println("Inserisci l'equazione nella forma: ax^2 + bx + c = 0");

                    //chiedo all'utente di inserire il coefficente a
                    System.out.println("Inserisci il coefficente a: ");
                    a = keyboard.nextDouble();

                    //chiedo all'utente di inserire il coefficente b
                    System.out.println("Inserisci il coefficente b: ");
                    b = keyboard.nextDouble();

                    //chiedo all'utente di inserire il coefficente c
                    System.out.println("Inserisci il coefficente c: ");
                    c = keyboard.nextDouble();

                    //invoco il metodo che ritorna i valori delle x
                    double[] soluzioni = CalcoloX(a, b, c);

                    if (soluzioni.length == 2) {
                        System.out.println("Le radici dell'equazione sono reali e distinte:");
                        System.out.println("x1 = " + soluzioni[0]);
                        System.out.println("x2 = " + soluzioni[1]);
                    } else if (soluzioni.length == 1) {
                        System.out.println("L'equazione ha radici reali coincidenti:");
                        System.out.println("x = " + soluzioni[0]);
                    } else {
                        System.out.println("Le radici dell'equazione sono complesse:");
                        System.out.println("x1 = " + soluzioni[0] + " + " + soluzioni[1] + "i");
                        System.out.println("x2 = " + soluzioni[0] + " - " + soluzioni[1] + "i");
                    }


                    break;
                case 3:
                    quit = true;
                    break;
            }
        } while (!quit);
        keyboard.close();
    }

    private static double[] CalcoloX(double a, double b, double c){
        //dichiarazione discriminante
        double delta = b * b - 4 * a * c;

        //soluzioni
        if (delta > 0) {
            double radice1 = (-b + Math.sqrt(delta)) / (2 * a);
            double radice2 = (-b - Math.sqrt(delta)) / (2 * a);
            return new double[]{radice1, radice2};
        } else if (delta == 0) {
            double radice = -b / (2 * a);
            return new double[]{radice};
        } else {
            double parteReale = -b / (2 * a);
            double parteImmaginaria = Math.sqrt(-delta) / (2 * a);
            return new double[]{parteReale, parteImmaginaria};
        }
    }
}