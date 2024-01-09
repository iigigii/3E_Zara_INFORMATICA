//Zara Luigi
//classe 3E
//Date: 28 novembre 2023

import java.security.Key;
import java.util.Scanner;
public class Vinaio {
    public static void main(String[] args)
    {
        //scanner
        Scanner Keyboard= new Scanner(System.in);

        //Dichiarazione e inizializzazione delle variabili
        int NumeroBottiglie, Viva;
        float  CapacitaBottiglia ,CostoAlLitro, TotaleImponibile, Iva, PrezzoFinale;
        CapacitaBottiglia=1.5F;
        CostoAlLitro=1;
        Viva=21;

        //Chiedo all'utente di fornire in ingresso il numero di bottiglioni che desidera acquistare
        System.out.println("Quante bottiglie di Barbera desidera acquistare? ");
        NumeroBottiglie= Keyboard.nextInt();

        //assegnazioni variabili
        TotaleImponibile=NumeroBottiglie*CapacitaBottiglia*CostoAlLitro;
        Iva=TotaleImponibile/100*Viva;
        PrezzoFinale=TotaleImponibile+Iva;

        //mostro in output lo scontrino
        System.out.println("Scomtrino:");
        System.out.println("Numero bottiglie acquistate: "+NumeroBottiglie);
        System.out.println("Prezzo totale di vendita: "+TotaleImponibile +"€");
        System.out.println("Iva applicata al totale imponibile: "+Iva +"€");
        System.out.println("Prezzo totale di vendita compreso di Iva: "+PrezzoFinale +"€");

    }
}



