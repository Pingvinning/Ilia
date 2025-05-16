class Admin extends User implements Notifiable {
    private int id;

    public Admin(String name, String email, int id) {
        super(name, email);
        this.id = id;
        displayInfo();
        accessSystem();
    }

    @Override
    public void displayInfo() {
        System.out.println("Administrator: " + name);
    }

    @Override
    public void accessSystem() {
        System.out.println("Admin access granted.");
    }

    @Override
    public void sendNotification(String msg) {
        System.out.println("[Email to " + email + "]: " + msg);
    }
}