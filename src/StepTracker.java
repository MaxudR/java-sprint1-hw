import java.util.Scanner;

public class StepTracker {
    int goalStep = 10000;
    StepPerDay[] months;

    static class StepPerDay {
        int[] steps = new int[30];
    }

    StepTracker() {
        months = new StepPerDay[12];
        for (int i = 0; i < months.length; i++) {
            months[i] = new StepPerDay();
        }


    }

    void saveStep(int month, int day, int step) {
        months[month].steps[day - 1] = step;
    }

    void printMonthStat(int month) {
        int sum = 0;
        Converter converter = new Converter();
        int daysGoal = 0;
        int tempDaysGoal = 0;
        int max = 0;

        System.out.println("Количество пройденных шагов по дням:");
        for (int i = 0; i < months[month].steps.length - 1; i++) {
            System.out.print((i + 1) + " день: " + months[month].steps[i] + ", ");
            if (i == months[month].steps.length - 2) {
                System.out.println((i + 2) + " день: " + months[month].steps[months[month].steps.length - 1]);
            }
        }

        for (int i = 0; i < months[month].steps.length; i++) {
            sum = sum + months[month].steps[i];
        }
        System.out.println("Общее количество шагов за месяц: " + sum);

        for (int i = 0; i < months[month].steps.length; i++) {
            if (months[month].steps[i] > max) {
                max = months[month].steps[i];
            }
        }
        System.out.println("Максимальное пройденное количество шагов в месяце: " + max);

        System.out.println("Среднее количество шагов за месяц: " + (sum / months[month].steps.length));

        System.out.println("Пройденная дистанция(в км) за месяц: " + converter.convertStepToCm(sum)); //???округлять???

        System.out.println("Количество сожжённых килокалорий за месяц: " + converter.convertStepToCal(sum));

        for (int i = 0; i < months[month].steps.length; i++) {
            if (months[month].steps[i] >= goalStep) {
                tempDaysGoal = tempDaysGoal + 1;
                if (tempDaysGoal > daysGoal) {
                    daysGoal = tempDaysGoal;
                }
            } else {
                tempDaysGoal = 0;
            }
        }
        System.out.println("Лучшая серия: " + daysGoal);
    }

    void setGoalStep(int step, Scanner scanner) {
        while (true) {
            if (step > 0) {
                goalStep = step;
                System.out.println("Обновленная цель по количеству шагов в день: " + goalStep);
                return;
            }
            System.out.println("Пожалуста, введите положительное целое число: ");
            step = scanner.nextInt();

        }

    }

}
