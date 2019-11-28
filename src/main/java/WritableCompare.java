import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class WritableCompare implements WritableComparable {
    private int a;
    private int b;


    void readFields(DataInput in) throws IOException{
        a = readFields(a);
        b = readFields(b);
    };

    void write(DataOutput out) throws IOException {
        out.write(a);
        out.write(b);
    };

    int compareTo(WritableComparable o){
        int presentValue = this.value;
        
    }

}



