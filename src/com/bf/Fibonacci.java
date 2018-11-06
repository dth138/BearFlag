package com.bf;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Fibonacci {



    public static Integer NthValue(Integer a, Integer b, Integer n) throws Exception {

        Integer f = 0;

        if (n == 0) {
            f = 0;
        } else if (n == 1) {
            f = a;
        } else if (n == 2) {
            f = b;
        }

        while (n > 2) {
            f = a + b;
            if (f < b) {
                throw new Exception("Max Integer Reached");
            }
            a = b;
            b = f;
            n--;
        }

        return f;
    }

    @Test
    public void NthValueTests() {
        try {
            //Base
            assertEquals((Integer) 3, NthValue(1,2,3));

            //Initial Conditions
            assertEquals((Integer) 0, NthValue(1,2,0));
            assertEquals((Integer) 1, NthValue(1,2,1));
            assertEquals((Integer) 2, NthValue(1,2,2));

            assertEquals((Integer) 343, NthValue(5,7,10));
            assertEquals((Integer) 343, NthValue(5,7,10));
        } catch (Exception e) {
            //Just in case
            System.out.println(e.getMessage());
        }

        assertThrows(Exception.class , () -> Fibonacci.NthValue(1, Integer.MAX_VALUE, 3));
    }
}
