package com.github.dkoval.algopuzzles.firecode.level2;

/**
 * Compress a sorted String by replacing instances of repeated characters
 * with the character followed by the count of the character.
 */
public class StringCompression {

    public static String compressString(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            count++;
            char c = text.charAt(i);
            if (i + 1 >= text.length() || c != text.charAt(i + 1)) {
                sb.append(c);
                if (count > 1) {
                    sb.append(count);
                }
                count = 0;
            }
        }
        return sb.toString();
    }

    public static String compressStringRecursively(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        char head = text.charAt(0);
        String tail = text.substring(1);
        int count = 1;
        while (tail.length() > 0 && head == tail.charAt(0)) {
            count++;
            tail = tail.substring(1);
        }
        return (count > 1)
                ? String.valueOf(head) + count + compressString(tail)
                : String.valueOf(head) + compressString(tail);
    }
}
