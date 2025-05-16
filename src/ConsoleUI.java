import java.util.Scanner;

class ConsoleUI implements UIComponent {
    private Scanner input = new Scanner(System.in);
    private ReservationService service = new ReservationService();

    @Override
    public void renderMenu() {
        System.out.println("=== Welcome to GrandHotel ===");
        String[] options = {"Add Customer", "Add Admin", "List Rooms", "Reserve Room", "View Reservations", "Exit"};
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    @Override
    public int getSelection() {
        try {
            return Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
            return -1;
        }
    }

    public void start() {
        int choice;
        do {
            renderMenu();
            choice = getSelection();

            switch (choice) {
                case 1:
                    service.addCustomer();
                    break;
                case 2:
                    service.addAdmin();
                    break;
                case 3:
                    service.showRooms();
                    break;
                case 4:
                    service.makeReservation();
                    break;
                case 5:
                    service.listReservations();
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 6);
    }
}