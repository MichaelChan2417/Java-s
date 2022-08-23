package Q133_CloneGraph;

import java.util.*;

/**\
 * Create a deep clone of the graph
 */
public class CloneGraph {

    HashMap<Integer, Node> map;
    public Node cloneGraph(Node node){
        if(node == null) return null;
        map = new HashMap<>();
        Node ans = new Node(node.val);

        dfs(ans, node);

        return ans;
    }

    // build the node neighbors same as org
    public void dfs(Node node, Node org){
        map.put(node.val, node);

        for(Node orgNeighbor : org.neighbors){
            // if not visited, then add the new neighbor
            if(!map.containsKey(orgNeighbor.val)){
                // create new node
                Node curNewNeighbor = new Node(orgNeighbor.val);
                dfs(curNewNeighbor, orgNeighbor);
            }
            Node curNeighbor = map.get(orgNeighbor.val);
            node.neighbors.add(curNeighbor);

        }
    }

}

class Node{
    public int val;
    public List<Node> neighbors;

    public Node(){
        this.val = 0;
        this.neighbors = new ArrayList<>();
    }
    public Node(int val){
        this.val = val;
        this.neighbors = new ArrayList<>();
    }
    public Node(int val, List<Node> ng){
        this.val = val;
        this.neighbors = ng;
    }

}