class PasswordChecker {
    private final String password;   // final: cannot change; no getter exposes it

    public PasswordChecker(String password) {
        this.password = (password == null) ? "" : password;
    }

    public String getStrength() {
        int len = password.length();
        if (len < 6) {
            return "Weak";
        } else if (len < 10) {
            return "Medium";
        } else {
            return "Strong";
        }
    }
}

public class PasswordCheckerDemo {
    public static void main(String[] args) {
        PasswordChecker pc1 = new PasswordChecker("abcd");           // 4 chars
        PasswordChecker pc2 = new PasswordChecker("abcdefgh");       // 8 chars
        PasswordChecker pc3 = new PasswordChecker("abcdefghijkl");   // 12 chars

        System.out.println("4 chars  -> " + pc1.getStrength());
        System.out.println("8 chars  -> " + pc2.getStrength());
        System.out.println("12 chars -> " + pc3.getStrength());
    }
}