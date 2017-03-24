import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/teams", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("teams", Team.getAllTeams());
      model.put("members", Member.getAllMembers());
      model.put("template", "templates/teams.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/teams/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/newTeamForm.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/teams", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String teamName = request.queryParams("teamName");
      Team newTeam = new Team(teamName);
      model.put("teams", Team.getAllTeams());
      model.put("template", "templates/teams.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/teams/:teamId", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Team thisTeam = Team.findTeamIndex(Integer.parseInt(request.params(":teamId")));
      model.put("team", thisTeam);
      model.put("members", thisTeam.getMembersOfTeam());
      model.put("template", "templates/team.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/teams/:teamId/members", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Team thisTeam = Team.findTeamIndex(Integer.parseInt(request.params(":teamId")));
      model.put("team", thisTeam);
      model.put("template", "templates/teamMembers.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/teams/:teamId/members/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Team thisTeam = Team.findTeamIndex(Integer.parseInt(request.params(":teamId")));
      model.put("team", thisTeam);
      model.put("template", "templates/newMemberForm.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/teams/:teamId/members", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Team thisTeam = Team.findTeamIndex(Integer.parseInt(request.params(":teamId")));
      String memberName = request.queryParams("memberName");
      String memberSkills = request.queryParams("memberSkills");
      Member newMember = new Member(memberName);
      newMember.setMemberSkills(memberSkills);
      thisTeam.addMemberToTeam(newMember);
      model.put("team", thisTeam);
      model.put("members", thisTeam.getMembersOfTeam());
      model.put("template", "templates/teamMembers.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/members/:memberId", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Member thisMember = Member.findMemberIndex(Integer.parseInt(request.params(":memberId")));
      model.put("member", thisMember);
      model.put("template", "templates/member.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/all-members", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("members", Member.getAllMembers());
      model.put("template", "templates/allMembers.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/info", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/info.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
