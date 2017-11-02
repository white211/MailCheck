package cn.white.controller;

import cn.white.entity.Goods;
import cn.white.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

  @RequestMapping("/addGood.do")
    public String addgood(Goods goods){
      goodsService.saveGoods(goods);
      return "/list";
  }

  @RequestMapping("/list.do")
  public String showGoods(){
        return "/list";
  }

}
