package support;

public class House {
    public int squareFootage;
    public int price;

    public House(int squareFootage, int price) {
        this.price = price;
        this.squareFootage = squareFootage;
    }

    public int appreciation(int percent) {
        String mult = "0";
        if (percent < 10) {
             mult = "1.0" + percent;
        } else if (percent > 10 && percent < 100) {
             mult = "1." + percent;
        } else {
            System.out.println("Did your house really double in price?");
            mult = String.valueOf(percent);
        }
        double m = Double.parseDouble(mult);
        double pr = (int) price * m ;
        price = (int) pr;
        return price;
    }




}
