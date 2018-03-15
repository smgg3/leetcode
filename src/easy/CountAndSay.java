/**The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"

@author Sravani Murakonda
*/
package easy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CountAndSay {

    public String countAndSay(int n) {
        if (n <= 0)
            return null;
        else if (n == 1)
            return "1";
        StringBuffer s = new StringBuffer("1");
        for (int i = 0; i < n - 1; i++) {
            StringBuffer str = s;
            int length = s.length();
            int count = 0;
            s = new StringBuffer();
            for (int j = 0; j < length - 1; j++) {
                if (str.charAt(j) == str.charAt(j + 1)) {
                    count++;

                } else {
                    count++;
                    s.append(count).append(str.charAt(j));
                    count = 0;

                }
            }
            s.append(count + 1).append(str.charAt(length - 1));
        }
        return s.toString();
    }

    @Test
    public void testCountAndSay() {
        assertEquals("1211", countAndSay(4));
        assertEquals(null, countAndSay(-1));
    }

}
