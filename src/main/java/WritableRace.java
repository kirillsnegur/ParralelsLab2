import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.Text;
import org.mortbay.util.IO;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class WritableRace implements Writable {
    public Text first;
    public Text second;

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        first.readFields(dataInput);
        second.readFields(dataInput);
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        first.write(dataInput);
        second.readFields(dataInput);
    }
}
