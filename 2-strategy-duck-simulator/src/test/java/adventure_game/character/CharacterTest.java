package adventure_game.character;

import adventure_game.FightStyle;
import adventure_game.weapon.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CharacterTest {
    private Character character;
    private Character opponent;
    private Weapon mockWeapon;

    @BeforeEach
    public void setUp() {
        mockWeapon = mock(Weapon.class);
        character = new Character(mockWeapon) {};
        opponent = new Character() {};
    }

    @Test
    public void characterIsAliveInitially() {
        assertTrue(character.isAlive());
    }

    @Test
    public void characterDiesWhenHealthReachesZero() {
        character.attack(opponent);
        opponent.receiveDamage(100);

        assertFalse(opponent.isAlive());
    }

    @Test
    public void characterCannotAttackWhenDead() {
        opponent.receiveDamage(100);

        assertThrows(IllegalStateException.class, () -> opponent.attack(character));
    }

    @Test
    public void characterCannotUseWeaponWithDifferentFightStyle() {
        Weapon incompatibleWeapon = mock(Weapon.class);
        when(incompatibleWeapon.getFightStyle()).thenReturn(mock(FightStyle.class));

        assertThrows(IllegalArgumentException.class, () -> character.setWeapon(incompatibleWeapon));
    }

    @Test
    public void characterCanAttackAndDealDamage() {
        when(mockWeapon.useWeapon()).thenReturn(10);
        character.attack(opponent);

        assertEquals(90, opponent.health);
    }

    @Test
    public void characterHealthDoesNotGoBelowZero() {
        character.attack(opponent);
        opponent.receiveDamage(200);

        assertEquals(0, opponent.health);
    }
}