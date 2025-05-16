import java.util.Objects;

class Reservation {
    private Customer customer;
    private Room room;
    private String date;

    public Reservation(Customer customer, Room room, String date) {
        this.customer = customer;
        this.room = room;
        this.date = date;
    }

    @Override
    public String toString() {
        return customer + " reserved " + room + " on " + date;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Reservation)) return false;
        Reservation r = (Reservation) o;
        return date.equals(r.date) && customer.equals(r.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, room, date);
    }
}