package cn.white.service;

import cn.white.dao.GoodsDao;
import cn.white.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private JedisPool jedisPool;


    public void saveGoods(Goods goods) {
        goodsDao.saveGoods(goods);
        Jedis jedis = jedisPool.getResource();

        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try{
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(goods);
            byte[] bytes = baos.toByteArray();
            jedis.set("goods:1".getBytes(),bytes);
        }catch (Exception e){
            e.printStackTrace();
        }
//        jedis.hset(goods.getGoods_name(),"price",goods.getGoods_price());
//        jedis.hset(goods.getGoods_name(),"desc",goods.getGoods_desc());
//        jedis.hset(goods.getGoods_name(),"stock",goods.getGoods_stock());
    }

    public List<Goods> selectGoods() {
        return null;
    }
}







