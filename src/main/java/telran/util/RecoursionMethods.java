package telran.util;

public class RecoursionMethods {
    public static void f(int a) {
        if (a > 3) {
            f(a - 1);
        }
    }
    public static long factorial(int n) {
        //n! = 1 * 2 * 3 *.....*n
        if(n < 0) {
            n = -n;
        }
        return n == 0 ? 1 : n * factorial(n - 1);
    }
    /**
     * 
     * @param num - any integer number
     * @param degree - any positive number
     * @return num ^ degree
     * limitations:
     * 1. no cycles allowed
     * 2. arithmetic operators + ; - are allowed only
     * 3. bitwise operators like >>, <<, &&, etc disallowe
     */
    public static long pow(int num, int degree) {
        if (degree < 0) {
            throw new IllegalArgumentException();
        }
        return powRecursive(num, degree);
    }
    
    private static long powRecursive(int num, int degree) {
        return (degree == 0) ? 1 : (degree == 1) ? num : multiply(num, powRecursive(num, degree - 1));
    }
    
    private static long multiply(long a, long b) {
        long result = (b == 0) ? 0 : (b > 0) ? add(a, multiply(a, b - 1)) : -multiply(a, -b);
        return result;
    }
    
    private static long add(long a, long b) {
        long result = (b == 0) ? a : (b > 0) ? add(a + 1, b - 1) : add(a - 1, b + 1);
        return result;
    }


    public static int sum(int [] array) {
        return sum(array, array.length);
    }
    private static int sum(int[] array, int length) {
        return length == 0 ? 0 : array[length - 1] + sum(array, length - 1);
    }
    /**
     * 
     * @param x
     * @return x ^ 2
     * limitations:
     * 1. no cycles
     * 2. arithemetic operators only + ; -
     * 3. no bitwise operators
     * 4. no standard and additional methods are allowed
     * 5. no additional fields of the class RecursionMethods are allowed
     */
    public static int square(int x) {
        x = (x < 0) ? -x : x; 
        long result = multiply(x, x); 
        return (x == 0) ? 1 : (int) result; 
    }



    /**
     * 
     * @param string
     * @param subString
     * @return true if subString is actually substring of the given string
     * limitations:
     * 1. no cycles
     * 2. the allowed methods of class String are
     *     2.1 charAt(int index)
     *     2.2 length()
     *     2.3 substring(int beginIndex)
     */
    public static boolean isSubstring(String string, String subString) {
        return isSubstringRecursive(string, subString, 0, 0) || subString.length() == 0;
    }
    
    private static boolean isSubstringRecursive(String string, String subString, int indexString, int indexSubString) {
        boolean isMatch = indexSubString == subString.length();
        boolean reachedEnd = indexString == string.length();
        
        if (isMatch || reachedEnd) {
            return isMatch;
        }
        
        boolean matches = string.charAt(indexString) == subString.charAt(indexSubString);
        return matches
            ? isSubstringRecursive(string, subString, indexString + 1, indexSubString + 1)
            : isSubstringRecursive(string, subString, indexString - indexSubString + 1, 0);
    }
}