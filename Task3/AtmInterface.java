import java.util.*;

class History {
    public void THistory() {
        System.out.println("THistory");
    }
}

class Withdraw {
    public void CWithdraw() {
        System.out.println("CWithdraw");
    }
}

class Deposit {
    public void CDeposit() {
        System.out.println("CDeposit");
    }
}

class Transfer {
    public void BTransfer() {
        System.out.println("BTransfer");
    }
}

public class AtmInterface {
    public static void Function() {
        Scanner sc = new Scanner(System.in);
        History h = new History();
        Withdraw w = new Withdraw();
        Deposit d = new Deposit();
        Transfer t = new Transfer();
        while (true) {
            System.out.print(
                "Select Option \n\n1. Transaction History\n2. Withdraw\n3. Deposit\n4. Transfer\n5. Quit\n\nEnter Your Choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    h.THistory();
                    break;
                case 2:
                    w.CWithdraw();
                    break;
                case 3:
                    d.CDeposit();
                    break;
                case 4:
                    t.BTransfer();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("\nWrong Input\n");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter your Card Number:");
            long card = sc.nextLong();
            if (card == 9874563210L) {
                int i = 0;
                while (i < 3) {
                    System.out.print("Enter the pin: ");
                    int pin = sc.nextInt();
                    if (pin == 1234) {
                        Function();
                        break;
                    } else {
                        System.out.println("\nWrong Pin\n");
                        i++;
                    }
                }
            } else {
                System.out.println("\nWrong User Name\n");
            }
        }
    }
}
