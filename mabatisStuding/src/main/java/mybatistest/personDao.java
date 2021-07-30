package mybatistest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class personDao {
    private static volatile personDao dao;

    public personDao() {
    }


    public static personDao getInstance() {
        if (dao == null) {
            synchronized (personDao.class) {
                dao = new personDao();
            }
        }
        return dao;
    }

    public List<Person> findAllPerson() throws IOException {
        List<Person> list;
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        list = session.selectList("findAllPerson");
        return list;
    }

    ;
}
