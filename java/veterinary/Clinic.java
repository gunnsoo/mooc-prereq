import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class Clinic {
    private File patientFile;
    private int day;

    public Clinic(File file) {
        this.patientFile = file;
    }

    public Clinic(String fileName) {
        this(new File(fileName));
    }

    public String nextDay(File f) throws FileNotFoundException {
        Scanner scanner = new Scanner(f);
        Scanner input_scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String dat = scanner.next();
            String[] datS = dat.split(",");
            System.out.println("Consultation for " + datS[0] + " the " + datS[1] + " at " + datS[3] + ".\nWhat is the health of " + datS[0] + "?\n");
            if (datS[1] != "Dog" && datS[1] != "Cat") {
                throw new InvalidPetException();
            }
            boolean ok_health = false;
            while (!ok_health) {
                try {
                    double health = input_scanner.nextDouble();
                    ok_health = true;
                } catch (exception e) {
                    ;
                } 
            }
            System.out.println("On a scale of 1 to 10, how much pain is " + datS[0] + " in right now?\n")
            boolean ok_painLevel = false;
            while (!ok_painLevel) {
                try {
                    int painLevel = input_scanner.nextInt();
                    ok_painLevel = true;
                } catch (exception e) {
                    ;
                }
            }
            
        }

        return "e";

    }

    public static void main(String[] args){
        System.out.println("Hello");

        File f = new File("Appointments.csv");
        try {
            Scanner scanner = new Scanner(f);
            while (scanner.hasNext()){
                String dat = scanner.next();
                String[] datS = dat.split(",");
                System.out.println("Consultation for " + datS[0] + " the " + datS[1] + " at " + datS[3] + ".\nWhat is the health of " + datS[0] + "?\n");
            }
        } catch (Exception e) {
            ;
        }

        // Clinic c = new Clinic("Appointments.txt");
        // try {
        //     System.out.println(c.nextDay(f));
        // } catch (Exception e) {
        //     ;
        // }
    }
}