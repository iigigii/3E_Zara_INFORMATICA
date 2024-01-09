//Surname and name: Zara Luigi
//Class 3E
//Date: 30 November 2023
import java.util.Scanner;
public class Vinaio1 {
        public static void main(String[] args) {
                // Scanner variable declaration
                Scanner Keyboard = new Scanner(System.in);

                // Declaration and initialisation of variables
                int NumeroBottiglie, Viva, Scelta;
                int Chiusura, nClienti;
                float Cassa;
                float CapacitaBottiglia, TotaleImponibile, Iva, PrezzoFinale;
                float CostoAlLitroBarbera, CostoAlLitroMerlot, CostoAlLitroLugana;

                //initialisation of variable CapacitaBottiglia
                CapacitaBottiglia = 1.5F;

                //initialisation of variables of how much cost the type of wine
                CostoAlLitroBarbera = 1.5F;
                CostoAlLitroMerlot = 1;
                CostoAlLitroLugana = 2;

                //initialisation of variables Iva, Cassa, Clienti and NumeroBottiglie
                Iva=0;
                Viva = 21;
                Cassa = 0;
                nClienti = 0;
                NumeroBottiglie = 0;

                //initialisations of variables of receipt
                TotaleImponibile=0;
                PrezzoFinale = 0;
                Chiusura = 0;

                //Procedure
                do {
                        //initialisation of variable Client
                        nClienti = nClienti + 1;

                        //I ask the user what they want to buy
                        System.out.println("Buongiorno, cosa desidera acquistare? ");
                        System.out.println("Digiti 1 per il Barbera \nDigiti 2 per il Lugana \nDigiti 3 per il Merlot  ");
                        Scelta = Keyboard.nextInt();

                        //until the customer enters a number between 1 and 3 the cycle repeats.
                        while(Scelta > 4 || Scelta < 0){
                                System.out.println("La sua scelta non e' presente nel nostro catalogo ");
                                System.out.println("Digiti 1 per il Barbera \nDigiti 2 per il Lugana \nDigiti 3 per il Merlot  ");
                                Scelta = Keyboard.nextInt();
                        }

                        //new paragraph
                        System.out.println("\n");

                        //I ask the user how many bottles of wine they want to buy
                        if (Scelta > 0 && Scelta < 4) {
                                System.out.println("Quante bottiglie desidera acquistare? ");
                                NumeroBottiglie = Keyboard.nextInt();

                                //The number of the bottles can't be negative
                                while(NumeroBottiglie<0){
                                        System.out.println("Il numero delle bottiglie non può essere negativo!");
                                        System.out.println("Inserisci un numero positivo");
                                        NumeroBottiglie = Keyboard.nextInt();
                                }

                                if (NumeroBottiglie > 0) {
                                        switch (Scelta) {
                                                case 1:
                                                        // Case 1: Barbera wine
                                                        TotaleImponibile = NumeroBottiglie * CapacitaBottiglia * CostoAlLitroBarbera;
                                                        Iva = TotaleImponibile / 100 * Viva;
                                                        PrezzoFinale = TotaleImponibile + Iva;
                                                        break;

                                                case 2:
                                                        // Case 2: Lugana wine
                                                        TotaleImponibile = NumeroBottiglie * CapacitaBottiglia * CostoAlLitroLugana;
                                                        Iva = TotaleImponibile / 100 * Viva;
                                                        PrezzoFinale = TotaleImponibile + Iva;
                                                        break;

                                                case 3:
                                                        // Case 3: Merlot wine
                                                        TotaleImponibile = NumeroBottiglie * CapacitaBottiglia * CostoAlLitroMerlot;
                                                        Iva = TotaleImponibile / 100 * Viva;
                                                        PrezzoFinale = TotaleImponibile + Iva;
                                                        break;

                                                //invalid choice
                                                default:
                                                        if (Scelta < 0 && Scelta > 4) {
                                                                System.out.println("Scelta non valida.");
                                                        }
                                                        break;
                                        }

                                        //initialisation of variable Cassa
                                        Cassa = Cassa + PrezzoFinale;
                                }

                                //new paragraph
                                System.out.println("\n");

                                //receipt output
                                System.out.println("Scontrino:");
                                System.out.println("Numero bottiglie acquistate: " + NumeroBottiglie);
                                System.out.println("Prezzo totale di vendita: " + TotaleImponibile + "€");
                                System.out.println("Iva applicata al totale imponibile: " + Iva + "€");
                                System.out.println("Prezzo totale di vendita compreso di Iva: " + PrezzoFinale + "€");

                                //new paragraph
                                System.out.println("\n");
                                do {
                                        //Does the cash register have to remain open?
                                        System.out.println("La cassa deve rimanere aperta?");
                                        System.out.println("Digita 1.si / Digita 2.no");
                                        Chiusura = Keyboard.nextInt();

                                        // the number of the Chiusura can't be over and equal 2 and inferior or equal of 1
                                        if (Chiusura != 1 && Chiusura != 2) {
                                                System.out.println("Il numero inserito non è valido!");
                                        }
                                } while (Chiusura < 1 || Chiusura > 2);
                        }

                } while (Chiusura == 1);

                //Output of Total profit and number of customers
                System.out.println("Hai guadagnato in tutto: " + Cassa + "€");
                System.out.println("Numero clienti: " + nClienti);
        }
}