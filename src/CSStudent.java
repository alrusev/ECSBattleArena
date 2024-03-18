import java.util.Random;

public class CSStudent extends Student {

    CSStudent(String name) {
        super(name, 7, 6, 6, 6, 4);
    }

    /**
     * Performs the pairWorking attack as described in the Coursework Specification.
     * @param friend Friend who's helping with attack.
     * @param enemy Enemy on receiving end of attack.
     * @throws Exception If KP is insufficient.
     */
    public void pairWorking(Character friend, Character enemy) throws Exception {
        KPcheck();

        int friendDamage = ((100 * friend.getAttack())/(100 + enemy.getDefence()));
        int studentDamage = ((100 * getAttack())/(100 + enemy.getDefence()));

        enemy.decreaseHP(friendDamage + studentDamage);

        abilityUsed(enemy);

        System.out.println("The CS student used Pair Working");
    }

    /**
     * Performs the support ability as described in the Coursework Specification.
     * @param friend Friend taking part in the support ability.
     * @throws Exception If KP is insufficient.
     */
    public void support(Character friend) throws Exception {
        KPcheck();

        friend.increaseHP(getDefence());

        System.out.println("The CS student used Support");
    }

    /**
     * Randomly chooses between one of the CSStudent's special abilities.
     * 80% chance of pairWorking, 20% chance of support.
     * @param friend
     * @param enemy
     * @throws Exception
     */
    public void randomCSStudentAbility(Character friend, Character enemy) throws Exception {
        Random random = new Random();
        int randomNumber = random.nextInt(10);

        if (randomNumber <= 7) {
            pairWorking(friend, enemy);
        } else {
            support(friend);
        }
    }

    /**
     * If KP is sufficient, uses random special ability. Otherwise picks between javaProgramming and selfStudy.
     * @param friend Friend helping student.
     * @param enemy Enemy on receiving end of attack.
     * @throws Exception If KP is insufficient.
     */
    public void strike(Character friend, Character enemy) throws Exception {
        if(currentKP == maxKP) {
            randomCSStudentAbility(enemy, friend);
        } else {
            pickJavaOrSelfStudy(enemy);
        }
    }

}