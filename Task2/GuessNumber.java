import java.util.*;

public class GuessNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int num = r.nextInt(1, 100), i = 1;
        while (i <= 10) {
            System.out.print("\nEnter the Guess:-");
            int guess = sc.nextInt();
            if (guess == num) {
                System.out.println("\n\n\t\tRIGHT GUESS\n\t\tNo of guess=" + i + "\n");
                break;
            } else if (guess < num) {
                System.out.println("\nIt is lower then generated number");
                i++;
            } else if (guess > num) {
                System.out.println("\nIt is higher then generated number");
                i++;
            } else {
                System.out.println("\nWrong Input\n");
            }
            System.out.println("No of attempts left:" + (11 - i));
        }
        sc.close();
    }
}