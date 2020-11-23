/*
 * Copyright 2020 Robert Kimura
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package RPGArena.Game;

import RPGArena.Game.Character.Character;
import RPGArena.Game.Character.Mage;
import RPGArena.Game.Character.Paladin;
import RPGArena.Game.Character.Rogue;

import java.util.Scanner;

import static RPGArena.Game.Arena.player1;
import static RPGArena.Game.Arena.player2;

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
                    player1 = new Paladin(strength, defense);
                    player1.name = name;
                    break;
                case "rogue":
                    player1 = new Rogue(strength, defense);
                    player1.name = name;
                    break;
                case "mage":
                    player1 = new Mage(strength, defense);
                    player1.name = name;
                    break;
                default:
                    player1 = new Character(strength, defense);
                    player1.name = name;
                    break;
            }
            System.out.println("Player1 set to "+ player1.className + "\n");


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

            System.out.println(input);
            switch (inno) {
                case "paladin":
                    player2 = new Paladin(strength, defense);
                    player2.name = name;
                    break;
                case "rogue":
                    player2 = new Rogue(strength, defense);
                    player2.name = name;
                    break;
                case "mage":
                    player2 = new Mage(strength, defense);
                    player2.name = name;
                    break;
                default:
                    player2 = new Character(strength, defense);
                    player2.name = name;
                    break;
            }
            System.out.println("Player2 set to "+ player2.className);

            System.out.println("\nCustom Characters ready.");
        }
    }
}
