import java.util.ArrayList;
import java.util.Scanner;

class Player{
    String name,team;
    int runs_scored, wickets;

    Player(String name,String team,int runs_scored,int wickets){
        this.name = name;
        this.runs_scored = runs_scored;
        this.wickets = wickets;
        this.team = team;
    }
}
class Team{
    int team1S, team2S;
    Team(int team1S, int team2S){
        this.team1S = team1S;
        this.team2S = team2S;
    }
}
class CricketMatch{
    String team1, team2;

    CricketMatch(String team1, String team2){
        this.team1 = team1;
        this.team2 = team2;

    }
    ArrayList<Player> team = new ArrayList<>();

    void add(Player obj){
        team.add(obj);
    }

    Team score(){
        int team1S = 0 , team2S = 0;

        for (Player play : team){
            if (play.team.equals(team1)){
                team1S += play.runs_scored;
            }
        }
//        Team 2 Score
        for (Player play : team){
            if (play.team.equals(team2)){
                team2S += play.runs_scored;
            }
        }
        return new Team(team1S , team2S);

    }
    void totalScore(){
//        Team 1 Score
        Team score = score();
        System.out.println(team1 + " Score =" + score.team1S);
        System.out.println(team2 + " Score =" + score.team2S);
    }
    void win(){
        Team score = score();
        if (score.team1S > score.team2S){
            System.out.println("Congratulation " + team1 + " You WON!!!!!!!!!!!!!!!");
        } else if (score.team1S < score.team2S) {
            System.out.println("Congratulation " + team2 + " You WON!!!!!!!!!!!!!!!");
        }else {
            System.out.println("Oh its TIE");
        }

    }
    void matchSummary(){
        Team score = score();
//        Team 1 summary
        System.out.println(team1+" Summary");
        int i=1;
        for (Player play : team){
            if (play.team.equals(team1)){
                System.out.println("Player "+i);
                i++;
                System.out.println("Player Name: "+play.name);
                System.out.println(play.name + " runs: "+play.runs_scored);
                System.out.println(play.name + " wickets: "+play.wickets);
            }
        }
        System.out.println(team1 + " Score: "+score.team1S);
//        Team 2 Summary
        System.out.println(team2+" Summary");
        int j=1;
        for (Player play : team){
            if (play.team.equals(team2)){
                System.out.println("Player "+j);
                j++;
                System.out.println("Player Name: "+play.name);
                System.out.println(play.name + " runs: "+play.runs_scored);
                System.out.println(play.name + " wickets: "+play.wickets);
            }
        }
        System.out.println(team2 + " Score: "+score.team2S);
        Scanner user = new Scanner(System.in);
        System.out.print("Enter Length: ");
        int len = user.nextInt();
        System.out.println("Enter Width: ");
        int wid = user.nextInt();
        System.out.println("Area: "+(len*wid));

        
    }

}




public class Cricket_Match_Simulator {
    public static void main(String[] args) {

        System.out.println("------CRICKET MATCH------");
        System.out.println("Enter teams name: ");
        Scanner team = new Scanner(System.in);

        System.out.print("First team name: ");
        String team1= team.next();
        System.out.print("Second team name: ");
        String team2= team.next();

        CricketMatch match = new CricketMatch(team1,team2);
        while (true){
            System.out.println("Add Players Details");
            System.out.print("Enter Team Name: ");
            Scanner user = new Scanner(System.in);
            String name = user.nextLine();
            if (name.equals(team1) || name.equals(team2)){
                System.out.print("Enter Player name:");
                String playerName = user.nextLine();
                System.out.print("Enter Runs " + playerName +": ");
                int playerRuns = user.nextInt();
                user.nextLine();
                System.out.print("Enter Wickets: ");
                int playerWicket = user.nextInt();
                Player player = new Player(playerName, name, playerRuns, playerWicket);
                match.add(player);

                System.out.print("Do you want to continue (y or n): ");
                String choice = user.next().toLowerCase();
                if (choice.equals("n")) {
                    break;
                }
            }
            else {
                System.out.println("Team not Match " +team1 +" and " +team2);

            }
        }


        while (true){
            System.out.println("What you want to do ?");
            System.out.println("Total Score of team (enter score)");
            System.out.println("See who win (enter win)");
            System.out.println("Match Summary (enter summary)");
            System.out.println("If not then enter (n)");
            System.out.print("Enter: ");
            Scanner user = new Scanner(System.in);
            String choice = user.nextLine().toLowerCase();
            if (choice.equals("n")){
                break;
            }else {
                switch (choice) {
                    case "score":
                        match.totalScore();
                        break;
                    case "win":
                        match.win();
                        break;
                    case "summary":
                        match.matchSummary();
                        break;
                    default:
                        System.out.println("Invalid Command");
                }
                System.out.print("Do you want to continue (y or n): ");
                String breakChoice = user.next().toLowerCase();
                if (breakChoice.equals("n")) {
                    break;
                }
            }
        }
    }
}