package com.lv.util;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lvsr
 * on 2018/07/25 17:57
 */
public class FileTraversal {
    public static void main(String[] args) {
       /*File f = new File("E:\\test.pdf");
       if (f.exists() && f.isFile()){
           System.out.print(f.length());
       }else{
           System.out.print("do not find");
       }*/
        File file = new File("E:\\report");
        List<Map<String, String>> list = getListFiles("E:\\report", "", true);
        for (Map<String, String> fileName : list) {
            System.out.println(fileName);
        }
        //通过stream遍历list集合
        /*list.stream()
                .forEach(item -> {
                    System.out.println(item);
                });*/
        System.out.println(list.size());
        try {
            System.out.println(FormetFileSize(getFileSize(file)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return
     * @Author simperLv
     * @Description //TODO
     * @Date 2018/07/27  19:30
     * @Param
     */
    public static List<Map<String, String>> getListFiles(String path, String suffix, boolean isdepth) {
        List<Map<String, String>> lstFileNames = new ArrayList<Map<String, String>>();
        //List<Long> lstFileSizes = new ArrayList<Long>();
        File file = new File(path);
        return FileTraversal.listFile(lstFileNames, file, suffix, isdepth);
    }

    private static List<Map<String, String>> listFile(List<Map<String, String>> lstFileNames, File f, String suffix, boolean isdepth) {
        //若是目录，采用递归的方法遍历子目录
        File[] t = f.listFiles();
        if (f.isDirectory()) {
            for (int i = 0; i < t.length; i++) {
                if (isdepth || t[i].isFile()) {
                    listFile(lstFileNames, t[i], suffix, isdepth);
                }
            }
        } else {
            String filePath = f.getAbsolutePath();
            long fileSize = f.length();
            Map<String, String> map = new HashMap<String, String>();
            int begIndex = filePath.lastIndexOf("."); // 最后一个.(即后缀名前面的.)的索引
            if (!suffix.equals("")) {
                String tempsuffix = "";
                if (begIndex != -1) {
                    tempsuffix = filePath.substring(begIndex + 1,
                            filePath.length());
                    if (tempsuffix.equals(suffix)) {
                        String fileSizes = FormetFileSize(fileSize);
                        //String filePaths = filePath.substring(begIndex+1,filePath.length());
                        map.put(filePath, fileSizes);
                        lstFileNames.add(map);
                    }
                }

            } else {
                //String filePaths = filePath.substring(begIndex+1,filePath.length());
                String fileSizes = FormetFileSize(fileSize);
                map.put(filePath, fileSizes);
                lstFileNames.add(map);
            }
        }
        return lstFileNames;
    }

    // 取得文件夹大小
    public static long getFileSize(File f) throws Exception {
        long size = 0;
        File flist[] = f.listFiles();
        for (int i = 0; i < flist.length; i++) {
            if (flist[i].isDirectory()) {
                size = size + getFileSize(flist[i]);
            } else {
                size = size + flist[i].length();
            }
        }
        return size;
    }

    public static String FormetFileSize(long fileS) {// 转换文件大小
        DecimalFormat df = new DecimalFormat("#.00");
        String fileSizeString = "";
        if (fileS < 1024) {
            fileSizeString = df.format((double) fileS) + "B";
        } else if (fileS < 1048576) {
            fileSizeString = df.format((double) fileS / 1024) + "K";
        } else if (fileS < 1073741824) {
            fileSizeString = df.format((double) fileS / 1048576) + "M";
        } else {
            fileSizeString = df.format((double) fileS / 1073741824) + "G";
        }
        return fileSizeString;
    }

}
