package RPGArena.Game.Character;

import RPGArena.Game.Arena;

public class Character {

    public String name;
    public String className;
    public int strength;
    public int health;
    public int defense;

    public int wins;

    @SuppressWarnings("SpellCheckingInspection")
    public static String[] nameList = {"Geoff", "Steve", "Krogar", "Dave", "Keith", "Deven"};

    public Character() {
        this.name = nameList[Arena.generator.nextInt(nameList.length)];
        this.className = "Fighter ";
        this.wins = 0;
    }

    public Character(int str, int def, int health) {
        this();
        this.strength = str;
        this.defense = def;
        this.health = health;
    }

    public int takeDamage(int damage) {
        int damageTaken = damage - this.defense;
        if(damageTaken > 0){
            this.health -= damageTaken;
            return damageTaken;
        } else if (damageTaken<0){
            return 0;
        }
        return 0;
    }

    public int attack(Character target) {
        int damage = this.strength * 2;
        return target.takeDamage(damage);
    }
    public boolean isAlive(){
        return this.health > 0;
    }

}