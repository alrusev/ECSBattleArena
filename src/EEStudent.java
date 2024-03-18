import java.util.Random;

public class EEStudent extends Student {

    EEStudent(String name) {
        super(name, 9, 6, 6, 5, 7);
    }

    /**
     * Performs the soldering attack. Does triple damage to the enemy.
     * @param enemy Enemy on receiving end of attack.
     * @throws Exception If KP is insufficient.
     */
    public void soldering(Character enemy) throws Exception{
        KPcheck();

        int damage = 3 * ((100 * getAttack())/(100 + enemy.getDefence()));
        enemy.decreaseHP(damage);
        abilityUsed(enemy);

        System.out.println("The EE student used Soldering");
    }

    /**
     * If KP is sufficient, uses special ability. Otherwise picks between javaProgramming and selfStudy.
     * @param enemy Enemy on receiving end of attack.
     * @throws Exception If KP is insufficient.
     */
    public void strike(Character enemy) throws Exception {
        if(currentKP == maxKP) {
            soldering(enemy);
        } else {
            pickJavaOrSelfStudy(enemy);
        }
    }

}
