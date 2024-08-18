public class CreditCard {
    String accountNumber, cardName;
    double currentAmount;

    void topUpCreditCard(double amountToAdd) {
        this.currentAmount += amountToAdd;
        System.out.println("Sum is successfully added.");
        System.out.println("Your current card balance is:" + this.currentAmount);
    }

    void chargeFromCreditCard(double amountToCharge) {
        if (amountToCharge < this.currentAmount) {
            this.currentAmount -= amountToCharge;
            System.out.println("Sum is successfully withdrawed.");
            System.out.println("Your current card balance is:" + this.currentAmount);
        } else
            System.out.println("You can't do this operation, sum is too big.");
    }

    void getCreditCardInfo() {
        System.out.println("-------------------------------------------------------------");
        System.out.println("Current card is: " + this.cardName);
        System.out.println("It's number is: " + this.accountNumber);
        System.out.println("There is " + this.currentAmount + " money on the card.");
        System.out.println("-------------------------------------------------------------");
    }

}