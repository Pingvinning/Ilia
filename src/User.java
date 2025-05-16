abstract class User extends Person {
    public User(String name, String email) {
        super(name, email);
    }

    public abstract void accessSystem();


    @Override
    public String toString() {
        return "User[name=" + name + ",email=" + email + "]";
    }
}