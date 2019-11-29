import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Reducer;

import javax.xml.soap.Text;
import java.io.IOException;
import java.util.Iterator;

public class AirportDelayReducer extends Reducer<RaceComparable, Text, Text, LongWritable> {

    @Override
    protected void reduce(RaceComparable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        Iterator<Text> iterator = values.iterator();
        double delayMax = 0, delaySum = 0;
        
    }
}
