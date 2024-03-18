import java.util.*;

/**
 * Class Battle allows the Students to fight the Monsters.
 */
public class Battle {

    Team team1;
    Team team2;
    int rounds = 1;
    int studentsDead = 0;
    int monstersDead = 0;
    String studentStatus = "Alive";

    public Battle(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    /**
     * Allows the students to fight the monsters. Sorts teams so the fastest members attack first.
     * @return Winning team.
     * @throws Exception
     */
    public Team fight() throws Exception {
//      Combines the two teams into one.
        Character[] teamsCombinedArray = new Character[team1.getMembers().length + team2.getMembers().length];

        for (int i = 0; i < team1.getMembers().length; i++) {
            teamsCombinedArray[i] = team1.getMembers()[i];
        }

        for (int i = 0; i < team2.getMembers().length; i++) {
            teamsCombinedArray[team1.getMembers().length + i] = team2.getMembers()[i];
        }

//      Converts array containing both teams into ArrayList.
        List<Character> teamsCombined = Arrays.asList(teamsCombinedArray);
//      Sorts the members of the ArrayList by Speed and reverses it so the fastest are first.
        teamsCombined.sort(Comparator.comparingInt(Character::getSpeed));
        Collections.reverse(teamsCombined);

//      Contains the code for each round.
        while (rounds < 31) {
//          Sorts members by speed at the start of each round.
            teamsCombined.sort(Comparator.comparingInt(Character::getSpeed));
            Collections.reverse(teamsCombined);

//          Checks if character is dead. If he's a student, increases count of dead students. If he's
//          a monsters, increases count of dead monsters.
            for (Character character : teamsCombined) {
                if (character.getHP() == 0) {
                    studentStatus = "Dead";
                    if (character.getTeam() == team1) {
                        studentsDead++;
                    } else if (character.getTeam() == team2) {
                        monstersDead++;
                    }
                }

//              Prevents dead characters from attacking.
                if (character.getHP() == 0) {
                    break;
                } else {
                    studentStatus = "Alive";
//                  Allows alive characters to attack each other.
                    if (character.getTeam() == team1) {
                        team1.move(character, team2);
                    } else if (character.getTeam() == team2) {
                        team2.move(character, team1);
                    }
                }

//              Prints students' stats.
                System.out.println("\n" + "Name:" + character.getName() + "\n" + " - Level:" + character.getLevel() + "\n" + " - HP:" + character.getHP() + "/" + character.getMaxHP() + "\n" + " - Status:" + studentStatus + "\n");

                rounds++;
            }

//          Checks which team won and returns winning team.
            if (monstersDead == 5) {
                return team1;
            } else if (studentsDead == 5) {
                return team2;
            }
        }

        return null;

    }

}
