/*
 * Copyright 2020 Robert Kimura
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package RPGArena.Game.Character;


import RPGArena.Game.Arena;

public class Mage extends Character {
    public int magic;
    public int intelligence;

    public Mage(){

    }



    @SuppressWarnings("unused")
    public Mage(int str, int def) {
        super();
        this.className = "Mage ";
        this.strength = str - 1;
        this.defense = def - 1;
        this.health = 100 - 1;
        this.intelligence = Arena.generator.nextInt(1000);
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
