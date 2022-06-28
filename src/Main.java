import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int command = scanner.nextInt();

            if (command == 1) {
                System.out.println("За какой месяц текущего года вы хотите ввести количество шагов? Введите число, от 0 до 11, соответствующее месяцу года");
                int month = scanner.nextInt();
                System.out.println("За какой день вы хотите ввести количество шагов? Введите число, от 1 до 30, соответствующее дню месяца");
                int day = scanner.nextInt();
                System.out.println("Введите количество шагов");
                double countStep = scanner.nextDouble();
            } else if (command == 2) {

            } else if (command == 3) {

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


