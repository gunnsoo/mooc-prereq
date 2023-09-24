public class Fly {
    private double mass;
    private double speed;

    Fly (double mass, double speed) {
        this.mass = mass;
        this.speed = speed;
    }

    Fly (double mass) {
        this(mass, 10);
    }

    Fly () {
        this(5, 10);
    }

    public double getMass() {
        return this.mass;
    }

    public double getSpeed() {
        return this.speed;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String toString() {
        if (this.mass == 0) {
            return "I'm dead, but I used to be a fly with a speed of " + String.format("%.2f", this.speed) + ".";
        }
        return "I'm a speedy fly with " + String.format("%.2f", this.speed) + " speed and " + String.format("%.2f", this.mass) + " mass.";
    }

    public void grow(int addedMass) {
        for (int i = 0; i < addedMass; i++) {
            if (this.mass < 20) {
                this.speed += 1;
            } else {
                this.speed -= 0.5;
            }
            this.mass += 1;
        }
        // this.mass += addedMass;
        // if (this.mass < 20) {
        //     for (int i = 0; i < addedMass; i++) {
        //         if (this.mass >= 20) {
        //             break;
        //         }
        //         this.speed += 1;
        //     }
        // } else {
        //     for (int i = 0; i < this.mass - 20; i++) {
        //         this.speed -= 0.5;
        //     }
        // }        
    }

    public boolean isDead() {
        if (this.mass == 0) {
            return true;
        }
        return false;
    }
}