package cn.jcmenzz.tolearn.filerelated.csv;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 记录和操作图书信息
 */
public class RecordBooksOrder {
    static ArrayList<Books> booksList = new ArrayList<Books>();//创建书架

    public static void main(String[] args) {
        init();
        // 将书架上所有图书信息打印出来
        for (int i = 0; i < booksList.size(); i++) {
            System.out.println(booksList.get(i));
        }
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.print("请输入图书编号：");
            int bookId = scan.nextInt();
            Books stockBooks = getBooksById(bookId);
            if (stockBooks != null) {
                System.out.println("当前图书信息" + stockBooks);
                System.out.print("请输入购买数量：");
                int bookNumber = scan.nextInt();
                if (bookNumber <= stockBooks.number) {//判断库存是否足够
                    //将输入信息封装成Books对象
                    Books books = new Books(stockBooks.id, stockBooks.name, stockBooks.price, bookNumber, stockBooks.price * bookNumber, stockBooks.Publish);
                    //将本条数据保存在本地文件中
                    FileUtil.saveBooks(books);
                    //修改库存
                    stockBooks.setNumber(stockBooks.number - bookNumber);
                } else {
                    System.out.println("库存不足！");
                }
            } else {
                System.out.println("图书编号输入错误！");
            }
        }
    }

    /**
     * 初始化书架上的图书信息 将图书放到书架上
     */
    private static void init() {
        Books goods1 = new Books(101, "Java基础入门", 44.50, 100, 4450.00, "清华大学出版社");
        Books goods2 = new Books(102, "Java编程思想", 108.00, 50, 5400.00, "机械工业出版社");
        Books goods3 = new Books(103, "疯狂Java讲义", 99.00, 100, 9900.00, "电子工业出版社");
        booksList.add(goods1);
        booksList.add(goods2);
        booksList.add(goods3);
    }

    /**
     * 根据输入的图书编号查找图书信息 循环遍历书架中图书信息，找到图书编号相等的取出
     */
    private static Books getBooksById(int bookId) {
        for (int i = 0; i < booksList.size(); i++) {
            Books thisBooks = booksList.get(i);
            if (bookId == thisBooks.id) {
                return thisBooks;
            }
        }
        return null;
    }
}
