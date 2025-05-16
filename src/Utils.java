import java.util.List;

class Utils {
    public static <T> void printAll(List<T> items) {
        for (T item : items) {
            System.out.println(item);
        }
    }
}