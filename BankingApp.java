import java.util.Scanner;

public class BankingApp {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        final String CLEAR = "\033[H\033[2J";
        final String BLUE_BOLD_START = "\033[34;1m";
        final String RED_BOLD_START = "\033[31;1m";
        final String GREEN_BOLD_START = "\033[32;1m";
        final String RESET = "\033[30;0m";

        final String SUCCESS_MSG = String.format("%s%s%s\n", GREEN_BOLD_START, "%s", RESET);

        final String MAIN_MENU = "\u1F4B0 Welcome to Smart Banking App";
        final String OPEN_NEW_ACCOUNT = "Add New Customer";
        final String DEPOSIT_MONEY = "Remove Exisiting Customer";
        final String WITHDRAW_MONEY = "Print Customer Details";
        final String TRANSFER_MONEY = "Transfer Money";
        final String CHECK_ACCOUNT_BALANCE = "Check Account Balance";
        final String DROP_EXISTING_ACCOUNT = "Drop Existing Account";
        final String EXTI = "Exit";

        String screen = MAIN_MENU;

        String[] custName = new String[0];
        int[] custID = new int[0];
        int[] bankBalance = new int[0];

        do {
            final String APP_TITLE = String.format("%s%s%s", BLUE_BOLD_START, screen, RESET);
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
                    System.out.print(" Enter an option to continue: ");

                    int option = scanner.nextInt();
                    scanner.nextLine();

                    switch (option) {
                        case 1:
                            screen = OPEN_NEW_ACCOUNT;
                            break;
                        case 2:
                            screen = DEPOSIT_MONEY;
                            break;
                        case 3:
                            screen = WITHDRAW_MONEY;
                            break;
                        case 4:
                            screen = TRANSFER_MONEY;
                            break;
                        case 5:
                            screen = CHECK_ACCOUNT_BALANCE;
                            break;
                        case 6:
                            screen = DEPOSIT_MONEY;
                            break;
                        case 7:
                            System.out.println(CLEAR);
                            System.exit(0);
                        default:
                            continue;
                    }
                    break;
                case OPEN_NEW_ACCOUNT:
                    System.out.printf("ID: SDB-%05d \n", (custName.length + 1));

                    boolean valid;
                    String name;
                    int id;
                    int initialAount;
                    do {
                        valid = true;
                        System.out.print("Name: ");
                        name = scanner.nextLine().strip();
                        if (name.isBlank()) {
                            System.out.printf("%sName can't be empty%s\n", RED_BOLD_START, RESET);
                            valid = false;
                            continue;
                        }
                        for (int i = 0; i < name.length(); i++) {
                            if (!(Character.isLetter(name.charAt(i)) ||
                                    Character.isSpaceChar(name.charAt(i)))) {
                                System.out.printf("%sInvalid Name%s\n", RED_BOLD_START, RESET);
                                valid = false;
                                break;
                            }
                        }
                    } while (!valid);

                    do {
                        valid = true;
                        System.out.print("Initial deposit: ");
                        initialAount = scanner.nextInt();
                        scanner.nextLine();

                        if (initialAount < 5000) {
                            System.out.printf("%sInsufficient Amount!%s\n", RED_BOLD_START, RESET);
                            valid = false;
                            continue;
                        }
                    } while (!valid);

                    // create customer id array
                    id = custName.length + 1;
                    int[] newCustID = new int[custID.length + 1];
                    for (int i = 0; i < custID.length; i++) {
                        newCustID[i] = custID[i];
                    }
                    newCustID[newCustID.length - 1] = id;
                    custID = newCustID;

                    // create customer names array
                    String[] newCustName = new String[custName.length + 1];
                    for (int i = 0; i < custName.length; i++) {
                        newCustName[i] = custName[i];
                    }
                    newCustName[newCustName.length - 1] = name;
                    custName = newCustName;

                    // create customer bank amount array
                    int[] newCustBankAmt = new int[bankBalance.length + 1];
                    for (int i = 0; i < bankBalance.length; i++) {
                        newCustBankAmt[i] = bankBalance[i];
                    }
                    newCustBankAmt[newCustBankAmt.length - 1] = id;
                    bankBalance = newCustBankAmt;

                    System.out.println();
                    System.out.printf(SUCCESS_MSG, String.format("SDB-%05d: %s added successfuly.\n Do you want to add more (Y/n)? ", id, name));
                    if (scanner.nextLine().strip().toUpperCase().equals("Y"))
                        continue;
                    screen = MAIN_MENU;
                    break;
                default:
                    break;
            }
        } while (true);
    }
}