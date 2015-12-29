import java.util.ArrayList;

/**
 * Created by bresya on 19.12.2015.
 */
public class Team {
    private final int MAX_PLAYER_COUNT = 33;
    private final int MAX_GOALKEEPER_COUNT = 3;

    private int totalPlayerCount;

    public Team() {
    }

    public ArrayList<Player> getGoalkeepers() {
        return goalkeepers;
    }

    public Player returnFirstPlayer(){
        if (getGoalkeepers().size()>0){
            return getGoalkeepers().get(0);
        }
        else if (getDefenders().size()>0){
            return getDefenders().get(0);
        }
        else if (getMidfielders().size()>0){
            return getMidfielders().get(0);
        }
        else if (getStrikers().size()>0){
            return getStrikers().get(0);
        }
        return null;
    }

    public ArrayList<Player> getDefenders() {
        return defenders;
    }

    public ArrayList<Player> getMidfielders() {
        return midfielders;
    }

    public ArrayList<Player> getStrikers() {
        return strikers;
    }

    private ArrayList<Player> goalkeepers = new ArrayList<Player>(0);
    private ArrayList<Player> defenders = new ArrayList<Player>(0);
    private ArrayList<Player> midfielders = new ArrayList<Player>(0);
    private ArrayList<Player> strikers = new ArrayList<Player>(0);

    void addPlayer(Player player){
            if (totalPlayerCount < MAX_PLAYER_COUNT) {
                switch (player.getRole()) {
                case GK:
                    if (goalkeepers.size() < MAX_GOALKEEPER_COUNT)
                        goalkeepers.add(player);
                    totalPlayerCount++;
                    break;
                    case CB:
                    case RB:
                    case LB:
                        defenders.add(player);
                    totalPlayerCount++;
                    break;
                    case CM:
                    case CAM:
                    case RM:
                    case LM:
                        midfielders.add(player);
                    totalPlayerCount++;
                    break;
                    case ST:
                    case RW:
                    case LW:
                        strikers.add(player);
                    totalPlayerCount++;
                    break;
            }
        }
        player.setInMain(false);
    }

    void deletePlayer(Player player){
        if(!player.isInMain()) {
            switch (player.getRole()) {
                case GK:
                    goalkeepers.remove(player);
                    totalPlayerCount--;
                    break;
                case CB:
                case RB:
                case LB:
                    defenders.remove(player);
                    totalPlayerCount--;
                    break;
                case CM:
                case CAM:
                case RM:
                case LM:
                    midfielders.remove(player);
                    totalPlayerCount--;
                    break;
                case ST:
                case RW:
                case LW:
                    strikers.remove(player);
                    totalPlayerCount--;
                    break;
            }
        }
    }
}
