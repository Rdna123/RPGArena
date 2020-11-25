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


public abstract class Player{
    public String className;

    public String name;

    private int strength;
    public int health = getHealth();
    private int defense;

    private int wins;

    @SuppressWarnings("SpellCheckingInspection")
    public static String[] nameList = {"Geoff", "Steve", "Krogar", "Dave", "Keith", "Deven"};

    /**
     * Blank Constructor used for custom characters.
     */


    public Player(int str, int def) {
            this.name = nameList[(int)( Math.random() * 6)];
            this.wins = 0;
            this.strength = str;
            this.defense = def;
    }

    public int takeDamage(int damage) {
        int damageTaken = damage - getDefense();
        if(damageTaken > 0){
            this.health -= damageTaken;
            return damageTaken;

        } else if (damageTaken<0){
            return 0;
        }

        return 0;
    }

    public int attack(Player target) {
            int damage = getStrength();
            return target.takeDamage(damage);
        }


    public boolean isAlive(){
            return this.health > 0;
    }


//  Getters and Setters for class functions.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getHealth() {
        return health;
    }


    public void setHealth(int health) {
        this.health = health;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    @Deprecated
    public int getWins() {
        return wins;
    }

    @Deprecated
    public void setWins(int wins) {
        this.wins = wins;
    }

}
