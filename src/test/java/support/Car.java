package support;

public class Car {
    private int fuelLevel;
    private int distance;

    public Car() {
        this.fuelLevel = 100;
        this.distance = 0;
    }

    public void drive(int miles) {
        System.out.println("Car is driving " + miles +" miles");
        distance = distance + miles;
        fuelLevel = fuelLevel -10;
        System.out.println("Current distance:" + getDistance());
    }

    public void fuelUp() {
        System.out.println("Car is being fueled up!");
        fuelLevel = 100;
        System.out.println();

    }

    public int getFuel() {
        return fuelLevel;
    }
    public int getDistance() {
        return distance;
    }


}
//
//public class Car2 {
//    public int fuelLevel;
//    public int mileage;
//    public Car2(int fuelLevel, int mileage) {
//        this.fuelLevel = fuelLevel;
//        this.mileage = mileage;
//    }
//    public int drive(int miles) {
//        if (fuelLevel == 0) {
//            System.out.println(" No gas in tank. You can not drive.");
//            mileage += 0;
//        }
//        else if (miles <= 0) {
//            System.out.println(" Miles can not be negative or 0. Your car's fuel level is unchanged.");
//            mileage += 0;
//        }
//        else if (miles >= fuelLevel * 30) {
//            System.out.println("Not enough fuel in your tank. Now you are stuck with empty tank.");
//            mileage += fuelLevel *30;
//        }
//        else {
//            System.out.println("Ok");
//            mileage += miles;
//        }
//        return mileage;
//    }
//    public int fuelDown(int gals) {
//        if (gals >= fuelLevel) {
//            fuelLevel = 0;
//        } else if(gals <0 ){
//            fuelLevel += 0;
//        }
//        else {
//            fuelLevel -= gals;
//        }
//        return fuelLevel;
//    }
//    public int fuelUp(int gallons) {
//        if (gallons <= 0) {
//            System.out.println("Number can not be 0 or negative. ");
//            fuelLevel += 0;
//        }
//        else if (gallons >= 20-fuelLevel) {
//            System.out.println(" Your car's fuel tank size is only 20 gallons.");
//            fuelLevel = 20;
//        } else {
//            System.out.println("Ok");
//            fuelLevel += gallons;
//        }
//        return fuelLevel;
//    }
//}