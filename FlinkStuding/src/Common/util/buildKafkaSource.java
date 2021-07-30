//package util;
//
//
//
//import java.util.Properties;
//
///**
// * @ClassName: buildKafkaSource
// * @Author: yzh
// * @Description: bulid kafka source
// * @Date: 2021/5/12 22:10
// * @Version: 1.0
// */
//public class buildKafkaSource  {
//    public  FlinkKafkaConsumer buildKafaSource(){
//        String topic = "";
//        MyDeserializationSchema deserializationSchema = new MyDeserializationSchema();
//        Properties properties = new Properties();
//        properties.setProperty("","");
//        return  new FlinkKafkaConsumer(topic,deserializationSchema,properties);
//    }
//}
