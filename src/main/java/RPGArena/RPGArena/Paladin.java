package main.java.io.github.rdna123.RPGArena;

public class Paladin extends Character{
    public int Inspiration;

    public Paladin(int str, int def, int health){
        super();
        this.className = "Paladin ";
        this.strength = str-4;
        this.defense = def+2;
        this.health = health-1;
    }

    public int takeDamage(int damage) {
        boolean Block = Arena.generator.nextInt(1000) >= Inspiration - this.health;
        Inspiration = Arena.generator.nextInt(1000);
        if (Block){
            System.out.println(this.name + " receives half damage");
            int damageTaken = (damage - this.defense)/2;
            if (damageTaken > 0) {
                this.health -= damageTaken;
                return damageTaken;
            } else if (damageTaken < 0) {
                return 0;
            }
        }else {
            int damageTaken = damage - this.defense;
            if (damageTaken > 0) {
                this.health -= damageTaken;
                return damageTaken;
            } else if (damageTaken < 0) {
                return 0;
            }
        }

        return 0;
    }
}
