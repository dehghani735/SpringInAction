package com.mdt.LeetCode;

import java.util.HashSet;

/**
 * Easy
 * <p>
 * Every valid email consists of a local name and a domain name, separated by the '@' sign. Besides lowercase letters, the email may contain one or more '.' or '+'.
 * For example, in "alice@leetcode.com", "alice" is the local name, and "leetcode.com" is the domain name.
 * If you add periods '.' between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name. Note that this rule does not apply to domain names.
 * For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.
 * If you add a plus '+' in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered. Note that this rule does not apply to domain names.
 * For example, "m.y+name@email.com" will be forwarded to "my@email.com".
 * It is possible to use both of these rules at the same time.
 * Given an array of strings emails where we send one email to each emails[i], return the number of different addresses that actually receive mails.*
 * <p>
 * date: 6/13/22
 */
public class P929UniqueEmailAddresses {

    public int numUniqueEmails(String[] emails) {
        var mySet = new HashSet<String>();

        for (var s : emails) {
            var sb     = new StringBuffer();
            var atSign = s.indexOf('@');
            for (var i = 0; i < atSign; i++) {
                if (s.charAt(i) == '.')
                    continue;
                else if (s.charAt(i) == '+')
                    break;
                else
                    sb.append(s.charAt(i));
            }
            for (var i = atSign; i < s.length(); i++)
                 sb.append(s.charAt(i));

            mySet.add(sb.toString());
        }

        return mySet.size();
    }

    /**
     * nick's solution using subsring method
     *
     * @param emails
     * @return
     */
    public int numUniqueEmails2(String[] emails) {
        var mySet = new HashSet<String>();

        for (var s : emails) {
            var sb         = new StringBuffer();
            var atSign     = s.indexOf('@');
            var localName  = s.substring(0, atSign);
            var domainName = s.substring(atSign);

            if (localName.contains("+")) {
                var plusPosition = localName.indexOf("+");
                localName = localName.substring(0, plusPosition);
            }

            localName = localName.replaceAll("\\.", "");
            var newName = localName + domainName;
            mySet.add(newName);
        }

        return mySet.size();
    }
}
