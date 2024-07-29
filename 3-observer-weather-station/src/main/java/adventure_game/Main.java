package adventure_game;

import adventure_game.character.Archer;
import adventure_game.character.Character;
import adventure_game.character.Knight;
import adventure_game.observer.ConsoleLogger;
import adventure_game.observer.FileLogger;
import adventure_game.observer.StatisticsLogger;
import adventure_game.weapon.Sword;

public class Main {
    public static void main(String[] args) {
        Character firstCharacter = new Knight();
        Character secondCharacter = new Archer();
        firstCharacter.setWeapon(new Sword());

        BattleArena battleArena = new BattleArena(firstCharacter, secondCharacter);
        battleArena.registerObserver(new ConsoleLogger());
        battleArena.registerObserver(new FileLogger("battle_log.txt"));
        battleArena.registerObserver(new StatisticsLogger());

        battleArena.battle();
    }
}
