package cn.jcmenzz.tolearn.guirelated.sqlfruitery.dao;



import cn.jcmenzz.tolearn.guirelated.sqlfruitery.domain.FruitItem;
import cn.jcmenzz.tolearn.guirelated.sqlfruitery.tools.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * 管理员数据访问类
 */
public class AdminDao {
    ///获取所有数据
    public ArrayList<FruitItem> queryAllData() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<FruitItem> list = new ArrayList<FruitItem>();
        try {
            conn = JDBCUtils.getConnection();//获取连接
            stmt = conn.createStatement();//获得Statement对象
            //发送SQL语句
            String sql = "select * from fruit";
            rs = stmt.executeQuery(sql);
            //处理结果集
            while (rs.next()) {
                FruitItem fruitItem = new FruitItem();
                fruitItem.setNumber(rs.getString("number"));
                fruitItem.setName(rs.getString("fruitname"));
                fruitItem.setPrice(rs.getDouble("price"));
                fruitItem.setUnit(rs.getString("unit"));
                list.add(fruitItem);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return null;
    }

    //添加数据
    public void addFruitItem(FruitItem fruitItem) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "insert into fruit(number,fruitname,price,unit) values(" + fruitItem.getNumber() + ",'" + fruitItem.getName() + "','"
                    + fruitItem.getPrice() + "','" + fruitItem.getUnit() + "')";
            int num = stmt.executeUpdate(sql);
            if (num > 0) {
                System.out.println("插入数据成功！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }
    }

    //删除数据
    public void delFruitItem(String delNumber) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "delete from fruit where number=" + delNumber;
            int num = stmt.executeUpdate(sql);
            if (num > 0) {
                System.out.println("删除数据成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }
    }
}
