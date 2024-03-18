import java.util.Random;

public class EEEStudent extends Student {

    EEEStudent(String name) {
        super(name, 7, 8, 8, 6, 8);
    }

    /**
     * Performs the embeddedProgramming attack. Does damage to the enemy and heals himself for 5HP.
     * @param enemy Enemy on receiving end of attack.
     * @throws Exception If KP is insufficient.
     */
    public void embeddedProgramming(Character enemy) throws Exception{
        KPcheck();

        int damage = 3 * ((100 * getAttack())/(100 + enemy.getDefence()));
        enemy.decreaseHP(damage);
        abilityUsed(enemy);
        increaseHP(5);


        System.out.println("The EE student used Soldering");
    }

    /**
     * If KP is sufficient, uses special ability. Otherwise picks between javaProgramming and selfStudy.
     * @param enemy Enemy on receiving end of attack.
     * @throws Exception If KP is insufficient.
     */
    public void strike(Character enemy) throws Exception {
        if(currentKP == maxKP) {
            embeddedProgramming(enemy);
        } else {
            pickJavaOrSelfStudy(enemy);
        }
    }

}
