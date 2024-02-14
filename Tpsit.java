//Lotto project
//Group 3: Basaglia, Zara, Guerra, Boscolo, Tomasello
//class 3E
//date 02/02/2024



//importing libraries
import java.util.Locale;
import java.util.Random; //random
import java.util.Scanner; //scanner


public class Tpsit {
    public static void main(String[] args) {
        //Scanner declaration
        Scanner input = new Scanner(System.in);

        //variables declaration and initialization
        int SceltaRuota;
        int [] scommessa = null;
        double money = 0;
        double fresca = 0;
        double win = 0;

        //lotto variables
        int singolo = 0;
        int ambo = 0;
        int terna = 0;
        int quaterna = 0;
        int cinquina = 0;

        //string varaibles (scelta)
        String scelta;
        String scelta1;
        String scelta2 = null;
        int sceltaNum = 0;

        //scommessa:
        scommessa = Menu(input);
        sceltaNum = scommessa.length;

        //scelta:
        scelta = SceltaM(input, sceltaNum);


        //I ask the user if he wants to bet on something else
        System.out.println("Desidera scommettere su altro?");
        scelta1= input.next();

        //if the answer is "yes"
        if(scelta1.equalsIgnoreCase("si")){
            //I ask the user to enter another wager
            switch (sceltaNum){

                case 1:
                    System.out.println("La possibile scommessa è: singolo");
                    System.out.println("su quale vuoi scommettere?");
                    scelta2=input.next();
                    if(!scelta2.equalsIgnoreCase("singolo")){
                        do{
                            System.out.println("scelta non valida reinserire");
                            scelta2=input.next();
                        }while(!scelta2.equalsIgnoreCase("singolo"));
                    }
                    break;

                case 2:
                    System.out.println("Le possibili scommesse sono: singolo, ambo");
                    System.out.println("su quale vuoi scommettere?");
                    scelta2=input.next().toLowerCase(Locale.ROOT);
                    if(!scelta2.equalsIgnoreCase("singolo") && !scelta2.equalsIgnoreCase("ambo")){
                        do{
                            System.out.println("scelta non valida reinserire");
                            scelta2=input.next();
                        }while(!scelta2.equalsIgnoreCase("singolo") && !scelta2.equalsIgnoreCase("ambo"));
                    }
                    break;

                case 3:
                    System.out.println("Le possibili scommesse sono: singolo, ambo, terna");
                    System.out.println("su quale vuoi scommettere?");
                    scelta2=input.next();
                    if(!scelta2.equalsIgnoreCase("singolo") && !scelta2.equalsIgnoreCase("ambo") && !scelta2.equalsIgnoreCase("terna")){
                        do{
                            System.out.println("scelta non valida reinserire");
                            scelta2=input.next();
                        }while(!scelta2.equalsIgnoreCase("singolo") && !scelta2.equalsIgnoreCase("ambo") && !scelta2.equalsIgnoreCase("terna"));
                    }
                    break;

                case 4:
                    System.out.println("Le possibili scommesse sono: singolo, ambo, terna, quaterna");
                    System.out.println("su quale vuoi scommettere?");
                    scelta2=input.next();
                    if(!scelta2.equalsIgnoreCase("singolo") && !scelta2.equalsIgnoreCase("ambo") && !scelta2.equalsIgnoreCase("terna") && !scelta2.equalsIgnoreCase("quaterna")){
                        do{
                            System.out.println("scelta non valida reinserire");
                            scelta2=input.next();
                        }while(!scelta2.equalsIgnoreCase("singolo") && !scelta2.equalsIgnoreCase("ambo") && !scelta2.equalsIgnoreCase("terna") && !scelta2.equalsIgnoreCase("quaterna"));
                    }
                    break;

                case 5:
                    System.out.println("Le possibili scommesse sono: singolo, ambo, terna, quaterna e cinquina");
                    System.out.println("su quale vuoi scommettere?");
                    scelta2=input.next();
                    if(!scelta2.equalsIgnoreCase("singolo") && !scelta2.equalsIgnoreCase("ambo")&& !scelta2.equalsIgnoreCase("terna")&& !scelta2.equalsIgnoreCase("quaterna") && !scelta2.equalsIgnoreCase("cinquina")){
                        do{
                            System.out.println("scelta non valida reinserire");
                            scelta2=input.next();
                        }while(!scelta2.equalsIgnoreCase("singolo") && !scelta2.equalsIgnoreCase("ambo") && !scelta2.equalsIgnoreCase("terna") && !scelta2.equalsIgnoreCase("quaterna") && !scelta2.equalsIgnoreCase("cinquina"));
                    }
                    break;




            }



        }
        if(scelta1.equalsIgnoreCase("no")){
            System.out.println("ok");
        }
        else if(!scelta1.equalsIgnoreCase("si") && !scelta1.equalsIgnoreCase("no")) {
            do{
                System.out.println("Scelta non valida, reinserire");
                scelta1 = input.next();
            }while(!scelta1.equalsIgnoreCase("si") && !scelta1.equalsIgnoreCase("no"));


            if (scelta1.equalsIgnoreCase("si")) {
                switch (sceltaNum) {

                    case 1:
                        System.out.println("La possibile scommessa è: singolo");
                        System.out.println("su quale vuoi scommettere?");
                        scelta2 = input.next();
                        if (!scelta2.equalsIgnoreCase("singolo")) {
                            do {
                                System.out.println("scelta non valida reinserire");
                                scelta2 = input.next();
                            } while (!scelta2.equalsIgnoreCase("singolo"));
                        }
                        break;

                    case 2:
                        System.out.println("Le possibili scommesse sono: singolo, ambo");
                        System.out.println("su quale vuoi scommettere?");
                        scelta2 = input.next().toLowerCase(Locale.ROOT);
                        if (!scelta2.equalsIgnoreCase("singolo") && !scelta2.equalsIgnoreCase("ambo")) {
                            do {
                                System.out.println("scelta non valida reinserire");
                                scelta2 = input.next();
                            } while (!scelta2.equalsIgnoreCase("singolo") && !scelta2.equalsIgnoreCase("ambo"));
                        }
                        break;

                    case 3:
                        System.out.println("Le possibili scommesse sono: singolo, ambo, terna");
                        System.out.println("su quale vuoi scommettere?");
                        scelta2 = input.next();
                        if (!scelta2.equalsIgnoreCase("singolo") && !scelta2.equalsIgnoreCase("ambo") && !scelta2.equalsIgnoreCase("terna")) {
                            do {
                                System.out.println("scelta non valida reinserire");
                                scelta2 = input.next();
                            } while (!scelta2.equalsIgnoreCase("singolo") && !scelta2.equalsIgnoreCase("ambo") && !scelta2.equalsIgnoreCase("terna"));
                        }
                        break;

                    case 4:
                        System.out.println("Le possibili scommesse sono: singolo, ambo, terna, quaterna");
                        System.out.println("su quale vuoi scommettere?");
                        scelta2 = input.next();
                        if (!scelta2.equalsIgnoreCase("singolo") && !scelta2.equalsIgnoreCase("ambo") && !scelta2.equalsIgnoreCase("terna") && !scelta2.equalsIgnoreCase("quaterna")) {
                            do {
                                System.out.println("scelta non valida reinserire");
                                scelta2 = input.next();
                            } while (!scelta2.equalsIgnoreCase("singolo") && !scelta2.equalsIgnoreCase("ambo") && !scelta2.equalsIgnoreCase("terna") && !scelta2.equalsIgnoreCase("quaterna"));
                        }
                        break;

                    case 5:
                        System.out.println("Le possibili scommesse sono: singolo, ambo, terna, quaterna e cinquina");
                        System.out.println("su quale vuoi scommettere?");
                        scelta2 = input.next();
                        if (!scelta2.equalsIgnoreCase("singolo") && !scelta2.equalsIgnoreCase("ambo") && !scelta2.equalsIgnoreCase("terna") && !scelta2.equalsIgnoreCase("quaterna") && !scelta2.equalsIgnoreCase("cinquina")) {
                            do {
                                System.out.println("scelta non valida reinserire");
                                scelta2 = input.next();
                            } while (!scelta2.equalsIgnoreCase("singolo") && !scelta2.equalsIgnoreCase("ambo") && !scelta2.equalsIgnoreCase("terna") && !scelta2.equalsIgnoreCase("quaterna") && !scelta2.equalsIgnoreCase("cinquina"));
                        }
                        break;
                }


            }
        }





        //money:
        money = Soldi(input, scelta, money, scelta1, scelta2, fresca);

        //if the answer is null (no)

        //I ask the user how much money they want to put in scelta2
        if(scelta2!=null){
            System.out.println("quanti soldi vuoi scommettere in "+scelta2);
            fresca=input.nextInt();
        }



        //initialization of variable sceltaRuota
        SceltaRuota = 0;

        //I ask the user on how many wheels he wants to place the bet numbers
        System.out.println("Su quante ruote vuole puntare i numeri scommessi (1 o 10) ?");
        SceltaRuota= input.nextInt();

        //if SceltaRuota < 1 || SceltaRuota > 1 || SceltaRuota > 10)
        if(SceltaRuota !=1  && SceltaRuota !=10){
            //do-while SceltaRuota > 1 or SceltaRuota > 10)
            do{
                //invalid input: Try again
                System.out.println("Attenzione! puoi scegliere tra 1 e 10 ruote");
                SceltaRuota= input.nextInt();
            }while(SceltaRuota !=1  && SceltaRuota !=10);
        }
        Gioco(input,SceltaRuota,scommessa, singolo,ambo,terna,quaterna,cinquina,money,fresca, scelta,win,scelta2);

        if(SceltaRuota==1){
            switch (sceltaNum){
                case 1:
                    System.out.println("La tua probabilità di vincere con i numeri scommessi era di 1 su 90");
                    break;

                case 2:
                    System.out.println("La tua probabilità di vincere con i numeri scommessi era di 2 su 90");
                    break;


                case 3:
                    System.out.println("La tua probabilità di vincere con i numeri scommessi era di 3 su 90");
                    break;

                case 4:
                    System.out.println("La tua probabilità di vincere con i numeri scommessi era di 4 su 90");
                    break;

                case 5:
                    System.out.println("La tua probabilità di vincere con i numeri scommessi era di 5 su 90");
                    break;
            }
        }
        else{
            switch (sceltaNum){
                case 1:
                    System.out.println("La tua probabilità di vincere con i numeri scommessi era di 1 su 90 su ogni ruota");
                    break;

                case 2:
                    System.out.println("La tua probabilità di vincere con i numeri scommessi era di 2 su 90 su ogni ruota");
                    break;


                case 3:
                    System.out.println("La tua probabilità di vincere con i numeri scommessi era di 3 su 90 su ogni ruota");
                    break;

                case 4:
                    System.out.println("La tua probabilità di vincere con i numeri scommessi era di 4 su 90 su ogni ruota");
                    break;

                case 5:
                    System.out.println("La tua probabilità di vincere con i numeri scommessi era di 5 su 90 su ogni ruota");
                    break;
            }
        }

    }

