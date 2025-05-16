import java.util.Scanner;

class ConsoleUI implements UIComponent {
    Scanner input = new Scanner(System.in);
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

            if (choice == 1) service.addCustomer();
                else if (choice == 2) service.addAdmin();
                else if(choice == 3) service.showRooms();
                else if (choice == 4) service.makeReservation();
                else if (choice == 5) service.listReservations();
                else if (choice == 6) System.out.println("Goodbye!");
                else System.out.println("Invalid option.");

        } while (choice != 6);
    }
}