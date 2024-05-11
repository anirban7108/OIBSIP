import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

class History {
    File myFile = new File("Atm.txt");

    public void THistory(float balance) {
        System.out.println("***************************************************************************");
        try {
            Scanner sc = new Scanner(myFile);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("No Record Found");
            e.printStackTrace();
        }
    }
}

class Withdraw {
    Scanner sc = new Scanner(System.in);
    LocalDateTime lTime = LocalDateTime.now();
    DateTimeFormatter crFormatTime = DateTimeFormatter.ofPattern("dd:MM:yyyy HH:mm:ss");

    public float CWithdraw(float balance) {
        try (FileWriter writer = new FileWriter("Atm.txt",true)) {
            System.out.print("\n***************************************************************************\n\t\tWIRHDRAW\nEnter the amount: ");
            float wamount = sc.nextInt();
            if (wamount > balance) {
                System.out.println("Not Sufficient Balance");
            } else {
                balance = balance - wamount;
                String time = lTime.format(crFormatTime);
                writer.write(time + "\tWIRHDRAW\t\t" + wamount + "\t\t\t" + balance+"\n");
                System.out.println("\nWITHDRAW SUCCESFULL");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return balance;
    }
}

class Deposit {
    Scanner sc = new Scanner(System.in);
    LocalDateTime lTime = LocalDateTime.now();
    DateTimeFormatter crFormatTime = DateTimeFormatter.ofPattern("dd:MM:yyyy HH:mm:ss");

    public float CDeposit(float balance) {
        try (FileWriter writer = new FileWriter("Atm.txt",true)) {
            System.out.print("\n***************************************************************************\n\t\tDEPOSIT\nEnter the amount: ");
            int damount = sc.nextInt();
            balance = balance + damount;
            String time = lTime.format(crFormatTime);
            writer.write(time + "\tDEPOSIT\t\t\t" + damount + "\t\t\t" + balance+"\n");
            System.out.println("\nDEPOSIT SUCCESFULL");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return balance;
    }
}

class Transfer {
    Scanner sc = new Scanner(System.in);
    LocalDateTime lTime = LocalDateTime.now();
    DateTimeFormatter crFormatTime = DateTimeFormatter.ofPattern("dd:MM:yyyy HH:mm:ss");

    public float BTransfer(float balance) {
        try (FileWriter writer =new FileWriter("Atm.txt",true)) {
            System.out.print("\n***************************************************************************\n\t\tBANK TRANSFER\nEnter the account number: ");
            long acc=sc.nextLong();
            System.out.print("\nEnter account holder name: ");
            String ahname=sc.next();
            System.out.print("\nEnter the amount: ");
            float tamount = sc.nextInt();
            if (tamount > balance) {
                System.out.println("\nNot Sufficient Balance");
            } else {
                balance = balance - tamount;
                String time = lTime.format(crFormatTime);
                writer.write(time + "\tBANK TRANSFER\t\t" + tamount + "\t\t\t`" + balance+"\nAC NO: "+acc+" NAME:"+ahname+"\n");
                System.out.println("\nTRANSACTION COMPLETED");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return balance;
    }
}

class Currentbalance{
    public void cubalance(float balance){
        System.out.println("\n***************************************************************************\n\t\tCurrent Balance\n\t\t"+balance);
    }
}

public class AtmInterface {
    public static float balance;

    public static void Function() {
        Scanner sc = new Scanner(System.in);
        History h = new History();
        Withdraw w = new Withdraw();
        Deposit d = new Deposit();
        Transfer t = new Transfer();
        Currentbalance c=new Currentbalance();
        while (true) {
            System.out.print(
                    "\n***************************************************************************\nSelect Option \n\n1. Transaction History\n2. Withdraw\n3. Deposit\n4. Bank Transfer\n5. Current Balance\n6. Quit\n\nEnter Your Choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    h.THistory(balance);
                    break;
                case 2:
                    balance = w.CWithdraw(balance);
                    break;
                case 3:
                    balance = d.CDeposit(balance);
                    break;
                case 4:
                    balance = t.BTransfer(balance);
                    break;
                case 5:
                    c.cubalance(balance);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("\nWrong Input\n");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File myFile = new File("Atm.txt");
        try {
            myFile.createNewFile();
            try (FileWriter write = new FileWriter("Atm.txt")) {
                String str="\tDATE\tTIME\tD/C/T\t\t\tAMOUNT\t\t\tCURRENT BALANCE\n";
                write.write(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            System.out.print("\n\nEnter your Card Number:");
            long card = sc.nextLong();
            if (card == 1111) {
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
