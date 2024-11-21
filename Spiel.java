import java.util.Scanner;
import java.util.Random;

public class Spiel {
    static int computer_zieht(int m) {
        Random rand = new Random();
        if(m%4 != 0){
            return m%4;
        }else{
            return rand.nextInt(3)+1;
        }
    }

    static int mensch_zieht(int m) {
        System.out.println("\n" + "1, 2, oder 3 Münzen darfst du nehmen. Es liegen momentan " + m + " Münzen auf dem Tisch");
        Scanner scanner = new Scanner(System.in);
        int eingabe = scanner.nextInt();
        while(eingabe < 1 || eingabe > 3){
            System.out.println("Ungültige Eingabe. Bitte wähle 1, 2 oder 3 Münzen:");
            eingabe = scanner.nextInt();
        }
        System.out.println("Mensch zieht " + eingabe + " Münzen");
        return eingabe;
    }

    static int anfangen() {
        Random rand = new Random();
        System.out.println("\n" + "Werfen wir eine Münze, um zu entscheiden, wer anfängt.");
        int erste = rand.nextInt(10);
            if(erste%2==0){
                System.out.println("\n" + "Der Computer fängt an!");
                erste = 1;
            }else {
                System.out.println("\n" + "Du fängst an!");
                erste = 0;
            }
        return erste;
    }

    public static void main(String[] args) {
        int computer = 0;
        int du = 0;
        int new_spiel;
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        do {
            int muenzen = rand.nextInt(20)+1;
            System.out.println("\n" + "**************************************************" + "\n");
            System.out.println("\n" + "Es liegen am Anfang " + muenzen + " auf dem Tisch" + "\n");

            if (anfangen()==1){

                while (true) {
                    //Computer erste
                    int comp = computer_zieht(muenzen);
                    System.out.println("Computer ziehl " + comp + " Münzen.");
                    muenzen = muenzen - comp;
                    System.out.println("\n" + "Nach Computerzug liegen " + muenzen + " auf dem Tisch");

                    if (muenzen == 0) {
                        System.out.println("\n" + "*********************************" + "\n");
                        System.out.println("\t" + "\t" + "Computer gewinnt");
                        System.out.println("\n" + "*********************************" + "\n");
                        computer++;
                        break;
                    }

                    muenzen = muenzen - mensch_zieht(muenzen);
                    System.out.println("\n" + "Nach Menschzug liegen " + muenzen + " auf dem Tisch");

                    if (muenzen == 0) {
                        System.out.println("\n" + "*********************************" + "\n");
                        System.out.println("\t" + "\t" + "Mensch gewinnt");
                        System.out.println("\n" + "*********************************" + "\n");
                        du++;
                        break;
                    }
            }}else {//Du erste
                while (true) {

                    muenzen = muenzen - mensch_zieht(muenzen);
                    System.out.println("\n" + "Nach Menschzug liegen " + muenzen + " auf dem Tisch");

                    if (muenzen == 0) {
                        System.out.println("\n" + "*********************************" + "\n");
                        System.out.println("\t" + "\t" + "Mensch gewinnt");
                        System.out.println("\n" + "*********************************" + "\n");
                        du++;
                        break;
                    }
                    int comp = computer_zieht(muenzen);
                    System.out.println("Computer ziehl " + comp + " Münzen.");
                    muenzen = muenzen - comp;
                    System.out.println("\n" + "Nach Computerzug liegen " + muenzen + " auf dem Tisch");

                    if (muenzen == 0) {
                        System.out.println("\n" + "*********************************" + "\n");
                        System.out.println("\t" + "\t" + "Computer gewinnt");
                        System.out.println("\n" + "*********************************" + "\n");
                        computer++;
                        break;
                    }
                }
            }
            System.out.println("\n" + "Du hast " + du + " mal gewonnen.");
            System.out.println("\n" + "Der Computer hat " + computer + " mal gewonnen." + "\n");

            System.out.println("\n" + "Willst du nochmal spielen? Ja[1] ou Nein[0]: ");
            new_spiel = scanner.nextInt();

            while (new_spiel != 1 && new_spiel != 0) {
                System.out.println("Ungültige Eingabe. Wähle bitte 1 zu nochmal spielen oder 0 zu enden: ");
                new_spiel = scanner.nextInt();
            }

            if (new_spiel == 0){
                System.out.println("\n" + "*************************************" + "\n");
                System.out.println("Danke für spielen. Bis näschtes mal!");
                System.out.println("\n" + "*************************************" + "\n");
                break;
            }

        }while (true);
    }
}
