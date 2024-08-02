package adventure_game;

import adventure_game.character.*;
import adventure_game.character.Character;
import adventure_game.weapon.Knife;
import adventure_game.weapon.Sceptre;

public class AdventureGameLauncher {
    public static void main(String[] args) {
        Character knight = new Knight();
        Character archer = new Archer();
        BattleArena battleArena = new BattleArena(knight, archer);
        battleArena.battle();

        Character thief = new Thief();
        Character wizard = new Wizard();
        thief.setWeapon(new Knife());
        wizard.setWeapon(new Sceptre());
        BattleArena battleArena2 = new BattleArena(thief, wizard);
        battleArena2.battle();
    }
}
