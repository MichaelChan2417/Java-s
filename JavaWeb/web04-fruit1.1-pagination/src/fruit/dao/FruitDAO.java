package fruit.dao;

import fruit.pojo.Fruit;

import java.util.List;

public interface FruitDAO {
    // get all storage info
    List<Fruit> getFruitList();
    // get the specific storage info on spe page, 5 info each page
    List<Fruit> getFruitList(Integer pageNo);

    // return info based on specific fruitID
    Fruit getFruitById(Integer fid);

    // update the specific fruit
    void updateFruit(Fruit fruit);

    // delete the fruit
    void deleteFruit(int fid);

    // add the fruit
    void addFruit(Fruit fruit);


    // find total records in db
    long getFruitCount();
}
