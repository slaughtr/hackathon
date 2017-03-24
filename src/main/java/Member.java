import java.util.ArrayList;
import java.util.List;

public class Member {
  private String mName;
  private static ArrayList<Member> memberArray = new ArrayList<Member>();
  private int mId;
  private ArrayList<String> memberSkills;

  public Member(String name) {
    mName = name;
    memberArray.add(this);
    mId = memberArray.size();
    memberSkills = new ArrayList<String>();
  }

  public String getMemberName() {
    return mName;
  }

  public int getMemberId() {
    return mId;
  }

  public ArrayList<String> getMemberSkills() {
    return memberSkills;
  }

  public void setMemberSkills(String skills) {
    String[] splitSkills = skills.split(",");
    for (String skill : splitSkills) {
      memberSkills.add(skill);
    }
  }

  public static void clearMemberArray() {
    memberArray.clear();
  }

  public static List<Member> getAllMembers() {
    return memberArray;
  }

  public static Member findMemberIndex(int idNum) {
    return memberArray.get(idNum - 1);
  }
}
