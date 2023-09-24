public class Cat extends Pet{
    private int miceCaught;

    public Cat(String name, double health, int painLevel, int miceCaught) {
        super(name, health, painLevel);
        if (miceCaught < 0) {
            this.miceCaught = 0;
        } else {
            this.miceCaught = miceCaught;
        }
    }

    public Cat(String name, double health, int painLevel) {
        super(name, health, painLevel);
        this.miceCaught = 0;
    }

    public double getMiceCaught() {
        return this.miceCaught;
    }

    public int treat() {
        super.heal();

        int hl = (int)Math.ceil(this.health);

        if (this.miceCaught < 4) {
            return (this.painLevel*2) / hl;
        } else if (this.miceCaught >= 4 && this.miceCaught <= 7) {
            return this.painLevel / hl;
        } else {
            return this.painLevel / (hl*2);
        }
    }

    public void speak() {
        super.speak();
        String meow_st = "";
        for (int i = 0; i < this.miceCaught; i++) {
            meow_st += "meow ";
        }
        meow_st = meow_st.trim();
        if (this.miceCaught > 5) {
            System.out.println(meow_st.toUpperCase());
        } else {
            System.out.println(meow_st);
        }
    }

    public boolean equals(Object o) {
        Cat another_d = (Cat)o;
        boolean one_cond = super.equals(o);
        return one_cond && this.miceCaught == another_d.miceCaught;
    }
}