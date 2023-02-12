package ec.microdev.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class Util {
    public static void addIfNotNull(Map<String, Object> map, String key, String value) {
        if (value != null) {
            map.put(key, value);
        }
    }

    public static String getServerClaimDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        String claimDate = sdf.format(new Date());
        return claimDate.toString();
    }
}
