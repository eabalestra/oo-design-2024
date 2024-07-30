package decorator.adventure_game;

import decorator.adventure_game.gem.*;
import decorator.adventure_game.weapon.*;

public class WeaponFactory {
    public Weapon createWeapon(String weaponType) {
        return switch (weaponType) {
            case "Bow" -> new Bow();
            case "Knife" -> new Knife();
            case "Sword" -> new Sword();
            case "Sceptre" -> new Sceptre();
            case "FistPunch" -> new FistPunch();
            default -> throw new IllegalArgumentException("Invalid weapon type");
        };
    }

    public Weapon createGem(String gemType, Weapon weapon) {
        return switch (gemType) {
            case "Diamond" -> new DiamondGem(weapon);
            case "Basic" -> new BasicGem(weapon);
            case "Lethal" -> new LethalGem(weapon);
            case "Pro" -> new ProGem(weapon);
            default -> throw new IllegalArgumentException("Invalid gem type");
        };
    }
}
