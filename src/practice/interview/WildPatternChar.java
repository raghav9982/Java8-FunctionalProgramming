package practice.interview;

import java.util.HashMap;
import java.util.Map;

public class WildPatternChar {

    // Recursive function to check if the input string matches
    // with a given wildcard pattern
    public static boolean isMatch(String str, int n,
                                  String pattern, int m,
                                  Map<String, Boolean> lookup)
    {
        // construct a unique map key from dynamic elements of the input
        String key = n + "|" + m;

        // if the subproblem is seen before
        if (lookup.containsKey(key)) {
            return lookup.get(key);
        }

        // since the subproblem is seen for the first time, solve it and
        // store its result in a map

        // end of the pattern is reached
        if (m == pattern.length())
        {
            // return true only if the end of the input string is also reached
            lookup.put(key, (n == str.length()));
            return n == str.length();
        }

        // if the input string reaches its end, return when the
        // remaining characters in the pattern are all `*`

        if (n == str.length())
        {
            for (int i = m; i < pattern.length(); i++)
            {
                if (pattern.charAt(i) != '*')
                {
                    lookup.put(key, false);
                    return false;
                }
            }

            lookup.put(key, true);
            return true;
        }

        // if the current wildcard character is `?` or the current character in
        // the pattern is the same as the current character in the input string

        if (pattern.charAt(m) == '?' || pattern.charAt(m) == str.charAt(n))
        {
            // move to the next character in the pattern and the input string
            lookup.put(key, isMatch(str, n + 1, pattern, m + 1, lookup));
        }

        // if the current wildcard character is `*`
        else if (pattern.charAt(m) == '*')
        {
            // move to the next character in the input string or
            // ignore `*` and move to the next character in the pattern

            lookup.put(key, isMatch(str, n + 1, pattern, m, lookup) ||
                    isMatch(str, n, pattern, m + 1, lookup));
        }
        else {
            // we reach here when the current character in the pattern is not a
            // wildcard character, and it doesn't match the current
            // character in the input string

            lookup.put(key, false);
        }

        return lookup.get(key);
    }

    // Check if a string matches with a given wildcard pattern
    public static boolean isMatch(String str, String pattern)
    {
        Map<String, Boolean> lookup = new HashMap<>();
        return isMatch(str, 0, pattern, 0, lookup);
    }

    public static void main(String[] args)
    {
        System.out.println(isMatch("XYXZZXY", "X***Y"));    // true
        System.out.println(isMatch("XYXZZXY", "X*ZZ??"));   // true
        System.out.println(isMatch("XYXZZXY", "*X*X?"));    // true
        System.out.println(isMatch("XYXZZXY", "X***X"));    // false
        System.out.println(isMatch("XYXZZXY", "*"));        // true
    }
}
