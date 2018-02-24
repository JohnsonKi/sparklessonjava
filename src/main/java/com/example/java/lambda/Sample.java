package com.example.java.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Sample {
    public static void main(String[] args) {
        Sample s1 = new Sample();
        s1.test4();
    }

    public void test4() {
        List<String> strs = Arrays.asList("hoge", "fuga", "bar");
        Consumer<String> cons = s -> System.out.println(s);
        strs.forEach(cons);
    }

    public void test3() {
        List<String> strs = Arrays.asList("hoge", "fuga", "bar");
        Consumer<String> cons = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        strs.forEach(cons);
    }

    public void test2() {
        List<String> strs = Arrays.asList("hoge", "fuga", "bar");
        strs.forEach(s -> System.out.println(s));
    }

    public void test1() {
        List<String> strs = Arrays.asList("hoge", "fuga", "bar");
        strs.forEach(
                new Consumer<String>() {
                    public void accept(String s) {
                        System.out.println(s);
                    }
                }
        );
    }
}
