package com.mdt;

import java.util.*;

public class Interview {

    public static void main(String[] args) {

        String input = "abc def";

        var charArray = input.toCharArray();
        int start = 0;
        int end = 0;

        while (end < charArray.length) {
            if (charArray[end] == ' ') {
                reverseWord(charArray, start, end - 1);
                start = end + 1;
            }
            end++;
        }

        reverseWord(charArray, start, end - 1);

        System.out.println(new String(charArray));
    }

    public static void reverseWord(char[] charArray, int start, int end) {
        while (start < end) {
            var temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
            start++;
            end--;
        }
    }
}

class MarkdownProcessor {
    public static void main(String[] args) {
        String markdown = "# Heading\n\nThis is **bold** and this is *italic*.";
        String markdown2 = """
                # Heading
                        
                This is **bold** and this is *italic*. salam.""";
        String markdown3 = """
                This is a paragraph with a soft
                line break.

                This is another paragraph that has
                > Some text that
                > is in a
                > block quote.

                # Heading

                This is **bold** and this is *italic*.

                This is another paragraph with a ~~strikethrough~~ word.""";

//        String html = convertToHtml(markdown2);
//        System.out.println(html);

        var html2 = markdown(markdown3);
        System.out.println(html2);


    }

    public static String convertToHtml(String markdown) {
        StringBuilder html = new StringBuilder();

        int length = markdown.length();
        int i = 0;

        while (i < length) {
            char c = markdown.charAt(i);

            if (c == '#') {
                int headingLevel = 0;
                while (i < length && markdown.charAt(i) == '#') {
                    headingLevel++;
                    i++;
                }

                // Skip whitespace after heading markers
                while (i < length && markdown.charAt(i) == ' ') {
                    i++;
                }

                // Extract heading content
                StringBuilder headingContent = new StringBuilder();
                while (i < length && markdown.charAt(i) != '\n') {
                    headingContent.append(markdown.charAt(i));
                    i++;
                }

                // Generate HTML heading tags
                html.append("<h").append(headingLevel).append(">").append(headingContent).append("</h").append(headingLevel).append(">");
            } else if (c == '*') {
                // Check for bold or italic
                if (i + 1 < length && markdown.charAt(i + 1) == '*') {
                    i += 2;

                    // Extract bold content
                    StringBuilder boldContent = new StringBuilder();
                    while (i < length && !(markdown.charAt(i) == '*' && markdown.charAt(i + 1) == '*')) {
                        boldContent.append(markdown.charAt(i));
                        i++;
                    }

                    // Generate HTML bold tags
                    html.append("<strong>").append(boldContent).append("</strong>");

                    i += 2;
                } else {
                    i++;

                    // Extract italic content
                    StringBuilder italicContent = new StringBuilder();
                    while (i < length && markdown.charAt(i) != '*') {
                        italicContent.append(markdown.charAt(i));
                        i++;
                    }

                    // Generate HTML italic tags
                    html.append("<em>").append(italicContent).append("</em>");

                    i++; // I added
                }
            } else if (c == '\n') {
                // Replace newlines with HTML line breaks
                html.append("<br>");
                i++;
            } else {
                // Append other characters as is
                html.append(c);
                i++;
            }
        }

        return html.toString();
    }

//    public static String convertToHtml(String markdown) {
//        // Convert headings
//        markdown = markdown.replaceAll("^# (.+)$", "<h1>$1</h1>");
//        markdown = markdown.replaceAll("^## (.+)$", "<h2>$1</h2>");
//        markdown = markdown.replaceAll("^### (.+)$", "<h3>$1</h3>");
//
//        // Convert bold and italic
//        markdown = markdown.replaceAll("\\*\\*(.+?)\\*\\*", "<strong>$1</strong>");
//        markdown = markdown.replaceAll("\\*(.+?)\\*", "<em>$1</em>");
//
//        // Convert paragraphs
//        markdown = markdown.replaceAll("^(.+)$", "<p>$1</p>");
//
//        return markdown;
//    }

//     public static String convertToHtml(String markdown) {
//         StringBuilder html = new StringBuilder();
//
//         String[] lines = markdown.split("\n");
//         for (String line : lines) {
//             if (line.startsWith("# ")) {
//                 String heading = line.substring(2);
//                 html.append("<h1>").append(heading).append("</h1>");
//             } else if (line.startsWith("## ")) {
//                 String heading = line.substring(3);
//                 html.append("<h2>").append(heading).append("</h2>");
//             } else if (line.startsWith("### ")) {
//                 String heading = line.substring(4);
//                 html.append("<h3>").append(heading).append("</h3>");
//             } else {
//                 html.append("<p>").append(line).append("</p>");
//             }
//         }
//
//         return html.toString();
//     }

