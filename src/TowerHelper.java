import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * TowerHelper is a helper class for TowerOfMonsters. It helps with reading the .txt file which contains all the information for the monsters.
 */

public class TowerHelper {

    BufferedReader reader;
    int numberOfLines = 0;

    /**
     * Reads .txt file containing the information for the monsters.
     * @param fileName .txt file containing the information for the monsters.
     */
    public TowerHelper(String fileName) {
        try {
            this.reader = new BufferedReader(new FileReader(fileName));
//            Initializes BufferedReader.
        } catch (IOException e) {
            System.err.println("Error: could not find file");
        }
    }

    /**
     * Gets the current line from the .txt file containing the monsters' information and returns it as a String.
     * @return The current line from the .txt file as a String.
     */
    public String getLine() {
        String currentLine;
        try {
            if ((currentLine = reader.readLine()) != null) {
                return currentLine;
//                Checks if current line is null and returns it otherwise.
            }
        } catch (IOException e) {
            return "Error: current line is null";
        }

        return "";
    }

    /**
     * Checks if the .txt file is ready to read.
     * @return Boolean determining whether the file is ready to read or not.
     */
    public boolean fileIsReady() {
        try {
            return reader.ready();
        } catch (Exception IOException) {
            return false;
        }

    }

    /**
     * Creates a team of monsters using the provided .txt file. Store each line of monsters from the .txt as a new team.
     * @return List of teams.
     */
    public ArrayList<Team> createTeamFromTxt() {
        ArrayList<Team> listOfTeams = new ArrayList<>();

        while(fileIsReady()) {
//            Loops through the .txt file.
            MonsterTeam team = new MonsterTeam("Monsters");
            numberOfLines++;

            String currentLine = getLine();
            String[] monsters = currentLine.split(";");
//            Splits the current line into separate monsters.

            for (String monster : monsters) {
                String monsterName = monster.split("\\(")[0];
//                Gets the monster's name.
                String monsterType = monster.split("\\(")[1].split(",")[0];
//                Gets the monster's type (Minion or boss) by splitting the text at the correct points.
                int monsterLevel = Integer.parseInt(monster.split(",")[1].split("\\)")[0]);
//                Gets the monster's level by splitting the text at the correct points.

                if (monsterType.equals("Boss")) {
                    Boss boss = new Boss(monsterName);
//                    Checks if the monster's a boss. If yes - creates a boss with the parameters it read from the .txt file and adds it to the team.

                    if(boss.getLevel() != monsterLevel) {
                        for (int lvl = 1; lvl <= monsterLevel; lvl++) {
                            boss.increaseEP(boss.getTargetEP());
                        }
                    }

                    team.addMember(boss);
                } else if (monsterType.equals("Minion")) {
                    Minion minion = new Minion(monsterName);
//                    Checks if the monster is a minion. If yes - creates a minion with the parameters it read from the .txt file and adds it to the team.

                    if(minion.getLevel() != monsterLevel) {
                        for (int lvl = 1; lvl <= monsterLevel; lvl++) {
                            minion.increaseEP(minion.getTargetEP());
                        }
                    }

                    team.addMember(minion);
                }
            }
//  Adds all monster teams to the list of teams.
            listOfTeams.add(team);
        }

        return listOfTeams;
    }

    /**
     * Gets the number of lines in the .txt file
     * @return Number of lines in .txt file as int
     */
    public int getNumberOfLines() {
        return numberOfLines;
    }

}
