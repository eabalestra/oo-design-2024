package adventure_game;

import adventure_game.character.Character;
import adventure_game.factory.GameFactory;
import adventure_game.observer.ConsoleLogger;
import adventure_game.observer.FileLogger;
import adventure_game.observer.StatisticsLogger;
import adventure_game.weapon.Weapon;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private final GameFactory factory;
    private final BattleArena battleArena;
    private final List<Character> characters;

    public GameController(GameFactory factory) {
        this.factory = factory;
        characters = new ArrayList<>();
        battleArena = new BattleArena();
        addObservers();
    }

    public void createCharacter(String characterType, String weaponType, List<String> gems) {
        Character character = factory.createCharacter(characterType);
        Weapon weapon = factory.createWeapon(weaponType);

        addGemsToWeapon(gems, weapon);
        character.setWeapon(weapon);

        characters.add(character);
    }

    public void startBattle(int characterIndex1, int characterIndex2) {
        if (characters.size() < 2) {
            throw new IllegalStateException("There should be at least two characters to start the battle.");
        }
        battleArena.setCharacters(characters.get(characterIndex1), characters.get(characterIndex2));
        battleArena.battle();
    }

    private void addGemsToWeapon(List<String> gems, Weapon weapon) {
        for (String gem : gems) {
            factory.addGem(weapon, gem);
        }
    }

    private void addObservers() {
        battleArena.registerObserver(new ConsoleLogger());
        battleArena.registerObserver(new FileLogger("battle_log.txt"));
        battleArena.registerObserver(new StatisticsLogger());
    }

    protected Character getCharacter(int index) {
        return characters.get(index);
    }
}
