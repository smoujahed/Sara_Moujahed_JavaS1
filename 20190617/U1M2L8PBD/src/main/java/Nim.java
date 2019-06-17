import java.util.Scanner;

public class Nim {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = 3;
        int b = 4;
        int c = 5;
        System.out.println("Player 1, enter your name: ");
        String player1 = scanner.nextLine();
        System.out.println("Player 2, enter your name: ");
        String player2 = scanner.nextLine();

        String currentPlayer = player1;

        while (a > 0 || b > 0 || c > 0) {
            System.out.format("A: %d   B: %d   C: %d", a, b, c);
            System.out.println("");
            System.out.println("");
            System.out.println(currentPlayer + ", choose a pile: ");
            String pileChoice1 = scanner.nextLine();
            System.out.format("How many to remove from pile %s: ", pileChoice1);
            int removeNum1 = Integer.parseInt(scanner.nextLine());

            if (pileChoice1.equals("a") || pileChoice1.equals("A")) {
                a = a - removeNum1;
            } else if (pileChoice1.equals("b") || pileChoice1.equals("B")) {
                b = b - removeNum1;
            } else if (pileChoice1.equals("c") || pileChoice1.equals("C")) {
                c = c - removeNum1;
            } else {
                System.out.println("You did not enter a valid pile. Goodbye.");
            }
            if(currentPlayer.equals(player1)) {
                currentPlayer = player2;
            } else {
                currentPlayer = player1;
            }
        }
        System.out.format("A: %d   B: %d   C: %d", a, b, c);
        System.out.println("");
        System.out.println(currentPlayer + ", there are no counters left, so you WIN!");
    }

}
