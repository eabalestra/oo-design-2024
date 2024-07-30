package decorator.adventure_game;

import decorator.adventure_game.character.Character;
import decorator.adventure_game.character.Knight;
import decorator.adventure_game.character.Archer;
import decorator.adventure_game.observer.ConsoleLogger;
import decorator.adventure_game.observer.FileLogger;
import decorator.adventure_game.observer.StatisticsLogger;

public class Main {
    public static void main(String[] args) {
        WeaponFactory weaponFactory = new WeaponFactory();

        Character firstCharacter = new Knight();
        Character secondCharacter = new Archer();

        firstCharacter.setWeapon(weaponFactory.createWeapon("Sword"));
        firstCharacter.setWeapon(weaponFactory.createGem("Diamond", firstCharacter.getWeapon()));

        BattleArena battleArena = new BattleArena(firstCharacter, secondCharacter);
        battleArena.registerObserver(new ConsoleLogger());
        battleArena.registerObserver(new FileLogger("battle_log.txt"));
        battleArena.registerObserver(new StatisticsLogger());

        battleArena.battle();
    }
}
