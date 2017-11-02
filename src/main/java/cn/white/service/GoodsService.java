package cn.white.service;

import cn.white.entity.Goods;

import java.util.List;

public interface GoodsService {
    void saveGoods(Goods goods);

    List<Goods> selectGoods();
}
