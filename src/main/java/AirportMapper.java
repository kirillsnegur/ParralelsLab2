import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class AirportMapper extends Mapper<LongWritable, Text, RaceComparable, Text>{

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String attr[] = CSVParser.parseString(value);
        RaceComparable raceAirportId = new RaceComparable(CSVParser.getCell(attr[14]),0);
        Text description = new Text(attr[1]);
        context.write(raceAirportId, description);
    }
}
