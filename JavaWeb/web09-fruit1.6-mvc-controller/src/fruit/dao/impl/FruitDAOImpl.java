package fruit.dao.impl;

import fruit.dao.FruitDAO;
import fruit.pojo.Fruit;
import myssm.basedao.BaseDAO;

import java.util.List;

public class FruitDAOImpl extends BaseDAO<Fruit> implements FruitDAO {

    @Override
    public List<Fruit> getFruitList() {
        return super.executeQuery("select * from t_fruit");
    }

    @Override
    public List<Fruit> getFruitList(Integer pageNo) {
        return super.executeQuery("select * from t_fruit limit ?, 5", (pageNo-1)*5);
    }

    @Override
    public List<Fruit> getFruitList(String keyword, Integer pageNo) {
        return super.executeQuery("select * from t_fruit where fname like ? or remark like ? limit ?, 5", "%"+keyword+"%", "%"+keyword+"%", (pageNo-1)*5);
    }

    @Override
    public Fruit getFruitById(Integer fid) {
        return super.load("select * from t_fruit where fid = ?", fid);
    }

    @Override
    public void updateFruit(Fruit fruit) {
        String sql = "update t_fruit set fname = ?, price = ?, fcount = ?, remark = ? where fid = ?";
        super.executeUpdate(sql, fruit.getFname(), fruit.getPrice(), fruit.getFcount(), fruit.getRemark(), fruit.getFid());
    }

    @Override
    public void deleteFruit(int fid) {
        String sql = "delete from t_fruit where fid = ?";
        super.executeUpdate(sql, fid);
    }

    @Override
    public void addFruit(Fruit fruit) {
        String sql = "insert t_fruit values(0, ?, ?, ?, ?)";
        super.executeUpdate(sql, fruit.getFname(), fruit.getPrice(), fruit.getFcount(), fruit.getRemark());
    }

    @Override
    public long getFruitCount() {
        return (Long)super.executeComplexQuery("select count(*) from t_fruit")[0];
    }

    @Override
    public long getFruitCount(String keyword) {
        return (Long)super.executeComplexQuery("select count(*) from t_fruit where fname like ? or remark like ?", "%"+keyword+"%", "%"+keyword+"%")[0];
    }
}
