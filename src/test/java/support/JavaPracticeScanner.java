package support;


import java.util.Scanner;

public class JavaPracticeScanner {
    public static void main(String[] args) {
        System.out.println("Hello World");
        printString();
        printInt();
        printBoolean();
        sumWords();
        mathOperators();
        comparisionOperators();
    }

    public static void printString(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your string:");
        String string = scanner.nextLine();

        System.out.println(string);
    }

    public static void printInt(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your int:");
        int num = scanner.nextInt();

        System.out.println(num);
    }
    public static void printBoolean(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your boolean:");
        boolean statement = scanner.nextBoolean();

        System.out.println(statement);
    }

    public static void sumWords(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your first string:");
        String string1 = scanner.nextLine();

        System.out.println("Enter your second string:");
        String string2 = scanner.nextLine();

        System.out.println(string1 + string2);
    }

    public static void mathOperators(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an operator (+, -, *, /): ");
        String operator = scanner.nextLine();

        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();
        int result = 0;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                System.out.println("Invalid operator.");
                break;
        }
        System.out.println(result);
    }

    public static void comparisionOperators(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a comparison operator: ");
        String operator = scanner.nextLine();

        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();

        boolean result = false;
        switch (operator) {
            case "==":
                result = num1 == num2;
                break;
            case "!=":
                result = num1 != num2;
                break;
            case "<":
                result = num1 < num2;
                break;
            case ">":
                result = num1 > num2;
                break;
            case "<=":
                result = num1 <= num2;
                break;
            case ">=":
                result = num1 >= num2;
                break;
            default:
                System.out.println("Invalid comparison operator.");
                break;
        }
        System.out.println(result);
    }
}
