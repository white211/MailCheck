package cn.white.Test;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;

import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

import java.io.IOException;

public class QiNiu {
    //设置好账号的ACCESS_KEY和SECRET_KEY
    String ACCESS_KEY = "R2s07DxzycnzR7gNbgf9-6zSDdXqQ7VAE4e7C1tj"; //这两个登录七牛 账号里面可以找到
    String SECRET_KEY = "BDMFX3QIr67ERsv7fsBbGvZxSgzE6tUyCx4H-na2";

    //要上传的空间
    String bucketname = "test"; //填写新建的那个存储空间对象的名称
    //上传到七牛后保存的文件名
    String key = "01.jpg";
    //上传文件的路径
    String FilePath = "f:\\01.jpg";  //本地要上传文件路径

    //密钥配置
    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
//    Configuration config = new Configuration.Builder()
//            .chunkSize(256 * 1024)  //分片上传时，每片的大小。 默认256K
//            .putThreshhold(512 * 1024)  // 启用分片上传阀值。默认512K
//            .connectTimeout(10) // 链接超时。默认10秒
//            .responseTimeout(60) // 服务器响应超时。默认60秒
//            .recorder(null)  // recorder分片上传时，已上传片记录器。默认null
//            .recorder(null, null)  // keyGen 分片上传时，生成标识符，用于片记录器区分是那个文件的上传记录
//            .zone(Zone.zone2) // 设置区域，指定不同区域的上传域名、备用域名、备用IP。
//            .build();
    //创建上传对象
    UploadManager uploadManager = new UploadManager();

    //简单上传，使用默认策略，只需要设置上传的空间名就可以了
    public String getUpToken(){
        return auth.uploadToken(bucketname);
    }
    //普通上传
    public void upload() throws IOException{
        try {
            //调用put方法上传
            Response res = uploadManager.put(FilePath, key, getUpToken());
            //打印返回的信息
            System.out.println(res.isOK());
            System.out.println(res.bodyString());
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            System.out.println(r.toString());
            try {
                //响应的文本信息
                System.out.println(r.bodyString());
            } catch (QiniuException e1) {
                //ignore
            }
        }
    }
    public static void main(String args[]) throws IOException {
        new QiNiu().upload();
    }
}
