import java.util.List;
import java.util.ArrayList;

public class Team {
  private String mName;
  private static ArrayList<Team> teamsArray = new ArrayList<Team>();
  private int mId;
  private ArrayList<Member> mMembers;

  public Team(String name) {
    mName = name;
    teamsArray.add(this);
    mId = teamsArray.size();
    mMembers = new ArrayList<Member>();
  }

  public String getTeamName() {
    return mName;
  }

  public int getTeamId() {
    return mId;
  }

  public ArrayList<Member> getMembersOfTeam() {
    return mMembers;
  }

  public void addMemberToTeam(Member member) {
    mMembers.add(member);
  }

  public static void clearTeamArray() {
    teamsArray.clear();
  }

  public static List<Team> getAllTeams() {
    return teamsArray;
  }

  public static Team findTeamIndex(int idNum) {
    return teamsArray.get(idNum - 1);
  }

}
