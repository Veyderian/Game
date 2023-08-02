import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test //тест 1 второй сильнее
    public void shouldTheStrongestPlayer2() {
        Player ivan = new Player(1, "Иван", 156);
        Player roman = new Player(2, "Роман", 204);

        Game game = new Game();

        game.register(ivan);
        game.register(roman);

        int actual = game.round("Иван", "Роман");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test //тест 2 первый сильнее
    public void shouldTheStrongestPlayer1() {
        Player ivan = new Player(1, "Иван", 666);
        Player roman = new Player(2, "Роман", 13);

        Game game = new Game();

        game.register(ivan);
        game.register(roman);

        int actual = game.round("Иван", "Роман");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test //тест 3  игроки равны
    public void shouldWhenPlayersEqual() {
        Player ivan = new Player(1, "Иван", 290);
        Player roman = new Player(2, "Роман", 290);

        Game game = new Game();

        game.register(ivan);
        game.register(roman);

        int actual = game.round("Иван", "Роман");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test  // тест 4 игрок 1 незарегистрирован
    public void shouldWhenPlayer1NotRegistered() {
        Player ivan = new Player(1, "Иван", 156);
        Player roman = new Player(2, "Роман", 204);

        Game game = new Game();

        game.register(roman);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Иван", "Роман"));
    }

    @Test  // тест 5 игрок 2 незарегистрирован
    public void shouldWhenPlayer2NotRegistered() {
        Player ivan = new Player(1, "Иван", 156);
        Player roman = new Player(2, "Роман", 204);

        Game game = new Game();

        game.register(ivan);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Иван", "Роман"));
    }

    @Test  // тест 6 игроки  незарегистрированы
    public void shouldWhenPlayersNotRegistered() {
        Player ivan = new Player(1, "Иван", 156);
        Player roman = new Player(2, "Роман", 204);

        Game game = new Game();

        game.register(ivan);
        game.register(roman);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Пётр", "Фёдор"));
    }

}


