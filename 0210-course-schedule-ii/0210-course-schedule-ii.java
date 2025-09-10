class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Kahn's Algo
        int[] inDegree = new int[numCourses];
        int[] result = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] courses : prerequisites) {
            // courses[0] = course, courses[1] = precourse
            int course = courses[0];
            int pre = courses[1];
            graph.get(pre).add(course);
            inDegree[course]++;
        }

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0)
                queue.offer(i);
        }

        int index = 0;

        while (!queue.isEmpty()) {
            int course = queue.poll();
            result[index++] = course;

            for (int neighbor : graph.get(course)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }

        }

        return index == numCourses ? result : new int[0];
    }
}