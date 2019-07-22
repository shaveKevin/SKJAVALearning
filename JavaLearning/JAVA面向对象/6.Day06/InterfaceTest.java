public interface Sports {
// 注意接口只负责声明不负责实现
  public void setHomeTeam(String name);
  public void setVisitingTeam(String name);
}
public interface Football extends Sports {
  public void homeTeamSports(int points);
  public void visitingTeamScored(int points);
  public void endOfQuarter(int quarter);
}