public class StringCalculator {
    public int add(String numbers){
        if (numbers.length()==0){
            return 0;
        }
        String[] stringsArray;
        if(numbers.charAt(0)=='/' && numbers.charAt(1)=='/'){
            char del = numbers.charAt(2);
            numbers=numbers.substring(4);
            stringsArray = numbers.split(del+"");
        }else{
            stringsArray = numbers.split(",|\n");
        }
        int sum=0;
        for (int i = 0; i < stringsArray.length; i++) {
            sum+=Integer.parseInt(stringsArray[i]);
        }
        return sum;
    }
}