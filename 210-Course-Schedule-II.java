class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
 
      List<List<Integer>> adj= new ArrayList<>();
     int [] ans= new int [n];

       int []ind= new int [n];
          for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pr : prerequisites) {
            int c0 = pr[0];
            int c1 = pr[1];

            adj.get(c1).add(c0);
            ind[c0]++;
        }
       Queue<Integer> que= new LinkedList<>();
       for(int i=0;i<n;i++){
        if(ind[i]==0)que.offer(i);
       }
       int idx=0;
       while(!que.isEmpty()){
        int curr= que.poll();
        ans[idx++]=curr;

            for (int next : adj.get(curr)) {
                ind[next]--;

            if(ind[next]==0){
                que.offer(next);
            }

          }
        }

       
    
   if (idx != n) {
    return new int[0];
}
return ans;

    }
}
