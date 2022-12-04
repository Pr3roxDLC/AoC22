package me.pr3.day4;

import org.apache.commons.lang3.tuple.ImmutablePair;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class One {
    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.stream(new String(me.pr3.day3.One.class.getClassLoader().getResourceAsStream("input/day4/input.txt").readAllBytes()).split(System.lineSeparator()))
                .map(line -> new ImmutablePair<>(line.split(",")[0], line.split(",")[1]))
                .map(n -> new ImmutablePair<>(
                        new ImmutablePair<>(Integer.parseInt(n.left.split("-")[0]), Integer.parseInt(n.left.split("-")[1])),
                        new ImmutablePair<>(Integer.parseInt(n.right.split("-")[0]), Integer.parseInt(n.right.split("-")[1]))))
                .map(n -> new ImmutablePair<>(IntStream.range(n.left.left, n.left.right + 1), IntStream.range(n.right.left, n.right.right + 1)))
                .map(n -> new ImmutablePair<>(n.left.boxed().collect(Collectors.toSet()), n.right.boxed().collect(Collectors.toSet())))
                .filter(n -> n.left.containsAll(n.right) || n.right.containsAll(n.left))
                .count()
        );
    }
}
