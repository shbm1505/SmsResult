package finaldata.finaldata;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class FinalReducer extends Reducer<Text, Text, Text, Text> {

	public void reduce(Text key, Iterable<Text> values, Context context)
			throws IOException, InterruptedException {
		// process values
		Text u=key;
		String str=u.toString()+"|";
		
/*		 while(values.hasNext())
		 {
			 try {
				   context.write(t,values);
				  } catch (InterruptedException e) {
				   e.printStackTrace();
				  } 
			 break;
		 }
		 
	*/	 
		;
		String sentence=" ";
		String newstring=" ";
		
		int gender=0,location=0,health=0,fund=0,savings=0,kids=0,credit=0,home=0,car_insurance=0,life=0,age=0,income=0,car_loan=0;
		String genders=" ",locations=" ",healths=" ",funds=" ",savingss=" ",kidss=" ",credits=" ",homes=" ",car_insurances=" ",lifes=" ",ages=" ",incomes=" ",car_loans=" ";
//		String twinstring;
		
		
		for(Text tw : values)	
		{
			
			  sentence=tw.toString();	 
			  
			  if(sentence.contains("gender"))
			  {
				 gender=1;  
				 genders=sentence;
			  }
			  
			  
			  if(sentence.contains("location")){
				 location=1;
				 locations=sentence;
			  }
			  
			  if(sentence.contains("health")){
				  health=1;
				  healths=sentence;
			  }
			  
			  if(sentence.contains("fund")){
				  fund=1;
				  funds=sentence;
			  }
			  
			  
			  if(sentence.contains("savings")){
				  savings=1;
				  savingss=sentence;
			  }
			  
			  
			  if(sentence.contains("kids")){
				  kids=1;
				  kidss=sentence;
			  }
			  
			  
			  if(sentence.contains("credit")){
				  credit=1;
				  credits=sentence;
			  }
			  
			  
			  if(sentence.contains("home")){
				  home=1;
				  homes=sentence;
			  }
			  
			  
			  if(sentence.contains("car")&&sentence.contains("insurance")){
				  car_insurance=1;
				  car_insurances=sentence;
			  }
			  
			  if(sentence.contains("car")&&sentence.contains("loan")){
				  car_loan=1;
				  car_loans=sentence;
			  }
			  
			  
			  if(sentence.contains("life")){
				  life=1;
				  lifes=sentence;
			  }
			  
			  
			  if(sentence.contains("age")){
				  age=1;
				  ages=sentence;
			  }
			  if(sentence.contains("income")){
				  income=1;
				  incomes=sentence;
			  }
			  	  
		}
		
		if(gender==1)
			newstring=newstring+genders+"|";
		else
			newstring=newstring+"gender NA|";
		
		if(location==1)
			newstring=newstring+locations+"|";
		else
			newstring=newstring+"location NA|";
		
		if(health==1)
			newstring=newstring+healths+"|";
		else
			newstring=newstring+"health_insurance NA|";
		
		if(fund==1)
			newstring=newstring+funds+"|";
		else
			newstring=newstring+"mutual_fund NA|";
		
		if(savings==1)
			newstring=newstring+savingss+"|";
		else
			newstring=newstring+"saving_account NA|";
		
		if(kids==1)
			newstring=newstring+kidss+"|";
		else
			newstring=newstring+"has_kids NA|";
		
		if(credit==1)
			newstring=newstring+credits+"|";
		else
			newstring=newstring+"credit_card NA|";
		
		if(home==1)
			newstring=newstring+homes+"|";
		else
			newstring=newstring+"home_loan NA|";
		
		if(car_insurance==1)
			newstring=newstring+car_insurances+"|";
		else
			newstring=newstring+"car_insurance NA|";
		
		if(car_loan==1)
			newstring=newstring+car_loans+"|";
		else
			newstring=newstring+"car_loan NA|";
		
		if(life==1)
			newstring=newstring+lifes+"|";
		else
			newstring=newstring+"life NA|";
		
		if(age==1)
			newstring=newstring+ages+"|";
		else
			newstring=newstring+"age NA|";
		
		if(income==1)
			newstring=newstring+incomes+"|";
		else
			newstring=newstring+"income NA|";
		
		
		
		
		
		try {
			   context.write(new Text(str),new Text(newstring));
			  } catch (IOException e) {
			   e.printStackTrace();
			  } catch (InterruptedException e) {
			   e.printStackTrace();
			  }
		
		
	}

}

