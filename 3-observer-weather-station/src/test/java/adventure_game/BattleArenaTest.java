package adventure_game;

import adventure_game.character.Character;
import adventure_game.observer.Observer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BattleArenaTest {
    private Character attacker;
    private Character defender;
    private BattleArena battleArena;
    private Observer observer;

    @BeforeEach
    void setUp() {
        attacker = mock(Character.class);
        defender = mock(Character.class);
        observer = mock(Observer.class);
        battleArena = new BattleArena(attacker, defender);
        battleArena.registerObserver(observer);
    }

    @Test
    void registerObserverAddsObserver() {
        Observer newObserver = mock(Observer.class);
        battleArena.registerObserver(newObserver);

        assertTrue(battleArena.observers.contains(newObserver));
    }

    @Test
    void removeObserverRemovesObserver() {
        battleArena.removeObserver(observer);

        assertFalse(battleArena.observers.contains(observer));
    }

    @Test
    void notifyObserversCallsUpdateOnAllObservers() {
        Observer anotherObserver = mock(Observer.class);
        battleArena.registerObserver(anotherObserver);

        battleArena.notifyObservers();

        verify(observer, times(1)).update(attacker, defender);
        verify(anotherObserver, times(1)).update(attacker, defender);
    }
}