class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        generate(candidates, target, result, 0, new ArrayList<>());
        return result;
    }

    private static void generate(int[] candidates, int target, List<List<Integer>> result, int start, List<Integer> combination) {
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                continue;
            }
            combination.add(candidates[i]);
            generate(candidates, target - candidates[i], result, i, combination);
            combination.remove(combination.size() - 1);
        }
    }
}