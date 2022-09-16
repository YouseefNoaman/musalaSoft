package com.musalaSoft.musalaSoft.helper;

public class Util {

    public boolean checkMedicationCode(String s){
        if (s.trim().isBlank()){
            return false;
        }
        for (char c: s.toCharArray()) {
            if (!isUppercase(c) || !isdigit(c) || !isUnderscoreOnly(c)){
                return false;
            }
        }
        return true;
    }

    public boolean checkMedicationName(String s){
        if (s.trim().isBlank()){
            return false;
        }
        for (char c: s.toCharArray()) {
            if (!isLetter(c) || !isdigit(c) || !isHyphenOnly(c) || !isUnderscoreOnly(c)){
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

    private boolean isLetter(char c){
        return Character.isLetter(c);
    }

}
