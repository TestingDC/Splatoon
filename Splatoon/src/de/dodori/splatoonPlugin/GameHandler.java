package de.dodori.splatoonPlugin;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class GameHandler implements Listener {

        ArrayList<PlayerGameData> teamOne = new ArrayList<PlayerGameData>();
        ArrayList<PlayerGameData> teamTwo = new ArrayList<PlayerGameData>();
        int teamLimit = 2;

    public void joinGame(Player player) {
        if (Math.random() > 0.5) {
            PlayerGameData tempPlayerData = new PlayerGameData(player, true);
            if (teamTwo.size() < teamLimit)
                teamOne.add(tempPlayerData);
        } else {
            PlayerGameData tempPlayerData = new PlayerGameData(player, false);
            if (teamTwo.size() < teamLimit)
                teamTwo.add(tempPlayerData);
        }
    }
}

class PlayerGameData {
    Player player;
    int blocksInked;
    // int deaths;
    // int kills;
    boolean isTeamOne;

    public PlayerGameData(Player player, boolean isTeamOne) {
        this.player = player;
        this.isTeamOne = isTeamOne;
    }
}