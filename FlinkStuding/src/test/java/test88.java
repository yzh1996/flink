import org.apache.http.client.methods.HttpPost;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.BitSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

/**
 * @ClassName: test88
 * @Author: yzh
 * @Description:
 * @Date: 2021/5/16 9:20
 * @Version: 1.0
 */
public class test88 {
    public static void main(String[] args) {
        int i = 0;
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
             preparedStatement = connection.prepareStatement("insert into tb_source(word) values (?)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        do {
            double random = Math.random();
            String usernum = "1"+(random + "").substring(2, 12);
            try {
                preparedStatement.setString(1,usernum);
                preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            i++;
        }while (i<3);


    }

    private static Connection getConnection() {
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
