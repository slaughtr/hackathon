import java.util.ArrayList;
import java.util.List;

public class Member {
  private String mName;
  private static ArrayList<Member> memberArray = new ArrayList<Member>();
  private int mId;

  public Member(String name) {
    mName = name;
    memberArray.add(this);
  }

  public String getMemberName() {
    return mName;
  }


  public static void clearMemberArray() {
    memberArray.clear();
  }

  public static List<Member> getAllMembers() {
    return memberArray;
  }

}
