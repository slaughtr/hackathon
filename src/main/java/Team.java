import java.util.List;
import java.util.ArrayList;

public class Team {
  private String mName;
  private static ArrayList<Team> teamsArray = new ArrayList<Team>();
  private int mId;

  public Team(String name) {
    mName = name;
    teamsArray.add(this);
    mId = teamsArray.size();
  }

  public String getTeamName() {
    return mName;
  }

  public int getTeamId() {
    return mId;
  }










  public static void clearTeamArray() {
    teamsArray.clear();
  }

  public static List<Team> getAllTeams() {
    return teamsArray;
  }

}
