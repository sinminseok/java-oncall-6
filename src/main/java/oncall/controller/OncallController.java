package oncall.controller;

import oncall.domain.*;
import oncall.dto.WorkDateRequest;
import oncall.view.InputView;
import oncall.view.OutputView;



public class OncallController {

    public void run() {
        WorkDateRequest workDateRequest = InputView.inputWorkDate();
        UserGroup weekUsers = UserGroup.from(InputView.inputWeekdaysUser());
        UserGroup holidayUsers = UserGroup.from(InputView.inputHolidayUSer());
        OncallManager oncallManager = new OncallManager(weekUsers, holidayUsers, workDateRequest.month(), DayOfWeek.valueOfCommand(workDateRequest.dayOfWeek()), 1);
        int maxDay = workDateRequest.month() == 2 ? 28 : 31;

        WorkSchedule workSchedule = new WorkSchedule();
        for (int i = 1; i <= maxDay; i++) {
            UserSchedule userSchedule = oncallManager.assignUser();
            if (workSchedule.isSequenceUser(userSchedule)) {
                //연속 두번 처리
                workSchedule.addUserSchedule(oncallManager.assignSequenceUser(userSchedule));
                oncallManager.setNextDay();
                continue;
            }
            workSchedule.addUserSchedule(userSchedule);
            oncallManager.setNextDay();
        }

        OutputView.printSchedule(workSchedule.getSchedules());

    }
}
