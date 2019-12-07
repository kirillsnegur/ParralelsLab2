import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

//public class FlightMapper extends Mapper<LongWritable, Text, RaceComparable, Text> {
//
//    @Override
//    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
//        String attr[] = CSVParser.parseString(value);
//        if (CSVParser.isArrDelay(attr[17])) return;
//        RaceComparable raceAirportId = new RaceComparable(CSVParser.getCell(attr[14]),1);
//        Text delay = new Text(attr[17]);
//        context.write(raceAirportId, delay);
//    }
//}

public class FlightMapper extends Mapper<LongWritable, Text, RaceComparable, Text> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String attr[] = CSVParser.parseString(value);
        if (CSVParser.isDestAirport(attr[14])) return;
        RaceComparable dayOfWeek = new RaceComparable(CSVParser.getCell(attr[4]),1);
        Text destAirport = new Text(attr[14]);
        context.write(dayOfWeek, destAirport);
    }
}
