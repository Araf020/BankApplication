package src.arafat.util;

public enum AccountType {
    CURRENT, SAVINGS, SALARY;

    public static AccountType getAccountType(String type) {
        switch (type) {
            case "CURRENT":
                return CURRENT;
            case "SAVINGS":
                return SAVINGS;
            case "SALARY":
                return SALARY;
            default:
                throw new IllegalArgumentException("Unsupported account type");
        }
    }
}
