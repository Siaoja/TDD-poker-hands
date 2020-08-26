package com.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PokerHand {

    public int judgeTypes(String input) {
        List<Integer> pokers = formatPoker(input);
        Set<Integer> decors = new HashSet<>();

        for (int poker : pokers) {
            decors.add(poker % 10);
        }
        if(decors.size() == 1){
            return 6;
        }
        return 0;
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
