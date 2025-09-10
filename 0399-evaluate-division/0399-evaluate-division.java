class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int len = queries.size();
        double[] result = new double[len];
        Set<String> seen = new HashSet<>();
        Map<String, Node> nodes = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            List<String> s = equations.get(i);
            String top = s.get(0);
            String bot = s.get(1);
            double val = values[i];
            Node botN = new Node(bot);
            Node topN = new Node(top);
            if (seen.contains(top)) {
                topN = nodes.get(top);
            } else {
                nodes.put(top, topN);
            }
            if (seen.contains(bot)) {
                botN = nodes.get(bot);
            } else {
                nodes.put(bot, botN);
            }
            seen.add(top);
            seen.add(bot);
            botN.connections.add(new Connection(botN, topN, 1 / val));
            topN.connections.add(new Connection(topN, botN, val));
        }

        for (int i = 0; i < queries.size(); i++) {
            List<String> q = queries.get(i);
            String top = q.get(0);
            String bot = q.get(1);
            result[i] = dfs(nodes.get(top), bot, 1, new HashSet<>(), nodes.size());
        }

        return result;
    }

    private double dfs(Node topN, String bot, double curr, Set<Node> visited, int size) {
        if (!visited.contains(topN) && topN != null) {
            visited.add(topN);
            if (topN.equation.equals(bot)) {
                return curr;
            }
            for (int i = 0; i < topN.connections.size(); i++) {
                Connection co = topN.connections.get(i);
                double d = dfs(co.to, bot, curr * co.value, visited, size);
                if (d == -1 && i == topN.connections.size() - 1 && visited.size() == size) {
                    return -1;
                } else if (d != -1) {
                    return d;
                }
            }
        }
        return -1;
    }

    class Node {
        final String equation;
        List<Connection> connections;

        public Node(String equation) {
            this.equation = equation;
            this.connections = new ArrayList<>();
        }

    }

    class Connection {
        final Node from;
        final Node to;
        final Double value;

        public Connection(Node from, Node to, Double value) {
            this.from = from;
            this.to = to;
            this.value = value;
        }
    }
}