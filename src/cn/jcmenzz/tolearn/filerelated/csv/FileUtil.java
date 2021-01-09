package cn.jcmenzz.tolearn.filerelated.csv;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lenovo
 */
public class FileUtil {
    public static final String SEPARATE_FIELD = ",";//字段分隔 英文逗号
    public static final String SEPARATE_LINE = "\r\n";//行分隔

    /**
     * 保存图书信息
     */
    public static void saveBooks(Books books) {
        //判断本地是否存在此文件
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyyMMdd");
        String name = "销售记录" + format.format(date) + ".csv";//拼接文件名
        InputStream in = null;
        try {
            in = new FileInputStream(name);
            if (in != null) {
                in.close();
                createFile(name, true, books);
            }
        } catch (FileNotFoundException e) {
            createFile(name, false, books);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将图书的售出信息保存到本地，通过label标识来判断是修改文件还是新建文件
     *
     * @param name  文件名
     * @param label 文件已存在的标识 true：已存在则修改； false：不存在则新建
     * @param books 图书信息
     */
    public static void createFile(String name, boolean label, Books books) {
        BufferedOutputStream out = null;
        StringBuffer sbf = new StringBuffer();//拼接内容
        try {
            if (label) {//当已存在当天的文件，则在文件内容后追加
                //追加文件内容
                out = new BufferedOutputStream(new FileOutputStream(name, true));
            } else {//不存在当天文件，则新建文件
                //新建文件
                out = new BufferedOutputStream(new FileOutputStream(name));
                String[] fieldSort = new String[]{"图书编号", "图书名称", "购买数量", "单价", "总价", "出版社"};
                //创建表头
                for (String fieldKye : fieldSort) {
                    //新建时将表头存入本地文件
                    sbf.append(fieldKye).append(SEPARATE_FIELD);
                }
            }
            //追加换行符号
            sbf.append(SEPARATE_LINE);
            sbf.append(books.id).append(SEPARATE_FIELD);
            sbf.append(books.name).append(SEPARATE_FIELD);
            sbf.append(books.number).append(SEPARATE_FIELD);
            sbf.append((double) books.price).append(SEPARATE_FIELD);
            sbf.append((double) books.money).append(SEPARATE_FIELD);
            sbf.append(books.Publish).append(SEPARATE_FIELD);
            String str = sbf.toString();
            byte[] b = str.getBytes();
            for (byte value : b) {
                out.write(value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
