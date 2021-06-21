package ex3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class TestesMultiset {
	
	
	@Test
	public void TestaArrayList() {
		
		MultisetArrayList<String> multiset = new MultisetArrayList<>();
		
        MultisetArrayList<String> multiset2 = new MultisetArrayList<>();
		 
        multiset.add("Brasil");
        multiset.add("Argentina", 2);
        
        assertEquals("[Brasil, Argentina x 2]",multiset.toString());
        
        multiset2.addAll(multiset);
        
        assertEquals(true,multiset2.equals(multiset));
        
        multiset2.add("Marrocos");
        
        assertEquals(false,multiset2.equals(multiset));
        
		MultisetArrayList<String> multiset3 = new MultisetArrayList<>();
		
        MultisetArrayList<String> multiset4 = new MultisetArrayList<>();
        
        multiset3.add("Mexico");
        multiset3.add("Australia");
        
        multiset4.add("Australia");
        multiset4.add("Mexico");
        
        assertEquals(true,multiset4.equals(multiset3));

	}
	
	@Test
	public void TestaLinkedList() {
		
		MultisetLinkedList<String> multiset = new MultisetLinkedList<>();
		
		MultisetLinkedList<String> multiset2 = new MultisetLinkedList<>();
		 
        multiset.add("Brasil");
        multiset.add("Argentina", 2);
        
        assertEquals("[Brasil, Argentina x 2]",multiset.toString());
        
        multiset2.addAll(multiset);
        
        assertEquals(true,multiset2.equals(multiset));
        
        multiset2.add("Marrocos");
        
        assertEquals(false,multiset2.equals(multiset));
        
		MultisetArrayList<String> multiset3 = new MultisetArrayList<>();
		
        MultisetArrayList<String> multiset4 = new MultisetArrayList<>();
        
        multiset3.add("Mexico");
        multiset3.add("Australia");
        
        multiset4.add("Australia");
        multiset4.add("Mexico");
        
        assertEquals(true,multiset4.equals(multiset3));

	}
	
	@Test
	public void TestaStack() {
		
		MultisetStack<String> multiset = new MultisetStack<>();
		
		MultisetStack<String> multiset2 = new MultisetStack<>();
		 
        multiset.add("Brasil");
        multiset.add("Argentina", 2);
        
        assertEquals("[Brasil, Argentina x 2]",multiset.toString());
        
        multiset2.addAll(multiset);
        
        assertEquals(true,multiset2.equals(multiset));
        
        multiset2.add("Marrocos");
        
        assertEquals(false,multiset2.equals(multiset));
        
		MultisetArrayList<String> multiset3 = new MultisetArrayList<>();
		
        MultisetArrayList<String> multiset4 = new MultisetArrayList<>();
        
        multiset3.add("Mexico");
        multiset3.add("Australia");
        
        multiset4.add("Australia");
        multiset4.add("Mexico");
        
        assertEquals(true,multiset4.equals(multiset3));

	}
	
}
