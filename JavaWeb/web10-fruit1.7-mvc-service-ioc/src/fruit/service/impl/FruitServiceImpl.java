package fruit.service.impl;

import fruit.service.FruitService;
import fruit.dao.FruitDAO;
import fruit.pojo.Fruit;

import java.util.List;

public class FruitServiceImpl implements FruitService {

    private FruitDAO fruitDAO = null;

    @Override
    public List<Fruit> getFruitList(String keyword, Integer pageNo) {
        return fruitDAO.getFruitList(keyword, pageNo);
    }

    @Override
    public void addFruit(Fruit fruit) {
        fruitDAO.addFruit(fruit);
    }

    @Override
    public Fruit getFruitByFid(Integer fid) {
        return fruitDAO.getFruitById(fid);
    }

    @Override
    public void delFruit(Integer fid) {
        fruitDAO.deleteFruit(fid);
    }

    @Override
    public Integer getPageCount(String keyword) {
        int count = (int) fruitDAO.getFruitCount(keyword);
        int pageCount = (count+5-1)/5;

        return pageCount;
    }

    @Override
    public void updateFruit(Fruit fruit) {
        fruitDAO.updateFruit(fruit);
    }
}
