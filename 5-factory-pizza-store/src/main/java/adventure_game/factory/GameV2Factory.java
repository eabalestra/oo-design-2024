package adventure_game.factory;

import adventure_game.character.Character;
import adventure_game.character.*;
import adventure_game.weapon.*;
import adventure_game.gem.*;

public class GameV2Factory implements GameFactory {
    @Override
    public Character createCharacter(String type) {
        return switch (type) {
            case "Knight" -> new Knight();
            case "Archer" -> new Archer();
            case "Thief" -> new Thief();
            case "Monk" -> new Monk();
            case "Wizard" -> new Wizard();
            case "Fairy" -> new Fairy();
            case "Dwarf" -> new Dwarf();
            default -> throw new IllegalArgumentException("Invalid character type: " + type);
        };
    }

    @Override
    public Weapon createWeapon(String type) {
        return switch (type) {
            case "Bow" -> new Bow();
            case "Knife" -> new Knife();
            case "Sword" -> new Sword();
            case "FistPunch" -> new FistPunch();
            case "Sceptre" -> new Sceptre();
            default -> throw new IllegalArgumentException("Invalid weapon type: " + type);
        };
    }

    @Override
    public Weapon addGem(Weapon weapon, String type) {
        return switch (type) {
            case "Diamond" -> new DiamondGem(weapon);
            case "Basic" -> new BasicGem(weapon);
            case "Lethal" -> new LethalGem(weapon);
            case "Pro" -> new ProGem(weapon);
            case "Infinity" -> new InfinityGem(weapon);
            default -> throw new IllegalArgumentException("Invalid gem type: " + type);
        };
    }
}
