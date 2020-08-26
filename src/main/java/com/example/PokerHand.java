package com.example;

public class PokerHand {

    public int judgeTypes(String input) {

        String[] pokers = input.split(" ");

        char decor=' ';
        boolean decorFlag = true;

        for(int i = 0; i < pokers.length; i++){
            if(i == 0){
                decor = pokers[i].charAt(1);
            }else {
                if (pokers[i].charAt(1) != decor){
                    decorFlag = false;
                    break;
                }

            }
        }
        if(decorFlag == true)
            return 6;
        return 0;
    }

}
