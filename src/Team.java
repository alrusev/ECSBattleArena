import java.util.ArrayList;

/**
 * The Team class manages creating Teams and adding members into them.
 */
abstract public class Team {
    String name;
    ArrayList<Character> members;
    //  Constructor for team.
    Team(String name) {
        this.name = name;
        this.members = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    /**
     * Returns the members of a team as an array.
     * @return Array containing team members.
     */
    public Character[] getMembers() {
        return (Character[]) members.toArray(new Character[0]);
    }

    /**
     * Adds a member to the team and returns an integer depending on whether the
     * team is too big or already contains the member trying to be added.
     * @param member Member which is being added to the team.
     * @return An Integer.
     */
    public int addMember(Character member) {
        if (members.contains(member)) {
//          Checks if member is already part of team.
            return -1;
        } else if (members.size() >= 5) {
//          Checks if team is too big (has more than 5 members).
            return -2;
        } else {
//          Adds member to team if team still has space and the member isn't already part of it.
            member.setTeam(this);
            members.add(member);
            return members.size();
        }
    }

    abstract public void move(Character member, Team enemyTeam) throws Exception;

}