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

        if(isFullHouse(pokers)){
            return PokerHandConstant.FULL_HOUSE;
        }

        if(isThreeOfAKind(pokers)){
            return PokerHandConstant.THREE_OF_A_KIND;
        }

        if(isTwoPair(pokers)){
            return PokerHandConstant.TWO_PAIR;
        }

        if(isPair(pokers)){
            return PokerHandConstant.PAIR;
        }

        if(isHighCard(pokers)){
            return PokerHandConstant.HIGH_CARD;
        }

        return 0;
    }

    private boolean isHighCard(List<Integer> pokers) {
        Map<Integer, Integer> numberOccurTimes = new HashMap<>();
        for(Integer poker : pokers){
            int pokerNumber = poker/10;
            if (!numberOccurTimes.containsKey(pokerNumber)){
                numberOccurTimes.put(pokerNumber,1);
            }else{
                numberOccurTimes.put(pokerNumber, numberOccurTimes.get(pokerNumber) + 1);
            }
        }
        return numberOccurTimes.size()==5;
    }

    private boolean isPair(List<Integer> pokers) {
        Map<Integer, Integer> numberOccurTimes = new HashMap<>();
        for(Integer poker : pokers){
            int pokerNumber = poker/10;
            if (!numberOccurTimes.containsKey(pokerNumber)){
                numberOccurTimes.put(pokerNumber,1);
            }else{
                numberOccurTimes.put(pokerNumber, numberOccurTimes.get(pokerNumber) + 1);
            }
        }
        return numberOccurTimes.containsValue(2)&&numberOccurTimes.size()==4;
    }

    private boolean isTwoPair(List<Integer> pokers) {
        Map<Integer, Integer> numberOccurTimes = new HashMap<>();
        for(Integer poker : pokers){
            int pokerNumber = poker/10;
            if (!numberOccurTimes.containsKey(pokerNumber)){
                numberOccurTimes.put(pokerNumber,1);
            }else{
                numberOccurTimes.put(pokerNumber, numberOccurTimes.get(pokerNumber) + 1);
            }
        }
        return numberOccurTimes.containsValue(2)&&numberOccurTimes.size()==3;
    }

    private boolean isThreeOfAKind(List<Integer> pokers){
        Map<Integer, Integer> numberOccurTimes = new HashMap<>();
        for(Integer poker : pokers){
            int pokerNumber = poker/10;
            if (!numberOccurTimes.containsKey(pokerNumber)){
                numberOccurTimes.put(pokerNumber,1);
            }else{
                numberOccurTimes.put(pokerNumber, numberOccurTimes.get(pokerNumber) + 1);
            }
        }
        return numberOccurTimes.containsValue(3);
    }

    private boolean isFullHouse(List<Integer> pokers) {
        int firstPoker = pokers.get(0)/10;
        int middlePoker = pokers.get(2)/10;
        int lastPoker = pokers.get(4)/10;

        if(middlePoker - firstPoker == 0 && pokers.get(3)/10==pokers.get(4)/10){
            return true;
        }
        if(middlePoker - lastPoker == 0 && pokers.get(0)/10==pokers.get(1)/10){
            return true;
        }
        return false;
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

    private boolean isFourAKind(List<Integer> pokers){
        int countSameNumber = 0;
        for(int poker : pokers){
            if(poker/10 == pokers.get(1)/10){
                countSameNumber++;
            }
        }
        return countSameNumber == 4;
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
