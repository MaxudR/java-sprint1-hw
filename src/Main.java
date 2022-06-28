import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StepTracker stepTracker = new StepTracker();
        System.out.println("-------");
        System.out.println(stepTracker.months[1].countSteps[1]);
        System.out.println("-------");

        // создать объекты

        while (true) {
            printMenu();
            int command = scanner.nextInt();

            if (command == 1) {
                System.out.println("За какой месяц текущего года вы хотите ввести количество шагов? Введите число, от 0 до 11, соответствующее месяцу года");
                int month = scanner.nextInt();
                System.out.println("За какой день вы хотите ввести количество шагов? Введите число, от 1 до 30, соответствующее дню месяца");
                int day = scanner.nextInt();
                System.out.println("Введите количество шагов");
                int countStep = scanner.nextInt();
                stepTracker.saveCountStep(month,day,countStep);
            } else if (command == 2) {
                System.out.println("За какой месяц текущего года вы хотите вывести статистику? Введите число, от 0 до 11, соответствующее месяцу года");
                int month = scanner.nextInt();
                stepTracker.monthStat(month);
            } else if (command == 3) {
                System.out.println("Введите количество шагов");
                stepTracker.countGoalStep = scanner.nextInt();
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


