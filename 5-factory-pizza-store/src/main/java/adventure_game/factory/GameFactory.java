package adventure_game.factory;

import adventure_game.character.Character;
import adventure_game.weapon.Weapon;

public interface GameFactory {
    Character createCharacter(String type);
    Weapon createWeapon(String type);
    Weapon addGem(Weapon weapon, String type);
}
