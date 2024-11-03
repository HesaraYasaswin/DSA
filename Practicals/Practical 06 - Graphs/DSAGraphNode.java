public class DSAGraphNode {
    private String label;
    private DSALinkedList<DSAGraphNode> adjacent;
    private boolean visited;

    public DSAGraphNode(String label) {
        this.label = label;
        adjacent = new DSALinkedList<DSAGraphNode>();
        visited = false;
    }

    public String getLabel() {
        return label;
    }

    public void addAdjacent(DSAGraphNode node) {
        adjacent.insertLast(node);
    }

    public boolean hasAdjacent(DSAGraphNode node) {
        return adjacent.contains(node);
    }

    public DSALinkedList<DSAGraphNode> getAdjacentList() {
        return adjacent;
    }

    public void setVisited(boolean b) {
        visited = b;
    }

    public boolean isVisited() {
        return visited;
    }
}