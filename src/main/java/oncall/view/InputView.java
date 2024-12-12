package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import oncall.dto.WorkDateRequest;
import oncall.global.utils.Converter;

import java.util.List;

import static oncall.global.constants.ViewMessage.INPUT_MONTH_AND_DAY_MESSAGE;
import static oncall.global.constants.ViewMessage.INPUT_WEEK_DAYS_USER_NAME;

public class InputView {
    private InputView(){
    }

    public static WorkDateRequest inputWorkDate(){
        System.out.print(INPUT_MONTH_AND_DAY_MESSAGE);
        String input = Console.readLine();
        //todo 검증
        List<String> splits = Converter.splitDelimiter(input);
        int month = Converter.toNumber(splits.get(0));
        return new WorkDateRequest(month, splits.get(1));
    }

    public static List<String> inputWeekdaysUser(){
        System.out.println(INPUT_WEEK_DAYS_USER_NAME);
        String input = Console.readLine();
        return Converter.splitDelimiter(input);
    }
}
