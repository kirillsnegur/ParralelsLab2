import org.apache.hadoop.io.IntWritable;
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

public class FlightMapper extends Mapper<LongWritable, Text, IntWritable, Text> {

    private static IntWritable dayOfWeek;

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String attr[] = CSVParser.parseString(value);
        if (CSVParser.isArrDelay(attr[17])) return;
        dayOfWeek = new IntWritable(CSVParser.getCell(attr[4]));
//        RaceComparable raceAirportId = new RaceComparable(CSVParser.getCell(attr[4]),1);
        Text delay = new Text(attr[17]);
        context.write(dayOfWeek, delay);
    }
}
