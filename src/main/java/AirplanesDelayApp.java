import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class AirplanesDelayApp {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("Usage: AirplanesDelayApp <input pathRaces> <input Airports> <output pathResult>");
            System.exit(-1);
        }
        Job job = Job.getInstance();
        job.setJarByClass(AirplanesDelayApp.class);
        job.setJobName("AirplanesDelay");

        MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, FlightMapper.class);
        MultipleInputs.addInputPath(job, new Path(args[1]), TextInputFormat.class, AirportMapper.class);
        FileOutputFormat.setOutputPath(job, new Path(args[2]));

        job.setMapOutputKeyClass(RaceComparable.class);
        job.setReducerClass(AirportDelayReducer.class);

        job.setPartitionerClass(RaceAirportPartitioner.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        job.setNumReduceTasks(2);
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }

}
