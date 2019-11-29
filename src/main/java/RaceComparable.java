import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class RaceComparable implements WritableComparable {

    private int a;
    private int b;

    public void readFields(DataInput in) throws IOException{
        a = in.readInt();
        b = in.readInt();
    };

    public void write(DataOutput out) throws IOException {
        out.write(a);
        out.write(b);
    };

    public int compareTo(RaceComparable c){
        int presentValue = this.get;
        int CompareValue = ;
        return presentValue < CompareValue ? -1 : (presentValue == CompareValue) ? 0 : -1));
    }

}



