package oncall.view;

import oncall.domain.UserSchedule;

import java.util.List;

public class OutputView {

    private OutputView() {
    }

    public static void printSchedule(List<UserSchedule> userScheduleList) {
        for (UserSchedule userSchedule : userScheduleList) {
            String string = userSchedule.getMonth() + "월 " + userSchedule.getDay() + "일 " + userSchedule.getDayOfWeek().getName() + " " + userSchedule.getUserName();
            System.out.println(string);
        }
    }
}
