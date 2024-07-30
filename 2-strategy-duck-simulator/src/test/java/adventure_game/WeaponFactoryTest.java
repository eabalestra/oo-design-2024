package adventure_game;

import adventure_game.gem.DiamondGem;
import adventure_game.weapon.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WeaponFactoryTest {
    private WeaponFactory weaponFactory;

    @BeforeEach
    public void setUp() {
        weaponFactory = new WeaponFactory();
    }
    private static Stream<Object> weaponProvider() {
        return Stream.of(
                Arguments.of("Bow", new Bow()),
                Arguments.of("Knife", new Knife()),
                Arguments.of("Sword", new Sword()),
                Arguments.of("Sceptre", new Sceptre()),
                Arguments.of("FistPunch", new FistPunch())
        );
    }

    @ParameterizedTest
    @MethodSource("weaponProvider")
    public void testCreateWeapon(String weaponType, Weapon expected) {
        Weapon weapon = weaponFactory.createWeapon(weaponType);
        assertInstanceOf(expected.getClass(), weapon);
    }

    @Test
    public void testInvalidWeaponType() {
        assertThrows(IllegalArgumentException.class, () -> {
            weaponFactory.createWeapon("InvalidWeaponType");
        });

    }


}