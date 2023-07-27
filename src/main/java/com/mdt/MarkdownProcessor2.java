package com.mdt;
//
//public class MarkdownProcessor2 {
//    public static String convertToHtml(String markdown) {
//        StringBuilder html = new StringBuilder();
//        boolean isInParagraph = false;
//
//        for (int i = 0; i < markdown.length(); i++) {
//            char currentChar = markdown.charAt(i);
//
//            if (currentChar == '#') {
//                int headingLevel = 0;
//                while (i < markdown.length() && markdown.charAt(i) == '#') {
//                    headingLevel++;
//                    i++;
//                }
//
//                html.append("<h").append(headingLevel).append(">");
//                while (i < markdown.length() && markdown.charAt(i) != '\n') {
//                    html.append(markdown.charAt(i));
//                    i++;
//                }
//                html.append("</h").append(headingLevel).append(">");
//            } else if (currentChar == '*') {
//                if (isInParagraph) {
//                    html.append("</p>");
//                    isInParagraph = false;
//                } else {
//                    html.append("<p>");
//                    isInParagraph = true;
//                }
//            } else {
//                html.append(currentChar);
//            }
//        }
//
//        if (isInParagraph) {
//            html.append("</p>");
//        }
//
//        return html.toString();
//    }
//
//    public static void main(String[] args) {
//        String markdown = "# Heading 1\n\nThis is a paragraph.\n\n* List item 1\n* List item 2\n\n## Heading 2";
//        String html = convertToHtml(markdown);
//        System.out.println(html);
//    }
//}
//public class MarkdownProcessor2 {
//    public static void main(String[] args) {
//        String markdownText = "This is a paragraph.\n\nThis is another paragraph.\n\n> This is a block quote.\n\n~~This is a deleted text.~~";
//        String htmlText = processMarkdown(markdownText);
//        System.out.println(htmlText);
//    }
//
//    public static String processMarkdown(String markdownText) {
//        StringBuilder htmlText = new StringBuilder();
//        String[] lines = markdownText.split("\n");
//
//        boolean inBlockQuote = false;
//        boolean inDeletedText = false;
//
//        for (String line : lines) {
//            line = line.trim();
//
//            if (line.startsWith(">")) {
//                if (!inBlockQuote) {
//                    htmlText.append("<blockquote>");
//                    inBlockQuote = true;
//                }
//                line = line.substring(1).trim();
//            } else if (inBlockQuote) {
//                htmlText.append("</blockquote>");
//                inBlockQuote = false;
//            }
//
//            if (line.startsWith("~~")) {
//                if (!inDeletedText) {
//                    htmlText.append("<del>");
//                    inDeletedText = true;
//                }
//                line = line.substring(2).trim();
//            } else if (inDeletedText) {
//                htmlText.append("</del>");
//                inDeletedText = false;
//            }
//
//            if (!line.isEmpty()) {
//                htmlText.append("<p>").append(line).append("</p>");
//            } else {
//                htmlText.append("<br>");
//            }
//        }
//
//        if (inBlockQuote) {
//            htmlText.append("</blockquote>");
//        }
//
//        if (inDeletedText) {
//            htmlText.append("</del>");
//        }
//
//        return htmlText.toString();
//    }
//}


//public class MarkdownProcessor2 {
//    public static void main(String[] args) {
//        String markdownText = "This is a paragraph.\n\nThis is another paragraph.\n\n> This is a block quote.\n\n~~This is a deleted text.~~";
//        String htmlText = processMarkdown(markdownText);
//        System.out.println(htmlText);
//    }
//
//    public static String processMarkdown(String markdownText) {
//        StringBuilder htmlText = new StringBuilder();
//        String[] lines = markdownText.split("\n");
//
//        boolean inBlockQuote = false;
//        boolean inDeletedText = false;
//
//        for (String line : lines) {
//            line = line.trim();
//
//            if (line.startsWith(">")) {
//                if (!inBlockQuote) {
//                    htmlText.append("<blockquote>");
//                    inBlockQuote = true;
//                }
//                line = line.substring(1).trim();
//            } else if (inBlockQuote) {
//                htmlText.append("</blockquote>");
//                inBlockQuote = false;
//            }
//
//            if (line.startsWith("~~")) {
//                if (!inDeletedText) {
//                    htmlText.append("<del>");
//                    inDeletedText = true;
//                }
//                line = line.substring(2).trim();
//            } else if (inDeletedText) {
//                htmlText.append("</del>");
//                inDeletedText = false;
//            }
//
//            if (!line.isEmpty()) {
//                htmlText.append(line).append("<br>");
//            } else {
//                if (!inBlockQuote && !inDeletedText) {
//                    htmlText.append("</p><p>");
//                } else {
//                    htmlText.append("<br>");
//                }
//            }
//        }
//
//        if (inBlockQuote) {
//            htmlText.append("</blockquote>");
//        }
//
//        if (inDeletedText) {
//            htmlText.append("</del>");
//        }
//
//        if (htmlText.length() > 0) {
//            htmlText.insert(0, "<p>");
//            htmlText.append("</p>");
//        }
//
//        return htmlText.toString();
//    }
//}


public class MarkdownProcessor2 {
    public static void main(String[] args) {
        String markdownText = "This is a paragraph.\n\nThis is another paragraph.\n\n> This is a block quote.\n\n~~This is a deleted text.~~";
        String htmlText = processMarkdown(markdownText);
        System.out.println(htmlText);
    }

    public static String processMarkdown(String markdownText) {
        StringBuilder htmlText = new StringBuilder();
        String[] lines = markdownText.split("\n");

        boolean inParagraph = false;
        boolean inBlockQuote = false;
        boolean inDeletedText = false;

        for (String line : lines) {
            line = line.trim();

            if (line.startsWith(">")) {
                if (!inBlockQuote) {
                    htmlText.append("<blockquote>");
                    inBlockQuote = true;
                }
                line = line.substring(1).trim();
            } else if (inBlockQuote) {
                htmlText.append("</blockquote>");
                inBlockQuote = false;
            }

            if (line.startsWith("~~")) {
                if (!inDeletedText) {
                    htmlText.append("<del>");
                    inDeletedText = true;
                }
                line = line.substring(2).trim();
            } else if (inDeletedText) {
                htmlText.append("</del>");
                inDeletedText = false;
            }

            if (!line.isEmpty()) {
                if (!inParagraph) {
                    htmlText.append("<p>");
                    inParagraph = true;
                }
                htmlText.append(line).append("<br>");
            } else {
                if (inParagraph) {
                    htmlText.append("</p>");
                    inParagraph = false;
                }
                htmlText.append("<br>");
            }
        }

        if (inBlockQuote) {
            htmlText.append("</blockquote>");
        }

        if (inDeletedText) {
            htmlText.append("</del>");
        }

        if (inParagraph) {
            htmlText.append("</p>");
        }

        return htmlText.toString();
    }
}

