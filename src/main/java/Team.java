import java.util.List;
import java.util.ArrayList;

public class Team {
  private String mName;
  public static ArrayList<Team> teamsArray = new ArrayList<Team>();

  public Team(String name) {
    mName = name;
  }

  public String getTeamName() {
    return mName;
  }

  public static void clearTeamArray() {
    teamsArray.clear();
  }

}
