package me.pr3.day3;

import me.pr3.day2.Two;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class One {
    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.stream(new String(One.class.getClassLoader().getResourceAsStream("input/day3/input.txt").readAllBytes()).split(System.lineSeparator()))
                .map(n -> new ImmutablePair<>(n.substring(0, n.length() / 2), n.substring(n.length() / 2)))
                .map(n -> new ImmutablePair<>(n.left.chars().boxed().collect(Collectors.toSet()), n.right.chars().boxed().collect(Collectors.toSet())))
                .peek(n -> n.left.retainAll(n.right))
                .map(n -> n.left.toArray(new Integer[0])[0])
                .mapToInt(n -> Character.isUpperCase(n) ? n - 64 + 26 : n - 96)
                .sum());
    }
}
