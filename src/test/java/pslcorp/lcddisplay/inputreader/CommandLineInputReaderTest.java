package pslcorp.lcddisplay.inputreader;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by CamiloH on 2/14/2017.
 */
public class CommandLineInputReaderTest {

    private InputReader inputReader;

    @Before
    public void init() {
        inputReader = new CommandLineInputReader();
    }

    @Test(expected = IllegalArgumentException.class)
    public void readEmptyParams() {
        UserCommand userCommand = new UserCommand("");
        UserInput userInput = inputReader.readInput(userCommand);
    }

    @Test(expected = IllegalArgumentException.class)
    public void readOneParam(){
        UserCommand userCommand = new UserCommand("2");
        UserInput userInput = inputReader.readInput(userCommand);
    }

    @Test(expected = IllegalArgumentException.class)
    public void readIncorrectTypeParams(){
        UserCommand userCommand = new UserCommand("a b");
        UserInput userInput = inputReader.readInput(userCommand);
    }


    @Test(expected = IllegalArgumentException.class)
    public void readWrongSize(){
        UserCommand userCommand = new UserCommand("13 123");
        UserInput userInput = inputReader.readInput(userCommand);
    }

    @Test(expected = IllegalArgumentException.class)
    public void readBigSize()
    {
        UserCommand userCommand = new UserCommand("12345678911112222 123");
        UserInput userInput = inputReader.readInput(userCommand);
    }

    @Test(expected = IllegalArgumentException.class)
    public void readDecimalDigits()
    {
        UserCommand userCommand = new UserCommand("2 123.4");
        UserInput userInput = inputReader.readInput(userCommand);
    }

    @Test
    public void readCorrectParams(){
        UserCommand userCommand = new UserCommand("3 12345678901230");
        UserInput userInput = inputReader.readInput(userCommand);
        assertThat(userInput.getSize(),equalTo((short)3));
        assertThat(userInput.getDigits(),equalTo("12345678901230"));
    }

}
