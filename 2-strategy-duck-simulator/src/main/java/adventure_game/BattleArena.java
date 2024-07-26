package adventure_game;

import adventure_game.character.Character;

public class BattleArena {
    Character firstCharacter;
    Character secondCharacter;
    boolean isFirstCharacterTurn;

    public BattleArena(Character firstCharacter, Character secondCharacter) {
        this.firstCharacter = firstCharacter;
        this.secondCharacter = secondCharacter;
        isFirstCharacterTurn = true;
    }

    public void battle() {
        if (charactersAreAlive()) {
            while (charactersAreAlive()) {
                fight();
                changeTurn();
            }
            declareWinner();
        } else {
            throw new IllegalStateException("Characters are dead, they can't fight");
        }
    }

    private void declareWinner() {
        if (firstCharacter.isAlive()) {
            announceBattleResults(firstCharacter, secondCharacter);
        } else {
            announceBattleResults(secondCharacter, firstCharacter);
        }
    }

    private static void announceBattleResults(Character firstCharacter, Character secondCharacter) {
        System.out.println(secondCharacter.getClass().getSimpleName() + " is dead!");
        System.out.println(firstCharacter.getClass().getSimpleName() + " wins!");
    }

    private void changeTurn() {
        isFirstCharacterTurn = !isFirstCharacterTurn;
    }

    private void fight() {
        if (isFirstCharacterTurn) {
            firstCharacter.attack(secondCharacter);
        } else {
            secondCharacter.attack(firstCharacter);
        }
    }

    private boolean charactersAreAlive() {
        return firstCharacter.isAlive() && secondCharacter.isAlive();
    }

}
