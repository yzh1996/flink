package mybatistest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class batisTest {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        Person result = null;
        List<Person> list  =  null;
        try  {
//            personDao  mapper = session.getMapper(personDao.class);
////             list = mapper.findAllPerson();
//            List<Person> allPerson = mapper.findAllPerson();
           list = personDao.getInstance().findAllPerson();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
//        System.out.println(result);
//            list.stream().forEach(System.out::println);
        for (Person person :list ) {
            System.out.println(person.getPs_name()+"->"+person.getAge());
        }
    }
}
