class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
      List<List<Integer>> adj= new ArrayList<>();
      List<Integer> ans= new ArrayList<>();

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
       while(!que.isEmpty()){
        int curr= que.poll();
        ans.add(curr);

            for (int next : adj.get(curr)) {
                ind[next]--;

            if(ind[next]==0){
                que.offer(next);
            }

          }
        }

       
    
    return ans.size()==n;

    }
}