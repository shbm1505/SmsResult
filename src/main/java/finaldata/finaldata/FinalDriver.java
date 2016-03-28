package finaldata.finaldata;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;



public class FinalDriver {

   public static void main(String[] args) throws Exception {
	   
	   Configuration conf = new Configuration();
	         Job job = Job.getInstance(conf, "WordCounter");
	         job.setJarByClass(FinalDriver.class);
	         job.setMapperClass(FinalMapper.class);
	         job.setReducerClass(FinalReducer.class);
	   
	         // TODO: specify output types
	         
	         job.setMapOutputKeyClass(Text.class);
	         job.setMapOutputValueClass(Text.class);
	         job.setOutputKeyClass(Text.class);
	         job.setOutputValueClass(Text.class);
	         
	     //    job.setOutputKeyClass(Text.class);
	      //   job.setOutputValueClass(Text.class);
	   
	         // TODO: specify input and output DIRECTORIES (not files)
	     //    FileInputFormat.setInputPaths(job, new Path("/sms1.csv"));
	      //   FileOutputFormat.setOutputPath(job, new Path("/temp/"));
	         FileInputFormat.setInputPaths(job, new Path(args[0]));
	   
	         FileOutputFormat.setOutputPath(job, new Path(args[1]));
	   
	         if (!job.waitForCompletion(true))
	            return;
	      }
   }

