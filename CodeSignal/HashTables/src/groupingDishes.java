import java.util.*;

public class groupingDishes {
    String[][] Mysolution(String[][] dishes) {
        HashMap<String, ArrayList<String>> ings = new HashMap<>();

        for(String[] strings : dishes){
            String ing = strings[0];
            for(int i=1; i<strings.length; i++){
                ArrayList<String> cur_ing = ings.getOrDefault(strings[i], new ArrayList<String>());
                cur_ing.add(ing);
                ings.put(strings[i], cur_ing);
            }
        }

        ArrayList<String> keys = new ArrayList<String>();
        Iterator iter = ings.entrySet().iterator();

        // get the keys settled first
        while(iter.hasNext()){
            Map.Entry entry = (Map.Entry) iter.next();
            List<String> values = (List<String>)entry.getValue();
            if(values.size() >= 2){
                keys.add((String) entry.getKey());
            }
        }
        keys.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        String[] a = new String[]{};
        String[][] ans = new String[keys.size()][];
        int index = 0;

        for(String key : keys){
            ArrayList<String> k_ing = ings.get(key);
            k_ing.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });

            k_ing.add(0, key);
            String[] temp = k_ing.toArray(a);
            ans[index++] = temp;
        }

        return ans;
    }


    /**
     * Other's Solution
     * @param dishes
     * @return
     */
    String[][] Osolution(String[][] dishes) {
        // this step is same: setting up the map for ingred to dishes
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(String[] ingred: dishes){
            for(int i = 1; i < ingred.length; i++){
                if(map.containsKey(ingred[i])){
                    ArrayList<String> foods = map.get(ingred[i]);
                    foods.add(ingred[0]);
                    map.put(ingred[i],foods);
                }else{
                    ArrayList<String> foods = new ArrayList<>();
                    foods.add(ingred[0]);
                    map.put(ingred[i],foods);
                }
            }
        }

        ArrayList<String[]> list = new ArrayList<>();
        for(String ingred:map.keySet()){
            ArrayList<String> foods = map.get(ingred);
            if(foods.size()>1){
                Collections.sort(foods);
                String[] fin = new String[foods.size()+1];
                fin[0]=ingred;
                for(int i = 0; i < foods.size(); i++)
                    fin[i+1]=foods.get(i);
                list.add(fin);
            }
        }

        Collections.sort(list,(a,b)->a[0].compareTo(b[0]));
        return list.toArray(new String[0][]);
    }

}
