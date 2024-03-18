import java.lang.Math;

/**
 * Character class helps create a character. Contains Getters for all their attributes.
 */
public class Character {
    private final String name;
    private final int baseHP;
    private final int baseAtk;
    private final int baseDef;
    private final int baseSpd;
    private int level = 1;
    private Team charTeam;
    private int currentHP;
    boolean isAlive = true;

    Character(String name, int baseHP, int baseAtk, int baseDef, int baseSpd) {
        this.name = name;
        this.baseHP = baseHP;
        this.baseAtk = baseAtk;
        this.baseDef = baseDef;
        this.baseSpd = baseSpd;
        this.currentHP = baseHP;
    }

    public String getName() {
        return name;
    }

//  getMaxHP, getAttack, getDefence, getSpeed and getTargetEP are all created following the Coursework Specification.

    public int getMaxHP() {
        return (int) Math.round(baseHP * (Math.pow(level, 1.2)));
    }

    public int getAttack() {
        return (int) Math.round(baseAtk * (Math.pow(level, 1.2)));
    }

    public int getDefence() {
        return (int) Math.round(baseDef * (Math.pow(level, 1.2)));
    }

    public int getSpeed() {
        return (int) Math.round(baseSpd * (Math.pow(level, 1.2)));
    }

    public int getTargetEP() {
        return (int) Math.round(10 * (Math.pow(level, 1.5)));
    }

//

    public int getLevel() {
        return level;
    }

    int currentEP = 0;

    public int getHP() {
        return currentHP;
    }

    public int getEP() {
        return currentEP;
    }

    public void death() {
        isAlive = false;
    }

    public void increaseHP(int amount) {
        currentHP = currentHP + amount;
        if (currentHP >= getMaxHP()) {
            currentHP = getMaxHP();
        }
    }

    public void decreaseHP(int amount) {
        currentHP = currentHP - amount;
        if (currentHP <= 0) {
            currentHP = 0;
            death();
        }
    }

    /**
     *  Increases EP and levels the character up if they reach their target EP.
     */

    public void increaseEP(int amount) {
        currentEP = currentEP + amount;
        if (currentEP >= getTargetEP()) {
            this.level++;
            currentEP = 0;
            currentHP = getMaxHP();
        }
    }

    public void setTeam(Team team) {
        this.charTeam = team;
    }

    public Team getTeam() {
        return charTeam;
    }

}