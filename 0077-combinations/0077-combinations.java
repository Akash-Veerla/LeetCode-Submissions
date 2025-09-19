class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        generate(list, temp, 1, 0, k, n);
        return list;
    }

    public void generate(List<List<Integer>> list, List<Integer> temp, int num, int length, int k, int n){
        if(length == k){
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i = num; i <= n; i++){
            temp.add(i);
            generate(list, temp, i+1, length+1, k, n);
            temp.remove(temp.size()-1);
        }
    }
}