package adventure_game.factory;

import adventure_game.character.Character;
import adventure_game.weapon.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameFactoryTest {
    Character character;
    GameFactory factory;
    Weapon weapon;

    @BeforeEach
    void setUp() {
        factory = new GameV2Factory();
    }

    @Test
    void createCharacter_ShouldReturnCharacter_WhenTypeIsValid() {
        character = factory.createCharacter("Knight");

        assertEquals("Knight", character.getClass().getSimpleName());
    }

    @Test
    void createCharacter_ShouldThrowException_WhenTypeIsInvalid() {
        assertThrows(IllegalArgumentException.class, () -> factory.createCharacter("InvalidType"));
    }

    @Test
    void createWeapon_ShouldReturnWeapon_WhenTypeIsValid() {
        weapon = factory.createWeapon("Bow");

        assertEquals("Bow", weapon.getClass().getSimpleName());
    }

    @Test
    void createWeapon_ShouldThrowException_WhenTypeIsInvalid() {
        assertThrows(IllegalArgumentException.class, () -> factory.createWeapon("InvalidType"));
    }

    @Test
    void addGem_ShouldReturnWeaponWithGem_WhenTypeIsValid() {
        weapon = factory.createWeapon("Sword");

        Weapon gemmedWeapon = factory.addGem(weapon, "Diamond");

        assertEquals("DiamondGem", gemmedWeapon.getClass().getSimpleName());
    }

    @Test
    void addGem_ShouldThrowException_WhenTypeIsInvalid() {
        weapon = factory.createWeapon("Sword");

        assertThrows(IllegalArgumentException.class, () -> factory.addGem(weapon, "InvalidType"));
    }
}