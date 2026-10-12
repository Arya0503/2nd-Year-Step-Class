class PasswordChecker {
    private String password;

    public PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {
        int length = this.password.length();
        if (length < 6) {
            return "Weak";
        } else if (length <= 9) {
            return "Medium";
        } else {
            return "Strong";
        }
    }
}

public class PasswordCheckerMain {
    public static void main(String[] args) {
        PasswordChecker pc1 = new PasswordChecker("abcd");
        System.out.println(pc1.getStrength());

        PasswordChecker pc2 = new PasswordChecker("abcdefghij");
        System.out.println(pc2.getStrength());
    }
}