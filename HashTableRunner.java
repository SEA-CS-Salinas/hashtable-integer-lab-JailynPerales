//(c) A+ Computer Science
//www.apluscompsci.com

//Name - Jailyn Perales

import java.util.*;
import java.io.File;
import static java.lang.System.*;
import java.util.Hashtable;

public class HashTableRunner
{
  public static void main ( String[] args )
  {
		try{
			//make a new table			
			Hashtable<Integer, String> hash = new Hashtable<Integer, String>();
			//read from the file			
			Scanner file = new Scanner(new File("Numbers.dat"));
			//load stuff into the table			
			while (file.hasNextInt()) {
			    Number num = new Number(file.nextInt());
			    if(hash.containsKey(num.hashCode())){
			        boolean another = false;
			        String[] list = hash.get(num.hashCode()).split(" ");
			        for(int i = 0; i < list.length; i++){
			            if(list[i].equals(""+ num)){
			                another = true;
			                break;
			            }
			        }
			        if(!another){
			            hash.put(num.hashCode(), hash.get(num.hashCode()) + " " + num);
			        }
			    }
			    else{
			        hash.put(num.hashCode(), "" + num);
			    }
			}
			Object[] keySet = hash.keySet().toArray();
			System.out.println("HASHTABLE");
			for(int i = (hash.size()-1); i >= 0; i--) {
			    System.out.println("bucket " + keySet[i] + " " + hash.get(keySet[i]));
			}

		}
		
		catch(Exception e)
		{
			System.out.println("Houston, we have a problem!");
		}
  }
}
