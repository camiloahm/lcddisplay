package pslcorp.lcddisplay.inputreader;

import java.util.Objects;

/**
 * Created by dev-camiloh on 2/14/17.
 */
public class UserCommand {

    private String command;

    public UserCommand(final String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    @Override
    public int hashCode() {
        return Objects.hash(command);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof UserCommand)) {
            return false;
        }

        UserCommand uc = (UserCommand) o;

        return Objects.equals(command,uc.getCommand());
    }
}
