package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Player player1 = new Player(1, "Игорь", 15);
    Player player2 = new Player(2, "Матвей", 10);
    Player player3 = new Player(3, "Сергей", 10);

    @Test
    public void shouldIsRegisterPlayer1() {
        Game game = new Game();
        game.register(player2);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Игорь", "Матвей");
        });
    }

    @Test
    public void shouldIsRegisterPlayer2() {
        Game game = new Game();
        game.register(player1);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Игорь", "Матвей");
        });
    }

    @Test
    public void shouldIsStrengthPlayer1() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        int expected = 1;
        int actual = game.round("Игорь", "Матвей");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldIsStrengthPlayer2() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        int expected = 2;
        int actual = game.round("Матвей", "Игорь");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldIsStrengthEquals() {
        Game game = new Game();
        game.register(player2);
        game.register(player3);
        int expected = 0;
        int actual = game.round("Матвей", "Сергей");
        Assertions.assertEquals(expected, actual);
    }
}
