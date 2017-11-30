package cn.niceabc.j8fp.chepter02;

import javax.swing.*;
import java.util.function.Predicate;

public class Exercise03 {

    /*a*/
    Runnable hello = () -> System.out.println("hello");

    /*b*/
    public void test() {
        JButton btn = new JButton();
        btn.addActionListener(e -> System.out.println(e.getActionCommand()));
    }

    /*c*/
    public void testOverload() {
        check((Predicate<Integer>) x -> x > 5);
        check((IntPred) x -> x > 5);
    }

    interface IntPred {
        boolean test(Integer value);
    }

    public boolean check(Predicate<Integer> predicate) {
        return predicate.test(1);
    }

    public boolean check(IntPred predicate) {
        return predicate.test(1);
    }
}
