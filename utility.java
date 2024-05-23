//Zara Luigi
//Classe 3E

package tools;
public class utility {

    /*------------------------------------------ METODI GESTORE TELEFONICO -------------------------------------------*/

    //metodo menù
    public static int menu(String[] opzioni, Scanner keyboard)
    {
        int scelta;

        do {
            //ClrScr();
            System.out.println("=== "+opzioni[0]+" ===");
            for(int i=1;i<opzioni.length;i++)
            {
                System.out.println(opzioni[i]);
            }
            scelta = Integer.parseInt(keyboard.nextLine());
            if(scelta<1 || scelta>opzioni.length-1)
            {
                System.out.println("Valore errato. Riprova");
                Wait(3);
            }
        }while(scelta<1 || scelta>opzioni.length-1);

        return scelta;
    }

    //metodo clear screen
    public static void ClrScr() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //metodo wait
    public static void Wait(int x)
    {
        try{
            Thread.sleep(1000*x);
        }catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    //metodo leggi persona
    private static Contatto leggiPersona(boolean Sitel, Scanner keyboard) {
        //Sitel è true quando dobbiamo leggere
        String[] tipoC = {"Telefono", "1]abitazione", "2]cellulare", "3]aziendale"};

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

    //metodo ricerca persona
    private static boolean ricerca(Contatto[] gestore, Contatto contatto, int contrattiVenduti) {
        //Controllo se il nome e il cognome del contatto e ugale al nome e cogome del gestore
        boolean ricerca = false;

        for (int i = 0; i < contrattiVenduti; i++) {
            if (contatto.nome.equals(gestore[i].nome) && contatto.cognome.equals(gestore[i].cognome)) {
                ricerca = true;
            }
        }
        return ricerca;
    }

    //metodo visualizza
    private static void visualizza(Contatto[] gestore, int contrattiVenduti) {

        for (int i = 0; i < contrattiVenduti; i++) {
            System.out.println(gestore[i].stampa());
        }

    }

    //metodo ricercaIndexù
    private static int RicercaIndex(Contatto[] gestore, Contatto ricerca, int contrattiVenduti) {
        int indice = -1;

        for (int i = 0; i < contrattiVenduti; i++) {
            if (ricerca.nome.equals(gestore[i].nome) && ricerca.cognome.equals(gestore[i].cognome)) {
                indice = i;
                break;
            }
        }
        return indice;
    }

    //metodo cancella persona
    public static int cancellazione(Contatto[] gestore, int posizione, int contrattiVenduti) {
        if (posizione != gestore.length - 1)
            for (int i = posizione; i < contrattiVenduti - 1; i++)
                gestore[i] = gestore[i+1];
        return --contrattiVenduti;
    }

    //metodo algoritmo di ordinamento insertion sort
    private static void visualizzaOrdineAlfabetico(Contatto[] gestore, int contrattiVenduti) {
        // Ordinamento dei contatti in ordine alfabetico per cognome e nome
        for (int i = 1; i < contrattiVenduti; i++) {
            Contatto key = gestore[i];
            int j = i - 1;

        /* Sposta gli elementi dell'array gestore[0..i-1], che sono
           maggiori del key, alla posizione successiva
           della loro posizione attuale */
            while (j >= 0 && (gestore[j].cognome.compareTo(key.cognome) > 0 ||
                    (gestore[j].cognome.equals(key.cognome) && gestore[j].nome.compareTo(key.nome) > 0))) {
                gestore[j + 1] = gestore[j];
                j = j - 1;
            }
            gestore[j + 1] = key;
        }

        // Output
        for (int i = 0; i < contrattiVenduti; i++) {
            System.out.println(gestore[i].stampa());
        }
    }

    //metodo algoritmo di ordinamento selection sort
    private static void visualizzaOrdineAlfabetico(Contatto[] gestore, int contrattiVenduti) {
        // Ordinamento dei contatti in ordine alfabetico per cognome e nome
        for (int i = 0; i < contrattiVenduti - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < contrattiVenduti; j++) {
                if (gestore[j].cognome.compareTo(gestore[min_idx].cognome) < 0 ||
                        (gestore[j].cognome.equals(gestore[min_idx].cognome) && gestore[j].nome.compareTo(gestore[min_idx].nome) < 0)) {
                    min_idx = j;
                }
            }
            // Scambio di posizione tra l'elemento minimo e il primo elemento non ordinato
            Contatto temp = gestore[min_idx];
            gestore[min_idx] = gestore[i];
            gestore[i] = temp;
        }

        // Output
        for (int i = 0; i < contrattiVenduti; i++) {
            System.out.println(gestore[i].stampa());
        }
    }

    //metodo algoritmo di ordinamento bubble sort
    private static void visualizzaOrdineAlfabetico(Contatto[] gestore, int contrattiVenduti) {
        //Ordinamento dei contatti in ordine alfabetico per cognome e nome
        for (int i = 0; i < contrattiVenduti - 1; i++) {
            for (int j = i + 1; j < contrattiVenduti; j++) {
                if (gestore[i].cognome.compareTo(gestore[j].cognome) > 0 ||
                        (gestore[i].cognome.equals(gestore[j].cognome) && gestore[i].nome.compareTo(gestore[j].nome) > 0)) {
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

    //metodo effettua telefonata
    public static void effettuaTelefonata(Contatto[] contatto, double costo){
        if(contatto.saldo >= costo){
            contatto.saldo = contatto.saldo - costo;
            System.out.println("telefonata effettuata con successo. Credito rimanente: " + contatto.saldo);
        } else {
            System.out.println("credito insufficente per effettuare la telefonata :( ");
        }
    }

    //Metodo per ricaricare il saldo
    private static void ricaricaSaldo(Contatto contatto, double importo) {
        contatto.saldo = contatto.saldo + importo;
        System.out.println("Ricarica effettuata con successo. Saldo attuale: " + contatto.saldo);
    }

    /*------------------------------------ METODI ALGORITMI DI ORDINAMENTO GENALI ------------------------------------*/

    //metodo insertion sort
    /*public static void main(String[] args) {
        int[] v = new int[]{16, 44, 67, 8, 3, 23, 12, 54, 51, 13};

        insertionSort(v);

        System.out.print("Vettore ordinato: ");
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i] + " ");
        }
    }
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int valore = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > valore) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = valore;
        }
    }

     */

    //metodo selection sort
    /*public class SelectionSort {
        public static void main(String[] args) {
            int[] v = new int[]{16, 44, 67, 8, 3, 23, 12, 54, 51, 13};

            selectionSort(v);

            System.out.print("Vettore ordinato: ");
            for (int i = 0; i < v.length; i++) {
                System.out.print(v[i] + " ");
            }
        }

        public static void selectionSort(int[] arr) {
            int n = arr.length;
            int temp, pos_min;

            for (int i = 0; i < n - 1; i++) {
                pos_min = i;

                for (int j = i + 1; j < n; j++) {
                    if (arr[j] < arr[pos_min])
                        pos_min = j;
                }

                if (pos_min != i) {
                    temp = arr[i];
                    arr[i] = arr[pos_min];
                    arr[pos_min] = temp;
                }
            }
        }
    }
    */

    //metodo bubble sort
    /*public class BubbleSort {
        public static void main(String[] args) {
            int[] v = new int[]{16, 44, 67, 8, 3, 23, 12, 54, 51, 13};

            bubbleSort(v);

            System.out.print("Vettore ordinato: ");
            for (int i = 0; i < v.length; i++) {
                System.out.print(v[i] + " ");
            }
        }

        public static void bubbleSort(int[] arr) {
            int n = arr.length;
            int temp;
            boolean scambio = true;
            int N = n;

            while (scambio) {
                scambio = false;
                for (int j = 0; j < N - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        temp = arr[j + 1];
                        arr[j + 1] = arr[j];
                        arr[j] = temp;
                        scambio = true;
                    }
                }
                N--;
            }
        }
    }
    */
}
