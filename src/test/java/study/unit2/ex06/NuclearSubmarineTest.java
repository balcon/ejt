package study.unit2.ex06;

import org.junit.Test;

public class NuclearSubmarineTest {
    @Test
    public void testSub(){

        NuclearSubmarine goldFish = new NuclearSubmarine();
        goldFish.sailAway();
        goldFish.setCrewReady(true);
        goldFish.sailAway();

    }

}