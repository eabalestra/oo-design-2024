package adventure_game;

import adventure_game.character.Character;
import adventure_game.weapon.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BattleArenaTest {
    private Character character;
    private Character opponent;
    private Weapon mockWeapon;
    private BattleArena arena;

    @BeforeEach
    void setUp() {
        mockWeapon = mock(Weapon.class);
        character = new Character(mockWeapon) {};
        opponent = new Character() {};
        arena = new BattleArena(character, opponent);
    }

    @Test
    public void battleEndsWhenOneCharacterDies() {
        when(mockWeapon.useWeapon()).thenReturn(100);

        arena.battle();

        assertTrue(character.isAlive());
        assertFalse(opponent.isAlive());
    }

    @Test
    public void battleAlternatesTurnCorrectly() {
        when(mockWeapon.useWeapon()).thenReturn(25);

        arena.battle();

        verify(mockWeapon, times(4)).useWeapon();
    }

    @Test
    public void battleDoesNotProceedIfBothCharactersAreDead() {
        when(mockWeapon.useWeapon()).thenReturn(100);

        opponent.receiveDamage(100);
        character.receiveDamage(100);

        assertThrows(IllegalStateException.class, () -> arena.battle());
    }

}