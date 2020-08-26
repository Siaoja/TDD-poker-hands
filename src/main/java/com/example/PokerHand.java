package com.example;

import java.util.*;

public class PokerHand {

    public int judgeTypes(String input) {
        List<Integer> pokers = formatPoker(input);

        pokers.sort(Comparator.comparingInt(Integer::intValue));

        if(isStraightFlush(pokers)){
            return PokerHandConstant.STRAIGHT_FLUSH;
        }

        if(isStraight(pokers)){
            return PokerHandConstant.STRAIGHT;
        }

        if(isFlush(pokers)){
            return PokerHandConstant.FLUSH;
        }

        if(isFourAKind(pokers)){
            return PokerHandConstant.FOUR_A_KIND;
        }



        return 0;
    }

    private boolean isStraightFlush(List<Integer> pokers) {
        if(isFlush(pokers)&&isStraight(pokers)){
            return true;
        }
        return false;
    }

    private boolean isFlush(List<Integer> pokers){
        Set<Integer> decors = new HashSet<>();
        for (int poker : pokers) {
            decors.add(poker % 10);
        }
        if(decors.size() == 1){
            return true;
        }
        return false;
    }
    private boolean isStraight(List<Integer> pokers){
        if(pokers.get(pokers.size()-1)/10-pokers.get(0)/10==4){
            return true;
        }
        return false;
    }

    private boolean isFourAKind(List<Integer> pokers){
        int countSameNumber = 0;
        for(int poker : pokers){
            if(poker/10 == pokers.get(1)/10){
                countSameNumber++;
            }
        }
        if(countSameNumber == 4){
            return true;
        }
        return false;
    }

    private List<Integer> formatPoker(String input) {
        String[] pokers = input.split(" ");
        List<Integer> pokerNumbers = new ArrayList<>();
        for (String poker : pokers) {
            int number = 0;
            switch (poker.charAt(1)) {
                case 'C':
                    number += 1;
                    break;
                case 'D':
                    number += 2;
                    break;
                case 'H':
                    number += 3;
                    break;
                case 'S':
                    number += 4;
                    break;
            }
            switch (poker.charAt(0)) {
                case 'T':
                    number += 10 * 10;
                    break;
                case 'J':
                    number += 11 * 10;
                    break;
                case 'Q':
                    number += 12 * 10;
                    break;
                case 'K':
                    number += 13 * 10;
                    break;
                case 'A':
                    number += 14 * 10;
                    break;
                default:
                    number += (poker.charAt(0) - '0') * 10;
            }
            pokerNumbers.add(number);
        }
        return pokerNumbers;
    }

}
