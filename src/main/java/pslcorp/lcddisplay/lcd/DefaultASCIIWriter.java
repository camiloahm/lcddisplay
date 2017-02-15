package pslcorp.lcddisplay.lcd;

import pslcorp.lcddisplay.inputreader.UserInput;

/**
 * Created by dev-camiloh on 2/14/17.
 * <p>
 * LED representation for each number
 * <p>
 * -0-
 * |   |
 * 2   1
 * |   |
 * -3-
 * |   |
 * 5   4
 * |   |
 * -6-
 */
public class DefaultASCIIWriter implements ASCCIIWriter {

    private final char SPACE_CHARACTER = ' ';
    private final char[][] charConvention = {
             /* 0   1   2   3   4   5   6 */
    /* 0 */ {'-', '|', '|', ' ', '|', '|', '-'},
    /* 1 */ {' ', '|', ' ', ' ', '|', ' ', ' '},
    /* 2 */ {'-', '|', ' ', '-', ' ', '|', '-'},
    /* 3 */ {'-', '|', ' ', '-', '|', ' ', '-'},
    /* 4 */ {' ', '|', '|', '-', '|', ' ', ' '},
    /* 5 */ {'-', ' ', '|', '-', '|', ' ', '-'},
    /* 6 */ {'-', ' ', '|', '-', '|', '|', '-'},
    /* 7 */ {'-', '|', ' ', ' ', '|', ' ', ' '},
    /* 8 */ {'-', '|', '|', '-', '|', '|', '-'},
    /* 9 */ {'-', '|', '|', '-', '|', ' ', '-'}
    };


    @Override
    public String createASCII(final UserInput userInput) {

        StringBuilder output = new StringBuilder();
        int rows = 2 * userInput.getSize() + 3;

        for (int row = 0; row < rows; row++) {
            int position = (row / (userInput.getSize() + 1)) * 3;
            int uml = row % (userInput.getSize() + 1);
            int lower = 2 * userInput.getSize() + 2;

            for (int d = 0; d < userInput.getDigits().length(); d++) {
                int digit = userInput.getDigits().charAt(d) - '0';

                //Positions 0,3,6 upper-middle-lower
                if (uml == 0) {
                    output.append(SPACE_CHARACTER);
                    for (int k = 0; k < userInput.getSize(); k++) {
                        output.append(charConvention[digit][position]);
                    }
                    output.append(SPACE_CHARACTER);
                } else
                    //Positions 2,1 Upper parts
                    if (row > 0 && row < (userInput.getSize() + 1)) {
                        output.append(charConvention[digit][2]);
                        for (int k = 0; k < userInput.getSize(); k++) {
                            output.append(SPACE_CHARACTER);
                        }
                        output.append(charConvention[digit][1]);
                    } else
                        //PositionsLower 5,4 parts
                        if (row > (userInput.getSize() + 1) && row < lower) {
                            output.append(charConvention[digit][5]);
                            for (int k = 0; k < userInput.getSize(); k++) {
                                output.append(SPACE_CHARACTER);
                            }
                            output.append(charConvention[digit][4]);
                        }

                if (d != userInput.getDigits().length() - 1)
                    output.append(SPACE_CHARACTER);
            }
            output.append("\n");
        }

        return output.toString();
    }
}
