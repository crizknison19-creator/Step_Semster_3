final class NameTag {
    private final String firstName;
    private final String lastName;

    public NameTag(String fullName) {
        String[] parts = fullName.split(" ");   // split once, store results
        this.firstName = parts[0];
        this.lastName = parts[1];
    }

    public String getNickname() {
        return firstName + " " + lastName.charAt(0) + ".";
    }
}

public class NameTagDemo {
    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println("getNickname() -> " + tag.getNickname());

        NameTag a = new NameTag("Maria Gomez");
        NameTag b = new NameTag("Maria Gomez");
        System.out.println("Same nickname: " + a.getNickname().equals(b.getNickname()));
        System.out.println("Same object: " + (a == b));
    }
}