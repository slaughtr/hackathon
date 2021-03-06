import org.junit.*;
import static org.junit.Assert.*;

public class TeamTest {

  @After
  public void tearDown() {
    Team.clearTeamArray();
  }

  @Test
  public void team_instantiatesCorrectly_true() {
    Team testTeam = new Team("test");
    assertTrue(testTeam instanceof Team);
  }

  @Test
  public void team_setsNameCorrectly_true() {
    Team testTeam = new Team("test");
    assertTrue(testTeam.getTeamName().equals("test"));
  }

  @Test
  public void team_addsObjectsToArrayListProperly_true() {
    Team testTeam = new Team("spider");
    Team testTeam2 = new Team("dude");
    assertTrue(Team.getAllTeams().get(0) == testTeam);
    assertTrue(Team.getAllTeams().get(1) == testTeam2);
  }

  @Test
  public void team_setsIdCorrectly_true() {
    Team testTeam = new Team("test");
    assertTrue(testTeam.getTeamId() == 1);
  }

  @Test
  public void team_setsMemberToTeamList_true() {
    Team testTeam = new Team("test");
    Member testMember = new Member("Spider Dude");
    Member failMember = new Member("Not here");
    testTeam.addMemberToTeam(testMember);
    assertTrue(testTeam.getMembersOfTeam().contains(testMember));
  }
}
