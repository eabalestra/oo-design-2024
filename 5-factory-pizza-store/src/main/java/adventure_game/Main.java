package adventure_game;

import adventure_game.factory.GameFactory;
import adventure_game.factory.GameV2Factory;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GameFactory factory = new GameV2Factory();
        GameController game = new GameController(factory);

        game.createCharacter("Wizard", "Sceptre", List.of("Diamond"));
        game.createCharacter("Knight", "Sword", List.of("Diamond"));

        game.startBattle(0,1);

        game.createCharacter("Knight", "Sword", List.of("Diamond"));

        game.startBattle(1,2);
    }
}
