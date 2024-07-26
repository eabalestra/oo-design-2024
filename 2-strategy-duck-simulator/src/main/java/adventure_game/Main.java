package adventure_game;

import adventure_game.character.Archer;
import adventure_game.character.Character;
import adventure_game.character.Knight;

public class Main {
    public static void main(String[] args) {
        Character firstCharacter = new Knight();
        Character secondCharacter = new Archer();
        BattleArena battleArena = new BattleArena(firstCharacter, secondCharacter);
        battleArena.battle();
    }
}
