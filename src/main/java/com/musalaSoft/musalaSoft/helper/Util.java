package com.musalaSoft.musalaSoft.helper;

public class Util {

    public boolean checkDroneCode(String s){
        for (char c: s.toCharArray()) {
            if (!isUppercase(c) || !isdigit(c) || !isUnderscoreOnly(c)){
                return false;
            }
        }
        return true;
    }

    public boolean checkDroneName(String s){
        for (char c: s.toCharArray()) {
            if (!isUppercase(c) || !isdigit(c) || !isHyphenOnly(c) || !isUnderscoreOnly(c)){
                return false;
            }
        }
        return true;
    }

    private boolean isUppercase(char c){
        return Character.isUpperCase(c);
    }

    private boolean isdigit(char c){
        return Character.isDigit(c);
    }

    private boolean isUnderscoreOnly(char c){
        return c == '_';
    }

    private boolean isHyphenOnly(char c){
        return c == '-';
    }


}
