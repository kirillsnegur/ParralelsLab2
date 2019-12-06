import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlightMapper extends Mapper<LongWritable, Text, RaceComparable, Text> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String attr[] = CSVParser.parseString(value);
        if (CSVParser.isArrDelay())
        RaceComparable raceAirportId = new RaceComparable(CSVParser.getCell(attr[14]),1);
        Text delay = new Text(attr[17]);
        context.write(raceAirportId, delay);
    }
}
