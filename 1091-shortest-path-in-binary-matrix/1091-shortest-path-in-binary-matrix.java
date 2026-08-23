// class Solution {
//     public class Node {
//         int i;
//         int j;

//         Node(int i, int j) {
//             this.i = i;
//             this.j = j;
//         }

//         @Override
//         public boolean equals(Object o) {
//             if (this == o)
//                 return true;
//             if (!(o instanceof Node))
//                 return false;
//             Node node = (Node) o;
//             return i == node.i && j == node.j;
//         }

//         @Override
//         public int hashCode() {
//             return Objects.hash(i, j);
//         }
//     }

//     public int shortestPathBinaryMatrix(int[][] grid) {
//         int n = grid.length;
//         int m = grid[0].length;
//         boolean[][] isVis = new boolean[n][m];
//         Queue<Node> q = new LinkedList<>();
//         HashMap<Node, Integer> h = new HashMap<>();
//         if (grid[0][0] == 0) {
//             q.add(new Node(0, 0));
//             h.put(new Node(0, 0), 1);
//             isVis[0][0] = true;
//         }
//         while (!q.isEmpty()) {
//             Node t = q.poll();
//             int i = t.i;
//             int j = t.j;
//             int level = h.get(t);
//             if (i - 1 >= 0 && j - 1 >= 0 && !isVis[i - 1][j - 1] && grid[i - 1][j - 1] == 0) {
//                 Node s = new Node(i - 1, j - 1);
//                 q.add(s);
//                 isVis[i - 1][j - 1] = true;
//                 h.put(s, level + 1);
//             }
//             if (i - 1 >= 0 && !isVis[i - 1][j] && grid[i - 1][j] == 0) {
//                 Node s = new Node(i - 1, j);
//                 q.add(s);
//                 isVis[i - 1][j] = true;
//                 h.put(s, level + 1);
//             }
//             if (i - 1 >= 0 && j + 1 < m && !isVis[i - 1][j + 1] && grid[i - 1][j + 1] == 0) {
//                 Node s = new Node(i - 1, j + 1);
//                 q.add(s);
//                 isVis[i - 1][j + 1] = true;
//                 h.put(s, level + 1);
//             }
//             if (j + 1 < m && !isVis[i][j + 1] && grid[i][j + 1] == 0) {
//                 Node s = new Node(i, j + 1);
//                 q.add(s);
//                 isVis[i][j + 1] = true;
//                 h.put(s, level + 1);
//             }
//             if (i + 1 < n && j + 1 < m && !isVis[i + 1][j + 1] && grid[i + 1][j + 1] == 0) {
//                 Node s = new Node(i + 1, j + 1);
//                 q.add(s);
//                 isVis[i + 1][j + 1] = true;
//                 h.put(s, level + 1);
//             }
//             if (i + 1 < n && !isVis[i + 1][j] && grid[i + 1][j] == 0) {
//                 Node s = new Node(i + 1, j);
//                 q.add(s);
//                 isVis[i + 1][j] = true;
//                 h.put(s, level + 1);
//             }
//             if (i + 1 < n && j - 1 >= 0 && !isVis[i + 1][j - 1] && grid[i + 1][j - 1] == 0) {
//                 Node s = new Node(i + 1, j - 1);
//                 q.add(s);
//                 isVis[i + 1][j - 1] = true;
//                 h.put(s, level + 1);
//             }
//             if (j - 1 >= 0 && !isVis[i][j - 1] && grid[i][j - 1] == 0) {
//                 Node s = new Node(i, j - 1);
//                 q.add(s);
//                 isVis[i][j - 1] = true;
//                 h.put(s, level + 1);
//             }
//         }
//         Node sa = new Node(n - 1, m - 1);
//         return h.containsKey(sa) ? h.get(sa) : -1;
//     }
// }

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] isVis = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        int[][] dir = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 } };
        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1)
            return -1;
        q.add(new int[] { 0, 0, 1 });
        isVis[0][0] = true;
        while (!q.isEmpty()) {
            int[] t = q.poll();
            int i = t[0];
            int j = t[1];
            int level = t[2];
            if (i == n - 1 && j == m - 1)
                return level;
            for (int[] d : dir) {
                int x = i + d[0], y = j + d[1];
                if (x < 0 || x >= n || y < 0 || y >= m)
                    continue;
                if (isVis[x][y] || grid[x][y] == 1)
                    continue;
                q.add(new int[] { x, y, level + 1 });
                isVis[x][y] = true;
            }

        }
        return -1;
    }
}