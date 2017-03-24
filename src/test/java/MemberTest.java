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
  public void member_addAllObjectsToArrayList_true() {
    Member testMember = new Member("Test Erson");
    Member testMember2 = new Member("Spider Dude");
    assertTrue(Member.getAllMembers().get(0) == testMember);
  }

  @Test
  public void member_eachObjectAssignedIdCorrectly_true() {
    Member testMember = new Member("Test Erson");
    assertTrue(testMember.getMemberId() == 1);
  }

  @Test
  public void member_skillsAssignedAndSplitCorrectly_true() {
    Member testMember = new Member("Spider Dude");
    testMember.setMemberSkills("jump,crawl,eat");
    assertTrue(testMember.getMemberSkills().contains("jump") && testMember.getMemberSkills().contains("crawl") && testMember.getMemberSkills().contains("eat"));
  }

}
