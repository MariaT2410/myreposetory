import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogFile implements Checker {
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
                FileHandler fh = new FileHandler("log.txt");
                this.logger.addHandler(fh);
                SimpleFormatter sf = new SimpleFormatter();
                fh.setFormatter(sf);
                logger.setUseParentHandlers(false);
                this.logger.log(Level.INFO,messages.size()+" "+"<"+teg+">"+information+"<"+teg+">");

            }
        } catch (IllegalStateException | IOException e){ }
    }
}
