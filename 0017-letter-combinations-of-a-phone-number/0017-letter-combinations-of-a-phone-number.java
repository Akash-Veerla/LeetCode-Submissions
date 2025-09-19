class Solution {
    private static final Map<Character,String> phoneMap = new HashMap<>();
    static{
        phoneMap.put('2',"abc");
        phoneMap.put('3',"def");
        phoneMap.put('4',"ghi");
        phoneMap.put('5',"jkl");
        phoneMap.put('6',"mno");
        phoneMap.put('7',"pqrs");
        phoneMap.put('8',"tuv");
        phoneMap.put('9',"wxyz"); 
    }
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0) return result;

        Queue<String> queue = new LinkedList<>();
        queue.offer("");
         for(char digit : digits.toCharArray()){
            int size = queue.size();
            String letters = phoneMap.get(digit);
            for(int i = 0 ; i < size; i++){
                String combination = queue.poll();
                for(char letter :letters.toCharArray()){
                    queue.offer(combination + letter);
                }
            }
        }
        result.addAll(queue);
        return result;
    }
}