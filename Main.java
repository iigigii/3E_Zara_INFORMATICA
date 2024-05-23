//Zara luigi
//classe 3E

//importazione tools utility
import static tools.utility.*;
//importazione librerie
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        //istanzio un oggetto scanner
        Scanner keyboard = new Scanner(System.in);

        //menu opzioni
        String[] operazioni = {"VODAFONE",
                "[1] Inserimento",
                "[2] Visualizzazione",
                "[3] Ricerca",
                "[4] Ricerca Numero telefonico",
                "[5] Modifica contatto",
                "[6] Cancella contatto",
                "[7] Visualizza in ordine alfabetico",
                "[8] Telefonata",
                "[9] Ricarica",
                "[10] Salva file",
                "[11] Carica file",
                "[12] Fine"};

        //dichiarazione e inizializzazione delle variabili
        boolean Sitel = true;
        final int nMax = 3;
        int contrattiVenduti = 0;
        int posizione;
        boolean fine = true;

        //istanzio un oggetto gestore
        Contatto[] gestore = new Contatto[nMax];

        do {
            switch (menu(operazioni, keyboard)) {
                case 1:
                    if (contrattiVenduti < nMax) {
                        //firma contratto
                        gestore[contrattiVenduti]=leggiPersona(Sitel,keyboard);
                        contrattiVenduti++;
                    } else {
                        System.out.println("Non ci sono più contratti da vendere");
                    }
                    break;
                case 2: {
                    if(contrattiVenduti!=0){
                        visualizza(gestore, contrattiVenduti);
                    } else {
                        System.out.println("Non sono ancora presenti contratti venduti");
                    }
                    break;
                }
                case 3: {
                    if(contrattiVenduti !=0){
                        //Ci sono contratti venduti
                        //lettura, ricerca, visualizzazione
                        if(ricerca (gestore,leggiPersona(false, keyboard), contrattiVenduti)){
                            System.out.println("Il contatto esiste");

                        }else{
                            System.out.println("Il contatto non esiste");
                        }
                    }else{
                        System.out.println("Non sono ancora presenti contratti venduti");
                    }
                    break;
                }
                case 4 :
                    if(contrattiVenduti!=0){
                        posizione=RicercaIndex(gestore, leggiPersona(false, keyboard), contrattiVenduti);
                        if(posizione != -1){
                            System.out.println(gestore[posizione].cognome + " " + gestore[posizione].nome + ": " + gestore[posizione].telefono);
                        } else {
                            System.out.println("Contatto inesistente");
                        }
                    } else {
                        System.out.println("Non sono ancora presenti contratti venduti");
                    }
                    break;
                case 5:
                    Contatto numero = new Contatto();
                    int scelta;
                    if(contrattiVenduti!=0){
                        posizione=RicercaIndex(gestore, leggiPersona(false, keyboard), contrattiVenduti);
                        if(posizione != -1){
                            System.out.println("Vuoi modificare il numero telefonico (si = 1 | no = 0): ");
                            scelta=keyboard.nextInt();
                            keyboard.nextLine();
                            if(scelta==1){
                                System.out.println("Modifica numero telefonico: ");
                                numero.telefono=keyboard.nextLine();
                                gestore[posizione].telefono=numero.telefono;
                            } else {
                                System.out.println("Numero telefonico non modificato");
                            }
                        } else {
                            System.out.println("Contatto inesistente");
                        }
                    } else {
                        System.out.println("Non sono ancora presenti contratti venduti");
                    }
                    break;
                case 6:
                    /*
                    if (contrattiVenduti != 0) {
                        System.out.println("Inserisci il numero di telefono del contatto da cancellare: ");
                        String numeroTelefono = keyboard.nextLine();
                        boolean cancellato = cancellaPerNumero(gestore, numeroTelefono, contrattiVenduti);
                        if (cancellato) {
                            System.out.println("Contatto cancellato con successo.");
                        } else {
                            System.out.println("Nessun contatto trovato con il numero di telefono specificato.");
                        }
                    } else {
                        System.out.println("Non sono ancora presenti contratti venduti");
                    }
                    break;
                     */
                    if (contrattiVenduti != 0) {
                        posizione = RicercaIndex(gestore, leggiPersona(false, keyboard), contrattiVenduti);
                        if (posizione != -1) {
                            contrattiVenduti = cancellazione(gestore, posizione, contrattiVenduti);
                        } else {
                            System.out.println("contatto inesistente");
                        }
                    } else {
                        System.out.println("Non sono ancora presenti contratti venduti");
                    }
                    break;
                case 7: {
                    if(contrattiVenduti!=0){
                        visualizzaOrdineAlfabetico(gestore, contrattiVenduti);
                    } else {
                        System.out.println("Non sono ancora presenti contratti venduti");
                    }
                    break;
                }
                case 8:
                    //Effettua una telefonata
                    posizione = RicercaIndex(gestore, leggiPersona(false, keyboard), contrattiVenduti);
                    if (posizione != -1){
                        System.out.println("Inserisci il costo della telefonata: ");
                        double costo = keyboard.nextDouble();
                        effettuaTelefonata(gestore[posizione], costo);
                        keyboard.nextLine();
                    } else {
                        System.out.println("Contatto inesistente");
                    }
                    break;
                case 9:
                    //Ricarica il saldo
                    posizione = RicercaIndex(gestore, leggiPersona(false, keyboard), contrattiVenduti);
                    if(posizione != -1) {
                        System.out.println("Inserisci l'importo della ricarica: ");
                        double importo = keyboard.nextDouble();
                        keyboard.nextLine(); // Pulisci il buffer
                        ricaricaSaldo(gestore[posizione], importo);
                    } else {
                        System.out.println("Contatto inesistente");
                    }
                    break;
                case 10:
                    try{
                        ScriviFile("fileName.csv", gestore, contrattiVenduti);
                    }catch(IOException ex){
                        System.out.println(ex.toString());
                    }
                    break;
                case 11:
                    try{
                        LeggiFile("fileName.csv", gestore);
                    }catch(IOException ex){
                        System.out.println(ex.toString());
                    }
                    break;
                default:
                    fine = false;
                    break;
            }
        } while (fine);
    }

    //metodo leggi persona
    private static Contatto leggiPersona(boolean Sitel, Scanner keyboard) {
        //Sitel è true quando dobbiamo leggere
        String[] tipoC = {"Telefono","1]abitazione", "2]cellulare", "3]aziendale"};
        //Istanziato un oggetto di tipo contatto:
        Contatto persona = new Contatto();
        System.out.println("Inserisci il nome: ");
        persona.nome = keyboard.nextLine();
        System.out.println("Inserisci il cognome: ");
        persona.cognome = keyboard.nextLine();

        if (Sitel) {
            System.out.println("Inserisci il numero di telefono: ");
            persona.telefono = keyboard.nextLine();  //Vado a leggere il numero di telefono
            //I valori assegnati all'attributo sono compresi nel range
            switch (menu(tipoC, keyboard)) {
                case 1 -> persona.tipo = tipoContratto.abitazione;
                case 2 -> persona.tipo = tipoContratto.cellulare;
                default -> persona.tipo = tipoContratto.aziendale;

            }
        }

        return persona;
    }

    //metodo ricerca contatto
    private static boolean ricerca (Contatto[] gestore, Contatto contatto, int contrattiVenduti){
        //Controllo se il nome e il cognome del contatto e ugale al nome e cogome del gestore
        boolean ricerca = false;

        for(int i = 0; i<contrattiVenduti; i++){
            if(contatto.nome.equals(gestore[i].nome)  && contatto.cognome.equals(gestore[i].cognome)){
                ricerca = true;
            }
        }
        return ricerca;
    }

    //metodo ricercaIndex
    private static int RicercaIndex(Contatto[] gestore, Contatto ricerca, int contrattiVenduti){
        int indice=-1;

        for(int i=0; i < contrattiVenduti; i++){
            if(ricerca.nome.equals(gestore[i].nome)  && ricerca.cognome.equals(gestore[i].cognome)){
                indice=i;
                break;
            }
        }
        return indice;
    }

    //metodo visualizza
    private static void visualizza(Contatto [] gestore, int contrattiVenduti){
        for(int i=0 ; i<contrattiVenduti; i++){
            System.out.println(gestore[i].stampa());
        }
    }

    /*
    //metodo cancella contatto inserendo il numero di telefono
    private static boolean cancellaPerNumero(Contatto[] gestore, String numeroTelefono, int contrattiVenduti) {
        for (int i = 0; i < contrattiVenduti; i++) {
            if (gestore[i].telefono.equals(numeroTelefono)) {
                for (int j = i; j < contrattiVenduti - 1; j++) {
                    gestore[j] = gestore[j + 1]; //sposta di 1 posizione l'indice
                }
                gestore[contrattiVenduti - 1] = null; //contatto eliminato
                return true;
            }
        }
        return false;
    }
    */

    //metodo cancellazzione contatto
    public static int cancellazione(Contatto[] gestore, int posizione, int contattiVenduti){
        if(posizione !=gestore.length-1)
            for(int i=posizione; i < contattiVenduti-1; i++)
                gestore[i] = gestore[i+1];
        return --contattiVenduti;
    }

    //-----------------------------------------------------------------------------------------------------------------//

    //metodo ordina contatti in ordine alfabetico selection sort
    private static void visualizzaOrdineAlfabetico(Contatto[] gestore, int contrattiVenduti){
        //Ordinamento dei contatti in ordine alfabetico per cognome e nome
        for(int i = 0; i < contrattiVenduti - 1; i++){
            for(int j = i+1; j < contrattiVenduti; j++){
                if(gestore[i].cognome.compareTo(gestore[j].cognome) > 0 ||
                        gestore[i].cognome.equals(gestore[j].cognome) && gestore[i].nome.compareTo(gestore[j].nome) > 0){
                    Contatto temp = gestore[i];
                    gestore[i] = gestore[j];
                    gestore[j] = temp;
                }
            }
        }
        //output
        for (int i = 0; i < contrattiVenduti; i++) {
            System.out.println(gestore[i].stampa());
        }
    }

    //metodo incasina contatto -> visualizzare il vettore di partenza e quello finale ordinato
    private static void visualizzaOrdineAlfabetico2(Contatto[] gestore, int contrattiVenduti){
        //Ordinamento dei contatti in ordine alfabetico per cognome e nome
        for(int i = 0; i < contrattiVenduti - 1; i++){
            for(int j = i+1; j < contrattiVenduti; j++){
                if(gestore[i].cognome.compareTo(gestore[j].cognome) > 0 ||
                        gestore[i].cognome.equals(gestore[j].cognome) && gestore[i].nome.compareTo(gestore[j].nome) > 0){
                    Contatto temp = gestore[i];
                    gestore[i] = gestore[j];
                    gestore[j] = temp;
                }
            }
        }

        //output
        for (int i = 0; i < contrattiVenduti; i++) {
            System.out.println(gestore[i].stampa());
        }
    }

    //metodo per effettuare una telefonata
    public static void effettuaTelefonata(Contatto contatto, double costo){
        if (contatto.saldo >= costo) {
            contatto.saldo -= costo;
            System.out.println("Telefonata effettuata con successo :) - Saldo attuale: " + contatto.saldo + " €");
        } else {
            System.out.println("Saldo insufficiente per effettuare la telefonata");
        }
    }

    //metodo per ricaricare il saldo
    public static void ricaricaSaldo (Contatto contatto, double importo){
        contatto.saldo = contatto.saldo + importo;
        System.out.println("Ricarica effettuata con successo. Saldo attuale: " + contatto.saldo);
    }

    //metodo Scrivi file
    public static void ScriviFile(String fileName, Contatto[] gestore, int contrattiVenduti)throws IOException{
        FileWriter out = new FileWriter(fileName);

        //output
        for(int i = 0; i < contrattiVenduti; i++){
            out.write(gestore[i].toString() + "\r\n");
        }

        //svuotiamo il buffer
        out.flush();

        //fine
        out.close();
    }

    //metodo Leggi file
    public static int LeggiFile(String fileName, Contatto[] gestore)throws IOException{
        //istanzio oggetti
        FileReader reader = new FileReader(fileName);
        Scanner input = new Scanner(reader);

        //dichiarazione e inizializzazione variabili
        int nContatti = 0;
        String lineln;
        String[] vetAttributi;
        int contaElementi = 0;

        //funzione che ritorna true (ci sono linee del testo) + controllo elementi
        while(input.hasNextLine() && (contaElementi < gestore.length)){
            //dichiarazione
            lineln = input.nextLine();
            vetAttributi = lineln.split(";");

            //istanzio nuovo oggetto di tipo persona
            Contatto persona = new Contatto();

            //assegno i valori del file Contatto
            persona.nome = vetAttributi[0];
            persona.cognome = vetAttributi[1];
            persona.telefono = vetAttributi[2];

            switch(vetAttributi[3]){
                case "abitazione":
                    persona.tipo = tipoContratto.abitazione;
                    break;
                case "cellulare":
                    persona.tipo = tipoContratto.cellulare;
                    break;
                case "aziendale":
                    persona.tipo = tipoContratto.aziendale;
                    break;
            }

            //persona.tipo = tipoContratto.valueOf(vetAttributi[3]);
            persona.saldo = Double.parseDouble(vetAttributi[4]);

            //salvo nel gestore i contatti + gli conto
            gestore[contaElementi++] = persona;
        }

        return nContatti;
    }
}