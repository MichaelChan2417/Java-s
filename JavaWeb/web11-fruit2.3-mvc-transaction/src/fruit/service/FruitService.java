package fruit.service;

import fruit.pojo.Fruit;

import java.util.List;

public interface FruitService {
    // get list info on given page
    List<Fruit> getFruitList(String keyword, Integer pageNo);

    // add storage info
    void addFruit(Fruit fruit);

    // find selected id's info
    Fruit getFruitByFid(Integer fid);

    // delete specific record
    void delFruit(Integer fid);

    // get total pages
    Integer getPageCount(String keyword);

    // update selected fruit
    void updateFruit(Fruit fruit);
}
