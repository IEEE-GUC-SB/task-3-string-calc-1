import java.util.ArrayList;

public class StringCalculator {
    public int add(String numbers) throws Exception {
        if (numbers.length()==0){
            return 0;
        }
        String[] stringsArray;
        if(numbers.charAt(0)=='/' && numbers.charAt(1)=='/'){
            if(numbers.charAt(2)=='['){
                String del="";
                int i=3;
                while(numbers.charAt(i)!=']'){
                    del+=numbers.charAt(i);
                    i++;
                }
                numbers = numbers.substring(i+2);
                stringsArray = numbers.split(del+"");
            }else{
                char del = numbers.charAt(2);
                numbers=numbers.substring(4);
                stringsArray = numbers.split(del+"");
            }
        }else{
            stringsArray = numbers.split(",|\n");
        }
        int sum=0;
        boolean negativesFound =false;
        ArrayList<Integer> negatives = new ArrayList<>();
        for (int i = 0; i < stringsArray.length; i++) {
            int num = Integer.parseInt(stringsArray[i]);
            if(num<0){
                negativesFound=true;
                negatives.add(num);
            }else{
                if(num<=1000){
                    sum+= num;
                }
            }
        }
        if(negativesFound){
            throw new Exception("negatives not allowed" + negatives.toString());
        }
        return sum;
    }
}