package pslcorp.lcddisplay.inputreader;

import java.util.Objects;

/**
 * Created by dev-camiloh on 2/14/17.
 */
public class UserInput {

    private short size;
    private String digits;

    public UserInput(short size, String digits) {
        this.size = size;
        this.digits = digits;
    }

    public short getSize() {
        return size;
    }

    public String getDigits() {
        return digits;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, digits);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof UserInput)) {
            return false;
        }

        UserInput ui = (UserInput) o;

        return Objects.equals(size, ui.getSize()) && Objects.equals(digits, ui.getDigits());
    }
}
