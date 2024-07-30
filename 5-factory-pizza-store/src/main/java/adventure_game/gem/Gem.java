package adventure_game.gem;

import adventure_game.weapon.Weapon;

public abstract class Gem extends Weapon {
    protected Weapon weapon;

    public Gem(Weapon weapon) {
        if (weapon.gemCount() >= weapon.maxGems()) {
            throw new IllegalArgumentException("Weapon reached max gems");
        } else {
            this.weapon = weapon;
        }
    }

    public int maxGems() {
        return weapon.maxGems();
    }

    public int gemCount() {
        return 1 + weapon.gemCount();
    }

}
