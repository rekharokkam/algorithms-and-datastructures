package com.learning.basicjava.grokkingthecodinginterviewpattern.twopointers;

import java.util.Hashtable;

/**
 * Given a string word and an abbreviation abbr, return TRUE if the abbreviation matches the given string.
 * Otherwise return FALSE.
 *
 * Constraints:
 * 1 <= word.length <= 20
 * word consists of only lower case English letters
 * 1 <= abbr.length <= 10
 * abbr consists of lowercase English letters and digits
 * All the integers in abbr will fit in a 32-bit integer.
 *
 * Testcases:
 * word calendar
 * abbr - cal3ar - valid
 * abbr - c6r - valid
 * abbr - c06r - invalid
 * abbr - cale0ndar - invalid
 * abbr - c24r - invalid
 *
 *
 */
public class ValidWordAbbreviation {

    public static boolean isAbbreviation (String word, String abbr) {
        int misMatchCounter = 0;
        for (int wordCounter = 0, abbrCounter = 0; abbrCounter < abbr.length(); abbrCounter ++) {
            if (word.charAt(wordCounter) != abbr.charAt(abbrCounter)) {
                misMatchCounter += 1;
                if (Character.isDigit(abbr.charAt(abbrCounter)) && (misMatchCounter <= 1)) {
                    int skip = Character.getNumericValue(abbr.charAt(abbrCounter));
                    if (skip == 0) {
                        return false;
                    }
                    wordCounter += skip;
                    continue;
                } else {
                    return false;
                }
            }
            wordCounter ++;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean isAbbreviationRight = isAbbreviation("calendar", "c24r");
        System.out.println(isAbbreviationRight);

    }
}
