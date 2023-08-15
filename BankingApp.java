import java.util.Scanner;

public class BankingApp {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
     
        final String CLEAR = "\033[H\033[2J";
        final String BLUE_BOLT_START = "\033[34;1m";
        final String RESET = "\033[30;0m";

        final String MAIN_MENU = "\u1F4B0 Welcome to Smart Banking App";
        final String OPEN_NEW_ACCOUNT = "Add New Customer";
        final String DEPOSIT_MONEY = "Remove Exisiting Customer";
        final String WITHDRAW_MONEY = "Print Customer Details";
        final String TRANSFER_MONEY = "Transfer Money";
        final String CHECK_ACCOUNT_BALANCE = "Check Account Balance";
        final String DROP_EXISTING_ACCOUNT = "Drop Existing Account";
        final String EXTI = "Exit";

        String screen = MAIN_MENU;

       // do {
            final String APP_TITLE = String.format("%s%s%s",BLUE_BOLT_START, screen, RESET);
            System.out.println(CLEAR);
            System.out.println("\t" + APP_TITLE + "\n");
            switch (screen) {
                case MAIN_MENU:
                System.out.println(" [1]. Open New Account");
                System.out.println(" [2]. Deposit Money");
                System.out.println(" [3]. Withdraw Money");
                System.out.println(" [4]. Transfer Money");
                System.out.println(" [5]. Check Account Balance");
                System.out.println(" [6]. Drop Existig Account");
                System.out.println(" [7]. Exit\n");
                System.out.print("\tEnter an option to continue: ");

                int option = scanner.nextInt();
                scanner.nextLine();
                    break;
            
                default:
                    break;
            }
        //} while (true);
    }
}