// class Solution {
//     class Pair{
//         String node;
//         double wt;
//         Pair(char a,double b){node=a;wt=b;}
//     }
//     public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
//         Map<String,List<Pair>>adj=new HashMap<>();
//         int n=values.length,m=queries.length;
//         for(int i=0;i<n;i++){
//             List<String>t=equations.get(i);
//             double val=values[i];
//             if(!map.containsKey(t.get(0))) map.put(new ArrayList<>());
//             if(!map.containsKey(t.get(1))) map.put(new ArrayList<>());
//             map.get(t.get(1)).add(new Pair(t.get(0),val));
//             map.get(t.get(0)).add(new Pair(t.get(1),1/val));
//         }
//     }
//     public void dijkstra(Map<Character,List<Pair>>adj,)
// }
class Solution {
    class Pair {
        String node;
        double wt;

        Pair(String a, double b) {
            node = a;
            wt = b;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> adj = new HashMap<>();
        Set<String> set = new HashSet<>();
        int n = values.length, m = queries.size();
        for (int i = 0; i < n; i++) {
            List<String> t = equations.get(i);
            double val = values[i];
            if (!adj.containsKey(t.get(0)))
                adj.put(t.get(0), new HashMap<>());
            if (!adj.containsKey(t.get(1)))
                adj.put(t.get(1), new HashMap<>());
            adj.get(t.get(1)).put(t.get(0), val);
            adj.get(t.get(0)).put(t.get(1), 1 / val);
            set.add(t.get(0));
            set.add(t.get(1));
        }
        Map<String, Map<String, Double>> ans = new HashMap<>();
        for (String a : set) {
            for (String b : set) {
                if (!ans.containsKey(a))
                    ans.put(a, new HashMap<>());
                if (!ans.containsKey(b))
                    ans.put(b, new HashMap<>());
                if (a.equals(b)) {
                    ans.get(a).put(b, 1.0);
                    ans.get(b).put(a, 1.0);
                    continue;
                }
                ans.get(a).put(b, (double)Double.MAX_VALUE);
                ans.get(b).put(a, (double)Double.MAX_VALUE);
            }
        }
        double[] sans = new double[m];
        Arrays.fill(sans,-1.0);
        for (int i = 0; i < m; i++) {
            List<String> l = queries.get(i);
            if (!ans.containsKey(l.get(0)) || !ans.containsKey(l.get(1))) {
                continue;
            }
            dijkstra(adj, ans.get(l.get(1)), l.get(1));
            double v= ans.get(l.get(1)).get(l.get(0));
            if(v!=Double.MAX_VALUE) sans[i]=v;
        }
        return sans;
    }

    public void dijkstra(Map<String, Map<String, Double>> adj, Map<String, Double> ans, String nodee) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(a.wt, b.wt));
        pq.add(new Pair(nodee, 1.0));
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            String node = p.node;
            double wt = p.wt;
            // Map<String,Double>map=adj.get(node);
            if (wt > ans.get(node))
                continue;
            for (var e : adj.get(node).entrySet()) {
                String nnode = e.getKey();
                double nwt = e.getValue();
                double twt = wt * nwt;
                if (twt >= ans.get(nnode))
                    continue;
                ans.put(nnode, twt);
                pq.add(new Pair(nnode, twt));
            }
        }
    }
}