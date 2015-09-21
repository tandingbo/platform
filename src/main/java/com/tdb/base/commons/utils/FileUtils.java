package com.tdb.base.commons.utils;

import java.io.File;
import java.io.FileWriter;

/**
 * ClassName: CoreConstant
 * Description:
 * Author: Tandingbo
 * Date: 2015/9/18 16:02
 */
public class FileUtils {
    public static void save(String path, String data) {
        try {
            File file = new File(path);
            File dir = new File(path.substring(0, path.lastIndexOf("/")));
            if (!dir.exists()) {
                dir.mkdirs();
            }
            if (data == null) {
                if (!file.exists()) {
                    file.mkdirs();
                }
            } else {
                FileWriter out = new FileWriter(file);
                out.write(data);
                out.flush();
                out.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
