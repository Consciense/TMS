import java.util.Scanner;

public class TMSHomework6 {
    public static void main(String[] args) {
        doCardOperations();
        operateATMMachine();
    }

    public static void doCardOperations() {
        CreditCard[] wallet = new CreditCard[3];
        wallet[0] = createFirstCard();
        wallet[1] = createSecondCard();
        wallet[2] = createThirdCard();
        int userChoice;
        do {
            chooseCardToOperate(wallet);
            userChoice = getUserInput("Input any integer value to use your wallet again " +
                    "or 0 to stop ...").nextInt();
        } while (userChoice != 0);
    }

    public static void useCreditCard(CreditCard card) {
        System.out.println("Choose desired option:");
        System.out.println("1 - spend money");
        System.out.println("2 - top up yur card");
        System.out.println("Other value - check your balance");

        int option = getUserInput("").nextInt();
        double amountOfMoney;
        switch (option) {
            case 1:
                amountOfMoney = getUserInput("Input value to spend...").nextDouble();
                card.chargeFromCreditCard(amountOfMoney);
                break;
            case 2:
                amountOfMoney = getUserInput("Input value to add...").nextDouble();
                card.topUpCreditCard(amountOfMoney);
                break;
            default:
                card.getCreditCardInfo();
                break;
        }

    }

    public static void chooseCardToOperate(CreditCard[] wallet) {
        System.out.println("Choose card to operate:");
        System.out.println("0 - first card");
        System.out.println("1 - second card");
        System.out.println("2 - third card");
        System.out.println("Other value - show all cards information");
        int option = getUserInput("").nextInt();
        if (option > 2 || option < 0) {
            showWalletInfo(wallet);
            return;
        }
        useCreditCard(wallet[option]);
    }

    public static Scanner getUserInput(String messageToUser) {
        System.out.println(messageToUser);
        return new Scanner(System.in);
    }

    public static void showWalletInfo(CreditCard[] currentWallet) {
        for (CreditCard card : currentWallet)
            card.getCreditCardInfo();
    }

    public static CreditCard createFirstCard() {
        CreditCard card = new CreditCard();
        card.cardName = "Visa";
        card.accountNumber = "4601 2204 3228 8093";
        card.currentAmount = 6000;
        return card;
    }

    public static CreditCard createSecondCard() {
        CreditCard card = new CreditCard();
        card.cardName = "MasterCard";
        card.accountNumber = "5570 7503 1282 3043";
        card.currentAmount = 3000;
        return card;
    }

    public static CreditCard createThirdCard() {
        CreditCard card = new CreditCard();
        card.cardName = "Mir";
        card.accountNumber = "9112 3800 4269 3043";
        card.currentAmount = 1000;
        return card;
    }

    public static void operateATMMachine() {
        ATMMachine ATM = new ATMMachine(45, 8, 0);
        int userChoice, numberOfBanknotes;
        do {
            System.out.println("1 - add banknotes to the ATM");
            System.out.println("2 - take out banknotes");
            System.out.println("3 - check banknotes at the ATM");
            userChoice = getUserInput("Choose ATM operation to perform or 0 to stop ...").nextInt();
            if (userChoice == 1) {
                System.out.println("1 - add banknotes of 20");
                System.out.println("2 - add banknotes of 50");
                System.out.println("3 - add banknotes of 100");
                userChoice = getUserInput("Choose banknotes to add " +
                        "or input other value to go back ...").nextInt();
                if (userChoice != 1 && userChoice != 2 && userChoice != 3)
                    return;
                do {
                    numberOfBanknotes = getUserInput("Input number of banknotes to add...").nextInt();
                    if (numberOfBanknotes < 0)
                        System.out.println("Incorrect number...");
                } while (numberOfBanknotes < 0);
                switch (userChoice) {
                    case 1:
                        ATM.addBanknotes(0, numberOfBanknotes);
                        break;
                    case 2:
                        ATM.addBanknotes(1, numberOfBanknotes);
                        break;
                    case 3:
                        ATM.addBanknotes(2, numberOfBanknotes);
                        break;
                    default:
                        return;
                }
            } else if (userChoice == 2) {
                int summToWithdraw;
                do {
                    summToWithdraw = getUserInput("Input sum to withdraw...").nextInt();
                    if (summToWithdraw < 0)
                        System.out.println("Incorrect number...");
                } while (summToWithdraw < 0);
                boolean isSuccessful = ATM.withdrawSum(summToWithdraw);
                System.out.println((isSuccessful) ? "Operation was successful" : "Operation was unsuccessful");
            } else if (userChoice == 3) {
                ATM.getATMInfo();
            }
        } while (userChoice != 0);
    }
}