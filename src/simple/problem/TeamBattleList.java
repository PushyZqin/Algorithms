package simple.problem;

/**
 * 两个乒乓球队进行比赛，各出三人。甲队为a,b,c三人，乙队为x,y,z三人。已抽签决定比赛名单。
 * 有人向队员打听比赛的名单。a说他不和x比，c说他不和x,z比，请编程序找出三队赛手的名单。
 *
 * @author Pushy
 * @since 2018/12/28 12:13
 */
public class TeamBattleList {

    /**
     * 通过双循环模拟排列组合
     */
    public static void solution() {
        String[] team1 = {"a", "b", "c"};
        String[] team2 = {"x", "y ", "z"};

        for (int i = 0; i < team1.length; i++) {
            for (int j = 0; j < team2.length; j++) {
                if (team1[i].equals("c")) {
                    if (team2[j].equals("x") || team2[j].equals("z")) {
                        continue;
                    }
                    System.out.println(team1[i] + "-" + team2[j]);
                } else if (team1[i].equals("a")) {
                    if (team2[j].equals("x")) {
                        continue;
                    }
                    System.out.println(team1[i] + "-" + team2[j]);
                } else {
                    System.out.println(team1[i] + "-" + team2[j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        TeamBattleList.solution();
    }

}