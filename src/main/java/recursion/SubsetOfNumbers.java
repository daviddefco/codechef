package recursion;

/**
 * Given a num­ber N, Write an algorithm to print all possible su­sets with Sum equal to N
 * Example: N=4
 * 1111
 * 112
 * 121
 * 13
 * 211
 * 22
 * 31
 * 4
 */
public class SubsetOfNumbers {
    public void subSet(int n, String solution) {
        if (n == 0) {
            System.out.println(solution);
            return;
        } else {
            for (int i = 1; i <= n; i++) {
                solution += i;
                subSet(n - i, solution);
                solution = solution.substring(0, solution.length() -1);
            }
        }
    }

    public static void main(String[] args) {
        SubsetOfNumbers problem = new SubsetOfNumbers();
        problem.subSet(4, "");
    }
}