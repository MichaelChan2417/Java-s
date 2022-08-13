package Q721_AccountMerge;

import java.util.*;

public class MergeAccount {
    public List<List<String>> accountsMerge(List<List<String>> accounts){
        // First allocate the Union
        int n = accounts.size();
        UnionFind uf = new UnionFind(n);

        // Assign each email to its id and user's name
        HashMap<String, Integer> emailToId = new HashMap<>();

        for(int i=0; i<n; i++){
            // i means the id here
            List<String> account = accounts.get(i);
            for(int j=1; j<account.size(); j++){
                String email = account.get(j);
                if(!emailToId.containsKey(email)){
                    emailToId.put(email, i);
                }
                else{
                    // these two id are the same person: i and emailToId.get(email)
                    uf.union(i, emailToId.get(email));
                }
            }
        }

        // Then we should combine together based on ID
        HashMap<Integer, List<String>> idToEmails = new HashMap<>();

        // For each ID, assign its emails
        for(Map.Entry<String, Integer> entry : emailToId.entrySet()){
            String email = entry.getKey();
            int key = uf.find(entry.getValue());

            List<String> emails = idToEmails.getOrDefault(key, new ArrayList<>());
            emails.add(email);
            idToEmails.put(key, emails);
        }

        List<List<String>> ans = new ArrayList<>();
        for(int id : idToEmails.keySet()){
            List<String> temp = idToEmails.get(id);
            temp.sort(new Comparator<String>(){
                public int compare(String s1, String s2){
                    return s1.compareTo(s2);
                }
            });

            List<String> added_ans = new ArrayList<>();
            added_ans.add(accounts.get(id).get(0)); // this is the name
            added_ans.addAll(temp);
            ans.add(added_ans);
        }

        return ans;
    }
}

class UnionFind{
    // use to allocate its id
    int[] parent;

    UnionFind(int n){
        parent = new int[n];
        for(int i=0; i<n; i++){
            // each element belongs to itself
            parent[i] = i;
        }
    }

    public void union(int index1, int index2){
        // this means index1 and index2 should be unioned together
        parent[find(index2)] = parent[index1];
    }

    public int find(int index){
        // if the node does not belong to itself
        if(parent[index] != index){
            // then it must have a father which it had already belonged to
            parent[index] = find(parent[index]);
        }

        return parent[index];
    }
}