public class Pond {
    public static void main(String[] args) {
        Frog f1 = new Frog("Peepo");
        Frog f2 = new Frog("Pepe", 10, 15);
        Frog f3 = new Frog("Peepaw", 4.6, 5.0);
        Frog f4 = new Frog("ore");

        Fly fl1 = new Fly(1,3);
        Fly fl2 = new Fly(6);
        Fly fl3 = new Fly();

        Frog.setSpecies("1331 Frogs");
        System.out.println(f1.toString());
        f1.eat(fl2);
        System.out.println(fl2.toString());
        f1.grow(8);
        f1.eat(fl2);
        System.out.println(fl2.toString());
        System.out.println(f1.toString());
        System.out.println(f4.toString());
        f3.grow(4);
        System.out.println(f3.toString());
        System.out.println(f2.toString());
    }
}