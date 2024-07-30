package adventure_game;

import adventure_game.character.Character;
import adventure_game.factory.GameFactory;
import adventure_game.weapon.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GameControllerTest {
    GameFactory factory;
    GameController gameController;
    Character character;
    Weapon weapon;

    @BeforeEach
    void setUp() {
        factory = mock(GameFactory.class);
        gameController = new GameController(factory);
        character = mock(Character.class);
        weapon = mock(Weapon.class);
    }

    @Test
    void createCharacter_ShouldAddCharacterToList_WhenValidInputs() {
        when(factory.createCharacter("Knight")).thenReturn(character);
        when(factory.createWeapon("Sword")).thenReturn(weapon);
        when(factory.addGem(weapon, "Diamond")).thenReturn(weapon);

        gameController.createCharacter("Knight", "Sword", List.of("Diamond"));

        assertEquals(character, gameController.getCharacter(0));
    }

    @Test
    void createCharacter_ShouldThrowException_WhenInvalidCharacterType() {
        when(factory.createCharacter("InvalidType")).thenThrow(IllegalArgumentException.class);

        assertThrows(IllegalArgumentException.class, () -> gameController.createCharacter("InvalidType", "Sword", List.of("Diamond")));
    }

    @Test
    void createCharacter_ShouldThrowException_WhenInvalidWeaponType() {
        when(factory.createCharacter("Knight")).thenReturn(character);
        when(factory.createWeapon("InvalidType")).thenThrow(IllegalArgumentException.class);

        assertThrows(IllegalArgumentException.class, () -> gameController.createCharacter("Knight", "InvalidType", List.of("Diamond")));
    }

    @Test
    void startBattle_ShouldThrowException_WhenNotEnoughCharacters() {
        assertThrows(IllegalStateException.class, () -> gameController.startBattle(0, 1));
    }
}