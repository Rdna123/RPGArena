package main.java.io.github.rdna123.RPGArena;


public class Mage extends Character {
    public int magic;
    public int intelligence;

    public Mage(int str, int def, int health, int intel) {
        super();
        this.className = "Mage ";
        this.strength = str - 1;
        this.defense = def - 1;
        this.health = health - 1;
        this.intelligence = intel;
    }

    public int attack(Character target) {
        int damage = 0;
        boolean accuracy = Arena.generator.nextInt(200) < 90;
        boolean overPower = Arena.generator.nextInt(1000) < 30;
        if (this.magic >= this.health + 7) {
            if (accuracy) {
                if (overPower) {
                    damage = ((this.health*100)+ (this.magic*100));
                    this.health = this.health/2;
                } else {
                    damage = ((this.health / 3) + (this.strength / 5) + (this.magic - this.health + 6) + (intelligence / 10));
                    System.out.println("**Magic Cast**");
                }
            } else {
                damage = (this.strength);
                magic += 15;
            }

        }return target.takeDamage(damage);
    }
}
