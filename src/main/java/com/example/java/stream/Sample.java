package com.example.java.stream;

import org.apache.commons.lang.SystemUtils;
import org.apache.commons.lang.math.IntRange;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Sample {
    public static void main(String[] args) {
        Sample s1 = new Sample();
        s1.createStream1();
    }

    public void createStream1() {
        // Stream.of
        Stream<String> st1 = Stream.of("a", "b", "c");
//        IntStream st1 = IntStream.of(100, 200, 300);
//        LongStream st1 = LongStream.of(10L, 20L, 30L);
//        DoubleStream st1 = DoubleStream.of(1.0, 2.0, 3.0);
        st1.forEach(System.out::println);

        String[] array = {"a", "b", "c"};
        Stream<String> streamArray = Stream.of(array);
        streamArray.forEach(System.out::println);

        // List.Stream
        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> str = list.stream();

        List<Integer> intList = Arrays.asList(1, 2, 3);
        intList.forEach(System.out::println);

        // Arrays.Stream
        String[] arr = {"aaa", "bbb", "ccc", "eee", "fff"};
        Stream<String> str2 = Arrays.stream(arr);
        Stream<String> str21 = Arrays.stream(arr, 1,3);
        str21.forEach(System.out::println);

        // Range
        IntStream.range(1,11).forEach(System.out::println);
        IntStream.rangeClosed(0, 10).forEach(System.out::println);

        // Iterator
        IntStream.iterate(1, i -> i+10)
                .limit(10)
                .forEach(System.out::println);

        Stream.iterate("a", x -> x + ">")
                .limit(10)
                .forEach(System.out::println);

        // generate
        Stream.generate(() -> "aaa")
                .limit(10)
                .forEach(System.out::println);

        Random r1 = new Random(System.currentTimeMillis());
        Stream.generate(() -> new String(r1.ints(3, 'a', 'd').toArray(), 0, 3))
                .limit(10)
                .forEach(System.out::println);

        IntStream.generate(() -> 123)
                .limit(3)
                .forEach(System.out::println);

        // concat
        Stream<String> stream1 = Stream.of("a", "b", "c", "d", "e");
        Stream<String> stream2 = Stream.of("A", "B", "C", "D", "E");
        Stream.concat(stream1, stream2).forEach(System.out::println);

        IntStream stream3 = IntStream.of(100, 200, 300);
        IntStream stream4 = IntStream.of(400, 500, 600);
        IntStream.concat(stream3, stream4).forEach(System.out::println);

        // char
        String str3 = "abacleotxbcc";
        str3.chars().forEach(System.out::println);
        str3.chars().forEach(x -> System.out.println((char)x));

        // codePoints
        String emoji = "\uD83D\uDE04";
        emoji.codePoints().forEach(System.out::println);
        emoji.codePoints()
                .mapToObj(Integer::toHexString)
                .forEach(System.out::println);

        // Random
        r1.ints(6, 1, 10)
                .forEach(System.out::println);

        // empty
        Stream.empty().forEach(System.out::println);
        IntStream.empty().forEach(System.out::println);

        // IO File
        try {
            BufferedReader read1 = new BufferedReader(new FileReader("C:\\MyWorkSpace\\TestData\\linecount.txt"));
            Stream<String> stream10 = read1.lines();
            stream10.forEach(System.out::println);

        } catch (Exception e) {
        }

        // NIO File
        try {
            Stream<String> stream11 = Files.lines(Paths.get("C:\\MyWorkSpace\\TestData\\linecount.txt"));
            stream11.forEach(System.out::println);
        } catch (Exception e) {
        }

        // Folder Stream
        try {
            Path p1 = Paths.get("C:\\MyWorkSpace\\TestData");
            Files.find(p1, 2, (p, attr) -> p.toString().endsWith("csv"))
                    .forEach(x -> System.out.println(x + " | getFileName:" + x.getFileName() + " | getName:" + x.getName(1)));
        } catch (Exception e) {
        }

    }
}
