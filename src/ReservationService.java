import java.util.*;

class ReservationService {
    private List<User> users = new ArrayList<>();
    private List<Room> rooms = new ArrayList<>();
    private Set<Reservation> reservations = new HashSet<>();
    private Map<Customer, List<Reservation>> byCustomer = new HashMap<>();
    private List<Reservation> recent = new ArrayList<>();
    private static int totalCreated;

    public ReservationService() {
        totalCreated++;
        Room[] arr = new Room[4];
        for (int i = 0; i < 4; i++) {
            if (i % 2 == 0) {
                arr[i] = new SingleRoom(100 + i, 50 + i * 5);
            } else {
                arr[i] = new DoubleRoom(200 + i, 80 + i * 10);
            }
        }
        for (Room r : arr) {
            rooms.add(r);
        }
    }

    public static int getTotalCreated() {
        return totalCreated;
    }

    public void addCustomer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Name: ");
        String n = sc.nextLine();
        System.out.print("Email: ");
        String e = sc.nextLine();
        int id = new Random().nextInt(1000);
        Customer c = new Customer(n, e, id);
        users.add(c);
        System.out.println("Added " + c);
    }

    public void addAdmin() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Admin name: ");
        String n = sc.nextLine();
        Admin a = new Admin(n, n + "@hotel.com", new Random().nextInt(1000));
        users.add(a);
        User u = a;
        ((Notifiable) u).sendNotification("Welcome " + n);
    }

    public void showRooms() {
        for (Room r : rooms) {
            System.out.println(r.details());
        }
    }

    public void listReservations() {
        List<Reservation> sorted = new ArrayList<>(reservations);
        for (int i = 0; i < sorted.size() - 1; i++) {
            for (int j = i + 1; j < sorted.size(); j++) {
                if (sorted.get(i).toString().compareTo(sorted.get(j).toString()) > 0) {
                    Reservation temp = sorted.get(i);
                    sorted.set(i, sorted.get(j));
                    sorted.set(j, temp);
                }
            }
        }
        for (Reservation r : sorted) {
            System.out.println(r);
        }
    }

    public void makeReservation() {
        if (rooms.isEmpty()) {
            System.out.println("Booking failed: No rooms available");
            return;
        }

        Customer c = null;
        for (User u : users) {
            if (u instanceof Customer) {
                c = (Customer) u;
                break;
            }
        }

        if (c == null) {
            System.out.println("Booking failed: No customer registered");
            return;
        }

        Room r = rooms.get(0);
        String date = new Date().toString();

        try {
            if (date.contains("13")) {
                throw new InvalidReservationException("Reservations not allowed on 13th!");
            }
            Reservation res = new Reservation(c, r, date);
            reservations.add(res);
            recent.add(res);
            byCustomer.computeIfAbsent(c, k -> new ArrayList<>()).add(res);
            System.out.println("Booked: " + res);
        } catch (InvalidReservationException ex) {
            System.out.println("Custom Exception: " + ex.getMessage());
        }
    }
}