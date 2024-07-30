package adventure_game;

import adventure_game.weapon.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GemTest {
    private WeaponFactory weaponFactory;
    private List<String> weaponList;
    private List<String> gemList;

    @BeforeEach
    public void setUp() {
        weaponFactory = new WeaponFactory();
        weaponList = List.of("Bow", "FistPunch", "Knife", "Sword", "Sceptre");
        gemList = List.of("Basic", "Diamond", "Pro", "Lethal");
    }

    private static Stream<Object> weaponsProvider() {
        return Stream.of(
                Arguments.of("Bow", List.of("Basic", "Diamond"), 40),
                Arguments.of("FistPunch", List.of("Lethal"), 52),
                Arguments.of("Knife", List.of("Pro", "Pro", "Pro"), 70),
                Arguments.of("Sword", List.of("Basic"), 20),
                Arguments.of("Sceptre", List.of("Diamond", "Pro"), 45)
        );
    }

    @ParameterizedTest
    @MethodSource("weaponsProvider")
    public void testWeaponDamage(String weaponString, List<String> gems, Integer expectedDamage) {
        Weapon weapon = weaponFactory.createWeapon(weaponString);
        for (String gem : gems) {
            weapon = weaponFactory.createGem(gem, weapon);
        }
        assertEquals(weapon.useWeapon(), expectedDamage);
    }

    @Test
    public void testMaxGems() {
        for (String weaponString : weaponList) {
            Weapon weapon = weaponFactory.createWeapon(weaponString);
            for (int i = 0; i < weapon.maxGems(); i++) {
                int anyGem = i % gemList.size();
                weapon = weaponFactory.createGem(gemList.get(anyGem), weapon);
            }
            Weapon finalWeapon = weapon;
            assertThrows(IllegalArgumentException.class, () -> weaponFactory.createGem("Basic", finalWeapon));
        }
    }
}
