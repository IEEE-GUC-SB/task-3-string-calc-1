public class StringCalculator {
    public int add(String numbers){
        if (numbers.length()==0){
            return 0;
        }

        String[] stringsArray = numbers.split(",|\n");
        int sum=0;
        for (int i = 0; i < stringsArray.length; i++) {
            sum+=Integer.parseInt(stringsArray[i]);
        }
        return sum;
    }
}