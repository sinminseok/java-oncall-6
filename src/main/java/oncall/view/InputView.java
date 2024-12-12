package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import oncall.domain.DayOfWeek;
import oncall.dto.WorkDateRequest;
import oncall.global.utils.Converter;
import oncall.global.validator.InputValidator;

import java.util.List;

import static oncall.global.constants.ViewMessage.*;

public class InputView {
    private InputView() {
    }

    public static WorkDateRequest inputWorkDate() {
        System.out.print(INPUT_MONTH_AND_DAY_MESSAGE);
        String input = Console.readLine();
        InputValidator.validateWorkDate(input);
        List<String> splits = Converter.splitDelimiter(input);
        int month = Converter.toNumber(splits.get(0));
        return new WorkDateRequest(month, DayOfWeek.valueOfCommand(splits.get(1)));
    }

    public static List<String> inputWeekdaysUser() {
        System.out.print(INPUT_WEEK_DAYS_USER_NAME);
        String input = Console.readLine();
        return Converter.splitDelimiter(input);
    }

    public static List<String> inputHolidayUSer() {
        System.out.print(INPUT_HOLIDAY_USER_NAME);
        String input = Console.readLine();
        return Converter.splitDelimiter(input);
    }
}
