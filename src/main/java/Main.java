import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {

        LocalDateTime time = LocalDateTime.now().minusDays(1);
        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd").format(time));

    }
}
