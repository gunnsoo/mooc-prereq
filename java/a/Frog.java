public class Frog {
    static private String species = "Rare Pepe";

    private String name;
    private int age;
    private double tongueSpeed;
    private boolean isFroglet;

    Frog (String name, int age, double tongueSpeed) {
        this.name = name;
        this.age = age;
        this.tongueSpeed = tongueSpeed;

        if (this.age > 1 && this.age < 7) {
            this.isFroglet = true;
        } else {
            this.isFroglet = false;
        }
    }

    Frog (String name, double ageInYears, double tongueSpeed) {
        this(name, (int)(ageInYears * 12), tongueSpeed);
    }

    Frog (String name) {
        this(name, 5, 5.0);
    }

    public void grow(int nm) {
        for (int i = 0; i < nm; i++) {
            if (this.age < 12) {
                this.tongueSpeed += 1;
            }
            if (this.age >= 30 && this.tongueSpeed >= 6) {
                this.tongueSpeed -= 1;
            }
            this.age += 1;
        }
        if (this.age > 1 && this.age < 7) {
            this.isFroglet = true;
        } else {
            this.isFroglet = false;
        }
    }

    public void grow() {
        grow(1);
    }

    public void eat(Fly f) {
        if (f.isDead()) {
            return;
        }
        if (this.tongueSpeed > f.getSpeed()) {
            if (f.getMass() >= this.age * 0.5) {
                grow();
            }
            f.setMass(0);
        }
    }
    
    public String toString() {
        if (isFroglet) {
            return "My name is " + name + " and I'm a rare froglet! I'm " + age + " months old and my tongue has a speed of " + String.format("%.2f", tongueSpeed) + ".";
        }
        return "My name is " + name + " and I'm a rare frog. I'm " + age + " months old and my tongue has a speed of " + String.format("%.2f", tongueSpeed) + ".";
    }

    public static String getSpecies () {
        return Frog.species;
    }

    public static void setSpecies (String s) {
        Frog.species = s;
    }
}