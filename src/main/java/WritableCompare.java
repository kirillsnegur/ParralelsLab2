import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;

public class WritableCompare implements WritableComparable {
    void readFields(DataInput in);
    void write(DataOutput out);
    int compareTo(WritableComparable o)

}



