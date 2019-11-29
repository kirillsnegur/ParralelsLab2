import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlightMapper extends Mapper<LongWritable, Text, RaceComparable, Text> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String attr[] = CSVParser.parseString(value);
        RaceComparable raceAirPortId = new RaceComparable(CSVParser.getCell("14"),1);
        Text delay = new Text();
        context.write(raceAirPortId, delay);
    }
}
