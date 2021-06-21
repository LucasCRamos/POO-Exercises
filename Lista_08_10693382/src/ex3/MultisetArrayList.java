package ex3;

import java.util.*;

//Inspirado em: https://www.techiedelight.com/multiset-implementation-java/

class MultisetArrayList<T>
{
    private ArrayList<T> values;
 
    private ArrayList<Integer> frequency;
    
    private final String errorMessage = "Não pode ser um número negativo: ";
 
    public MultisetArrayList()
    {
        values = new ArrayList<>();
        frequency = new ArrayList<>();
    }
    
    public int size()
    {
        int size = 0;
        for (Integer i: frequency) {
            size += i;
        }
        return size;
    }
 
    
    public int add(T element, int count)
    {
        if (count < 0) {
            throw new IllegalArgumentException(errorMessage + count);
        }
 
        int index = values.indexOf(element);
        
        int prevCount = 0;
 
        if (index != -1)
        {
            prevCount = frequency.get(index);
            frequency.set(index, prevCount + count);
        }
        
        else if (count != 0)
        {
            values.add(element);
            frequency.add(count);
        }
 
        return prevCount;
    }
 
    public boolean add(T element) {
    	
        return add(element, 1) >= 0;
    }
  
   public int count(T element)
   {
       int index = values.indexOf(element);

       return (index == -1) ? 0 : frequency.get(index);
   }
 
    boolean addAll(MultisetArrayList<T> c)
    {
        for (T element: c.values) {
        	
            add(element,c.count(element));
        }
 
        return true;
    }
    
    
    public boolean equals(MultisetArrayList<T> c) {
    	
    		
		if(c.values.size() != values.size()) return false; //se tamanho dos arrays forem diferentes, não são iguais
				
		else {
	
	    	for(T element: c.values) {
	    		
	    	
			int elementPosition = values.indexOf(element); //posição do elemento no array
			
			if(elementPosition < 0) return false; //se < 0, elemento não existe
			
			int elementFrequency = frequency.get(elementPosition); //frequência do elemento no array
			
			int elementPosition2 = c.values.indexOf(element); //posição do elemento no array recebido
			
			int elementFrequency2 = c.frequency.get(elementPosition2); //frequência do elemento no array recebido
			
			if(elementFrequency != elementFrequency2) return false; //se forem diferentes, arrays não são iguais
		
	    			
	    	}
		
		}
	    	
	    	return true;
    	
    } 
 
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < values.size(); i++)
        {
            sb.append(values.get(i));
 
            if (frequency.get(i) > 1) {
                sb.append(" x ").append(frequency.get(i));
            }
 
            if (i != values.size() - 1) {
                sb.append(", ");
            }
        }
 
        return sb.append("]").toString();
    }
    
}
 