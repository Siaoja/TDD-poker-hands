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
        assertEquals(PokerHandConstant.FLUSH, type);
    }

    @Test
    void should_return_Straight_when_judge_types_given_2C3D4H5S6D() {
        //given
        PokerHand pokerHand = new PokerHand();
        String input="2C 3D 4H 5S 6D";

        //when
        int type = pokerHand.judgeTypes(input);

        //then
        assertEquals(PokerHandConstant.STRAIGHT, type);
    }


    @Test
    void should_return_Four_a_kind_when_judge_types_given_1C1D3H1S1H() {
        //given
        PokerHand pokerHand = new PokerHand();
        String input="1C 1D 3H 1S 1H";

        //when
        int type = pokerHand.judgeTypes(input);

        //then
        assertEquals(PokerHandConstant.FOUR_A_KIND, type);
    }

    @Test
    void should_return_Straight_Flush_when_judge_types_given_1C2C3C4C5C() {
        //given
        PokerHand pokerHand = new PokerHand();
        String input="1C 2C 3C 4C 5C";

        //when
        int type = pokerHand.judgeTypes(input);

        //then
        assertEquals(PokerHandConstant.STRAIGHT_FLUSH, type);
    }

    @Test
    void should_return_Straight_Flush_when_judge_types_given_2C2D4C2H4S() {
        //given
        PokerHand pokerHand = new PokerHand();
        String input="2C 2D 4C 2H 4S";

        //when
        int type = pokerHand.judgeTypes(input);

        //then
        assertEquals(PokerHandConstant.FULL_HOUSE, type);
    }
}
