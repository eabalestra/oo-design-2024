package decorator.adventure_game.observer;

import decorator.adventure_game.character.Character;

import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements Observer, Logger{
    String message;
    String filePath;

    public FileLogger(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void update(Character attacker, Character defender) {
        String attackerName = attacker.getClass().getSimpleName();
        String defenderName = defender.getClass().getSimpleName();
        String weaponName = attacker.getWeapon().getClass().getSimpleName();

        message = attackerName + " attacked " + defenderName + " with " + weaponName + " for " + attacker.getDamage() + " damage. " + defenderName + " has " + defender.getHealth() + " health left.";
        log(message);
    }

    @Override
    public void log(String message) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(message + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
