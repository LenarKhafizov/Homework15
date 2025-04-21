package ru.netology;
import java.util.HashMap;

public class Game {
    HashMap<String,Player> players = new HashMap<>();

    public void register(Player player) {
        players.put(player.getName(),player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = null;
        Player player2 = null;
        for (String key : players.keySet()) {
            if (key.equals(playerName1)) {
                player1 = players.get(playerName1);
            }
            if (key.equals(playerName2)) {
                player2 = players.get(playerName2);
            }
        }

        if (player1 == null) {
            throw new NotRegisteredException(playerName1);
        }
        if (player2 == null) {
            throw new NotRegisteredException(playerName2);
        }

        if (player1.getStrength() == player2.getStrength()) {
            return 0;
        } else {
            if (player1.getStrength() > player2.getStrength()) {
                return 1;
            } else {
                return 2;
            }
        }
    }
}
