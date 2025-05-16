abstract class Room {
    protected int number;
    protected double price;

    public Room(int number, double price) {
        this.number = number;
        this.price = price;
    }

    public abstract String details();

    @Override
    public String toString() {
        return "Room#" + number + " [$" + price + "]";
    }
}