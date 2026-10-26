
import java.util.*;

class Solution {
    class DSU {
        int[] parent;
        int[] size;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int u, int v) {
            int pu = find(u);
            int pv = find(v);

            if (pu == pv) return;

            if (size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            } else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        List<int[]> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int cost = Math.abs(points[i][0] - points[j][0])
                         + Math.abs(points[i][1] - points[j][1]);

                edges.add(new int[]{cost, i, j});
            }
        }

        edges.sort((a, b) -> Integer.compare(a[0], b[0]));

        DSU dsu = new DSU(n);
        int totalCost = 0;
        int count = 0;

        for (int[] edge : edges) {
            int cost = edge[0];
            int u = edge[1];
            int v = edge[2];

            if (dsu.find(u) != dsu.find(v)) {
                dsu.union(u, v);
                totalCost += cost;
                count++;

                if (count == n - 1) break;
            }
        }

        return totalCost;
    }
}
