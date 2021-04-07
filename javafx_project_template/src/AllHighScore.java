import java.util.ArrayList;

class AllHighScore{ 

    private AllHighScore(){};
     
    public void addPlayer(PlayerHighScore player) {
        String info = player.infromation();
        playerList.add(info);
    }

    ArrayList<String> playerList = new ArrayList<String>();

    private static AllHighScore instance = new AllHighScore();

    public static AllHighScore getInstance() {
        return instance;
    }
    public ArrayList<String> getPlayerList(){
        return playerList;
    }
}
