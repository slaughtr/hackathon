import org.junit.*;
import static org.junit.Assert.*;

public class MemberTest {

  @After
  public void tearDown() {
    Member.clearMemberArray();
  }

  @Test
  public void member_instantiatesCorrectly_true() {
    Member testMember = new Member("test");
    assertTrue(testMember instanceof Member);
  }

  @Test
  public void member_setsNameCorrectly_true() {
    Member testMember = new Member("test");
    assertTrue(testMember.getMemberName().equals("test"));
  }

}
