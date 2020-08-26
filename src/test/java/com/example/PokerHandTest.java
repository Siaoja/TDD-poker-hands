package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokerHandTest {

    @Test
    void should_return_Flush_when_judge_types_given_2H4H6H8HTH() {
        //given
        PokerHand pokerHand = new PokerHand();
        String input="2H4H6H8HTH";

        //when
        int type = pokerHand.judgeTypes(input);

        //then
        assertEquals(6, type);
    }
}
