import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class WritableCompare implements WritableComparable {
    private int a;
    private int b;



    void readFields(DataInput in);
    void write(DataOutput out) throws IOException {
        out.write(a);
    };
    int compareTo(WritableComparable o)

}



