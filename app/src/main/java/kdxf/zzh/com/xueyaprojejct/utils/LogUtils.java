package kdxf.zzh.com.xueyaprojejct.utils;

import android.util.Log;

/**
 * Created by ASUS on 2018/11/8.
 */

public class LogUtils {
    public static void Log_i(String className, String msg) {
        if (Config.isprintLog) {
            Log.i( className, msg );
        }
    }
}
