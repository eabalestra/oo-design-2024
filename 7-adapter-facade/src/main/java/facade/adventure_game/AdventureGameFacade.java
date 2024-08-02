package facade.adventure_game;

import facade.adventure_game.character.Character;
import facade.adventure_game.gem.Gem;
import facade.adventure_game.observer.Observer;

import java.util.List;

public class AdventureGameFacade {
    Character firstCharacter;
    Character secondCharacter;
    BattleArena battleArena;
    List<Observer> observers;

    public AdventureGameFacade(Character firstCharacter, String firstCharacterWeapon, List<String> firstCharacterGems,
                               Character secondCharacter,
                               String secondCharacterWeapon, List<String> secondCharacterGems, List<Observer> observers) {
        this.firstCharacter = firstCharacter;
        this.secondCharacter = secondCharacter;
        this.observers = observers;
        WeaponFactory weaponFactory = new WeaponFactory();

        firstCharacter.setWeapon(weaponFactory.createWeapon(firstCharacterWeapon));
        for (String gem : firstCharacterGems) {
            firstCharacter.setWeapon(weaponFactory.createGem(gem, firstCharacter.getWeapon()));
        }
        secondCharacter.setWeapon(weaponFactory.createWeapon(secondCharacterWeapon));
        for (String gem : secondCharacterGems) {
            secondCharacter.setWeapon(weaponFactory.createGem(gem, secondCharacter.getWeapon()));
        }

        this.battleArena = new BattleArena(firstCharacter, secondCharacter);
        for (Observer observer : observers) {
            battleArena.registerObserver(observer);
        }
    }

    public void startBattle() {
        battleArena.battle();
    }
}
