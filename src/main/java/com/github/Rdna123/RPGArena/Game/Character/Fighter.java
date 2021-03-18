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


/**
 * Base class for character types.
 */
public class Fighter extends Player {

    public int strength;
    public int health;
    public int defense;

    public int wins;



    public Fighter(int str, int def) {
        super(str, def);
        setClassName("Fighter ");
        this.wins = 0;
        this.strength = str;
        this.defense = def;
        this.health = 100;
    }

    @Override
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

    @Override
    public int attack(Player target) {
        int damage = this.strength * 2;
        return target.takeDamage(damage);
    }

}