package support;

public class Cat {
    private String name;
    private int energy;

    public Cat(String name, String color) {
        this.name = name;
        this.energy = 100;
    }

    public void meow() {
        System.out.println(name + " says meow!");
        useEnergy(10);
    }

    public void purr() {
        System.out.println(name + " is purring...");
        useEnergy(5);
    }

    public void eat() {
        System.out.println(name + " is eating...");
        restoreEnergy(20);
    }

    public void sleep() {
        System.out.println(name + " is sleeping...");
        restoreEnergy(30);
    }

    private void useEnergy(int amount) {
        energy -= amount;
        if (energy < 0) {
            energy = 0;
            System.out.println(name + " is out of energy!");
        }
    }

    private void restoreEnergy(int amount) {
        energy += amount;
        if (energy > 100) {
            energy = 100;
        }
    }

    //Getter and Setters

    public String getName() {
        return name;
    }
    public int getEnergy() {
        return energy;
    }
}
