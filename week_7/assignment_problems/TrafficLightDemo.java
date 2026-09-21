class TrafficLight {
    private static final String[] CYCLE = {"RED", "GREEN", "YELLOW"};

    private final String id;
    private int position;   // index into CYCLE; starts at RED

    public TrafficLight(String id) {
        this.id = id;
        this.position = 0;
    }

    // The only way to change the color: move forward in the cycle
    public String next() {
        position = (position + 1) % CYCLE.length;
        return CYCLE[position];
    }

    public String getColor() {
        return CYCLE[position];
    }

    public String getId() {
        return id;
    }
}

public class TrafficLightDemo {
    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");

        System.out.println("getColor() -> " + t.getColor());
        System.out.println("next() -> " + t.next());
        System.out.println("next() -> " + t.next());
        System.out.println("next() -> " + t.next());
        System.out.println("next() -> " + t.next());
    }
}