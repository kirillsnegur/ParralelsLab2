import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class GroupingComparatorClass extends WritableComparator{

    protected GroupingComparatorClass(){
        super(RaceComparable.class, true);
    }

    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        RaceComparable raceA = (RaceComparable)a, raceB = (RaceComparable)b;
        return Integer.compare(raceA.getAirport_id(), raceB.getAirport_id());
    }
}
