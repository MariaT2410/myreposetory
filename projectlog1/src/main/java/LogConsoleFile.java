import com.google.inject.Inject;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class LogConsoleFile implements Checker {

    @Inject
    private @NotNull
    Logger logger;
    @Inject
    private @NotNull
    Logger logger2;
    private List<String> messages = new ArrayList<String>(0);


    @Override
    public void waitForIn() throws IOException {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Your teg:");
            String teg = scanner.nextLine();
            System.out.println("Waiting for new lines. Key in Ctrl+D to exit.");
            while (true) {
                String information = scanner.nextLine();
                messages.add(information);
                this.logger2.info(messages.size() + " " + information);
                FileHandler fih = new FileHandler("new_log.txt");
                SimpleFormatter sf = new SimpleFormatter();
                fih.setFormatter(sf);
                this.logger.addHandler(fih);
                logger.setUseParentHandlers(false);
                this.logger.log(Level.INFO, (messages.size() + 1) + " " + "<"+teg+">"+ information + "<"+teg+">");
            }
        }catch (IllegalStateException | NoSuchElementException | IOException e) {}

    }
}
