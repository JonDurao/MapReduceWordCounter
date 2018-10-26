import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class WordCountReducer extends Reducer implements org.apache.hadoop.mapred.Reducer {
    public void reduce(Object o, Iterator iterator, OutputCollector outputCollector, Reporter reporter) throws IOException {

    }

    public void close() throws IOException {

    }

    public void configure(JobConf jobConf) {

    }
}
