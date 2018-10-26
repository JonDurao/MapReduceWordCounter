import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

//public class WordCountMapper extends Mapper <LongWritable, Text, Text, LongWritable> {
public class WordCountMapper extends Mapper {
    @Override
//    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
    protected void map(Object key, Object value, Context context) throws IOException, InterruptedException {
        if (value instanceof Text) {

            // Cosas que no son palabras como separador
            String[] splits = value.toString().trim().split("\\W+");

            for (String split : splits) {
                // NullWritable.get() para pasar un valor vacio
                context.write(new Text(split), new LongWritable(1));
            }
        }
    }
}
