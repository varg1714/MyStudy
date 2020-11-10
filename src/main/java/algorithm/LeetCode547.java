package algorithm;

/**
 * @author varg
 * @date 2020/11/10 14:22
 */
public class LeetCode547 {

    public int findCircleNum(int[][] M) {

        int[] visited = new int[M.length];
        int count = 0;

        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] path, int[] visited, int i) {

        for (int j = 0; j < path.length; j++) {
            if (path[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(path, visited, j);
            }
        }

    }

}
