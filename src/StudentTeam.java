import javax.swing.text.html.CSS;
import java.util.Random;

/**
 * The StudentTeam class allows a team of students to perform a move.
 */
public class StudentTeam extends Team {

    public StudentTeam(String name) {
        super(name);
    }

    /**
     * Allows students to perform a move, be it a passive one like healing or
     * an aggressive one like attacking the enemies.
     * @param Student Team member who will be performing a move.
     * @param MonstersTeam Team which will be on the receiving end of the move.
     * @throws Exception
     */
    public void move(Character Student, Team MonstersTeam) throws Exception {
        Random random = new Random();
//      Picks random member of enemy team to be attacked.
        int randomNumber = random.nextInt(MonstersTeam.getMembers().length);
//      Picks random member of friendly team to take part in a certain special ability which requires 2 students.
        int randomFriend = random.nextInt(Student.getTeam().getMembers().length);
        Character enemy = MonstersTeam.getMembers()[randomNumber];
        Character friend = Student.getTeam().getMembers()[randomFriend];

//      Checks what type of student is performing the move and uses the adequate strike() method.
        if(Student instanceof AIStudent) {
            ((AIStudent)Student).strike(enemy);
        } else if(Student instanceof CSStudent) {
            ((CSStudent)Student).strike(friend, enemy);
        } else if(Student instanceof CyberStudent) {
            ((CyberStudent)Student).strike(enemy, MonstersTeam);
        } else if(Student instanceof SEStudent) {
            ((SEStudent)Student).strike(enemy);
        }

    }

}