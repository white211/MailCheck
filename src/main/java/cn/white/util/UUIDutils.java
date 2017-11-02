package cn.white.util;

import java.util.UUID;

public class UUIDutils {

    public  static  String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
