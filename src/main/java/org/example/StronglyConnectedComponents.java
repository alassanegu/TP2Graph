package org.example;

import org.graphstream.algorithm.Algorithm;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;

import java.util.Deque;
import java.util.LinkedList;

public class StronglyConnectedComponents implements Algorithm {
    private Graph graph;
    private Deque<Node> stack = new LinkedList<>();
    private int sccCount;

    @Override
    public void init(Graph graph) {
        this.graph = graph;
    }

    @Override
    public void compute() {
        graph.forEach(v -> v.removeAttribute("visited"));
        Explorer e1 = new Explorer(false, v -> {}, stack::push);
        graph.nodes().filter(v -> !v.hasAttribute("visited")).forEach(e1::explore);

        graph.forEach(v -> v.removeAttribute("visited"));
        Explorer e2 = new Explorer(true, v -> v.setAttribute("scc", sccCount),v -> {});
        stack.stream().filter(v -> !v.hasAttribute("visited")).forEach(v -> {
            e2.explore(v);
            sccCount ++;
        });
    }

    public int getSccCount(){
        return sccCount;
    }
    public int getScc(Node v){
        return v.getAttribute("scc", Integer.class);
    }
}
