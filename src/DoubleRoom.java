class DoubleRoom extends Room {
    public DoubleRoom(int number, double price) {
        super(number, price);
    }

    @Override
    public String details() {
        return "DoubleRoom " + number + " costs " + price;
    }
}
