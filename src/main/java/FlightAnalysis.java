import java.io.IOException;
import java.net.URI;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.s3a.S3AFileSystem;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import utils.AwsCredentials;
import utils.Utils;

public class FlightAnalysis {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "Flight Analysis");

        AwsCredentials cred = Utils.credentialsFromFile();
        Configuration fsConf = new Configuration();
        fsConf.set("fs.s3a.impl", S3AFileSystem.class.getName());
        fsConf.set("fs.s3n.awsAccessKeyId", cred.getAccessKey());
        fsConf.set("fs.s3n.awsSecretAccessKey", cred.getSecretAccessKey());

        FileSystem fs = FileSystem.get(new URI(args[0]),fsConf);
        Path inputPath = new Path(args[1]), outputPath = new Path(args[2]);

        if (fs.exists(outputPath)) {
            fs.delete(outputPath, true);
        }
    }
}
