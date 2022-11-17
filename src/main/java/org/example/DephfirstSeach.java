package org.example;

import org.graphstream.algorithm.Algorithm;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;

public class DephfirstSeach implements Algorithm {
    private Graph graph;
    int clock;

    @Override
    public void init(Graph graph) {
        this.graph = graph;
    }

    @Override
    public void compute() {
        graph.forEach(v -> v.removeAttribute("visited"));
        clock = 0;
        Explorer e = new Explorer(true, v -> graph.setAttribute("pre", clock++),
                v -> v.setAttribute("post", clock++));
        graph.nodes().filter(v -> !v.hasAttribute("visited")).forEach(e::explore);

    }
    public int getPre(Node v){
        return v.getAttribute("post",Integer.class);
    }
    public int getPost(Node v){
        return v.getAttribute("post", Integer.class);
    }
}
