package src.arafat.util;

public class ValidityCheck {
    public boolean isNameValid(String name) {
        return name.matches("[a-zA-Z]+");
    }
    public boolean isEmailValid(String email) {
        return email.matches("[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+");
    }
    public boolean isPhoneValid(String phone) {
        return phone.matches("[0-9]{11}");
    }

    public boolean isWithdrawAmountValid(double amount, double balance, double minimumBalanceToMaintain) {
        return amount > 0 && (balance - amount) >= minimumBalanceToMaintain;
    }
    public boolean isDepositAmountValid(double amount) {
        return amount > 0;
    }
    public boolean isTransferAmountValid(double amount,double balance, double minimumBalanceToMaintain) {
        return amount > 0 && (balance - amount) >= minimumBalanceToMaintain;
    }


}
