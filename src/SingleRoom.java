class SingleRoom extends Room {
    public SingleRoom(int number, double price) {
        super(number, price);
    }

    @Override
    public String details() {
        return "SingleRoom " + number + " costs " + price;
    }
}