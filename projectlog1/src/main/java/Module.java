import com.google.inject.AbstractModule;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public final class Module extends AbstractModule {

     @NotNull public int command;
    @NotNull
    public int id;

    @Override
    protected void configure() {

        Scanner in = new Scanner(System.in);


            System.out.println("-------MENU--------");
            System.out.println("1. Show Console. (Enter 1)");
            System.out.println("2. Write File. (Enter 2)");
            System.out.println("3. Show Console & Write File (Enter 3)");

            this.command = in.nextInt();
            switch (command) {
                case 1:
                    bind(Checker.class).to(LogConsole.class);
                    break;
                case 2:
                    bind(Checker.class).to(LogFile.class);
                    break;
                case 3:
                    bind(Checker.class).to(LogConsoleFile.class);
                    break;
                default:
                    break;
            }


    }
}



