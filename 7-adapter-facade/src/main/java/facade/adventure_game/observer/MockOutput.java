package facade.adventure_game.observer;

import facade.adventure_game.character.Character;

public class MockOutput implements Logger, Observer {
    String message;

    @Override
    public void update(Character attacker, Character defender) {
        String attackerName = attacker.getClass().getSimpleName();
        String defenderName = defender.getClass().getSimpleName();
        int damage = attacker.getDamage();

        message = attackerName + " attacks " + defenderName + " for " + damage + " damage "
                  + "." + "\n" + defenderName + " has " + defender.getHealth() + " health remaining.";
        log(message);
    }

    @Override
    public void log(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
