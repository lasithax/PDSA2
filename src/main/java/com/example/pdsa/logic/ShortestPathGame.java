package com.example.pdsa.logic;

import java.util.List;
import java.util.Random;

public class ShortestPathGame {

    private static final int MAX_VERTICES = 10;
    private int[][] adjacencyMatrix;
    private static int sourceVertex;

    public AllResult allresult;

    public class AllResult {
        int[] distances; // distances from source vertex to all other vertices
        int[][] paths; // paths from source vertex to each vertex

        // in milliseconds
        long bellmanFordTime;
        long dijkstraTime;

        public void setResult(int[] distances, int[] previousVertex) {
            this.distances = distances;

            for(int i = 0; i < distances.length; i++) {
                int[] path = new int[distances.length];
                int j = 0;
                int currentVertex = i;
                while(currentVertex != sourceVertex) {
                    path[j] = currentVertex;
                    currentVertex = previousVertex[currentVertex];
                    j++;
                }
                path[j] = sourceVertex;
                //reverse path
                for(int k = 0; k < path.length / 2; k++) {
                    int temp = path[k];
                    path[k] = path[path.length - k - 1];
                    path[path.length - k - 1] = temp;
                }

                paths[i] = path;
            }
        }

        public void setBellmanFordTime(long bellmanFordTime) {
            this.bellmanFordTime = bellmanFordTime;
        }

        public void setDijkstraTime(long dijkstraTime) {
            this.dijkstraTime = dijkstraTime;
        }
    }

    public static class DijkstraResult {
        int[] distances; // distances[0] = distance from starting city to city 0
        int[][] path; // paths[0] = paths from starting city to city 0 = [starting city, 2, 3, 4, 0]

        // in milliseconds

    }

    public class Graph {
        public List<Integer> vertices;
        public List<Edge> edges;

        public int[][] adjacencyMatrix;

        public class Edge {
            public int source;
            public int destination;
            public int weight;

            public Edge(int source, int destination, int weight) {
                this.source = source;
                this.destination = destination;
                this.weight = weight;
            }
        }

        public Graph(int[][] matrix){
            constructGraph(matrix);
        }

        private void constructGraph(int[][] matrix) {
            adjacencyMatrix = matrix;

            for(int i = 0; i < matrix.length; i++) {
                vertices.add(i);
            }

            for(int i = 0; i < matrix.length; i++) {
                for(int j = 0; j < matrix.length; j++) {
                    if(matrix[i][j] != 0) {
                        edges.add(new Edge(i, j, matrix[i][j]));
                    }
                }
            }
        }
    }

    public class Result {
        int[] visited;
        int[] distance;
        int[] previousVertex;
        //visited | distance | previousVertex
        // 0      | 0        | 0
        // 1      | 5        | 1
        // 1      | 10       | 2

        Result(int size) {
            visited = new int[size];
            distance = new int[size];
            previousVertex = new int[size];
        }
    }


    ShortestPathGame() {
        adjacencyMatrix = new int[MAX_VERTICES][MAX_VERTICES];
        allresult = new AllResult();
        initializeMatrix();
        initializeSourceVertex();
        calculateShortestPath(sourceVertex, adjacencyMatrix);
    }

    private void initializeMatrix() {
        for(int i = 0; i < MAX_VERTICES; i++) {
            for(int j = 0; j < MAX_VERTICES; j++) {
                if (i == j)
                    adjacencyMatrix[i][j] = 0;
                else
                    adjacencyMatrix[i][j] = adjacencyMatrix[j][i] = new Random().nextInt(46) + 5; // 5 to 50
            }
        }
    }

    private void initializeSourceVertex() {
        sourceVertex = new Random().nextInt(MAX_VERTICES);
    }

    private void calculateShortestPath(int sourceVertex, int[][] adjacencyMatrix) {
        Graph graph = new Graph(adjacencyMatrix);
        bellmanFord(graph, sourceVertex);
        dijkstra(graph, sourceVertex);
    }

    private void bellmanFord(Graph graph, int sourceVertex) {
        long startTime = System.currentTimeMillis();
        int V = graph.vertices.size();
        int E = graph.edges.size();
        Result result = new Result(V);

        for(int i = 0; i < V; i++) {
            result.distance[i] = Integer.MAX_VALUE;
        }
        result.distance[sourceVertex] = 0;

        for(int i = 0; i < V - 1; i++) {
            for(int j = 0; j < E; j++) {
                int u = graph.edges.get(j).source;
                int v = graph.edges.get(j).destination;
                int w = graph.edges.get(j).weight;
                if(result.distance[u] != Integer.MAX_VALUE && result.distance[u] + w < result.distance[v]) {
                    result.distance[v] = result.distance[u] + w;
                    result.previousVertex[v] = u;
                }
            }
        }

        long endTime = System.currentTimeMillis();
        long timeElapsed = endTime - startTime;
        allresult.setResult(result.distance, result.previousVertex);
        allresult.setBellmanFordTime(timeElapsed);
    }

    private void dijkstra(Graph graph, int sourceVertex) {
        long startTime = System.currentTimeMillis();
        int V = graph.vertices.size();
        int E = graph.edges.size();
        Result result = new Result(V);

        for(int i = 0; i < V; i++) {
            result.visited[i] = 0;
            result.distance[i] = Integer.MAX_VALUE;
        }
        result.distance[sourceVertex] = 0;
        result.visited[sourceVertex] = 1;
        result.previousVertex[sourceVertex] = sourceVertex;

        for(int j = 0; j < V; j++) {
            int u = findMinDistance(result.distance, result.visited);
            result.visited[u] = 1;

            for(int v = 0; v < V; v++) {
                if(result.visited[v] == 0 && graph.adjacencyMatrix[u][v] != 0 && result.distance[u] != Integer.MAX_VALUE && result.distance[u] + graph.adjacencyMatrix[u][v] < result.distance[v]) {
                    result.distance[v] = result.distance[u] + graph.adjacencyMatrix[u][v];
                    result.previousVertex[v] = u;
                }
            }
        }

        long endTime = System.currentTimeMillis();
        long timeElapsed = endTime - startTime;
        allresult.setDijkstraTime(timeElapsed);
    }

    private static int findMinDistance(int[] distance, int[] visited) {
        int minDistance = Integer.MAX_VALUE;
        int minDistanceVertex = -1;
        for (int i = 0; i < distance.length; i++) {
            if (visited[i] == 0 && distance[i] < minDistance) {
                minDistance = distance[i];
                minDistanceVertex = i;
            }
        }
        return minDistanceVertex;
    }
}
