/**
 * Created by bresya on 19.12.2015.
 */
public class Formation {

    public int getDefenders() {
        return defenders;
    }

    public int getMidfielders() {
        return midfielders;
    }

    public int getStrikers() {
        return strikers;
    }

    private final int defenders;
    private final int midfielders;
    private final int strikers;

    public Formation(int d, int m, int s){
        defenders=d;
        midfielders=m;
        strikers=s;
    }


}
