package kdxf.zzh.com.xueyaprojejct.http;


import java.io.IOException;

import okhttp3.Call;

/**
 * Created by ASUS on 2018/11/7.
 */

public interface RequestCallBack <String>{
    /**
     * 请求成功是的回调
     * @param call
     * @param t
     */
    public void sucess(Call call, String t);
    public void fail(Call call, IOException e);
}
