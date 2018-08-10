import java.util.ArrayList;
import java.util.Objects;
import java.util.Arrays;

class IsbnVerifier {

    boolean isValid(String stringToVerify) {

        if(stringToVerify.length()==0){
            return false;
        }
        String[] strings = {"0","1","2","3","4","5","6","7","8","9","X"};
        String[] strings1 = {"0","1","2","3","4","5","6","7","8","9","-"};
        ArrayList<Integer> arrayList = new ArrayList<>();
        int sum = 0;
        String lastChar = stringToVerify.substring(stringToVerify.length()-1);
        String restChar = stringToVerify.substring(0,stringToVerify.length()-1);
        if (!Arrays.asList(strings).contains(lastChar)){
            return false;
        }

        for(int i=0;i<restChar.length();i++){
            if (!Arrays.asList(strings1).contains(Character.toString(stringToVerify.charAt(i)))){
                return false;
            }
        }

        int lastNum = 0;
        if (Objects.equals(lastChar, "X")){
            lastNum = 10;
        }else {
            lastNum=Integer.parseInt(lastChar);
        }
        int multiply = 10;
        for(int i = 0;i<stringToVerify.length()-1;i++){
            if(!Objects.equals(Character.toString(stringToVerify.charAt(i)), "-")){
                arrayList.add(Integer.parseInt(Character.toString(stringToVerify.charAt(i))));
            }
        }

        if(arrayList.size()>9){
            return false;
        }

        for (int aStringToNum : arrayList) {
            sum+=aStringToNum*multiply;
            multiply--;
        }
        int finalResult = sum+lastNum;

        return finalResult%11==0;
//        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }
}