    // Menù method
    private static int [] Menu(Scanner input)
    {
        //sceltaNum variable declaration and initialization
        int sceltaNum = 0;

        //I ask the user how many numbers he wants to enter from 1 to 5
        System.out.println("Quanti numeri desidera scommettere (da 1 a 5) ? ");
        sceltaNum=input.nextInt();

        //while the user enter in input a number > 5 or < 1:
        while(sceltaNum < 1 || sceltaNum > 5){
            //the number is invalid! try again
            System.out.println("Il numero che hai inserito è fuori dal range consensito!");
            System.out.println("Digita un numero compreso tra 1 e 5");
            sceltaNum=input.nextInt();
            ClrScr();
        }

        //scommessa array declaration
        int [] scommessa = new int[sceltaNum];

        //for cicle
        for(int i = 0; i < sceltaNum; i++){
            //I ask the user to digit the numbers in input ( with the quantity of numbers he decided before)
            System.out.println("Inserisci il " +(i+1)+ "° numero (premere invio dopo aver digitato il numero) ");
            scommessa[i]= input.nextInt();
            if(i>0){
                if(scommessa[i]==scommessa[i-1]){
                    do{
                        System.out.println("Numero non valido, reinserire");
                        scommessa[i]= input.nextInt();
                    }while(scommessa[i]==scommessa[i-1]);
                }
            }

            //if scommessa[i] < 1 || scommessa[i] > 90:
            if(scommessa[i] < 1 || scommessa[i] > 90){
                //do-while the user enter numbers < 1 or > 90
                do{
                    System.out.println("Il numero che hai inserito è fuori dal range consensito!");
                    System.out.println("Digita un numero compreso tra 1 e 90");
                    scommessa[i]= input.nextInt();
                    ClrScr();
                }while(scommessa[i] < 1 || scommessa[i] > 90);
            }
        }

        //scommessa return
        return scommessa;

    }










