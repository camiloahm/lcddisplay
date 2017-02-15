package pslcorp.lcddisplay.lcd;

import org.junit.Before;
import org.junit.Test;
import pslcorp.lcddisplay.inputreader.UserInput;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by dev-camiloh on 2/14/17.
 */
public class DefaultLCDAsciiWriterTest {

    private ASCCIIWriter asciiWriter;

    @Before
    public void init() {
        asciiWriter = new DefaultASCIIWriter();
    }

    @Test
    public void createASCIIZero() {
        String result = asciiWriter.createASCII(new UserInput((short) 1, "0"));
        assertThat(result, equalTo
                         (" - " +
                        "\n| |" +
                        "\n   " +
                        "\n| |" +
                        "\n - \n"));
    }

    @Test
    public void createAsciiWithFewDigitsAndSmallSize() {
        String result = asciiWriter.createASCII(new UserInput((short) 2, "1234"));
        assertThat(result, equalTo
                         ("      --   --      " +
                        "\n   |    |    | |  |" +
                        "\n   |    |    | |  |" +
                        "\n      --   --   -- " +
                        "\n   | |       |    |" +
                        "\n   | |       |    |" +
                        "\n      --   --      \n"));
    }

    @Test
    public void createAllASCIINumbers() {
        String result = asciiWriter.createASCII(new UserInput((short) 3, "0123456789"));
        assertThat(result, equalTo
                         (" ---         ---   ---         ---   ---   ---   ---   --- " +
                        "\n|   |     |     |     | |   | |     |         | |   | |   |" +
                        "\n|   |     |     |     | |   | |     |         | |   | |   |" +
                        "\n|   |     |     |     | |   | |     |         | |   | |   |" +
                        "\n             ---   ---   ---   ---   ---         ---   --- " +
                        "\n|   |     | |         |     |     | |   |     | |   |     |" +
                        "\n|   |     | |         |     |     | |   |     | |   |     |" +
                        "\n|   |     | |         |     |     | |   |     | |   |     |" +
                        "\n ---         ---   ---         ---   ---         ---   --- " +
                        "\n"));
    }

    @Test
    public void createBigASCIINumber() {
        String result = asciiWriter.createASCII(new UserInput((short) 10, "0"));
        assertThat(result, equalTo
                 (" ---------- "+
                "\n|          |"+
                "\n|          |"+
                "\n|          |"+
                "\n|          |"+
                "\n|          |"+
                "\n|          |"+
                "\n|          |"+
                "\n|          |"+
                "\n|          |"+
                "\n|          |"+
                "\n            "+
                "\n|          |"+
                "\n|          |"+
                "\n|          |"+
                "\n|          |"+
                "\n|          |"+
                "\n|          |"+
                "\n|          |"+
                "\n|          |"+
                "\n|          |"+
                "\n|          |"+
                "\n ---------- \n" ));
    }
}
