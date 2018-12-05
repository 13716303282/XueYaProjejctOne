package kdxf.zzh.com.xueyaprojejct.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by ASUS on 2018/11/7.
 */

public class MD5 {
    public static String md5s(String plainText)  {
        String str = new String();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();

            int i;

            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            str = buf.toString();
        }catch (NoSuchAlgorithmException e) {
            e.printStackTrace();

        }
        return str;
    }
}
