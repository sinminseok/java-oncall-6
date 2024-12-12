package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import oncall.dto.WorkDateRequest;
import oncall.global.utils.Converter;

import java.util.List;

import static oncall.global.constants.ViewMessage.INPUT_MONTH_AND_DAY_MESSAGE;

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
}
