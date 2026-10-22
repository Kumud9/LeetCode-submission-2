class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int [][] dist= new int [n][n];
        int INF = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
        
                Arrays.fill(dist[i],INF);
                dist[i][i]=0;
            
        }
        for(int[] e : edges){
    int u = e[0];
    int v = e[1];
    int w = e[2];
    dist[u][v] = w;
    dist[v][u] = w;
}
     
        for(int k=0;k<n;k++){
        for(int i=0;i<n;i++){
          for(int j=0;j<n;j++){
            if(dist[i][k]!=INF && dist[k][j]!=INF)
             dist[i][j]= Math.min(dist[i][j],dist[i][k]+dist[k][j]);
          
          }
        }
        }
      int city=-1;
      int mincnt=Integer.MAX_VALUE;
      for(int i=0;i<n;i++){
        int count=0;

        for(int j=0;j<n;j++){
            if(i!=j && dist[i][j]<=distanceThreshold)count++;
        }
        if(count<=mincnt){
            mincnt=count;
            city=i;
        }
      }
      return city;
    }
}