    //gioco method
    private static int Gioco(Scanner input,  int SceltaRuota, int[] Scommessa, int singolo, int ambo, int terna, int quaterna, int cinquina, double money, double fresca, String scelta, double win, String scelta2){
        int [] Estrazione=new int[5];
        Random num= new Random();
        int vinta=0;
        double Vincita=0;
        switch(SceltaRuota){

            case 1:
                for(int j=0; j<5; j++){
                    Estrazione[j]= num.nextInt(1, 90)+1;
                    Wait();
                    System.out.println(Estrazione[j]);
                }
                for(int i=0; i< Scommessa.length;i++){

                    for(int g=0; g< Estrazione.length; g++){
                        if(Scommessa[i]==Estrazione[g]){
                            vinta++;
                        }
                    }
                }

                switch(vinta){

                    case 1:
                        System.out.println("hai fatto singolo!!!");
                        break;

                    case 2:
                        System.out.println("hai fatto ambo!!!");
                        break;

                    case 3:
                        System.out.println("hai fatto terna!!!");
                        break;

                    case 4:
                        System.out.println("hai fatto quaterna!!!");
                        break;

                    case 5:
                        System.out.println("hai fatto cinquina!!!");
                        break;

                    default:
                        System.out.println("Hai perso, spiaze :(");
                        break;
                }
                break;

            case 10:
                for(int h=0; h<10;h++){
                    for(int j=0; j<5; j++){
                        Estrazione[j]= num.nextInt(1, 90)+1;
                        Wait();
                        System.out.println(Estrazione[j]);
                    }
                    for(int i=0; i< Scommessa.length;i++){

                        for(int g=0; g< Estrazione.length; g++){
                            if(Scommessa[i]==Estrazione[g]){
                                vinta++;
                            }
                        }
                    }
                    switch(vinta){

                        case 1:
                            System.out.println("hai fatto singolo!!!");
                            singolo=singolo+1;
                            break;

                        case 2:
                            System.out.println("hai fatto ambo!!!");
                            ambo=ambo+1;
                            break;

                        case 3:
                            System.out.println("hai fatto terna!!!");
                            terna=terna+1;
                            break;

                        case 4:
                            System.out.println("hai fatto quaterna!!!");
                            quaterna=quaterna+1;
                            break;

                        case 5:
                            System.out.println("hai fatto cinquina!!!");
                            cinquina=cinquina+1;
                            break;

                        default:
                            System.out.println("Hai perso, spiaze :(");
                            break;
                    }
                    vinta = 0;
                }
        }

        if(SceltaRuota==10){
            switch(scelta){

                case "singolo":
                    win=(money*(11.23*singolo));
                    break;

                case "ambo":
                    win=(money*(250*ambo));
                    break;

                case "terna":
                    win=(money*(4500*terna));
                    break;

                case "quaterna":
                    win=(money*(120000*quaterna));
                    break;

                case "cinquina":
                    win=(money*(6000000*cinquina));
                    break;
            }

            if(scelta2!=null){
                switch(scelta2){

                    case "singolo":
                        fresca=(money*(11.23*singolo));
                        break;

                    case "ambo":
                        fresca=(money*(250*ambo));
                        break;

                    case "terna":
                        fresca=(money*(4500*terna));
                        break;

                    case "quaterna":
                        fresca=(money*(120000*quaterna));
                        break;

                    case "cinquina":
                        fresca=(money*(6000000*cinquina));
                        break;
                }
            }
        }
        if(SceltaRuota==1){
            switch (scelta) {
                case "singolo":
                    if (vinta > 0) {
                        win = (money * 11.23) * vinta;
                    }
                    break;
                case "ambo":
                    if (vinta > 1) {
                        if (vinta == 4) {
                            win = (2 * (money * 250));
                        }
                        win = (money * 250);
                    }
                    break;

                case "terna":
                    if (vinta > 2) {
                        win = (money * 4500);
                    }
                    break;

                case "quaterna":
                    if (vinta > 3) {
                        win = (money * 120000);
                    }
                    break;

                case "cinquina":
                    if (vinta > 4) {
                        win = (money * 6000000);
                    }
                    break;
            }

            if(scelta2!=null){
                switch (scelta2) {
                    //singolo case
                    case "singolo":
                        if (vinta > 0) {
                            fresca = (money * 11.23) ;
                        }
                        else{
                            fresca = 0;
                        }
                        break;
                    //ambo case
                    case "ambo":
                        if (vinta > 1) {
                            if (vinta == 4) {
                                fresca = (2 * (money * 250));
                            }
                            fresca = (money * 250);
                        }
                        else{
                            fresca = 0;
                        }
                        break;
                    //terna case
                    case "terna":
                        if (vinta > 2) {
                            fresca = (money * 4500);
                        }
                        else{
                            fresca = 0;
                        }
                        break;
                    //quaterna case
                    case "quaterna":
                        if (vinta > 3) {
                            fresca = (money * 120000);
                        }
                        else{
                            fresca = 0;
                        }
                        break;
                    //cinquina case
                    case "cinquina":
                        if (vinta > 4) {
                            fresca = (money * 6000000);
                        }
                        else{
                            fresca = 0;
                        }
                        break;
                    //default case
                    default:
                        fresca = 0;
                        break;
                }
            }
        }

        //vincita:
        Vincita = win + fresca;

        //probability of win

        //I show in output the amount of money that the user won
        System.out.println("Hai vinto "+Vincita+" euro");

        //vinta return
        return vinta;
    }











