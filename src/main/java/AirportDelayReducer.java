import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

//public class AirportDelayReducer extends Reducer<RaceComparable, Text, Text, Text> {

//    @Override
//    protected void reduce(RaceComparable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
//        Iterator<Text> iterator = values.iterator();
//        Text name = new Text(iterator.next());
//        double delayMax = 0, delaySum = 0, delayMin = 0, actualDelay;
//        int count = 0;
//        while (iterator.hasNext()){
//            count++;
//            String delayStr = iterator.next().toString();
//            actualDelay = delayStr.equals("") ? 0 : Double.parseDouble(delayStr);
//            if (actualDelay > delayMax) {
//                delayMax = actualDelay;
//            } else if (actualDelay < delayMin){
//                delayMin = actualDelay;
//            }
//            delaySum += actualDelay;
//        }
//
//        if (count == 0) return;
//        String contextOut = "delayMin: " + delayMin + "; delayAverage: "+ delaySum/count + "; delayMax: " + delayMax + ";";
//        context.write(name, new Text(contextOut));
//
//    }


public class AirportDelayReducer extends Reducer<IntWritable, Text, Text, Text> {

    @Override
    protected void reduce(IntWritable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        Text dayOfWeek = new Text(key.toString());
        double delayMax = 0, actualDelay;
        Iterator<Text> iterator = values.iterator();
        while (iterator.hasNext()) {
            String delayStr = iterator.next().toString();
            actualDelay = delayStr.equals("") ? 0 : Double.parseDouble(delayStr);
            if (actualDelay > delayMax) {
                delayMax = actualDelay;
            }
        }
        String contextOut = "delayMax: " + delayMax;
        context.write(dayOfWeek,new Text(contextOut));
    }
}