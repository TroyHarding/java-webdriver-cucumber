package support;

import java.util.Scanner;

public class JavaAdvanced {
    public static void main(String[] args) {
        Object[] dataArray = {123, "abc", true, 3.14, 'X'};
        printLines(dataArray);
        printArrays();
    }

    public static void printLines(Object[] objects) {
        for (int i = 0; i < objects.length; i++) {
            Object element = objects[i];
            System.out.println(element);
        }
    }

    public static void printArrays() {
        String[] name = new String[5];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter a name: ");
            name[i] = scanner.nextLine();}

        System.out.println("The names you entered are: " + name[0]+", "+ name[1]+", "+ name[2]+", "+name[3]+", "+name[4] );

        int[] id = new int[5];
        Scanner sc = new Scanner(System.in);
        for (int k = 0; k < 5; k++) {
            System.out.println("Enter an ID: ");
            id[k] = sc.nextInt();
        }
        System.out.println("The IDs you entered are: " + id[0] +", "+ id[1]+", "+ id[2]+", "+ id[3]+", "+ id[4]);

        boolean[] status = new boolean[5];
        Scanner sc1 = new Scanner(System.in);
        for (int s = 0; s < 5; s++) {
            System.out.println("Enter the status: true or false?  ");
            status[s] = sc1.nextBoolean();
        }
        System.out.println("The statuses you entered are: " + status[0]+", "+ status[1] +", "+ status[2]+", "+ status[3]+", "+ status[4]);
    }
}
