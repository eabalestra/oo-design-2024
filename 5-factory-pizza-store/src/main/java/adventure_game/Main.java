package adventure_game;

import adventure_game.character.Character;
import adventure_game.character.Knight;
import adventure_game.character.Archer;
import adventure_game.observer.ConsoleLogger;
import adventure_game.observer.FileLogger;
import adventure_game.observer.StatisticsLogger;

public class Main {
    public static void main(String[] args) {
        WeaponFactory weaponFactory = new WeaponFactory();

        Character firstCharacter = new Knight();
        Character secondCharacter = new Archer();

//        firstCharacter.setWeapon(weaponFactory.createWeapon("Sword"));
//        firstCharacter.setWeapon(weaponFactory.createGem("Diamond", firstCharacter.getWeapon()));

        BattleArena battleArena = new BattleArena(firstCharacter, secondCharacter);
        battleArena.registerObserver(new ConsoleLogger());
        battleArena.registerObserver(new FileLogger("battle_log.txt"));
        battleArena.registerObserver(new StatisticsLogger());

        battleArena.battle();
    }
}
