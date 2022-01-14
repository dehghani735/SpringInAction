package com.mdt.CrackingInterview.chapter1;

import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author mdt
 */
public class Intro {

    private static final Logger log = getLogger(Intro.class);

    public static void main(String[] args) {
        var words = List.of("a", "b", "c");
        var more  = List.of("d", "e", "f");
        var intro = new Intro();
        // Error-prone: classCastException. use toArray as below which allocates the right kind of array (String[] and of the right size)
        // https://stackoverflow.com/questions/5690351/java-stringlist-toarray-gives-classcastexception
        var merged = intro.merge(words.toArray(new String[words.size()]), more.toArray(new String[words.size()]));
        log.info(String.valueOf(merged));

        var sentence1 = intro.badJoinWords(words.toArray(new String[words.size()]));
        log.info(sentence1);

        var sentence2 = intro.goodJoinWords(words.toArray(new String[words.size()]));
        log.info(sentence2);
    }

    /**
     * Note: Resizing factor in java is 2 for ArrayList (Dynamically resizable arrays)
     * initial size is 10
     *
     * @param words
     * @param more
     * @return The merged array
     */
    public ArrayList<String> merge(String[] words, String[] more) {
        var array = new ArrayList<String>();
        for (var w : words) array.add(w);
        for (var w : more) array.add(w);

        return array;
    }

    /**
     * @param words
     * @return
     */
    String badJoinWords(String[] words) {
        var sentence = "";
        for (var w : words)
            sentence += w;

        return sentence;
    }

    /**
     * Note: Difference between StringBuffer and StringBuilder:
     * StringBuffer: A thread-safe, mutable sequence of characters.A string buffer is like a String, but can be modified.
     * StringBuilder: A mutable sequence of characters. This class provides an API compatible with StringBuffer, but with no guarantee of synchronization.
     * Where possible, it is recommended that this class be used in preference to StringBuffer as it will be faster under most implementations.
     *
     * @param words
     * @return
     */
    String goodJoinWords(String[] words) {
        var sentence = new StringBuilder();
        for (var w : words)
            sentence.append(w);

        return sentence.toString();
    }

    // TODO implement Hashtable, ArrayList, StringBuilder yourself
    // TODO TreeMap Red-Black tree?
    public void hashtable() {
        // TODO read about Dictionary (class)  and Map (Interface)
        Hashtable<String, Integer> numbers = new Hashtable<String, Integer>();
        numbers.put("one", 1);
        numbers.put("two", 2);
        numbers.put("three", 3);
//        To retrieve a number, use the following code:
        Integer n = numbers.get("two");
        if (n != null) {System.out.println("two = " + n);}
    }
}
