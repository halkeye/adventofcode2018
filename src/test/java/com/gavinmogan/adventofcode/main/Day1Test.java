package com.gavinmogan.adventofcode.main;

import org.junit.Test;
import org.testng.Assert;

import java.util.Arrays;

public class Day1Test {

    @Test
    public void testPart2() throws Exception {
        int finalFrequency = 0;
        Day1 d = new Day1();


        finalFrequency = d.part2(Arrays.asList(+1, -1));
        Assert.assertEquals(finalFrequency, 0);

        finalFrequency = d.part2(Arrays.asList(+3, +3, +4, -2, -4));
        Assert.assertEquals(finalFrequency, 10);

        finalFrequency = d.part2(Arrays.asList(-6, +3, +8, +5, -6));
        Assert.assertEquals(finalFrequency, 5);

        finalFrequency = d.part2(Arrays.asList(+7, +7, -2, -7, -4));
        Assert.assertEquals(finalFrequency, 14);

    }

    @Test
    public void testPart1() throws Exception {
        int finalFrequency;
        Day1 d = new Day1();
        finalFrequency = d.part1(Arrays.asList(+1, +1, +1));
        Assert.assertEquals(finalFrequency, 3);
        finalFrequency = d.part1(Arrays.asList(+1, +1, -2));
        Assert.assertEquals(finalFrequency, 0);
        finalFrequency = d.part1(Arrays.asList(-1, -2, -3));
        Assert.assertEquals(finalFrequency, -6);
    }

}