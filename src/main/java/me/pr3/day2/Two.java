package me.pr3.day2;

import me.pr3.Main;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.io.IOException;
import java.util.Arrays;

//Rock -> A
//Paper ->  B
//Scissors -> C
//Lose -> X
//Draw -> Y
//Win -> Z
public class Two {
    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.stream(new String(Two.class.getClassLoader().getResourceAsStream("input/day2/input.txt").readAllBytes()).split(System.lineSeparator()))
                .mapToInt(n -> {
                            int l = n.charAt(0);
                            return switch (n.charAt(2)) {
                                case 'X' -> l == 'A' ? 3 : l == 'B' ? 1 : 2;
                                case 'Y' -> l - 64;
                                default -> l == 'A' ? 2 : l == 'B' ? 3 : 1;
                            } + (n.charAt(2) - 88) * 3;
                        }
                ).
                sum());
    }
}
