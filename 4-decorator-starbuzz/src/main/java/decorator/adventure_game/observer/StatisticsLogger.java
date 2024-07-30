package decorator.adventure_game.observer;

import decorator.adventure_game.character.Character;

import java.util.HashMap;
import java.util.Map;

public class StatisticsLogger implements Observer, Logger {
    private final Map<String, Integer> statistics = new HashMap<>();

    @Override
    public void update(Character attacker, Character defender) {
        if (defender.getHealth() <= 0) {
            String key = attacker.getClass().getSimpleName() + " with " + attacker.getWeapon().getClass().getSimpleName();
            statistics.put(key, statistics.getOrDefault(key, 0) + 1);
        }
        log("");
    }

    @Override
    public void log(String message) {
        System.out.println("Battle Statistics:");
        for (Map.Entry<String, Integer> entry : statistics.entrySet()) {
            System.out.println(entry.getKey() + " has " + entry.getValue() + " victories.");
        }
    }
}