package com.bf;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordReverse {

    public static String Reverse(String input) {

        if (input == null || input.isEmpty()){
            return "";
        }

        String[] words = input.split(" ");
        Stack<String> stack = new Stack();
        for (String i: words) {
            stack.add(i);
        }

        String outputBuffer = "";
        while(!stack.isEmpty()){
            outputBuffer += stack.pop();
            if (!stack.isEmpty()){
                outputBuffer += " ";
            }
        }
        return outputBuffer;
    }

    @Test
    public void WordReverseTests() {
        assertEquals("Three Two One", Reverse("One Two Three"));
        assertEquals("One", Reverse("One"));
        assertEquals("Three Two", Reverse("Two Three"));
        assertEquals("", Reverse(""));

    }
}
