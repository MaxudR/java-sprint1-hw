import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        int command;

        while (true) { //??? как ограничить ввод пользователем String и double ???
            printMenu();
            command = scanner.nextInt();
            int step;
            int month;
            int day;

            if (command == 1) {
                System.out.println("За какой месяц текущего года вы хотите ввести количество шагов? Введите число, от 0 до 11, соответствующее месяцу года");
                month = scanner.nextInt();
                while (true) { //???типа дублирование кода и загромождение main??? Выделить в отдельные методы?
                    if (month >= 0 & month <= 11) {
                        break;
                    } else {
                        System.out.println("Пожалуста, введите число, от 0 до 11: ");
                        month = scanner.nextInt();
                    }
                }
                System.out.println("За какой день вы хотите ввести количество шагов? Введите число, от 1 до 30, соответствующее дню месяца");
                day = scanner.nextInt();
                while (true) {
                    if (day >= 1 & day <= 30) {
                        break;
                    } else {
                        System.out.println("Пожалуста, введите число, от 1 до 30: ");
                        day = scanner.nextInt();
                    }
                }
                System.out.println("Введите количество шагов");
                step = scanner.nextInt();
                while (true) {
                    if (step > 0) {
                        break;
                    } else {
                        System.out.println("Пожалуста, введите положительное целое число: ");
                        step = scanner.nextInt();
                    }
                }
                stepTracker.saveStep(month,day, step);
            } else if (command == 2) {
                System.out.println("За какой месяц текущего года вы хотите вывести статистику? Введите число, от 0 до 11, соответствующее месяцу года");
                month = scanner.nextInt();
                while (true) {
                    if (month >= 0 & month <= 11) {
                        break;
                    } else {
                        System.out.println("Пожалуста, введите число, от 0 до 11: ");
                        month = scanner.nextInt();
                    }
                }
                stepTracker.printMonthStat(month);
            } else if (command == 3) {
                System.out.println("Текущая цель по количеству шагов в день: " + stepTracker.goalStep);
                System.out.println("Введите количество шагов");
                step = scanner.nextInt();
                stepTracker.setGoalStep(step, scanner);
            } else if (command == 4) {
                System.out.println("Выход из приложения");
                break;
            } else {
                System.out.println("Извините, такой операции нет в списке.");
            }
        }
    }


    public static void printMenu() {
        System.out.println("Введите цифру для выполнения соответствующей операции");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("4 - Выйти из приложения");
    }
}


