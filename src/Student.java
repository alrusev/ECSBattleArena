import java.util.Random;

public class Student extends Character {

    int maxKP;
    int currentKP;

    /**
     * Constructor for the students.
     * @param name Name of the student.
     * @param baseHP Base HP of the student.
     * @param baseAtk Base Attack of the student.
     * @param baseDef Base Defence of the student.
     * @param baseSpd Base Speed of the student.
     * @param maxKP KP required before student can perform special ability.
     */
    Student(String name, int baseHP, int baseAtk, int baseDef, int baseSpd, int maxKP) {
        super(name, baseHP, baseAtk, baseDef, baseSpd);
        this.maxKP = maxKP;
        currentKP = 0;
    }

    public void increaseKP(int amount) {
        currentKP = currentKP + amount;

        if (currentKP >= maxKP) {
            currentKP = maxKP;
        }
    }

    /**
     * Performs the javaProgramming attack as described in the Coursework Specification.
     * @param enemy Enemy which is being attacked.
     */
    public void javaProgramming(Character enemy) {
        increaseEP(3);
        increaseKP(1);
        int damage = ((100 * getAttack())/(100 + enemy.getDefence()));
        enemy.decreaseHP(damage);
        enemy.increaseEP(2);
        if (enemy instanceof Student) {
            ((Student)enemy).increaseKP(3);
        }
        if (enemy.getHP() == 0) {
            increaseEP(4);
        }

        System.out.println("The student used Java Programming");
    }

    /**
     * Performs the selfStudy ability as described in the Coursework Specification.
     */
    public void selfStudy() {
        increaseHP(2);
        increaseEP(6);
        increaseKP(2);

        System.out.println("The student used Self Study");
    }

    /**
     * Increases EP, resets KP and gives an extra 4EP if enemy is dead
     * after student performs special ability.
     * @param enemy Enemy which the special ability is being used on.
     */
    public void abilityUsed(Character enemy) {
        this.increaseEP(4);
        this.currentKP = 0;
        if (enemy.getHP() == 0) {
            increaseEP(4);
        }
    }

    /**
     * Checks is student has sufficient KP to perform special ability.
     * @throws Exception If student has insufficient KP.
     */
    public void KPcheck() throws Exception {
        if (this.currentKP != this.maxKP) {
            throw new Exception("Insufficient KP");
        }
    }

    /**
     * Randomly picks which ability the student will use if they don't have enough KP for a special ability.
     * Has 66% chance of javaProgramming, 33% chance of selfStudy.
     * @param enemy Enemy which javaProgramming might be used on.
     */
    public void pickJavaOrSelfStudy(Character enemy) {
        Random random = new Random();
        int randomNumber = random.nextInt(10);

        if (randomNumber <= 6) {
            javaProgramming(enemy);
        } else {
            selfStudy();
        }
    }

}