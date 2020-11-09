package algorithm;

/**
 * @author varg
 * @date 2020/8/28 18:23
 */
public class Solution {

    public int numberOfPatterns(int m, int n) {

        int count = 0;

        for (int i = m; i <= n; i++) {

            int[] temp = new int[m];
            for (int j = 1; j <= 9 - m; j++) {
                for (int k = j; k < m; k++) {
                    temp[k - 1] = k;
                }
                for (int k = m; k <= 9; k++) {
                    temp[m - 1] = k;

                    boolean fit = true;
                    for (int g = 0; g < m - 1; g++) {
                        if (!getRate(temp[g], temp[g + 1]) && Math.abs(temp[g + 1] - temp[g]) != 1) {
                            fit = false;
                        }
                    }

                    if (fit) {
                        count++;
                    }
                }
            }

        }

        return count;
    }

    public int[] getPosition(int n) {

        int[] result = new int[2];
        if (n == 1) {
            result[0] = 0;
            result[1] = 0;
        }
        if (n == 2) {
            result[0] = 0;
            result[1] = 1;
        }
        if (n == 3) {
            result[0] = 0;
            result[1] = 2;
        }
        if (n == 4) {
            result[0] = 1;
            result[1] = 0;
        }
        if (n == 5) {
            result[0] = 1;
            result[1] = 1;
        }
        if (n == 6) {
            result[0] = 1;
            result[1] = 2;
        }
        if (n == 7) {
            result[0] = 2;
            result[1] = 0;
        }
        if (n == 8) {
            result[0] = 2;
            result[1] = 1;
        }
        if (n == 9) {
            result[0] = 2;
            result[1] = 2;
        }

        return result;

    }

    public boolean getRate(int m, int n) {

        int[] position1 = getPosition(m);
        int[] position2 = getPosition(n);

        if ((position1[0] - position1[0]) == 0) {
            return false;
        }
        int i = (position1[1] - position1[1]) / (position1[0] - position1[0]);
        return i == 1;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        System.out.println(solution.numberOfPatterns(3, 6));
    }
}
