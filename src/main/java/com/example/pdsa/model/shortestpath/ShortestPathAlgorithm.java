package com.example.pdsa.model.shortestpath;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "shortest_path_algorithm")
public class ShortestPathAlgorithm {
    public ObjectId _id;
    public int bellmanford;
    public int dijkstra;

    public ShortestPathAlgorithm() {
    }

    public ShortestPathAlgorithm(ObjectId _id, int bellmanford, int dijkstra) {
        this._id = _id;
        this.bellmanford = bellmanford;
        this.dijkstra = dijkstra;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public int getBellmanford() {
        return bellmanford;
    }

    public void setBellmanford(int bellmanford) {
        this.bellmanford = bellmanford;
    }

    public int getDijkstra() {
        return dijkstra;
    }

    public void setDijkstra(int dijkstra) {
        this.dijkstra = dijkstra;
    }
}
