import java.util.Random;

public class Minion extends Character implements Monster {

    public Minion(String name) {
        super(name, 5, 5, 5, 5);
    }

    /**
     * Performs the SyntaxError attack as described in the Coursework Specification.
     * @param enemy Enemy on the receiving end of the attack.
     */
    public void SyntaxError(Character enemy) {
        int damage = 100 * this.getAttack()/(100 + this.getDefence());
        enemy.decreaseHP(damage);

        System.out.println("The Minion used Syntax Error");
    }

    /**
     * Performs the NullPointerException ability as described in the Coursework Specification.
     */
    public void NullPointerException() {
        this.increaseHP(this.getDefence());

        System.out.println("The Minion used Null Pointer Exception");
    }

    /**
     * Performs the ArrayIndexOutOfBoundException attack as described in the Coursework Specification.
     * @param enemy Enemy on the receiving end of attack.
     */
    public void ArrayIndexOutOfBoundException(Character enemy) {
        int damage = 2 * this.getAttack();
        enemy.decreaseHP(damage);

        System.out.println("The Minion used Array Index Out Of Bound Exception");
    }

    /**
     * Picks random attack for the Minion to use based on the percentages given in the Coursework Specification.
     * @param enemy Enemy on receiving end of attack.
     */
    public void strike(Character enemy) {
        Random random = new Random();
        int randomNumber = random.nextInt(100);

        if (randomNumber <= 74) {
            SyntaxError(enemy);
            abilityUsedMonster(enemy);
        } else if (randomNumber <= 89) {
            NullPointerException();
            abilityUsedMonster(enemy);
        } else {
            ArrayIndexOutOfBoundException(enemy);
            abilityUsedMonster(enemy);
        }
    }

    /**
     * Increases EP of the monster and enemy. If the enemy is a student, their KP is increased by 3.
     * For each enemy killed, the monster gains an additional 4 EPs.
     *
     * @param enemy
     */
    public void abilityUsedMonster(Character enemy) {
        this.increaseEP(3);
        enemy.increaseEP(3);
        if (enemy instanceof Student) {
            ((Student)enemy).increaseKP(3);
        }
        if (enemy.getHP() == 0) {
            increaseEP(4);
        }
    }

}
