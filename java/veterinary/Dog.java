public class Dog extends Pet{
    private double droolRate;

    public Dog(String name, double health, int painLevel, double droolRate) {
        super(name, health, painLevel);
        if (droolRate <= 0) {
            this.droolRate = 0.5;
        } else {
            this.droolRate = droolRate;
        }
    }

    public Dog(String name, double health, int painLevel) {
        super(name, health, painLevel);
        this.droolRate = 5.0;
    }

    public double getDroolRate() {
        return this.droolRate;
    }

    public int treat() {
        super.heal();

        int hl = (int)Math.ceil(this.health);

        if (this.droolRate < 3.5) {
            return (this.painLevel*2) / hl;
        } else if (this.droolRate >= 3.5 && this.droolRate <= 7.5) {
            return this.painLevel / hl;
        } else {
            return this.painLevel / (hl*2);
        }
    }

    public void speak() {
        super.speak();
        String bark_st = "";
        for (int i = 0; i < this.painLevel; i++) {
            bark_st += "bark ";
        }
        bark_st = bark_st.trim();
        if (this.painLevel > 5) {
            System.out.println(bark_st.toUpperCase());
        } else {
            System.out.println(bark_st);
        }
    }

    public boolean equals(Object o) {
        Dog another_d = (Dog)o;
        boolean one_cond = super.equals(o);
        return one_cond && this.droolRate == another_d.droolRate;
    }
}