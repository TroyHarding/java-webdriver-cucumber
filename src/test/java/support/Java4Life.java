package support;


public class Java4Life {

    public static void main(String[] args) {

        //Class Instantion
        House cozy1bd = new House(350, 750000);
        House twoBtwoB = new House(800, 1200000);

        System.out.println(twoBtwoB.appreciation(3));
        System.out.println(twoBtwoB.appreciation(34));
        System.out.println(twoBtwoB.appreciation(123));

        System.out.println(cozy1bd.price);
        System.out.println(cozy1bd.squareFootage);
        System.out.println(twoBtwoB.squareFootage);
        System.out.println(twoBtwoB.price);
        System.out.println(cozy1bd.appreciation(400));

        //While Loop
        int i = 0;
        int[] numbers = {2,5,388,79,-1,23,8};

        int ln = numbers.length;
        while (i < ln) {
            System.out.println("The numbers is " + numbers[i]);
            i++;
        }
        //FOR Loop
        for (int j =0; j < numbers.length; j++ ) {
            System.out.println("the numberzzzzzzz is " + numbers[i]);
        }

        System.out.println(numbers.length);

        // Arrays of different Data Types
        //               0,1, 2,  3, 4
        int[] numberszzzz = {2,5,388,79,-1};
        String[] names = {"Manisha", "Quang", "Snigdha" };
        boolean[] values = {true, false, false, true};
        int lns = names.length;

        System.out.println(numberszzzz[0]);
        System.out.println(numberszzzz[1]);
        System.out.println(numberszzzz[2]);
        System.out.println(numberszzzz[3]);
        System.out.println(numberszzzz[4]);
        System.out.println(numberszzzz.length);

        // Calling the if else statment
                isLarge(723133328);
    }


    public static void isLarge(int num) {

        if (num >= 5) {
            System.out.println("Wow your number is great!!!!!!!");
        } else if(num ==4) {
            System.out.println("4 is ok too i guess");
        } else {
            System.out.println("Your number suxxxx");
        }
    }
}
