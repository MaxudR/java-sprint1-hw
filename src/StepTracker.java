import java.util.Scanner;

public class StepTracker {
    int goalStep = 10000;
    stepPerDay[] months;

    StepTracker() {
        months = new stepPerDay[12];
        for (int i = 0; i < months.length; i++) {
            months[i] = new stepPerDay();
        }

        /*
        //не забыть убрать тестовые данные
        months[0].steps[0] = 1;
        months[0].steps[1] = 10;
        months[0].steps[2] = 11;
        months[0].steps[3] = 12;
        months[0].steps[6] = 13;
        months[0].steps[5] = 14;
        months[0].steps[8] = 15;
        months[0].steps[10] = 16;
        months[0].steps[11] = 17;
        months[0].steps[12] = 18;
        months[1].steps[12] = 19;
        months[1].steps[0] = 18;
        months[1].steps[2] = 17;
        months[1].steps[5] = 16;
        months[2].steps[0] = 15;
        months[3].steps[0] = 14;
        months[4].steps[0] = 13;
        months[5].steps[0] = 12;
        months[6].steps[0] = 11;
         */
    }

    class stepPerDay { //??? тут варнинг Inner class 'stepPerDay' may be 'static', нипанятна
        int[] steps = new int[30];
    }

    void saveStep(int month, int day, int step) {
        months[month].steps[day - 1] = step;
    }

    void printMonthStat(int month) {
        int sum = 0;
        double km;
        double kcal;
        Converter converter = new Converter();
        int daysGoal = 0;
        int tempDaysGoal = 0;

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

        System.out.println("Среднее количество шагов за месяц: " + (sum / months[month].steps.length));

        km = converter.convertStepToCm(sum) * 0.00001;
        System.out.println("Пройденная дистанция(в км) за месяц: " + km); //???округлять???

        kcal = converter.convertStepToCal(sum) * 0.001;
        System.out.println("Количество сожжённых килокалорий за месяц: " + kcal);

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
            } else {
                System.out.println("Пожалуста, введите положительное целое число: ");
                step = scanner.nextInt();
            }
        }

    }

}
