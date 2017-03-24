import org.junit.*;
import static org.junit.Assert.*;

public class TeamTest {

  @After
  public void tearDown() {
    Team.clearTeamArray();
  }

  @Test
  public void team_InstantiatesCorrectly_true() {
    Team testTeam = new Team("test");
    assertTrue(testTeam instanceof Team);
  }

  @Test
  public void team_SetsNameCorrectly_true() {
    Team testTeam = new Team("test");
    assertTrue(testTeam.getTeamName().equals("test"));
  }
}
