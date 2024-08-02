package facade;

import facade.adventure_game.AdventureGameFacade;
import facade.adventure_game.character.Archer;
import facade.adventure_game.character.Character;
import facade.adventure_game.character.Knight;
import facade.adventure_game.observer.MockOutput;
import facade.adventure_game.observer.Observer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AdventureGameFacadeTest {
    private AdventureGameFacade adventureGameFacade;
    private Character firstCharacter;
    private Character secondCharacter;

    @BeforeEach
    public void setup() {
        firstCharacter = new Knight();
        secondCharacter = new Archer();
        List<Observer> observers = List.of(new MockOutput());

        String firstCharacterWeapon = "Sword";
        String secondCharacterWeapon = "Bow";
        List<String> firstCharacterGems = List.of("Diamond");
        List<String> secondCharacterGems = List.of("Pro");

        adventureGameFacade = new AdventureGameFacade(firstCharacter, firstCharacterWeapon,firstCharacterGems,
                secondCharacter, secondCharacterWeapon, secondCharacterGems, observers);
    }

    @Test
    public void testStartBattle() {
        adventureGameFacade.startBattle();
        assertTrue(firstCharacter.isAlive() ^ secondCharacter.isAlive());
    }

}