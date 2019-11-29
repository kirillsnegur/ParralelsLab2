import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class RaceComparable implements WritableComparable<RaceComparable> {

    RaceComparable(int airport_id,int ){

    }

    private int airport_id;
    private int value;

    private int getAirport_id(){
        return airport_id;
    }

    private int getValue() {
        return value;
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
        int presentID = this.getAirport_id();
        int compareID = c.getAirport_id();
        int compID = Integer.compare(presentID, compareID);
        return (compID != 0) ? compID : Integer.compare(this.getValue(), c.getValue());
    }
}



