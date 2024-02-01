package src.arafat.util;

public class ValidityCheck {
    public static boolean isNameValid(String name) {
        return name.matches("[a-zA-Z]+");
    }
    public static boolean isEmailValid(String email) {
        return email.matches("[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+");
    }
    public static boolean isPhoneValid(String phone) {
        return phone.matches("[0-9]{11}");
    }

    public static boolean isWithdrawAmountValid(double amount, double balance, double minimumBalanceToMaintain) {
        return amount > 0 && (balance - amount) >= minimumBalanceToMaintain;
    }
    public static boolean isDepositAmountValid(double amount) {
        return amount > 0;
    }
    public static boolean isTransferAmountValid(double amount,double balance, double minimumBalanceToMaintain) {
        return amount > 0 && (balance - amount) >= minimumBalanceToMaintain;
    }


}
