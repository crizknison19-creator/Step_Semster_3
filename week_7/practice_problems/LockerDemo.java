class Locker {
    private final int lockerNumber;
    private String code;   // no getter on purpose

    public Locker(int lockerNumber, String code) {
        this.lockerNumber = lockerNumber;
        this.code = code;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (!code.equals(currentCode)) {
            System.out.println("changeCode rejected: wrong current code");
            return false;
        }
        code = newCode;
        System.out.println("changeCode success");
        return true;
    }

    public int getLockerNumber() {
        return lockerNumber;
    }
}

public class LockerDemo {
    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");

        l.changeCode("1234", "5678");   // correct current code -> success
        l.changeCode("0000", "9999");   // wrong current code   -> rejected

        // Prove the code is still "5678": the old correct code no longer works
        System.out.println("Try old code 1234:");
        l.changeCode("1234", "0001");
        System.out.println("Try current code 5678:");
        l.changeCode("5678", "5678");
    }
}