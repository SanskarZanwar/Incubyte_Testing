package testing;


public class StringCalculator {

    public int add(String numbers) {
        if (numbers.length() < 2) {
            if (numbers.isEmpty()) {
                return 0;
            } else {
                return convertToInt(numbers);
            }
            } else { 
            String delimiter = ",";
            if (numbers.matches("//(.*)\n(.*)")) {
                delimiter = Character.toString(numbers.charAt(2));
                numbers = numbers.substring(4);
            }
           
            String[] numList = splitNumbers(numbers, delimiter + "|\n");
            return sum(numList);
        }
    }
   
    private String[] splitNumbers(String numbers, String divider) {
        return numbers.split(divider);
    }

    private int convertToInt(String num) {
    	
    	if(num.compareTo("a") >= 0 && num.compareTo("z")<=0) {
    		return convertStringToInt(num);
    	}
        return Integer.valueOf(num);
    }
    private int convertStringToInt(String num) {
    	char[] ch  = num.toCharArray();
    	for(char c : ch){
    	    int temp = (int)c;
    	    int temp_integer = 96; 
    	    if(temp<=122 & temp>=97)
    	        return(temp-temp_integer);
    	}
    	return 0;
    
    }

    private int sum(String[] numbers) {
        int total = 0,j=2,l,i=0;
        l = numbers.length;
        StringBuilder negativeString = new StringBuilder();
		int arr[] = new int[l]; 
		for(int k=0; k<l; k++) {
			arr[k]=0;
		}
		if(numbers[1].compareTo("/")==0 && numbers[2].compareTo("/") == 0){
			if(convertToInt(numbers[0]) == 1){
				j=1;
			}
			if(convertToInt(numbers[0]) == 0){
				j=0;
			}
		}
			
	        for (String number : numbers) {
	        	
	            if (convertToInt(number) < 0) {
	                if (negativeString.toString().equals(""))
	                    negativeString = new StringBuilder(number);
	                
	                else
	                    negativeString.append(",").append(number);
	            }
		    arr[i]=convertToInt(number);
	            if (convertToInt(number) < 1000 ) 
	                total += convertToInt(number);
	            else if(j==0){
	            	total=0;
			for(int k=0; k<numbers.length; k++){
				if(k%2 == 0){
					 total+= arr[k];
				}
			}
		    }
	            else {
	            	total=0;
			for(int k=0; k<numbers.length; k++){
				
				if(k%2 != 0)
					 total+= arr[k];
			
			}
	            }
	        }
	        return total;
    }
}
		
        