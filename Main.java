import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        ATMOperationInterface op = new ATMOperationImplementation();

        // ✅ Step 1: Store multiple ATM numbers and their pins
        Map<Integer, Integer> atmData = new HashMap<>();
        atmData.put(12345, 123);
        atmData.put(67890, 456);
        atmData.put(11111, 999);

        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to ATM Machine !!!");
        System.out.print("Enter ATM Number: ");
        int atmNumber = in.nextInt();
        System.out.print("Enter PIN: ");
        int pin = in.nextInt();

        // ✅ Step 2: Validate ATM number and pin
        if (atmData.containsKey(atmNumber) && atmData.get(atmNumber) == pin) {
            while (true) {
                System.out.println("1. View Available Balance");
                System.out.println("2. Withdraw Amount");
                System.out.println("3. Deposit Amount");
                System.out.println("4. View Mini Statement");
                System.out.println("5. Exit");
                System.out.print("Enter Choice: ");
                int ch = in.nextInt();

                switch (ch) {
                    case 1:
                        op.viewBalance();
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = in.nextDouble();
                        op.withdrawAmount(withdrawAmount);
                        break;
                    case 3:
                        System.out.print("Enter Amount to Deposit: ");
                        double depositAmount = in.nextDouble();
                        op.depositAmount(depositAmount);
                        break;
                    case 4:
                        op.viewMiniStatement();
                        break;
                    case 5:
                        System.out.println("Collect your ATM Card\nThank you for using ATM Machine!!");
                        System.exit(0);
                    default:
                        System.out.println("Please enter correct choice");
                }
            }
        } else {
            System.out.println("Incorrect ATM Number or PIN");
            System.exit(0);
        }
    }
}