    public static String markdown(String input) {
        int i = 0;
        StringBuilder res = new StringBuilder();
        boolean blockIsActive = false, isNewPara = false, strikethroughBegan = false, isAfterHeading = false;
        int paraCounter = 0;

        while (i < input.length()) {
            String ch = null;
            if (i == (input.length() - 1)) {
                ch = String.valueOf(input.charAt(i));
            } else
                ch = input.substring(i, i + 2); // todo exception, what if there is no more than one char remained.
            String newLine = input.substring(i, i + 1);

            if (newLine.equals("\n")) {
                if (input.substring(i + 1, i + 2).equals("\n")) {
                    paraCounter++;
                    isNewPara = true;
                    if (blockIsActive) {
                        res.append("</blockquote>");
                        blockIsActive = false;
                    }
                    if (paraCounter == 1 && !isAfterHeading)
                        res.insert(0, "<p>");
                    if (isNewPara && !isAfterHeading) {

                        res.append("</p>");
                    }
                    res.append("<p>");
                    i += 2;
                } else {
                    res.append("<br />");
                    i += 1;
                }
            } else if (ch.equals("> ")) {
                if (!blockIsActive) {
                    res.append("<blockquote>");
                    blockIsActive = true;
                }
                i += 2;
            } else if (ch.equals("~~")) {
                if (!strikethroughBegan) {
                    res.append("<del>");
                    strikethroughBegan = true;
                } else {
                    res.append("</del>");
                }
                i += 2;
            }
            /////////////////////////
            else if (newLine.equals("#")) {
                if (isNewPara)
                    res.delete(res.length() - 3, res.length());
                isNewPara = false;
                isAfterHeading = true;
                int headingLevel = 0;
                while (i < input.length() && input.charAt(i) == '#') {
                    headingLevel++;
                    i++;
                }
                // Skip whitespace after heading markers
                while (i < input.length() && input.charAt(i) == ' ') {
                    i++;
                }
                // Extract heading content
                StringBuilder headingContent = new StringBuilder();
                while (i < input.length() && input.charAt(i) != '\n') {
                    headingContent.append(input.charAt(i));
                    i++;
                }
                // Generate HTML heading tags
                res.append("<h").append(headingLevel).append(">").append(headingContent).append("</h").append(headingLevel).append(">");
            } else if (newLine.equals("*")) {
                // Check for bold or italic
                if (i + 1 < input.length() && input.charAt(i + 1) == '*') {
                    i += 2;

                    // Extract bold content
                    StringBuilder boldContent = new StringBuilder();
                    while (i < input.length() && !(input.charAt(i) == '*' && input.charAt(i + 1) == '*')) {
                        boldContent.append(input.charAt(i));
                        i++;
                    }

                    // Generate HTML bold tags
                    res.append("<strong>").append(boldContent).append("</strong>");

                    i += 2;
                } else {
                    i++;

                    // Extract italic content
                    StringBuilder italicContent = new StringBuilder();
                    while (i < input.length() && input.charAt(i) != '*') {
                        italicContent.append(input.charAt(i));
                        i++;
                    }

                    // Generate HTML italic tags
                    res.append("<em>").append(italicContent).append("</em>");

                    i++; // I added it
                }
            }
            ///////
            else {
                isAfterHeading = false;
                res.append(input.charAt(i));
                i += 1;
            }
        }
        if (isNewPara)
            res.append("</p>");
        return res.toString();
    }

    public int solution(int[] A) {

        // MissingInteger on codality demo test

        // Implement your solution here

//        Arrays.sort(A);
//        if (A[A.length - 1] <= 0) return 1;
//        if (A[0] > 1) return 1;
//
//        var result = 1;
//        // var x = new HashMap<Integer, Integer>();
//        for (var i = 0; i < A.length - 1; i++) {
//            if (A[i] == A[i + 1]) continue;
//            if (A[i] + 1 != A[i + 1]) result = A[i] + 1;
//            else result = A[A.length - 1] + 1;
//        }
//        return result;
//
//
//
//
//        // Implement your solution here
//        Arrays.sort(A);
//        if (A[A.length - 1] <= 0) return 1;
//        if (A[0] > 1) return 1;
//
//        var result = 1;
//        // var x = new HashMap<Integer, Integer>();
//        for (var i = 0; i < A.length - 1; i++) {
//            if (A[i] < 0) continue;
//            if (A[i] == A[i + 1]) continue;
//            if (A[i] + 1 != A[i + 1]) {
//                result = A[i] + 1;
//                return result;
//            }
//        }
//        result = A[A.length - 1] + 1;
//        return result;


        HashSet<Integer> set = new HashSet<>();
        // Add all positive integers in the array to the set
        for (int num : A) {
            if (num > 0) {
                set.add(num);
            }
        }
        // Find the smallest positive integer that does not occur in the array
        int smallestMissing = 1;
        while (set.contains(smallestMissing)) {
            smallestMissing++;
        }

        return smallestMissing;
    }


}