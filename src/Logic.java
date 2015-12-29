import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by bresya on 19.12.2015.
 */
public class Logic {
    private Team team = new Team();
    private MainSquad squad = new MainSquad(team);
    private final int[] empty = {0,0,0,0,0,0};
    private Player player = new Player(" ", 0, false, Role.GK, empty);
    private final PlayersView playersView;
    private final ProfileView profileView;
    private final Main main;
   // ArrayList<Player> players = new ArrayList<Player>();
    void setPlayer(Player player1) {
        this.player = player1;
    }

    public Player getPlayer() {
        return player;
    }

    void refresh(){

        playersView.refresh();
        main.refresh();
    }

    void refreshProfile(){
        profileView.refresh();
    }

    public MainSquad getSquad() {
        return squad;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void setSquad(MainSquad squad) {
        this.squad = squad;
    }

    public void readPlayersFromFile(){
        Scanner in;
        try {
            in = new Scanner(new FileReader("players.txt"));
            String[] strings;
            while (in.hasNextLine()){
                strings = in.nextLine().split("_");
                int[] stats = {
                        Integer.parseInt(strings[4]),
                        Integer.parseInt(strings[5]),
                        Integer.parseInt(strings[6]),
                        Integer.parseInt(strings[7]),
                        Integer.parseInt(strings[8]),
                        Integer.parseInt(strings[9]) };
                Player player = new Player(strings[0], Integer.parseInt(strings[1]), Boolean.parseBoolean(strings[2]), Role.valueOf(strings[3]), stats);
                if (player.isInMain()){
                    squad.addPlayer(player);
                }
                else team.addPlayer(player);
            }
            /*FileInputStream in = new FileInputStream("players.txt");
            ObjectInputStream inputStream = new ObjectInputStream(in);
            Player player;
            try {
                while ((player = (Player)inputStream.readObject())!=null)
                team.addPlayer(player);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }*/
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

     ArrayList<Player> merge(){
        ArrayList<Player> players = new ArrayList<Player>();
         if (squad.getGoalkeeper()!=null)
        players.add(squad.getGoalkeeper());
        players.addAll(squad.getDefenders());
        players.addAll(squad.getMidfielders());
        players.addAll(squad.getStrikers());
        players.addAll(team.getGoalkeepers());
        players.addAll(team.getDefenders());
        players.addAll(team.getMidfielders());
        players.addAll(team.getStrikers());
        return players;
    }

    public void addPlayersToFile(){

        ArrayList<Player> players = merge();
        FileWriter out;
        try {
            out = new FileWriter("players.txt");
            for (Player p: players){
                String stats = "";
                for (int i = 0; i < p.getStats().length; i++) {
                    stats+=Integer.toString(p.getStats()[i]) + "_";
                }
                String player = p.getName() + "_" + Integer.toString(p.getAge()) + "_" + Boolean.toString(p.isInMain()) + "_" + p.getRole() + "_" + stats + "\n";
                out.write(player);
                out.flush();
            }
            out.close();


            /*FileOutputStream out = new FileOutputStream(new File("players.txt"));
            ObjectOutputStream outputStream = new ObjectOutputStream(out);
            outputStream.writeObject(player);
            outputStream.flush();
            outputStream.close();
            String stats = "";
            for (int i = 0; i < this.getStats().length; i++) {
                stats+=Integer.toString(this.getStats()[i]) + " ";
            }
            String player = this.getName() + " " + Integer.toString(this.getAge()) + " " + Boolean.toString(this.isInMain()) + " " + this.getRole() + " " + stats + "\n";
            out.write(player.getBytes());*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Logic() {

        readPlayersFromFile();
        playersView = new PlayersView(this);
        profileView = new ProfileView(this);
        main = new Main(this);

    }

    public PlayersView getPlayersView() {
        return playersView;
    }

    public ProfileView getProfileView() {
        return profileView;
    }

    public static void main(String[] args) {

        Logic logic = new Logic();
        System.out.println("OK");

    }
}
