import java.util.ArrayList;

/**
 * TowerOfMonsters class makes a team of students fight a team of monsters until the the entire guild of students dies or all floors of the tower of monsters is complete.
 * The teams of monsters are created by reading the monster's name, type and level from a .txt file.
 */

public class TowerOfMonsters {

    protected static TowerHelper towerHelper;
    protected static Battle battle;

    public static void main(String[] args) throws Exception {
        towerHelper = new TowerHelper(args [0]);
        ArrayList<Team> towerOfMonsters = towerHelper.createTeamFromTxt();

        Guild studentGuild = new Guild();

//      Creates a Guild and 8 students which are then added to the guild

        Character student1 = new AIStudent("AI Student 1");
        Character student2 = new AIStudent("AI Student 2");
        Character student3 = new CSStudent("CS Student 1");
        Character student4 = new CSStudent("CS Student 2");
        Character student5 = new CyberStudent("Cyber Student 1");
        Character student6 = new CyberStudent("Cyber Student 2");
        Character student7 = new EEEStudent("EEE Student 1");
        Character student8 = new EEStudent("EE Student 1");

        studentGuild.addMember(student1);
        studentGuild.addMember(student2);
        studentGuild.addMember(student3);
        studentGuild.addMember(student4);
        studentGuild.addMember(student5);
        studentGuild.addMember(student6);
        studentGuild.addMember(student7);
        studentGuild.addMember(student8);

        Team studentTeam = new StudentTeam("Team of Students");
        Team monsterTeam = new MonsterTeam("Team of Monsters");

        for (int i = 0; i < towerHelper.getNumberOfLines(); i++) {
//      This is the code for each floor of the Tower of Monsters.
            try {
                Thread.sleep(500);

                studentTeam = studentGuild.getTeam();
                monsterTeam = towerOfMonsters.get(i);
                int floorNumber = i +1;

                System.out.println("the students are advancing to floor " + floorNumber);

//              Makes the student and monster team battle.
                battle = new Battle(studentTeam, monsterTeam);
                battle.fight();

//              Checks if student is dead and removes him from the Guild if he is.
                for (Character student : studentTeam.getMembers()) {
                    if (student.getHP() == 0) {
                        studentGuild.guildMembers.remove(student);
                    }
                }

//              Checks if the student team lost. If yes,it generates a new team from the remaining students in the Guild.
                if (studentTeam.members.size() < 1) {
                    studentTeam = studentGuild.getTeam();
                    battle.fight();
                }

//              Checks if the Guild is empty. If it is, it ends the game as the students have lost.
                if (studentGuild.guildMembers.size() < 1) {
                    System.out.println("The students fought as best they could, but their guild was wiped out on floor " + floorNumber);
                    System.out.println("Game Over!");
                    return;
                }
            } catch (InterruptedException e) {}
        }

    }

}
