package app.mapl.util.methods.stream;

import app.mapl.util.methods.Thing;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
   
public class StreamThis {

 
		
	
	public static void staticStreaming(String[] args) {
		System.out.println("Streaming   flatMap");
		List<String> list = Arrays.asList(args);  // { "5.6", "7.4", "4", "1", "2.3" }; 
		list.stream().flatMap(num -> Stream.of(num)).forEach(System.out::println);  
	}

//	Optional ofNullable
	 public static void nullable(String[] args)   {  //{ 1, 2, 3, 4 };
	   
	        Optional<Integer> op1  = Optional.ofNullable(9455); 
	        System.out.println("Optional 1: " + op1);
	        Optional<String> op2  = Optional.ofNullable(null);
	        System.out.println("Optional null 2: "   + op2); 
	    }
	 
	 public static void reduceFilterInts(int[] valints) {
		 
// Filter
		 Optional<int[]> opt = Optional.of(valints);
		 System.out.println("Filtered  "+opt.filter(o -> o.length >3).toString());  

		 
		 long count =  Arrays.stream(valints).count();
		 System.out.printf("sum of values: %d%n", count);
		 
		 // REDUCE
	        List<Thing> thingies = Arrays.asList(new Thing("rack", 18544), new Thing("wednesdays", 22),  new Thing("them", 3),  new Thing("all", 44));

	        Optional<Thing> thing = thingies.stream().reduce((c1, c2)
	                -> c1.getPrice() > c2.getPrice() ? c1 : c2);
System.out.println("highest cost");
	        thing.ifPresent(System.out::println);
	 }
 
}
