/**
 * Created by CamiloH on 2/13/2017.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    static final char SPACE = ' ';

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String line;
        int size;
        String number;

        while ((line = sc.nextLine()) != null) {

            List<String> splitOnWhitespace = Stream
                    .of(line)
                    .map(w -> w.split("\\s+")).flatMap(Arrays::stream)
                    .collect(Collectors.toList());

            if (splitOnWhitespace.size() != 2)
                break;

            size = Integer.parseInt(splitOnWhitespace.get(0));
            number = Integer.valueOf(splitOnWhitespace.get(1)).toString();

            if (size == 0)
                break;

            if (size == 0 && number.equals("0"))
                break;


            int rows = 2 * size + 3;

   /*
    * LED representation for each number, according to
    * the following convention:
    *
    *  -0-
    * |   |
    * 2   1
    * |   |
    *  -3-
    * |   |
    * 5   4
    * |   |
    *  -6-
    *
    */

            char[][] lookupChar = {
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

            StringBuilder output = new StringBuilder();

            for (int row = 0; row < rows; row++) {
                int position = (row / (size + 1)) * 3;
                int uml = row % (size + 1);
                int lower = 2 * size + 2;

                for (int d = 0; d < number.length(); d++) {
                    int digit = number.charAt(d) - '0';

                    //upper-middle-lower horizontal parts
                    if (uml == 0) {
                        output.append(SPACE);
                        for (int k = 0; k < size; k++) {
                            output.append(lookupChar[digit][position]);
                        }
                        output.append(SPACE);
                    } else
                        //upper-middle parts
                        if (row > 0 && row < (size + 1)) {
                            output.append(lookupChar[digit][2]);
                            for (int k = 0; k < size; k++) {
                                output.append(SPACE);
                            }
                            output.append(lookupChar[digit][1]);
                        } else
                            //middle-lower parts
                            if (row > (size + 1) && row < lower) {
                                output.append(lookupChar[digit][5]);
                                for (int k = 0; k < size; k++) {
                                    output.append(SPACE);
                                }
                                output.append(lookupChar[digit][4]);
                            }

                    if (d != number.length() - 1)
                        output.append(SPACE);
                }
                output.append("\n");
            }
            System.out.print(output.toString());
            System.out.println();
        }
    }
}
