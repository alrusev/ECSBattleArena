import java.util.Random;

public class AIStudent extends Student {

    AIStudent(String name) {
        super(name, 6, 7, 7, 5, 3);
    }

    /**
     * Performs the machineLearning attack as described in the Coursework Specification.
     * @param enemy Enemy on receiving end of attack.
     * @throws Exception If KP is insufficient.
     */
    public void machineLearning(Character enemy) throws Exception{
        KPcheck();

        int damage = 2 * ((100 * getAttack())/(100 + enemy.getDefence()));
        enemy.decreaseHP(damage);
        abilityUsed(enemy);

        System.out.println("The AI student used Machine Learning");
    }

    /**
     * Performs the naturalLanguageProcessing ability as described in the Coursework Specification.
     * @throws Exception If KP is insufficient.
     */
    public void naturalLanguageProcessing() throws Exception{
        KPcheck();

        increaseHP(getDefence());
        this.increaseEP(4);
        this.currentKP = 0;

        System.out.println("The AI student used Natural Language Processing");
    }

    /**
     * Randomly chooses between one of the AIStudent's special abilities.
     * 80% chance of machineLearning, 20% chance of naturalLanguageProcessing.
     * @param enemy Enemy on receiving end of attack.
     * @throws Exception If KP is insufficient.
     */
    public void randomAIStudentAbility(Character enemy) throws Exception {
        Random random = new Random();
        int randomNumber = random.nextInt(10);

        if (randomNumber <= 7) {
            machineLearning(enemy);
        } else {
            naturalLanguageProcessing();
        }
    }

    /**
     * Uses random special ability if KP is sufficient, otherwise picks between javaProgramming and selfStudy.
     * @param enemy Enemy on receiving end of attack.
     * @throws Exception If KP is insufficient.
     */
    public void strike(Character enemy) throws Exception {
        if(currentKP == maxKP) {
            randomAIStudentAbility(enemy);
        } else {
            pickJavaOrSelfStudy(enemy);
        }
    }



}