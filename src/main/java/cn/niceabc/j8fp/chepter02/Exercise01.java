package cn.niceabc.j8fp.chepter02;

import java.util.function.Function;

public class Exercise01 {

    /* a
         +----------+
    T+---> Function +--->R
         +----------+
    */

    /*b*/
    Function<Integer, Integer> func_b = a -> a + 1;

    /*c*/
    Function<Long, Long> func_c = x -> x + 1;

}
