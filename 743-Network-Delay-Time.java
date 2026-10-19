class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
         List<List<int[]>> graph = new ArrayList<>();
        for (int i=0;i<=n;i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] t :times) {
            int u =t[0],v =t[1],w =t[2];
            graph.get(u).add(new int[]{v, w});
        }
        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)->a[0]-b[0]
        );
        pq.add(new int[]{0, k});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int time = cur[0];
            int node = cur[1];
            if (time > dist[node]) continue;

            for (int[] edge : graph.get(node)) {
                int next = edge[0];
                int wt = edge[1];

                if (dist[node] + wt < dist[next]) {
                    dist[next] = dist[node] + wt;
                    pq.add(new int[]{dist[next], next});
                }
            }
        }

        int ans=0;
        for (int i=1;i<=n;i++) {
            if (dist[i] ==Integer.MAX_VALUE) return -1;
            ans = Math.max(ans,dist[i]);
        }

        return ans;
    }
}