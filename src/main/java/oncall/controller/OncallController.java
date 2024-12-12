package oncall.controller;

import oncall.domain.*;
import oncall.dto.WorkDateRequest;
import oncall.global.utils.Retry;
import oncall.view.InputView;
import oncall.view.OutputView;


public class OncallController {

    public void run() {
        OncallManager oncallManager = createOncallManager();
        WorkSchedule workSchedule = assignUsers(oncallManager);
        OutputView.printSchedule(workSchedule.getSchedules());
    }

    private OncallManager createOncallManager() {
        WorkDateRequest workDateRequest = Retry.retryOnExceptionWithResult(() -> InputView.inputWorkDate());
        UserGroup weekUsers = Retry.retryOnExceptionWithResult(() -> UserGroup.from(InputView.inputWeekdaysUser()));
        UserGroup holidayUsers = Retry.retryOnExceptionWithResult(() -> UserGroup.from(InputView.inputHolidayUSer()));
        OncallManager oncallManager = new OncallManager(weekUsers, holidayUsers, workDateRequest.month(), workDateRequest.dayOfWeek(), 1);
        return oncallManager;
    }

    private WorkSchedule assignUsers(OncallManager oncallManager) {
        WorkSchedule workSchedule = new WorkSchedule();
        for (int i = 1; i <= oncallManager.getMonthDay(); i++) {
            UserSchedule userSchedule = oncallManager.assignUser();
            if (workSchedule.isSequenceUser(userSchedule)) {
                assignSequenceUser(workSchedule, oncallManager, userSchedule);
                continue;
            }
            assignGeneralUser(workSchedule, oncallManager, userSchedule);
        }
        return workSchedule;
    }

    private void assignSequenceUser(WorkSchedule workSchedule, OncallManager oncallManager, UserSchedule userSchedule) {
        workSchedule.addUserSchedule(oncallManager.assignSequenceUser(userSchedule));
        oncallManager.setNextDay();
    }

    private void assignGeneralUser(WorkSchedule workSchedule, OncallManager oncallManager, UserSchedule userSchedule) {
        workSchedule.addUserSchedule(userSchedule);
        oncallManager.setNextDay();
    }
}
