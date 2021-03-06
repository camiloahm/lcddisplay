package pslcorp.lcddisplay; /**
 * Created by CamiloH on 2/13/2017.
 */

import pslcorp.lcddisplay.display.CommandLineDisplay;
import pslcorp.lcddisplay.display.Display;
import pslcorp.lcddisplay.display.UserOutput;
import pslcorp.lcddisplay.inputreader.CommandLineInputReader;
import pslcorp.lcddisplay.inputreader.InputReader;
import pslcorp.lcddisplay.inputreader.UserCommand;
import pslcorp.lcddisplay.inputreader.UserInput;
import pslcorp.lcddisplay.lcd.ASCCIIWriter;
import pslcorp.lcddisplay.lcd.DefaultASCIIWriter;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        InputReader inputReader = new CommandLineInputReader();
        ASCCIIWriter ascciiWriter = new DefaultASCIIWriter();
        Display display = new CommandLineDisplay();
        String commandLine;

        display.print(new UserOutput("Welcome to ASCII art (Finish this program with 0 0)"));

        while ((commandLine = sc.nextLine()) != null) {
            try {

                UserInput userInput = inputReader.readInput(new UserCommand(commandLine));
                if (userInput.getSize() == 0
                        && userInput.getDigits().length() == 1
                        && Short.parseShort(userInput.getDigits()) == 0) {

                    display.print(new UserOutput("Goodbye"));
                    break;

                } else if (userInput.getSize() == 0) {

                    display.print(new UserOutput("Size must be between 1 and 10"));

                } else {
                    String ascii = ascciiWriter.createASCII(userInput);
                    display.print(new UserOutput(ascii));
                }

            } catch (IllegalArgumentException ex) {
                display.print(new UserOutput(ex.getMessage()));
            }
        }
    }
}
