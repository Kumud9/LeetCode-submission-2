class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean [] hasinedge= new boolean[n];

        for(List<Integer> e: edges){
            hasinedge[e.get(1)]= true;
        }
        List<Integer> res= new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!hasinedge[i])res.add(i);
        }
        return res;
    }
}