package com.mdt;

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
                        
                This is **bold** and this is *italic*.""";
        String markdown3 = """
                This is a paragraph with a soft
                line break.

                This is another paragraph that has
                > Some text that
                > is in a
                > block quote.

                This is another paragraph with a ~~strikethrough~~ word.""";

        String html = convertToHtml(markdown2);
        System.out.println(html);
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
}