package cn.white.dao;

import cn.white.entity.Goods;

import java.util.List;

public interface GoodsDao {
    void saveGoods(Goods goods);

    List<Goods> selectGoods();
}
