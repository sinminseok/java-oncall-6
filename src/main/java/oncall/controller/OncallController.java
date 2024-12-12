package oncall.controller;

import oncall.dto.WorkDateRequest;
import oncall.view.InputView;

public class OncallController {

    public void run(){
        WorkDateRequest workDateRequest = InputView.inputWorkDate();
    }
}
