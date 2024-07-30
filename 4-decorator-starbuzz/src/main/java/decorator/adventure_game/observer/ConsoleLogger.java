package decorator.adventure_game.observer;

import decorator.adventure_game.character.Character;

public class ConsoleLogger implements Observer, Logger {
    String message;

    @Override
    public void update(Character attacker, Character defender) {
        String attackerName = attacker.getClass().getSimpleName();
        String defenderName = defender.getClass().getSimpleName();
        String weapon = attacker.getWeapon().getClass().getSimpleName();
        int damage = attacker.getDamage();

        message = attackerName + " attacks " + defenderName + " for " + damage + " damage " +
                "using " + weapon + "." + "\n" + defenderName + " has " + defender.getHealth() + " health remaining.";
        log(message);
    }

    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
