package facade.adventure_game;

import facade.adventure_game.character.Character;
import facade.adventure_game.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class BattleArena implements Subject {
    Character attacker;
    Character defender;
    List<Observer> observers;

    public BattleArena(Character firstCharacter, Character secondCharacter) {
        this.attacker = firstCharacter;
        this.defender = secondCharacter;
        observers = new ArrayList<>();
    }

    public void battle() {
        if (charactersAreAlive()) {
            while (charactersAreAlive()) {
                fight();
                notifyObservers();
            }
        } else {
            throw new IllegalStateException("One of the characters is dead. Battle cannot be started.");
        }
    }

    private void fight() {
        try {
            attacker.attack(defender);
            defender.attack(attacker);
            Character temp = attacker;
            attacker = defender;
            defender = temp;
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean charactersAreAlive() {
        return attacker.isAlive() && defender.isAlive();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(attacker, defender);
        }
    }
}
