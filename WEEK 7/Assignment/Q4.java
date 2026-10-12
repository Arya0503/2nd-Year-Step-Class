class TrafficLight {
    private String color;
    private final String id;

    public TrafficLight(String id) {
        this.id = id;
        this.color = "RED";
    }

    public void next() {
        if (this.color.equals("RED")) {
            this.color = "GREEN";
        } else if (this.color.equals("GREEN")) {
            this.color = "YELLOW";
        } else if (this.color.equals("YELLOW")) {
            this.color = "RED";
        }
    }

    public String getColor() {
        return this.color;
    }

    public String getId() {
        return this.id;
    }
}

public class TrafficLightMain {
    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println(t.getColor());

        t.next();
        System.out.println(t.getColor());

        t.next();
        System.out.println(t.getColor());

        t.next();
        System.out.println(t.getColor());
    }
}