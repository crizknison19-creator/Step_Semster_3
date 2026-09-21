class Character {
    private final int maxHealth;
    private int health;

    public Character(int maxHealth) {
        this.maxHealth = Math.max(maxHealth, 1);
        this.health = this.maxHealth;   // starts at full health
    }

    public void takeDamage(int amount) {
        if (amount < 0) {
            System.out.println("Damage cannot be negative");
            return;
        }
        health = Math.max(0, health - amount);           // floor at 0
    }

    public void heal(int amount) {
        if (amount < 0) {
            System.out.println("Healing cannot be negative");
            return;
        }
        health = Math.min(maxHealth, health + amount);   // cap at max
    }

    public int getHealth() {
        return health;
    }
}

public class HealthBarDemo {
    public static void main(String[] args) {
        Character c = new Character(100);

        c.takeDamage(30);
        System.out.println("takeDamage(30) -> health = " + c.getHealth());

        c.heal(50);
        System.out.println("heal(50) -> health = " + c.getHealth() + " (capped)");

        c.takeDamage(150);
        System.out.println("takeDamage(150) -> health = " + c.getHealth() + " (floored)");
    }
}