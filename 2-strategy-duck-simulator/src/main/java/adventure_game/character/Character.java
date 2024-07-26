package adventure_game.character;

import adventure_game.FightStyle;
import adventure_game.weapon.FistPunch;
import adventure_game.weapon.Weapon;

public abstract class Character {
    FightStyle fightStyle;
    Weapon weapon;
    int health;

    public Character() {
        weapon = new FistPunch();
        health = 100;
    }

    public Character(Weapon weapon) {
        this.weapon = weapon;
        health = 100;
    }

    public void setWeapon(Weapon weapon) {
        if (weapon.getFightStyle() != this.fightStyle)
            throw new IllegalArgumentException("This character can't use this weapon");
        this.weapon = weapon;
    }

    public void attack(Character other) {
        if (isAlive()) {
            int damage = weapon.useWeapon();
            other.receiveDamage(damage);
        } else {
            throw new IllegalStateException("This character can't attack because he is dead");
        }
    }

    public void receiveDamage(int damage) {
        if (!isAlive())
            throw new IllegalStateException(this.getClass().getSimpleName()+" is dead!");
        health -= damage;
        if (health < 0) { health = 0; }
    }

    public boolean isAlive() {
        return health > 0;
    }

}