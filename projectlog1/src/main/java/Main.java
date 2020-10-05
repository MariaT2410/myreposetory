import com.google.inject.Guice;
import com.google.inject.Injector;
import org.jetbrains.annotations.NotNull;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.inject.Inject;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private  final @NotNull Checker log;

    @Inject
    public Main(@NotNull Checker log) {
        this.log = log;
    }

     public static void main(@NotNull String[] args) throws IOException {
         final Injector injector = Guice.createInjector(new Module());
         injector.getInstance(Main.class).waitForInput();
    }

    private void waitForInput() throws IOException {
        log.waitForIn();
    }
}
