class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<int[]>> adj= new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e : edges ){
            int u= e[0];
            int v= e[1];
            int w = e[2];
           adj.get(u).add(new int[]{v,w});
           adj.get(v).add(new int[]{u,w});

        }
        int res= -1;
        int minreach=n+1;
       for(int src=0;src<n;src++){
        long [] dist= new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[src]=0;
         PriorityQueue<long[]>pq= new PriorityQueue<>(
            (a,b)-> Long.compare(a[0],b[0])
        );
        pq.add(new long[]{0,src}); 
        
        while(!pq.isEmpty()){
            long[] cur=pq.poll();
            long u =cur[0];
            int v= (int)cur[1];

            if(u>dist[v])continue;
            for(int [] nei: adj.get(v)){
                int s=nei[0];
                long w= nei[1];
                if(dist[s]>w+u){
                    dist[s]=w+u;
                    pq.add(new long[] {dist[s],s});
                }
            }


       }
          int count=0;
        for(int i=0;i<n;i++){
            if(i!=src && dist[i]<=distanceThreshold)count++;
        }
         if(count<=minreach){
            minreach=count;
            res= src;
         }

       }
       return res;


    }
}