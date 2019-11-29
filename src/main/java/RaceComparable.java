import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class RaceComparable implements WritableComparable {

    private int airport_id;
    private int value;

    public int getAirport_id(){
        return airport_id;
    }

    public void readFields(DataInput in) throws IOException{
        airport_id = in.readInt();
        value = in.readInt();
    };

    public void write(DataOutput out) throws IOException {
        out.write(airport_id);
        out.write(value);
    };

    public int compareTo(RaceComparable c){
        int presentValue = this.get;
        int CompareValue = ;
        return presentValue < CompareValue ? -1 : (presentValue == CompareValue) ? 0 : -1));
    }

}



