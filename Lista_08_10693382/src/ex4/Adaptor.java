package ex4;

import java.util.*;

public class Adaptor<T>{
	
    private Multiset<T> values;
    private List<T> newValues = new ArrayList<>();
    
    public Adaptor(Multiset<T> values)
    {
        this.values = values;
        
    }
	
    public Iterator<T> iterator() {
	    	
	      Iterator <T> itr = values.iterator();
	        
	        while(itr.hasNext()) {
	        	
	        	T element = itr.next();
	        	
	        	if(newValues.contains(element) == false) newValues.add(element);
	        	
	        }
	        
	        itr = newValues.iterator();
	        
			return itr;
	    }
	 
	 public static void main (String args[]) {
			
			Multiset<String> multiset = new Multiset<>();
			 
		    multiset.add("Brasil");
		    multiset.add("Argentina");
		    multiset.add("Uruguai");
		    multiset.add("Uruguai");
		    
		    System.out.println(multiset);   
		    
		    Adaptor<String> adaptor = new Adaptor<String>(multiset);
		    
		    Iterator <String> itr = adaptor.iterator();
		    
		    System.out.print("Conjunto: ");
		    
		    while(itr.hasNext()) {
		    	
		    	System.out.print(itr.next()+" ");
		    }

	 }
		    
}


