package support;

public class JavaPractice {
    public static void main(String[] args) {
        System.out.println("Hello World");
        printString();
        printInt();
        printBoolean();
        sumWords();
        mathOperators();
        comparisonOperators();
        multiCompparison();
    }

    public static void printString(){
        System.out.println("Like and Subscribe!");
    }

    public static void printInt(){
        System.out.println(247);
    }
    public static void printBoolean(){
        System.out.println(true);
    }

    public static void sumWords(){
        System.out.println("I am " + "Batman!");
    }

    public static void mathOperators(){
        System.out.println(2+2);
        System.out.println(4-2);
        System.out.println(2*2);
        System.out.println(4/2);
    }

    public static void comparisonOperators(){
        System.out.println(2 == 2);
        System.out.println(2 != 2);
        System.out.println(2 > 2);
        System.out.println(2 < 2);
        System.out.println(2 >= 2);
        System.out.println(2 <= 2);
    }
    public static void multiCompparison(){
        System.out.println(2 == 2 && 2 != 3);
        System.out.println(2 == 2 || 2 != 3);
    }
}
