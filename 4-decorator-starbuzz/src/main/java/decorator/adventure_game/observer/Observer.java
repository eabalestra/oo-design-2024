package decorator.adventure_game.observer;

import decorator.adventure_game.character.Character;

public interface Observer {
    void update(Character attacker, Character defender);
}
