import java.util.Arrays;


public class RedAstronaut extends Player implements Impostor {
    private String skill;

    RedAstronaut(String name, int susLevel, String skill) {
        super(name, susLevel);
        this.skill = skill;
    }

    RedAstronaut(String name) {
        super(name, 15);
        this.skill = "experienced";
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

    public void freeze(Player p) {
        if (p instanceof Impostor || (this instanceof Impostor && super.isFrozen()) || p.isFrozen()) {
            return;
        }
        if (this.getSusLevel() < p.getSusLevel()) {
            p.setFrozen(true);
        } else {
            this.setSusLevel(this.getSusLevel() * 2);
        }
        super.gameOver();
    }

    public void sabotage(Player p) {
        if (p instanceof Impostor || (this instanceof Impostor && super.isFrozen()) || p.isFrozen()) {
            return;
        }
        if (this.getSusLevel() < 20) {
            p.setSusLevel((int)(p.getSusLevel() * 1.5));
        } else {
            p.setSusLevel((int)(p.getSusLevel() * 1.25));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof RedAstronaut) {
            RedAstronaut player = (RedAstronaut) o;
            return super.equals(o) && this.skill.equals(player.skill);
        }
        return false;
    }

    @Override
    public String toString() {
        String oya = super.toString();
        String ans = oya + " I am an " + this.getSkill() + " player!";
        if (this.getSusLevel() > 15) {
            return ans.toUpperCase();
        }
        return ans;
    }

    public String getSkill() {
        return skill;
    }
}