package pslcorp.lcddisplay.inputreader;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by dev-camiloh on 2/14/17.
 */
public class CommandLineInputReader implements InputReader {

    @Override
    public UserInput readInput(final UserCommand input) {

        List<String> params = getCommandParams(input);

        try {
            if (StringUtils.isNumeric(params.get(0)) && StringUtils.isNumeric(params.get(1))) {

                short size = Short.parseShort(params.get(0));
                String digits = params.get(1);

                if (size < 0 || size > 10)
                    throw new IllegalArgumentException("Size must be between 1 and 10");

                return new UserInput(size, digits);

            } else {
                throw new IllegalArgumentException("Size and digits must be Numbers");
            }
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Size must be between 1 and 10");
        }
    }

    private List<String> getCommandParams(final UserCommand input) {

        List<String> splitOnWhitespace = Stream
                .of(input.getCommand())
                .map(w -> w.split("\\s+")).flatMap(Arrays::stream)
                .collect(Collectors.toList());

        if (splitOnWhitespace.size() != 2)
            throw new IllegalArgumentException("This programs receives 2 parameter Size and Digits");

        return splitOnWhitespace;
    }

}

