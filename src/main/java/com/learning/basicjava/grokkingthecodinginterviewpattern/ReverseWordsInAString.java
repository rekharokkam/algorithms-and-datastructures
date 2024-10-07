package com.learning.basicjava.grokkingthecodinginterviewpattern;

/**
 * Given a sentence, reverse the order of its words without affecting the order of letters within the given word.
 *
 * Constraints:
 * The sentence contains English uppercase and lowercase letters, digits, and spaces.
 * 1≤ sentence.length ≤ 10 power 4
 * The order of the letters within a word is not to be reversed.
 *
 * Note: The input string may contain leading or trailing spaces or multiple spaces between words.
 * The returned string, however, should only have a single space separating each word.
 * Do not include any extra spaces.
 *
 * Test cases:
 * The quick brown fox jumped over a lazy dog
 * She sells seashells on the seashore
 * Coding your improve to problems practice
 * Reverse the words in a sentence
 * We love Java
 * 1234 abc XYZ
 * You are amazing
 * Hello    World
 * Greetings 123
 *    MULTIPLE     SCENARIOS
 */
public class ReverseWordsInAString {

    public static String reverseWords(String sentence) {
        String trimmedSentence = sentence.replaceAll("\\s{2,}", " ");;
        System.out.println(trimmedSentence);
        String[] allWordsInSentence = trimmedSentence.split(" ");
        System.out.println("length of the array : " + allWordsInSentence.length);

        for (int start = 0, end = allWordsInSentence.length -1; start< allWordsInSentence.length / 2;
             start ++, end --) {
            String temp = allWordsInSentence[start];
            allWordsInSentence[start] = allWordsInSentence[end];
            allWordsInSentence[end] = temp;
        }

        return String.join(" ", allWordsInSentence).trim();
    }

    public static void main(String[] args) {
        String reversedSentence = reverseWords("Reverse this String");
        System.out.println(reversedSentence);
    }
}
