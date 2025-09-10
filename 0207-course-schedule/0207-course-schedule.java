class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = new List[numCourses];
        int[] indegree = new int[numCourses];
        ArrayList<Integer> ans = new ArrayList<>();

        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prereq = pair[1];
            if (adjList[prereq] == null) {
                adjList[prereq] = new ArrayList<>();
            }
            adjList[prereq].add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int course = queue.poll();
            ans.add(course);
            if (adjList[course] != null) {
                for (int next : adjList[course]) {
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
        }

        return numCourses == ans.size();
    }
}