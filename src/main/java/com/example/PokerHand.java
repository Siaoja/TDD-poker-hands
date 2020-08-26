package com.example;

import java.util.*;

public class PokerHand {

    public int judgeTypes( List<Integer> pokers) {

        if(isStraightFlush(pokers)){
            return PokerHandConstant.STRAIGHT_FLUSH;
        }

        if(isStraight(pokers)){
            return PokerHandConstant.STRAIGHT;
        }

        if(isFlush(pokers)){
            return PokerHandConstant.FLUSH;
        }

        return judgeSameNumberType(pokers);


    }

    private int judgeSameNumberType(List<Integer> pokers) {
        Map<Integer, Integer> numberOccurTimes = new HashMap<>();
        for(Integer poker : pokers){
            int pokerNumber = poker/10;
            if (!numberOccurTimes.containsKey(pokerNumber)){
                numberOccurTimes.put(pokerNumber,1);
            }else{
                numberOccurTimes.put(pokerNumber, numberOccurTimes.get(pokerNumber) + 1);
            }
        }
        if(numberOccurTimes.containsValue(4)){
            return PokerHandConstant.FOUR_A_KIND;
        }else if(numberOccurTimes.containsValue(3) && numberOccurTimes.containsValue(2)){
            return PokerHandConstant.FULL_HOUSE;
        }else if(numberOccurTimes.containsValue(3)){
            return PokerHandConstant.THREE_OF_A_KIND;
        }else if(numberOccurTimes.containsValue(2) && numberOccurTimes.size() == 3){
            return PokerHandConstant.TWO_PAIR;
        }else if(numberOccurTimes.containsValue(2)){
            return PokerHandConstant.PAIR;
        }else {
            return PokerHandConstant.HIGH_CARD;
        }
    }


    private boolean isStraightFlush(List<Integer> pokers) {
        return isFlush(pokers) && isStraight(pokers);
    }

    private boolean isFlush(List<Integer> pokers){
        Set<Integer> decors = new HashSet<>();
        for (int poker : pokers) {
            decors.add(poker % 10);
        }
        return decors.size() == 1;
    }
    private boolean isStraight(List<Integer> pokers){
        return pokers.get(pokers.size() - 1) / 10 - pokers.get(0) / 10 == 4;
    }

    public List<Integer> formatPoker(String input) {
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
        pokerNumbers.sort(Comparator.comparingInt(Integer::intValue));
        return pokerNumbers;
    }

    public String compareNumber(String input1, String input2) {
        List<Integer> player1Pokers = formatPoker(input1);
        List<Integer> player2Pokers = formatPoker(input2);

        int player1PokerType = judgeTypes(player1Pokers);
        int player2PokerType = judgeTypes(player2Pokers);

        if(player1PokerType==PokerHandConstant.FOUR_A_KIND){
            return compareFourAKind(player1Pokers,player2Pokers);
        }
        if(player1PokerType == PokerHandConstant.FULL_HOUSE){
            return compareFullHouse(player1Pokers,player2Pokers);
        }
        if(player1PokerType == PokerHandConstant.THREE_OF_A_KIND){
            return compareThreeOfAKind(player1Pokers,player2Pokers);
        }

        return compareMaxNumber(player1Pokers, player2Pokers);
    }

    private String compareThreeOfAKind(List<Integer> player1Pokers, List<Integer> player2Pokers) {
        if(player1Pokers.get(2)>player2Pokers.get(2)){
            return PokerHandConstant.PLAYER_1_WIN;
        }else{
            return PokerHandConstant.PLAYER_2_WIN;
        }
    }

    private String compareFullHouse(List<Integer> player1Pokers, List<Integer> player2Pokers) {
        if(player1Pokers.get(2)>player2Pokers.get(2)){
            return PokerHandConstant.PLAYER_1_WIN;
        }else{
            return PokerHandConstant.PLAYER_2_WIN;
        }
    }

    private String compareFourAKind(List<Integer> player1Pokers, List<Integer> player2Pokers) {
        if(player1Pokers.get(1)>player2Pokers.get(1)){
            return PokerHandConstant.PLAYER_1_WIN;
        }else{
            return PokerHandConstant.PLAYER_2_WIN;
        }

    }

    private String compareMaxNumber(List<Integer> player1Pokers, List<Integer> player2Pokers) {
        for (int i=player1Pokers.size()-1;i>=0;i--){
            if (player1Pokers.get(i)/10>player2Pokers.get(i)/10){
                return PokerHandConstant.PLAYER_1_WIN;
            }else if(player1Pokers.get(i)/10<player2Pokers.get(i)/10){
                return PokerHandConstant.PLAYER_2_WIN;
            }
        }
        return PokerHandConstant.TIE;
    }
}
