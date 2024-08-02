package facade.adventure_game.observer;

import facade.adventure_game.character.Character;

public interface Observer {
    void update(Character attacker, Character defender);
}
