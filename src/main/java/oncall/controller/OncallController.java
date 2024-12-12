package oncall.controller;

import oncall.domain.*;
import oncall.dto.WorkDateRequest;
import oncall.view.InputView;

import java.util.ArrayList;
import java.util.List;


public class OncallController {

    public void run() {
        WorkDateRequest workDateRequest = InputView.inputWorkDate();
        UserGroup weekUsers = UserGroup.from(InputView.inputWeekdaysUser());
        UserGroup holidayUsers = UserGroup.from(InputView.inputHolidayUSer());
        OncallManager oncallManager = new OncallManager(weekUsers, holidayUsers, workDateRequest.month(), DayOfWeek.valueOfCommand(workDateRequest.dayOfWeek()), 1);
        int maxDay = workDateRequest.month() == 2 ? 28 : 31;
        List<UserSchedule> userSchedules = new ArrayList<>();
        for (int i = 1; i <= maxDay; i++){
            userSchedules.add(oncallManager.assignUser());
            oncallManager.setNextDay();
        }

    }
}
