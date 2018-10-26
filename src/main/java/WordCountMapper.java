import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class WordCountMapper extends Mapper implements org.apache.hadoop.mapred.Mapper {
    public void map(Object o, Object o2, OutputCollector outputCollector, Reporter reporter) throws IOException {

    }

    public void close() throws IOException {

    }

    public void configure(JobConf jobConf) {

    }
}