    //sceltaM method (singolo, ambo, terna, quaterna, cinquina)
    private static String SceltaM(Scanner input, int sceltaNum){
        //initialization scelta variable
        String scelta = null;

        //I ask the user which combo he wants to bet on
        switch (sceltaNum){

            case 1:
                System.out.println("La possibile scommessa è: singolo");
                System.out.println("su quale vuoi scommettere?");
                scelta=input.next();
                if(!scelta.equalsIgnoreCase("singolo")){
                    do{
                        System.out.println("scelta non valida reinserire");
                        scelta=input.next();
                    }while(!scelta.equalsIgnoreCase("singolo"));
                }
                break;

            case 2:
                System.out.println("Le possibili scommesse sono: singolo, ambo");
                System.out.println("su quale vuoi scommettere?");
                scelta=input.next().toLowerCase(Locale.ROOT);
                if(!scelta.equalsIgnoreCase("singolo") && !scelta.equalsIgnoreCase("ambo")){
                    do{
                        System.out.println("scelta non valida reinserire");
                        scelta=input.next();
                    }while(!scelta.equalsIgnoreCase("singolo") && !scelta.equalsIgnoreCase("ambo"));
                }
                break;

            case 3:
                System.out.println("Le possibili scommesse sono: singolo, ambo, terna");
                System.out.println("su quale vuoi scommettere?");
                scelta=input.next();
                if(!scelta.equalsIgnoreCase("singolo") && !scelta.equalsIgnoreCase("ambo") && !scelta.equalsIgnoreCase("terna")){
                    do{
                        System.out.println("scelta non valida reinserire");
                        scelta=input.next();
                    }while(!scelta.equalsIgnoreCase("singolo") && !scelta.equalsIgnoreCase("ambo") && !scelta.equalsIgnoreCase("terna"));
                }
                break;

            case 4:
                System.out.println("Le possibili scommesse sono: singolo, ambo, terna, quaterna");
                System.out.println("su quale vuoi scommettere?");
                scelta=input.next();
                if(!scelta.equalsIgnoreCase("singolo") && !scelta.equalsIgnoreCase("ambo") && !scelta.equalsIgnoreCase("terna") && !scelta.equalsIgnoreCase("quaterna")){
                    do{
                        System.out.println("scelta non valida reinserire");
                        scelta=input.next();
                    }while(!scelta.equalsIgnoreCase("singolo") && !scelta.equalsIgnoreCase("ambo") && !scelta.equalsIgnoreCase("terna") && !scelta.equalsIgnoreCase("quaterna"));
                }
                break;

            case 5:
                System.out.println("Le possibili scommesse sono: singolo, ambo, terna, quaterna e cinquina");
                System.out.println("su quale vuoi scommettere?");
                scelta=input.next();
                if(!scelta.equalsIgnoreCase("singolo") && !scelta.equalsIgnoreCase("ambo")&& !scelta.equalsIgnoreCase("terna")&& !scelta.equalsIgnoreCase("quaterna")&& !scelta.equalsIgnoreCase("cinquina")){
                    do{
                        System.out.println("scelta non valida reinserire");
                        scelta=input.next();
                    }while(!scelta.equalsIgnoreCase("singolo") &&!scelta.equalsIgnoreCase("ambo")&& !scelta.equalsIgnoreCase("terna") &&!scelta.equalsIgnoreCase("quaterna")&& !scelta.equalsIgnoreCase("cinquina"));
                }
                break;




        }






        //scelta return
        return scelta;

    }

    //Soldi method
    private static double Soldi(Scanner input, String scelta, double money,String scelta1, String scelta2, double fresca){
        //I ask the user how much money he wants to bet on:
        System.out.println("quanti soldi vuoi scommettere in "+scelta);
        money = input.nextDouble();
        if(money<0){
            do{
                System.out.println("numero non conforme, reinserire");
                money = input.nextDouble();
            }while(money<0);
        }

        //money return
        return money;
    }










    //Wait method
    private static void  Wait() {
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    //clear screen  (Windows OS) method
    private static void ClrScr(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    //clear screen (MacOS) method
    /*public static void ClrScr() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }*/
}
