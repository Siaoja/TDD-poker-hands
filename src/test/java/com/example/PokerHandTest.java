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
        int type = pokerHand.judgeTypes(pokerHand.formatPoker(input));

        //then
        assertEquals(PokerHandConstant.FLUSH, type);
    }

    @Test
    void should_return_Straight_when_judge_types_given_2C3D4H5S6D() {
        //given
        PokerHand pokerHand = new PokerHand();
        String input="2C 3D 4H 5S 6D";

        //when
        int type = pokerHand.judgeTypes(pokerHand.formatPoker(input));

        //then
        assertEquals(PokerHandConstant.STRAIGHT, type);
    }


    @Test
    void should_return_Four_a_kind_when_judge_types_given_1C1D3H1S1H() {
        //given
        PokerHand pokerHand = new PokerHand();
        String input="1C 1D 3H 1S 1H";

        //when
        int type = pokerHand.judgeTypes(pokerHand.formatPoker(input));

        //then
        assertEquals(PokerHandConstant.FOUR_A_KIND, type);
    }

    @Test
    void should_return_Straight_Flush_when_judge_types_given_1C2C3C4C5C() {
        //given
        PokerHand pokerHand = new PokerHand();
        String input="1C 2C 3C 4C 5C";

        //when
        int type = pokerHand.judgeTypes(pokerHand.formatPoker(input));

        //then
        assertEquals(PokerHandConstant.STRAIGHT_FLUSH, type);
    }

    @Test
    void should_return_Straight_Flush_when_judge_types_given_2C2D4C2H4S() {
        //given
        PokerHand pokerHand = new PokerHand();
        String input="2C 2D 4C 2H 4S";

        //when
        int type = pokerHand.judgeTypes(pokerHand.formatPoker(input));

        //then
        assertEquals(PokerHandConstant.FULL_HOUSE, type);
    }

    @Test
    void should_return_Three_Of_A_Kind_when_judge_types_given_2C2D4C2H3S() {
        //given
        PokerHand pokerHand = new PokerHand();
        String input="2C 2D 4C 2H 3S";

        //when
        int type = pokerHand.judgeTypes(pokerHand.formatPoker(input));

        //then
        assertEquals(PokerHandConstant.THREE_OF_A_KIND, type);
    }

    @Test
    void should_return_Two_Pair_when_judge_types_given_2C2D4C3H3S() {
        //given
        PokerHand pokerHand = new PokerHand();
        String input="2C 2D 4C 3H 3S";

        //when
        int type = pokerHand.judgeTypes(pokerHand.formatPoker(input));

        //then
        assertEquals(PokerHandConstant.TWO_PAIR, type);
    }

    @Test
    void should_return_Pair_when_judge_types_given_2C2D4C3H1S() {
        //given
        PokerHand pokerHand = new PokerHand();
        String input="2C 2D 4C 3H 1S";

        //when
        int type = pokerHand.judgeTypes(pokerHand.formatPoker(input));

        //then
        assertEquals(PokerHandConstant.PAIR, type);
    }

    @Test
    void should_return_High_Card_when_judge_types_given_2C5D4C3H8S() {
        //given
        PokerHand pokerHand = new PokerHand();
        String input="2C 5D 4C 3H 8S";

        //when
        int type = pokerHand.judgeTypes(pokerHand.formatPoker(input));

        //then
        assertEquals(PokerHandConstant.HIGH_CARD, type);
    }


    @Test
    void should_return_player1_win_when_compare_number_given_2C5D4C3H8S_and_2C5D4C3H7S() {
        //given
        PokerHand pokerHand = new PokerHand();
        String input1="2C 5D 4C 3H 8S";
        String input2="2C 5D 4C 3H 7S";

        //when
        String result = pokerHand.compareNumber(input1, input2);

        //then
        assertEquals(PokerHandConstant.PLAYER_1_WIN,result );
    }

    @Test
    void should_return_player1_win_when_compare_number_given_2C5C4C3C8C_and_2C5C4C3C7C() {
        //given
        PokerHand pokerHand = new PokerHand();
        String input1="2C 5C 4C 3C 8C";
        String input2="2C 5C 4C 3C 7C";

        //when
        String result = pokerHand.compareNumber(input1, input2);

        //then
        assertEquals(PokerHandConstant.PLAYER_1_WIN,result );
    }


    @Test
    void should_return_player1_win_when_compare_number_given_2D3C4C5C6C_and_1D2C3D4D5D() {
        //given
        PokerHand pokerHand = new PokerHand();
        String input1="2D 3C 4C 5C 6C";
        String input2="1D 2C 3D 4D 5D";

        //when
        String result = pokerHand.compareNumber(input1, input2);

        //then
        assertEquals(PokerHandConstant.PLAYER_1_WIN,result );
    }


    @Test
    void should_return_player1_win_when_compare_number_given_2C3C4C5C6C_and_1D2D3D4D5D() {
        //given
        PokerHand pokerHand = new PokerHand();
        String input1="2C 3C 4C 5C 6C";
        String input2="1D 2D 3D 4D 5D";

        //when
        String result = pokerHand.compareNumber(input1, input2);

        //then
        assertEquals(PokerHandConstant.PLAYER_1_WIN,result );
    }

    @Test
    void should_return_player1_win_when_compare_number_given_2C2C2C2C5D_and_1D1D1D1D6C() {
        //given
        PokerHand pokerHand = new PokerHand();
        String input1="2C 2C 2C 2C 5D";
        String input2="1D 1D 1D 1D 6C";

        //when
        String result = pokerHand.compareNumber(input1, input2);

        //then
        assertEquals(PokerHandConstant.PLAYER_1_WIN,result );
    }

    @Test
    void should_return_player1_win_when_compare_number_given_2C2C2C5C5D_and_1D1D1D6D6C() {
        //given
        PokerHand pokerHand = new PokerHand();
        String input1="2C 2C 2C 5C 5D";
        String input2="1D 1D 1D 6D 6C";

        //when
        String result = pokerHand.compareNumber(input1, input2);

        //then
        assertEquals(PokerHandConstant.PLAYER_1_WIN,result );
    }
}
