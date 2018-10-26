import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import org.apache.log4j.BasicConfigurator;

public class WordCountDriver extends Configured implements Tool {
    public static void main(String[] args) throws Exception {
        BasicConfigurator.configure();
        ToolRunner.run(new WordCountDriver(), args);
    }

    public int run(String[] args) throws Exception {
        //MAPRED -> Hadoop 1

        final Job job = Job.getInstance(getConf());

        // Seteamos el mapper y el reducer del job
        job.setMapperClass(WordCountMapper.class);
        job.setReducerClass(WordCountReducer.class);

        // Seteamos el tipo de datos de entrada y salida
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        // Indicamos los tipos del clave valor que sacaremos del map
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(LongWritable.class);

        // Indicamos los tipos del clave valor que sacaremos del reduce
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);

        // Seteamos los paths de entrada y salida del job (ARGS)
//        FileInputFormat.addInputPath(job, new Path(args[0]));
//        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        FileInputFormat.addInputPath(job, new Path("/home/jndurao/IdeaProjects/map-reduce/src/main/resources/wc"));
        FileOutputFormat.setOutputPath(job, new Path("/home/jndurao/IdeaProjects/map-reduce/src/main/resources/wc-out"));

        // Indicamos el JAR que contiene el job
        job.setJarByClass(WordCountDriver.class);

        // Lanzamos el job
        // submit no espera a que termine la ejecucion
//        job.submit();
        job.waitForCompletion(true);

        return 0;
    }
}
