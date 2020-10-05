import com.google.inject.Inject;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Logger;

public class LogConsole implements Checker {
    @Inject
    private @NotNull Logger logger;

    private List<String> messages = new ArrayList<String>(0);

    @Override
    public void waitForIn() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Your teg:");
            String teg = scanner.nextLine();
            System.out.println("Waiting for new lines. Key in Ctrl+D to exit.");
            while (true) {
                String information = scanner.nextLine();
                messages.add(information);
                logger.info(messages.size()+" "+  "<"+teg+">" + information + "<"+teg+">");
            }
        } catch (IllegalStateException | NoSuchElementException e) {
        }

    }
}
