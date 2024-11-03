import java.util.ArrayList;

public class DSAGraph {
	private DSALinkedList<DSAGraphNode> vertices;
	private boolean isDirected;
	
	public DSAGraph(boolean isDirected) {
	    vertices = new DSALinkedList<DSAGraphNode>();
	    this.isDirected = isDirected;
	}

	public void addVertex(String label) {
	    if (getVertex(label) == null) {
	        vertices.insertLast(new DSAGraphNode(label));
	    }
	}

	public void addEdge(String label1, String label2) {
	    DSAGraphNode node1 = getVertex(label1);
	    DSAGraphNode node2 = getVertex(label2);

	    if (node1 == null) {
	        node1 = new DSAGraphNode(label1);
	        vertices.insertLast(node1);
	    }
	    if (node2 == null) {
	        node2 = new DSAGraphNode(label2);
	        vertices.insertLast(node2);
	    }

	    node1.addAdjacent(node2);
	    if (!isDirected) {
	        node2.addAdjacent(node1);
	    }
	}

	public DSALinkedList<DSAGraphNode> getVertices() {
	    return vertices;
	}

	public boolean isDirected() {
	    return isDirected;
	}

	private DSAGraphNode getVertex(String label) {
	    for (DSAGraphNode vertex : vertices) {
	        if (vertex.getLabel().equals(label)) {
	            return vertex;
	        }
	    }
	    return null;
	}

	public void displayAsList() {
	    System.out.println("Vertices:");
	    for (DSAGraphNode vertex : vertices) {
	        System.out.print(vertex.getLabel() + " -> ");
	        DSALinkedList<DSAGraphNode> adjacentList = vertex.getAdjacentList();
	        for (DSAGraphNode adjacent : adjacentList) {
	            System.out.print(adjacent.getLabel() + " ");
	        }
	        System.out.println();
	    }
	}

	public void displayAsMatrix() {
		int numVertices = vertices.getCount();
	    System.out.print("  ");
	    for (DSAGraphNode vertex : vertices) {
	        System.out.print(vertex.getLabel() + " ");
	    }
	    System.out.println();
	    for (DSAGraphNode vertex : vertices) {
	        System.out.print(vertex.getLabel() + " ");
	        for (DSAGraphNode adjacent : vertices) {
	            if (vertex.hasAdjacent(adjacent)) {
	                System.out.print("1 ");
	            } else {
	                System.out.print("0 ");
	            }
	        }
	        System.out.println();
	    }
	}
	
	public void depthFirstSearch() {
	    DSALinkedList<DSAGraphNode> visited = new DSALinkedList<DSAGraphNode>();
	    DSALinkedList<DSAGraphNode> stack = new DSALinkedList<DSAGraphNode>();

	    for (DSAGraphNode vertex : vertices) {
	        vertex.setVisited(false);
	    }

	    for (DSAGraphNode vertex : vertices) {
	        if (!vertex.isVisited()) {
	            vertex.setVisited(true);
	            stack.insertLast(vertex);

	            while (!stack.isEmpty()) {
	                DSAGraphNode v = stack.getLast();

	                boolean foundUnvisited = false;
	                for (DSAGraphNode w : v.getAdjacentList()) {
	                    if (!w.isVisited()) {
	                        visited.insertLast(v);
	                        visited.insertLast(w);
	                        w.setVisited(true);
	                        stack.insertLast(w);
	                        foundUnvisited = true;
	                        break;
	                    }
	                }

	                if (!foundUnvisited) {
	                    stack.removeLast();
	                }
	            }
	        }
	    }

	    System.out.println("Depth First Search:");
	    for (DSAGraphNode vertex : visited) {
	        System.out.print(vertex.getLabel() + " ");
	    }
	    System.out.println();
	}

	public void breadthFirstSearch() {
	    DSALinkedList<DSAGraphNode> visited = new DSALinkedList<DSAGraphNode>();
	    DSALinkedList<DSAGraphNode> queue = new DSALinkedList<DSAGraphNode>();

	    for (DSAGraphNode vertex : vertices) {
	        vertex.setVisited(false);
	    }

	    for (DSAGraphNode vertex : vertices) {
	        if (!vertex.isVisited()) {
	            vertex.setVisited(true);
	            queue.insertLast(vertex);

	            while (!queue.isEmpty()) {
	                DSAGraphNode v = queue.removeFirst();
	                visited.insertLast(v);

	                for (DSAGraphNode w : v.getAdjacentList()) {
	                    if (!w.isVisited()) {
	                        visited.insertLast(w);
	                        w.setVisited(true);
	                        queue.insertLast(w);
	                    }
	                }
	            }
	        }
	    }

	    System.out.println("Breadth First Search:");
	    for (DSAGraphNode vertex : visited) {
	        System.out.print(vertex.getLabel() + " ");
	    }
	    System.out.println();
	}
}