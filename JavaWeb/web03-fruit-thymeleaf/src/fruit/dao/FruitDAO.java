package fruit.dao;

import fruit.pojo.Fruit;

import java.util.List;

public interface FruitDAO {
    // get all the storage list
    List<Fruit> getFruitList();

    // return info based on specific fruitID
    Fruit getFruitById(Integer fid);

    // update the specific fruit
    void updateFruit(Fruit fruit);

    // delete the fruit
    void deleteFruit(int fid);

    // add the fruit
    void addFruit(Fruit fruit);
}
