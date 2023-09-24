import java.util.Arrays;


public class BlueAstronaut extends Player implements Crewmate {
    private int numTasks;
    private int taskSpeed;

    BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed ) {
        super(name, susLevel);
        this.numTasks = numTasks;
        this.taskSpeed = taskSpeed;
    }

    BlueAstronaut(String name) {
        super(name, 15);
        this.numTasks = 6;
        this.taskSpeed = 10;
    }

    @Override
    public void emergencyMeeting() {
        if (super.isFrozen()) {
            return;
        }
        Player[] ps = Player.getPlayers();
        Arrays.sort(ps);
        for (int i = ps.length-1; i >= 0; i--) {
            if (ps[i].equals(this) || ps[i].isFrozen()) {
                continue;
            }
            if (ps[i].getSusLevel() == ps[i-1].getSusLevel()) {
                break;
            }
            ps[i].setFrozen(true);
            break;
        }
        super.gameOver();
    }

    public void completeTask() {
        if (super.isFrozen() || this.numTasks == 0) {
            return;
        }
        if (this.taskSpeed > 20) {
            this.numTasks -= 2;
        } else {
            this.numTasks -= 1;
        }
        if (this.numTasks < 0) {
            this.numTasks = 0;
        }
        if (this.numTasks == 0) {
            System.out.println("I have completed all my tasks");
            super.setSusLevel((int)(super.getSusLevel() * 0.5));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof BlueAstronaut) {
            BlueAstronaut player = (BlueAstronaut) o;
            return super.equals(o) && this.numTasks == player.numTasks && this.taskSpeed == player.taskSpeed;
        }
        return false;
    }

    @Override
    public String toString() {
        String oya = super.toString();
        String ans = oya + " I have " + this.getNumTasks() + " left over.";
        if (this.getSusLevel() > 15) {
            return ans.toUpperCase();
        }
        return ans;
    }

    public int getNumTasks() {
        return numTasks;
    }

    public int getTaskSpeed() {
        return taskSpeed;
    }
}