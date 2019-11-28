import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class WritableCompare implements WritableComparable {
    public int a;
    public int b;


    pubvoid readFields(DataInput in) throws IOException{
        a = readFields(a);
        b = readFields(b);
    };

    public void write(DataOutput out) throws IOException {
        out.write(a);
        out.write(b);
    };

    int compareTo(WritableComparable c){
        int presentValue = this.value;
        int CompareValue = c.value;
        return presentValue < CompareValue ? -1 : (presentValue == CompareValue) ? 0 : -1));
    }

}



