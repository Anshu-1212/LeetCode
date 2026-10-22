// class Solution {
//     public int[] sumOfDistancesInTree(int n, int[][] edges) {
//         List<List<Integer>> adj = new ArrayList<>();
//         for (int i = 0; i < n; i++)
//             adj.add(new ArrayList<>());
//         for (int[] e : edges) {
//             adj.get(e[0]).add(e[1]);
//             adj.get(e[1]).add(e[0]);
//         }
//         int[][] dp = new int[n][n];
//         for (int[] a : dp)
//             Arrays.fill(a, -1);
//         int[] ans = new int[n];
//         for (int i = 0; i < n; i++) {
//             int s = 0;
//             for (int j = 0; j < n; j++) {
//                 s += helper(i, j, adj, dp, -1);
//             }
//             ans[i] = s;
//         }
//         return ans;
//     }

//     public int helper(int st, int end, List<List<Integer>> adj, int[][] dp, int p) {
//         if (st == end) {
//             return 0;
//         }
//         if (dp[st][end] != -1)
//             return dp[st][end];
//         int dist = -1;
//         for (int a : adj.get(st)) {
//             if (a == p)
//                 continue;
//             int v = helper(a, end, adj, dp, st);
//             if (v != -1) {
//                 dist = v;
//                 break;
//             }
//         }
//         if (dist == -1)
//             return -1;
//         return dp[st][end] = 1 + dist;
//     }
// }

class Solution {
    int[] path;
    int[] size;
    int[] ans;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        path = new int[n];
        size = new int[n];
        sizeSum(0, -1, adj);
        pathSum(0, -1, adj);
        /*
        0-->1
        path[u]-=path[v]
        path[u]-=size[v]
        size[u]-=sie[v]
        size[v]+=size[u]
        path[v]+=path[u]
        path[v]+=size[u]
        */
        ans = new int[n];
        helper(0, -1, adj);
        return ans;
    }

    public int pathSum(int i, int p, List<List<Integer>> adj) {
        int ans = 0;
        for (int a : adj.get(i)) {
            if (a == p)
                continue;
            int v = pathSum(a, i, adj);
            ans += (v + size[a]);
        }
        return path[i] = ans;
    }

    public int sizeSum(int i, int p, List<List<Integer>> adj) {
        int ans = 1;
        for (int a : adj.get(i)) {
            if (a == p)
                continue;
            int v = sizeSum(a, i, adj);
            ans += v;
        }
        return size[i] = ans;
    }

    public void helper(int i, int p, List<List<Integer>> adj) {
        ans[i] = path[i];
        for (int a : adj.get(i)) {
            if (a == p)
                continue;
            int u = i, v = a;
            path[u] -= path[v];
            path[u] -= size[v];
            size[u] -= size[v];
            size[v] += size[u];
            path[v] += path[u];
            path[v] += size[u];
            helper(a, i, adj);
            path[v] -= size[u];
            path[v] -= path[u];
            size[v] -= size[u];
            size[u] += size[v];
            path[u] += size[v];
            path[u] += path[v];
        }
    }
}