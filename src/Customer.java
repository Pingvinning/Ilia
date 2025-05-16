import java.util.Objects;

class Customer extends User {
    private int id;

    public Customer(String name, String email, int id) {
        super(name, email);
        this.id = id;
    }

    @Override
    public void displayInfo() {
        System.out.println("Customer: " + name);
    }

    @Override
    public void accessSystem() {
        System.out.println("Customer access granted.");
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Customer)) return false;
        return id == ((Customer) o).id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
