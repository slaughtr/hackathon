import org.junit.*;
import static org.junit.Assert.*;

public class MemberTest {

  @After
  public void tearDown() {
    Member.clearMemberArray();
  }

  @Test
  public void member_instantiatesCorrectly_true() {
    Member testMember = new Member("Test Erson");
    assertTrue(testMember instanceof Member);
  }

  @Test
  public void member_setsNameCorrectly_true() {
    Member testMember = new Member("Test Erson");
    assertTrue(testMember.getMemberName().equals("Test Erson"));
  }

  @Test
  public void member_addAllObjectsToArrayList() {
    Member testMember = new Member("Test Erson");
    Member testMember2 = new Member("Spider Dude");
    assertEquals(testMember, Member.getAllMembers().get(0));
  }

  @Test
  public void member_eachObjectAssignedIdCorrectly() {
    Member testMember = new Member("Test Erson");
    assertEquals(testMember.getMemberId(), 1);
  }

}
