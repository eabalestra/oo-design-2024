package adventure_game;

import adventure_game.observer.Observer;
import adventure_game.character.Character;

import java.util.ArrayList;
import java.util.List;

public class BattleArena implements Subject {
    Character attacker;
    Character defender;
    List<Observer> observers;

    public BattleArena() {
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

    public void setCharacters(Character attacker, Character defender) {
        this.attacker = attacker;
        this.defender = defender;
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
