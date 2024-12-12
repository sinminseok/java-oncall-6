package oncall.global.validator;

import oncall.global.exception.CustomException;

import java.util.List;

import static oncall.global.exception.ErrorMessage.ERROR_INVALID_INPUT;
import static oncall.global.utils.Converter.splitDelimiter;

public class InputValidator {
    private static final String POSITIVE_NUMBER_REGEX = "[1-9]\\d*";

    private InputValidator(){
    }

    public static void validateWorkDate(String input){
        List<String> splits = splitDelimiter(input);
        validateWorkDateValues(splits);
        validateMonth(splits.get(0));
    }

    private static void validateWorkDateValues(List<String> values){
        if(values.size() != 2){
            throw new CustomException(ERROR_INVALID_INPUT);
        }
    }

    private static void validateMonth(String month){
        if (!month.matches(POSITIVE_NUMBER_REGEX)) {
            throw new CustomException(ERROR_INVALID_INPUT);
        }
        if(Integer.parseInt(month) < 1 || Integer.parseInt(month) > 12){
            throw new CustomException(ERROR_INVALID_INPUT);
        }
    }


}
