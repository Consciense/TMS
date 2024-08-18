public class ATMMachine {
    int[] banknotes = new int[3];
    // banknotes[0] - banknotes of 20
    // banknotes[1] - banknotes of 50
    // banknotes[2] - banknotes of 100

    ATMMachine(int banknotesOf20, int banknotesOf50, int banknotesOf100) {
        this.banknotes[0] = banknotesOf20;
        this.banknotes[1] = banknotesOf50;
        this.banknotes[2] = banknotesOf100;
    }

    public void getATMInfo() {
        System.out.println("There is:");
        System.out.println(this.banknotes[0] + " banknotes of 20");
        System.out.println(this.banknotes[1] + " banknotes of 50");
        System.out.println(this.banknotes[2] + " banknotes of 100");
        System.out.println("Total amount equals " + (this.banknotes[0] * 20 + this.banknotes[1] * 50 + this.banknotes[2] * 100));
    }

    public void addBanknotes(int indexOfArray, int amountOfBanknotes) {
        this.banknotes[indexOfArray] += amountOfBanknotes;
    }

    public boolean withdrawSum(int withdrawalAmount) {
        int currentBalance = this.banknotes[0] * 20 + this.banknotes[1] * 50 + this.banknotes[2] * 100;
        if (currentBalance < withdrawalAmount) {
            System.out.println("There is not enough banknotes in the ATM at the moment...");
            System.out.println("Try again later...");
            return false;
        }
        int[] banknotesToGiveOut = calculateBanknotesToGiveOut(withdrawalAmount);
        if (banknotesToGiveOut[2] == -1)
            return false;
        giveOutBanknotes(banknotesToGiveOut);
        System.out.println("Don't forget to take your cash!");
        System.out.println(banknotesToGiveOut[0] + " banknotes of 20");
        System.out.println(banknotesToGiveOut[1] + " banknotes of 50");
        System.out.println(banknotesToGiveOut[2] + " banknotes of 100");
        return true;
    }

    public int[] calculateBanknotesToGiveOut(int withdrawalAmount) {
        int[] banknotes = new int[]{0, 0, 0};
        // banknotes[0] - banknotes of 20
        // banknotes[1] - banknotes of 50
        // banknotes[2] - banknotes of 100
        if (this.banknotes[2] != 0) {
            banknotes[2] = withdrawalAmount / 100;
            if (banknotes[2] > this.banknotes[2]) {
                banknotes[1] += (banknotes[2] - this.banknotes[2]) * 2;
                banknotes[2] = this.banknotes[2];
            }
        }
        if (this.banknotes[1] != 0) {
            withdrawalAmount -= banknotes[2] * 100;
            banknotes[1] += withdrawalAmount / 50;
            if (banknotes[1] > this.banknotes[1]) {
                if ((banknotes[1] - this.banknotes[1]) % 2 != 1) {
                    banknotes[0] += (banknotes[1] - this.banknotes[1]) * 2.5;
                    banknotes[1] = this.banknotes[1];
                } else
                    banknotes[1] = this.banknotes[1] - 1;
            }
        }
        withdrawalAmount -= banknotes[1] * 50;
        if (withdrawalAmount % 20 != 0) {
            System.out.println("Incorrect sum try other options...");
            return new int[]{0, 0, -1};
        }
        banknotes[0] += withdrawalAmount / 20;
        return banknotes;
    }

    public void giveOutBanknotes(int[] banknotesToGiveOut) {
        this.banknotes[0] -= banknotesToGiveOut[0];
        this.banknotes[1] -= banknotesToGiveOut[1];
        this.banknotes[2] -= banknotesToGiveOut[2];
    }
}