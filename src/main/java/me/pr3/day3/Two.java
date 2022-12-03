package me.pr3.day3;

import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.tuple.ImmutableTriple;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Two {
    public static void main(String[] args) throws IOException {
        System.out.println(ListUtils.partition(Arrays.stream(new String(One.class.getClassLoader().getResourceAsStream("input/day3/input.txt").readAllBytes()).split(System.lineSeparator()))
                        .toList(), 3).stream()
                .map(n -> new ImmutableTriple<>(
                        n.get(0).chars().boxed().collect(Collectors.toSet()),
                        n.get(1).chars().boxed().collect(Collectors.toSet()),
                        n.get(2).chars().boxed().collect(Collectors.toSet())))
                .peek(n -> n.left.retainAll(n.middle))
                .peek(n -> n.left.retainAll(n.right))
                .map(n -> (Integer) n.left.toArray()[0])
                .mapToInt(n -> Character.isUpperCase(n) ? n - 64 + 26 : n - 96).sum());
    }
}
