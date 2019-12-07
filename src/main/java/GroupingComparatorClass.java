import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparator;

public class GroupingComparatorClass extends WritableComparator{

    public GroupingComparatorClass(){
        super(GroupingComparatorClass.class, true);
    }

    @Override
    public int compare(Object a, Object b) {
        return super.compare(a, b);
    }
}
