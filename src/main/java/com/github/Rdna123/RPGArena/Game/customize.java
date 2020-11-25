/*
 * Copyright 2020 Robert Kimura
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.github.Rdna123.RPGArena.Game;

import com.github.Rdna123.RPGArena.Game.Character.Mage;
import com.github.Rdna123.RPGArena.Game.Character.Paladin;
import com.github.Rdna123.RPGArena.Game.Character.Rogue;
import com.github.Rdna123.RPGArena.Game.Character.Fighter;
import java.util.Scanner;

import static com.github.Rdna123.RPGArena.Game.Arena.fighter1;
import static com.github.Rdna123.RPGArena.Game.Arena.fighter2;
public class customize {
    public static void custom() {
        Arena.blank = false;

        for (int i = 0;i<1;i++) {

            System.out.print("game-custom-p1 name> ");
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            String name = input;

            System.out.println("\nClasses: Fighter(Default), Mage, Paladin, and Rogue\n");
            System.out.print("game-custom-p1 class> ");
            in = new Scanner(System.in);
            input = in.nextLine();

            String inno = input.toLowerCase();

            System.out.println("Enter strength");
            System.out.print("game-custom-p1 Str> ");
            in = new Scanner(System.in);
            int inputInt= in.nextInt();
            int strength = inputInt;


            System.out.print("game-custom-p1 Def> ");
            in = new Scanner(System.in);
            inputInt = in.nextInt();
            int defense = inputInt;


            switch (inno){
                case "paladin":
                    fighter1 = new Paladin(strength, defense);
                    fighter1.setName(name);
                    break;
                case "rogue":
                    fighter1 = new Rogue(strength, defense);
                    fighter1.setName(name);
                    break;
                case "mage":
                    fighter1 = new Mage(strength, defense);
                    fighter1.setName(name);
                    break;
                default:
                    fighter1 = new Fighter(strength, defense);
                    fighter1.setName(name);
                    break;
            }
            System.out.println("Player1 set to "+ fighter1.getClassName() + "\n");


            System.out.print("game-custom-p2 name> ");
            in = new Scanner(System.in);
            input = in.nextLine();
            name = input;

            System.out.println("\nClasses: Fighter(Default), Mage, Paladin, and Rogue\n");
            System.out.print("game-custom-p2 class> ");
            in = new Scanner(System.in);
            input = in.nextLine();

            inno = input.toLowerCase();

            System.out.println("Enter strength");
            System.out.print("game-custom-p2 Str> ");
            in = new Scanner(System.in);
            inputInt= in.nextInt();
            strength = inputInt;


            System.out.print("game-custom-p2 Def> ");
            in = new Scanner(System.in);
            inputInt = in.nextInt();
            defense = inputInt;


            switch (inno) {
                case "paladin":
                    fighter2 = new Paladin(strength, defense);
                    fighter2.setName(name);
                    break;
                case "rogue":
                    fighter2 = new Rogue(strength, defense);
                    fighter2.setName(name);
                    break;
                case "mage":
                    fighter2 = new Mage(strength, defense);
                    fighter2.setName(name);
                    break;
                default:
                    fighter2 = new Fighter(strength, defense);
                    fighter2.setName(name);
                    break;
            }
            System.out.println("Player2 set to "+ fighter2.getClassName());

            System.out.println("\nCustom Characters ready.");
        }
    }
}
