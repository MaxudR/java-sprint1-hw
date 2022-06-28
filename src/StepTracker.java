public class StepTracker {
    int countGoalStep = 10000;
    CountStepPerDay[] months;

    StepTracker() {
        months = new CountStepPerDay[12];
        for (int i = 0; i < months.length; i++) {
            months[i] = new CountStepPerDay();
        }
    }

    class CountStepPerDay {
        int[] countSteps = new int[30];
    }

    void saveCountStep (int month, int day, int countStep) {
        months[month].countSteps[day - 1] = months[month].countSteps[day - 1] + countStep;
    }

    void monthStat (int month) {
        System.out.println("Количество пройденных шагов по дням:");
        for (int i = 0; i < months[month].countSteps.length; i++) {
            System.out.print((i + 1) + " день: " + months[month].countSteps[i] + ", ");
            if (i == months[month].countSteps.length - 2) {
                System.out.print((i + 2) + " день: " + months[month].countSteps[months[month].countSteps.length - 1]);
            }
        }

    }

}
