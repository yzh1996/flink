package util;

import org.apache.flink.api.common.serialization.DeserializationSchema;
import org.apache.flink.api.common.typeinfo.TypeInformation;

import java.io.IOException;

/**
 * @ClassName: MyDeserializationSchema
 * @Author: yzh
 * @Description:
 * @Date: 2021/5/12 22:15
 * @Version: 1.0
 */
public class MyDeserializationSchema  implements DeserializationSchema {
    @Override
    public String deserialize(byte[] message) throws IOException {
        return new String(message,"UTF-8");
    }

    @Override
    public boolean isEndOfStream(Object nextElement) {
        return false;
    }

    @Override
    public TypeInformation getProducedType() {
        return null;
    }
}
