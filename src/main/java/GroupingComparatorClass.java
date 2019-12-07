import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class GroupingComparatorClass extends WritableComparator{

    protected GroupingComparatorClass(){
        super(RaceComparable.class, true);
    }

    @Override
    public int compare(WritableComparable a, RaceComparable b) {
        return Integer.compare(a.getAirport_id(), b.getAirport_id());
    }
}
