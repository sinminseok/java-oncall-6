package oncall.controller;

import oncall.dto.WorkDateRequest;
import oncall.view.InputView;

import java.util.List;

public class OncallController {

    public void run(){
        WorkDateRequest workDateRequest = InputView.inputWorkDate();
        List<String> weekdaysUsers = InputView.inputWeekdaysUser();
    }
}
