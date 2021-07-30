package Source;

import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.source.RichSourceFunction;

import java.sql.*;

/**
 * @ClassName: userdefSource.mysqlSource
 * @Author: yzh
 * @Description: 自定义数据源
 * @Date: 2021/5/11 21:21
 * @Version: 1.0
 */
/*
    close方法在run方法中的while循环结束后会被调用，但是cancel方法没有被调用，文档注释又说是可以通过set boolean值的方式终止循环？
 */
public class mysqlSource extends RichSourceFunction<String> {
    private Connection connection;
    private ResultSet rs;
    private boolean sym = true;
    private  int count = 0;

    @Override
    public void open(Configuration parameters) throws Exception {
        connection = ps_namenection();
        Statement statement = connection.createStatement();
        rs = statement.executeQuery("select * from tb_source");
    }

    @Override
    public void close() throws Exception {
        try {
            connection.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void run(SourceContext ctx) throws Exception {

        while (sym && count <10) {
//            String word = rs.getString("word");
            ctx.collect("1");
            count++;
        }
    }

    public void cancel() {
     sym = false;

    }

    private Connection ps_namenection() {
        Connection con = null;
        try {
//            jdbc:mysql://localhost:3306/test89?useUnicode=true&characterEncoding=UTF-8
//            jdbc:mysql://localhost:3306/flink?useUnicode=true&characterEncoding=UTF-8
            Class.forName("com.mysql.jdbc.Driver");
//            com.mysql.jdbc.Driver
//            com.mysql.jdbc.Driver
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flink?useUnicode=true&characterEncoding=UTF-8",
                    "root",
                    "8870078");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
