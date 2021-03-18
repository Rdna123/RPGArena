/*
 * Copyright 2020 Robert Kimura
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.github.Rdna123.RPGArena.Utils;

import java.util.Scanner;

public class Input {

    /**
     * @param Message
     * The what the input is for.
     * @return String
     */
    public static String inString(String Message){
        System.out.print(Message+"> ");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        input = command(input);
        return input;
    }

    public static String command(String input){
        input = input.replaceAll("\\s", "");
        input = input.toLowerCase();
        return input;
    }

    public static int inNum(String Message){
        System.out.print(Message+"> ");
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }
    public static Boolean inBoolean(String Message){
        System.out.print(Message+"> ");
        Scanner in = new Scanner(System.in);
        return in.nextBoolean();
    }
}
