public class Gameplay {
    
    public static void main(String[] args) {
        BlueAstronaut b1 = new BlueAstronaut("Bob", 20, 6, 30);
        BlueAstronaut b2 = new BlueAstronaut("Heath", 30, 3, 21);
        BlueAstronaut b3 = new BlueAstronaut("Albert", 44, 2, 0);
        BlueAstronaut b4 = new BlueAstronaut("Angel", 0, 1, 0);

        RedAstronaut r1 = new RedAstronaut("Liam", 19, "experienced");
        RedAstronaut r2 = new RedAstronaut("Suspicious Person", 100, "expert");

        r1.sabotage(b1);
        r1.freeze(r2);
        r1.freeze(b3);
        b3.emergencyMeeting();
        r2.emergencyMeeting();
        b1.emergencyMeeting();
        b2.completeTask();
        b2.completeTask();
        b2.completeTask();
        r1.freeze(b4);
        r1.sabotage(b1);
        r1.sabotage(b1);
        r1.freeze(b1);

        // b4.emergencyMeeting();
        // System.out.println(r1.toString());

        for (int i = 0; i < 5; i++) {
            r1.sabotage(b2);
            System.out.println(b2.toString());
        }
        r1.freeze(b2);
    }
}