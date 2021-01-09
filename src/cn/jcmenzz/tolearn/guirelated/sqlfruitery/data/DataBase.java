package cn.jcmenzz.tolearn.guirelated.sqlfruitery.data;



import cn.jcmenzz.tolearn.guirelated.sqlfruitery.domain.FruitItem;

import java.util.ArrayList;

/**
 * 存储数据
 */
public class DataBase {
    public static ArrayList<FruitItem> data = new ArrayList<FruitItem>();

    //初始数据
    static {
        data.add(new FruitItem("1", "苹果", 5.0, "kg"));
    }
}
