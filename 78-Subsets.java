class Solution {
    public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> ans= new ArrayList<>();
    List<Integer> list= new ArrayList<>();
    // Arrays.sort(nums);
    func(ans,list,0,nums);
    return ans;

    }
    public void func(List<List<Integer>> ans, List<Integer>list, int idx,int[] nums ){
        ans.add(new ArrayList<>(list));
        for(int i=idx;i<nums.length;i++){
         list.add(nums[i]);
         func(ans, list,i+1,nums);
         list.remove(list.size()-1);

        }
    }
}