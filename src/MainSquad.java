import java.util.ArrayList;

/**
 * Created by bresya on 19.12.2015.
 */
public class MainSquad {
    private Formation formation;
    private Player goalkeeper;
    private Team team;

    private ArrayList<Player> defenders = new ArrayList<Player>();
    private ArrayList<Player> midfielders = new ArrayList<Player>();
    private ArrayList<Player> strikers = new ArrayList<Player>();

    MainSquad(){

    }

    public MainSquad(Team team) {
        this.team = team;
    }

    public Player getGoalkeeper() {
        return goalkeeper;
    }

    public void setGoalkeeper(Player goalkeeper) {
        this.goalkeeper = goalkeeper;
    }

    public ArrayList<Player> getDefenders() {
        return defenders;
    }

    public void setDefenders(ArrayList<Player> defenders) {
        this.defenders = defenders;
    }

    public ArrayList<Player> getMidfielders() {
        return midfielders;
    }

    public void setMidfielders(ArrayList<Player> midfielders) {
        this.midfielders = midfielders;
    }

    public ArrayList<Player> getStrikers() {
        return strikers;
    }

    public void setStrikers(ArrayList<Player> strikers) {
        this.strikers = strikers;
    }


    void addPlayer(Player player){
        switch (player.getRole()){
            case GK:
                    goalkeeper=player;
                break;
            case CB:
            case RB:
            case LB:
                if (defenders.size()<10)//formation.getDefenders())
                    defenders.add(player);
                break;
            case CM:
            case CAM:
            case RM:
            case LM:
                if (midfielders.size()<10)//formation.getMidfielders())
                    midfielders.add(player);
                break;
            case ST:
            case RW:
            case LW:
                if (strikers.size()<10/*formation.getStrikers()*/)
                    strikers.add(player);
                break;
        }
        team.deletePlayer(player);
        player.setInMain(true);
    }

    void deletePlayer(Player player){
        team.addPlayer(player);
        switch (player.getRole()){
            case GK:
                    goalkeeper=null;
                break;
            case CB:
            case RB:
            case LB:
                defenders.remove(player);
                break;
            case CM:
            case CAM:
            case RM:
            case LM:
                midfielders.remove(player);
                break;
            case ST:
            case RW:
            case LW:
                strikers.remove(player);
                break;
        }

    }


    void setFormation(int d, int m, int s){
        formation = new Formation(d, m, s);
    }
}
