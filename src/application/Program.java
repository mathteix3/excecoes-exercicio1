package application;
import model.entities.Account;
import model.exception.BusinessException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter account data:");
            System.out.print("Number: ");
            int number = scanner.nextInt();

            scanner.nextLine();

            System.out.print("Holder: ");
            String holder = scanner.nextLine();
            System.out.print("Initial balance: ");
            double balance = scanner.nextDouble();
            System.out.print("Withdraw limit: ");
            double withdrawLimit = scanner.nextDouble();

            Account account = new Account(number,holder,balance,withdrawLimit);

            System.out.print("Enter amount for withdraw: ");
            double amountWithdraw = scanner.nextDouble();
            account.withdraw(amountWithdraw);
            System.out.println("\n" + account);

        }catch (BusinessException exception){
            System.out.println("Error: " + exception.getMessage());
        }catch (InputMismatchException exception){
            System.out.println("Unexpected error.");
        }
        finally {
            scanner.close();
        }
    }
}
