package com.dtkj.utils;

import java.io.File;
import java.math.BigDecimal;

/**
 * Created by sword on 17/3/21
 * Email: 1619153872@qq.com
 * Description: the utils for data unit convert
 */
public class DTDataUnitUtils {
    /**
     * 格式化单位
     *
     * @param size 值
     * @return 值
     */
    public static String getFormatSize(double size) {
        double kiloByte = size / 1024;
        if (kiloByte < 1) {
            return size + "B";
        }

        double megaByte = kiloByte / 1024;
        if (megaByte < 1) {
            BigDecimal result1 = new BigDecimal(Double.toString(kiloByte));
            return result1.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "KB";
        }

        double gigaByte = megaByte / 1024;
        if (gigaByte < 1) {
            BigDecimal result2 = new BigDecimal(Double.toString(megaByte));
            return result2.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "MB";
        }

        double teraBytes = gigaByte / 1024;
        if (teraBytes < 1) {
            BigDecimal result3 = new BigDecimal(Double.toString(gigaByte));
            return result3.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "GB";
        }
        BigDecimal result4 = new BigDecimal(teraBytes);
        return result4.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "TB";
    }

    /**
     * 获取文件或文件夹大小
     *
     * @param file
     * @return
     */
    public static String getFileSize(File file) {
        String cacheSize = "0b";
        try {
            cacheSize = DTDataUnitUtils.getFormatSize(DTDataCleanUtils.getFolderSize(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cacheSize;
    }
}
