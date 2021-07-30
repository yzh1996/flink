package Commen;
import org.apache.flink.streaming.api.functions.AssignerWithPeriodicWatermarks;
import org.apache.flink.streaming.api.watermark.Watermark;
import javax.annotation.Nullable;

/**
 * 周期性的生成watermark，getCurrentWatermark方法由框架自己调用，间隔由streamEnv.getConfig.setAutoWatermarkInterval()决定
 */
public class TimeConstruct implements AssignerWithPeriodicWatermarks<String>{
    private  long delayTime = 3000L;
    private  long MaxTime;
    private  long curTime;
    @Nullable
    @Override
    public Watermark getCurrentWatermark() {
        return new Watermark(MaxTime-delayTime);

    }

    //水位线需要返回的是最大的时间值
    @Override
    public long extractTimestamp(String string, long previousElementTimestamp) {

        curTime = Long.parseLong(string.split(" ")[1]);
        MaxTime = Math.max(MaxTime,curTime);
        return curTime;
    }

    public static void main(String[] args) {
        TimeConstruct timeConstruct = new TimeConstruct();
        System.out.println(timeConstruct.MaxTime);
    }
}
