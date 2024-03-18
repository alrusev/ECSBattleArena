import java.util.Random;

/**
 * The MonsterTeam class allows a team of monsters to perform a move.
 */
public class MonsterTeam extends Team {

    public MonsterTeam(String name) {
        super(name);
    }

    /**
     * Allows the monsters (Boss or Minion) perform a move.
     * @param Monster Monster performing the move.
     * @param StudentsTeam StudentTeam on the receiving end of the move.
     */
    public void move(Character Monster, Team StudentsTeam) {
        Random random = new Random();
//      Picks random student to be attacked.
        int randomNumber = random.nextInt(StudentsTeam.getMembers().length);
        Character enemy = StudentsTeam.getMembers()[randomNumber];

//      Checks type of monster and allows them to attack.
        if(Monster instanceof Boss) {
            ((Boss)Monster).strike(enemy);
        } else if(Monster instanceof Minion) {
            ((Minion)Monster).strike(enemy);
        }
    }
}