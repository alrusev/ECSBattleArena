import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * The Guild class creates a guild and populates it with members.
 */
public class Guild {
    ArrayList<Character> guildMembers = new ArrayList<>();

    /**
     * Adds member to guild. If they're already a part of it, it shows a warning.
     * @param guildMember Person being added to the Guild.
     */
    public void addMember(Character guildMember) {
        if (guildMembers.contains(guildMember)) {
            System.out.println("User already part of Guild");
        } else {
            guildMembers.add(guildMember);
            System.out.println("User added to Guild");
        }
    }

    /**
     * Returns guild members as an array of characters.
     * @return Array of Characters.
     */
    public Character[] getMembers() {
        return guildMembers.toArray(new Character[0]);
    }

    /**
     * Sorts the Guild members by their level and adds in the highest level Guild members to the team.
     * @return The created team.
     */

    public Team getTeam() {
//      Sorts the guild members by their level.
        guildMembers.sort(Comparator.comparingInt(Character::getLevel));
//      Reverses sorting so the highest levels are first.
        Collections.reverse(guildMembers);
        Team createdTeam = new StudentTeam("Student team");
//      Creates team and populates it with Guild members.
        for (Character guildMember : guildMembers) {
            createdTeam.addMember(guildMember);
        }

        return createdTeam;
    }

}
