import java.util.Random;

public class CyberStudent extends Student {

    CyberStudent(String name) {
        super(name, 7, 7, 5, 6, 6);
    }

    /**
     * Performs the cyberAttack attack as described in the Coursework Specification.
     * @param enemyTeam Enemy team on receiving end of attack.
     * @throws Exception If KP is insufficient.
     */
    public void cyberAttack(Team enemyTeam) throws Exception {
        KPcheck();

        this.increaseEP(4);
        this.currentKP = 0;

        for(Character enemy : enemyTeam.getMembers()) {
            enemy.decreaseHP(getAttack());

            if (enemy.getHP() == 0) {
                increaseEP(4);
            }
        }

        System.out.println("The Cyber student used Cyber Attack");
    }

    /**
     * If KP is sufficient, uses special ability. Otherwise picks between javaProgramming and selfStudy.
     * @param enemy Enemy on receiving end of attack.
     * @param enemyTeam Enemy team on receiving end of attack.
     * @throws Exception If KP is insufficient.
     */
    public void strike(Character enemy, Team enemyTeam) throws Exception {
        if(currentKP == maxKP) {
            cyberAttack(enemyTeam);
        } else {
            pickJavaOrSelfStudy(enemy);
        }
    }



}