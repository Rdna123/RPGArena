package RPGArena.Game.Character;

import RPGArena.Game.Arena;

public class Rogue extends Character {

    public int dexterity = 25;

    public Rogue(){

    }

    public Rogue(int str, int def){
        super();
        this.className = "Rogue ";
        this.strength = str-1;
        this.defense = def-1;
        this.health = 100-12;
    }

    public int attack(Character target){
        boolean criticalHit = Arena.generator.nextInt(1000) < dexterity;
        int damage = this.strength * 2;
        if(criticalHit){
            damage *= 3;
            System.out.println("*** Critical Hit ***");
        }
        return target.takeDamage(damage);
    }

}

