package finaldata.finaldata;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class FinalMapper extends Mapper<LongWritable, Text, Text, Text>
{
		
 public void map(LongWritable key, Text value, Context context) throws IOException
      {
	 String line=value.toString();
	 String arr[]=line.split("\\t");
	 String phoneno=arr[0];
	 String attrib=arr[1];
	 String val=arr[2];
	 String priority=arr[3];
	 String smsid=arr[4];
	 String date=arr[5];
      
      
	 try {
		 context.write(new Text(phoneno), new Text(attrib+"\t"+val+"\t"+priority+"\t"+smsid+"\t"+date));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	 
/*	 try {
		 context.write(new Text(mobile+"\t"+attribute+"\t"+val+"\t"+priority), new Text(smsid+"\t"+date));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	*/ 
	 
	         }
           
}      
      
