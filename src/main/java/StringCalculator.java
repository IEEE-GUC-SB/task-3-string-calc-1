import java.util.ArrayList;
import java.util.Arrays;

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
                del = '['+ del + ']';
                System.out.println(del);
                numbers = numbers.substring(i+2);
                System.out.println(numbers);
                stringsArray = numbers.split(del);
                System.out.println(Arrays.toString(stringsArray));
            }else{
                char c = numbers.charAt(2);
                numbers=numbers.substring(4);
                String del = c+"";
                if(c == '.' || c == '*' || c == '|'){
                    del="\\"+del;
                }
                stringsArray = numbers.split(del);
            }
        }else{
            stringsArray = numbers.split(",|\n");
        }
        int sum=0;
        boolean negativesFound =false;
        ArrayList<Integer> negatives = new ArrayList<>();
        for (int i = 0; i < stringsArray.length; i++) {
            if(stringsArray[i].length()==0){
                continue;
            }
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