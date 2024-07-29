package adventure_game.observer;

import adventure_game.character.Character;

public interface Observer {
    void update(Character attacker, Character defender);
}
