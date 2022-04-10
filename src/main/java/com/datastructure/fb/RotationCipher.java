package com.datastructure.fb;

import org.junit.Assert;


/**
 * https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=238827593802550&c=3001266390183960
 * &ppid=454615229006519&practice_plan=1
 */
public class RotationCipher {
    public static void main(String[] args) {
        RotationCipher sol = new RotationCipher();
        Assert.assertTrue("Cheud-726?", "Cheud-726?".equals(sol.rotationalCipher("Zebra-493?", 3)));
    }

    String rotationalCipher(String input, int rotationFactor) {
        // Write your code here
        int normalizedCharacterRotation = rotationFactor % 26;
        int normalizedDigitRotation = rotationFactor % 10;

        StringBuilder sb = new StringBuilder();
        int rotatedCharacter;
        for (Character ch : input.toCharArray()) {
            if (isLowerCharacter(ch)) {
                rotatedCharacter = (ch - 'a' + normalizedCharacterRotation) % 26 + 'a';
            } else if (isUpperCharacter(ch)) {
                rotatedCharacter = (ch - 'A' + normalizedCharacterRotation) % 26 + 'A';
            } else if (isDigit(ch)) {
                rotatedCharacter = (ch - '0' + normalizedDigitRotation) % 10 + '0';
            } else {
                rotatedCharacter = ch;
            }
            sb.append((char) rotatedCharacter);
        }
        return sb.toString();
    }

    private boolean isLowerCharacter(final Character ch) {

        return ch >= 'a' && ch <= 'z';
    }

    private boolean isUpperCharacter(final Character ch) {

        return ch >= 'A' && ch <= 'Z';
    }

    private boolean isDigit(final Character ch) {
        return ch - '0' >= 0 && ch - '0' <= 9;
    }

}
