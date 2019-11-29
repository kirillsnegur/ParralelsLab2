import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class RaceAirportPartitioner extends Partitioner<RaceComparable, Text> {

    @Override
    public int getPartition(RaceComparable raceComparable, Text text, int i) {
        return 
    }
}
