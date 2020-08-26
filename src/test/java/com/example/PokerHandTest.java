package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokerHandTest {

    @Test
    void should_return_Flush_when_judge_types_given_2H4H6H8HTH() {
        //given
        PokerHand pokerHand = new PokerHand();
        String input="2H 4H 6H 8H TH";

        //when
        int type = pokerHand.judgeTypes(input);

        //then
        assertEquals(6, type);
    }

    @Test
    void should_return_Straight_when_judge_types_given_2C3D4H5S6D() {
        //given
        PokerHand pokerHand = new PokerHand();
        String input="2C 3D 4H 5S 6D";

        //when
        int type = pokerHand.judgeTypes(input);

        //then
        assertEquals(5, type);
    }


    @Test
    void should_return_Four_a_kind_when_judge_types_given_1C1D3H1S1H() {
        //given
        PokerHand pokerHand = new PokerHand();
        String input="1C 1D 3H 1S 1H";

        //when
        int type = pokerHand.judgeTypes(input);

        //then
        assertEquals(8, type);
    }
}
