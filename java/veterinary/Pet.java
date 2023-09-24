public abstract class Pet {
    String name;
    double health;
    int painLevel;

    public Pet(String name, double health, int painLevel) {
        this.name = name;
        if (health > 1.0) {
            this.health = 1.0;
        } else if (health < 0.0) {
            this.health = 0.0;
        }
        if (painLevel > 10) {
            this.painLevel = 10;
        } else if (painLevel < 1) {
            this.painLevel = 1;
        }
    }

    public String getName() {
        return this.name;
    }
    public double getHealth() {
        return this.health;
    }
    public int getPainLevel() {
        return this.painLevel;
    }

    public abstract int treat();

    public void speak() {
        String ans = "Hello! My name is " + this.name;
        if (this.painLevel > 5) {
            System.out.println(ans.toUpperCase());
        } else {
            System.out.println(ans);
        }
    }

    public boolean equals(Object o) {
        Pet another_p = (Pet)o;
        return this.name == another_p.name;
    }

    protected void heal() {
        this.health = 1.0;
        this.painLevel = 1;
    }
}