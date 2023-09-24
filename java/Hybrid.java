public class Hybrid extends Automobile {
    private String alternativeFuel;
    public Hybrid(String make, String model, String alternativeFuel) {
        super(make, model);
        this.alternativeFuel = alternativeFuel;
    }

    public Hybrid(String make, String model) {
        this(make, model, "hydrogen");
    }
    public String toString() {
        //override
        return super.toString() + " Fuel Type: " + this.alternativeFuel;
    }
}