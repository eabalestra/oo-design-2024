package facade.adventure_game;

import facade.adventure_game.character.*;
import facade.adventure_game.character.Character;
import facade.adventure_game.observer.ConsoleLogger;

import java.util.List;

public class AdventureGameFacadeMain {
    public static void main(String[] args) {
        Character firstCharacter = new Knight();
        Character secondCharacter = new Archer();
        String firstCharacterWeapon = "Sword";
        String secondCharacterWeapon = "Bow";
        List<String> firstCharacterGems = List.of("Diamond");
        List<String> secondCharacterGems = List.of("Pro");

        AdventureGameFacade adventureGameFacade = new AdventureGameFacade(firstCharacter, firstCharacterWeapon, firstCharacterGems,
                secondCharacter, secondCharacterWeapon, secondCharacterGems, List.of(new ConsoleLogger()));

        adventureGameFacade.startBattle();
    }
}
