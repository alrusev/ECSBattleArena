import java.util.Random;

public class Boss extends Character implements Monster {

    public Boss(String name) {
        super(name, 8, 7, 8, 7);
    }

    /**
     * Performs the SyntaxError attack as described in the Coursework Specification.
     * @param enemy Enemy on receiving end of attack.
     */
    public void SyntaxError(Character enemy) {
        int damage = 100 * this.getAttack()/(100 + this.getDefence());
        enemy.decreaseHP(damage);

        System.out.println("The Boss used Syntax Error");
    }

    /**
     * Performs the NullPointerException ability as described in the Coursework Specification.
     */
    public void NullPointerException() {
        this.increaseHP(this.getDefence());

        System.out.println("The Boss used Null Pointer Exception");
    }

    /**
     * Performs the ArrayIndexOutOfBoundException attack as described in the Coursework Specification.
     * @param enemy Enemy on receiving end of attack.
     */
    public void ArrayIndexOutOfBoundException(Character enemy) {
        int damage = 2 * this.getAttack();
        enemy.decreaseHP(damage);

        System.out.println("The Boss used Array Index Out Of Bound Exception");
    }

    /**
     * Performs the NoneTermination ability as described in the Coursework Specification.
     */
    public void NoneTermination() {
        for (Character monster : this.getTeam().getMembers()) {
            if (monster.getHP() <= 0) {
                monster.increaseHP(getMaxHP());
                isAlive = true;
            }
        }

        System.out.println("The Boss used None Termination");
    }

    /**
     * Performs the ConcurrentModificationException attack as described in the Coursework Specification.
     */
    public void ConcurrentModificationException() {
        int damage = 100 * this.getAttack()/(100 + this.getDefence());

        for (Character enemy : this.getTeam().getMembers()) {
            enemy.decreaseHP(damage);
        }

        System.out.println("The Boss used Concurrent Modification Exception");
    }

    /**
     * Picks random attack for the Boss to use based on the percentages given in the Coursework Specification.
     * @param enemy Enemy on receiving end of attack.
     */
    public void strike(Character enemy) {
        Random random = new Random();
        int randomNumber = random.nextInt(100);

        if (randomNumber <= 49) {
            SyntaxError(enemy);
            abilityUsedMonster(enemy);
        } else if (randomNumber <= 64) {
            NullPointerException();
            abilityUsedMonster(enemy);
        } else if (randomNumber <= 79) {
            ArrayIndexOutOfBoundException(enemy);
            abilityUsedMonster(enemy);
        } else if (randomNumber <= 89) {
            NoneTermination();
            this.increaseEP(3);
        } else {
            ConcurrentModificationException();
            abilityUsedMonster(enemy);
        }
    }

    /**
     * Increases EP of the monster and enemy. If the enemy is a student, their KP is increased by 3.
     * For each enemy killed, the monster gains an additional 4 EPs.
     * @param enemy Enemy on receiving end of attack.
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
