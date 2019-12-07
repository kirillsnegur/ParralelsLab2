import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparator;

public class GroupingComparatorClass extends WritableComparator{

    public GroupingComparatorClass(){
        super(RaceComparable.class, true);
    }

    @Override
    public int compare(RaceComparable a, RaceComparable b) {
        return super.compare(a, b);
    }
}
