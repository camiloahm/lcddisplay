package pslcorp.lcddisplay.display;

/**
 * Created by dev-camiloh on 2/14/17.
 */
public class CommandLineDisplay implements Display {

    @Override
    public void print(UserOutput userOutput) {
       System.out.println(userOutput.getOutput());
    }

}
