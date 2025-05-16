import java.util.Arrays;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        ConsoleUI ui = new ConsoleUI();
        ui.start();

        // Example static method usage
        System.out.println("Total Reservation Services created: " + ReservationService.getTotalCreated());

        // Example generic method usage
        List<String> messages = Arrays.asList("Hello", "World", "Generic");
        Utils.printAll(messages);
    }
}