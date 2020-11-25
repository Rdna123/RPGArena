/*
 * Copyright 2020 Robert Kimura
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.github.Rdna123.RPGArena.Game.Character;



public class Mage extends Player {
    private int magic;
    private final int intelligence = (int)(Math.random() * 10000);

    private boolean accuracy;

    private boolean overPower;

    private final int strength;

    private  int health;


    public Mage(int str, int def) {
        super(str, def);
        setClassName("Mage ");
        this.strength = str;
        setStrength(str - 1);
        this.health = 99;
        setHealth(this.health);
        setDefense(def);
    }


    @Override
    public int attack(Player target) {
        int damage = 0;
        this.accuracy = (int) (Math.random() * 10000) < 90;
        this.overPower = (int) (Math.random() * 10000) < 30;
        if (this.magic >= this.health + 7) {
            if (accuracy) {
                if (overPower) {
                    damage = ((this.health * 100) + (this.magic * 100));
                    this.health = this.health / 2;
                } else {
                    damage = ((this.health / 3) + (this.strength / 5) + (this.magic + 6) + (intelligence / 10));
                    System.out.println("**Magic Cast**");
                }
            } else {
                damage = this.strength;
                magic += 20;
            }
        }

        return target.takeDamage(damage);
    }


    public int getIntelligence() {
        return intelligence;
    }

    public boolean isAccuracy() {
        return accuracy;
    }

    public void setAccuracy(boolean accuracy) {
        this.accuracy = accuracy;
    }

    public boolean isOverPower() {
        return overPower;
    }

    public void setOverPower(boolean overPower) {
        this.overPower = overPower;
    }
}
