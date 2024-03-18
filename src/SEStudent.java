import java.util.Random;

public class SEStudent extends Student {

    SEStudent(String name) {
        super(name, 8, 5, 8, 4, 10);
    }

    /**
     * Performs the groupWork attack as described in the Coursework Specification.
     * @param enemy Enemy on receiving end of attack.
     * @throws Exception If KP is insufficient.
     */
    public void groupWork(Character enemy) throws Exception {
        KPcheck();

        this.increaseEP(4);
        this.currentKP = 0;
        for(Character student : this.getTeam().getMembers()) {
            if (student.getHP() > 0) {
                enemy.decreaseHP(((100 * student.getAttack())/(100 + enemy.getDefence())));
            }
        }

        if (enemy.getHP() == 0) {
            increaseEP(4);
        }

        System.out.println("The SE student used Group Work");
    }

    /**
     * Performs the groupDiscussion ability as described in the Coursework Specification.
     * @throws Exception IF KP is insufficient.
     */
    public void groupDiscussion() throws Exception {
        KPcheck();

        for (Character student : this.getTeam().getMembers()) {
            if (student.getHP() > 0) {
                student.increaseHP(this.getDefence()/2);
            }
        }
        this.increaseEP(4);
        this.currentKP = 0;

        System.out.println("The SE student used Group Discussion");
    }

    /**
     * Randomly chooses between one of the SEStudent's special abilities.
     * 80% chance of groupWork, 20% chance of groupDiscussion.
     * @param enemy Enemy on receiving end of attack.
     * @throws Exception If KP is insufficient.
     */
    public void randomSEStudentAbility(Character enemy) throws Exception {
        Random random = new Random();
        int randomNumber = random.nextInt(10);

        if (randomNumber <= 7) {
            groupWork(enemy);
        } else {
            groupDiscussion();
        }
    }

    /**
     * Uses random special ability if KP is sufficient, otherwise picks between javaProgramming and selfStudy.
     * @param enemy
     * @throws Exception
     */
    public void strike(Character enemy) throws Exception {
        if(currentKP == maxKP) {
            randomSEStudentAbility(enemy);
        } else {
            pickJavaOrSelfStudy(enemy);
        }
    }

}