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



public class Rogue extends Player {

    private final int defense;
    private final int strength;
    public int dexterity = 25;

    public Rogue(int str, int def){
        super(str, def);
        this.className = "Rogue ";
        this.strength = str-1;
        this.defense = def-1;
        this.health = 100-12;
    }

    @Override
    public int attack(Player target){
        boolean criticalHit = (int) (Math.random() * 10000) < dexterity;
        int damage = this.strength * 2;
        if(criticalHit){
            damage *= 3;
            System.out.println("*** Critical Hit ***");
        }
        return target.takeDamage(damage);
    }

}

