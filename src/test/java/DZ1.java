import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public static class DZ1 {

    //Условная логика
    //1 задание
    @Test
    public boolean isEven(int n) {
        if (n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
    //2 задание
    public boolean isPositive(int n){
        return n >= 0 ?true : false;
    }

    //3 задание
    @Test
    public String checkAccess(int age){
        return age > 18 ? "Allowed" : "Denied";
    }

    //4 задание
    @Test
    public String getGrade(int score){
        if ((score >= 0) && (score <= 20)){return "Score: E";}
        else if ((score >= 21) && (score <= 40)) {return "Score: D";}
        else if((score >= 41) && (score <= 60)){return "Score: C";}
        else if((score >= 61) && (score <= 80)){return "Score: B";}
        else {return "Score: A";}
    };

    //ЦИКЛЫ и НАКОПЛЕНИЕ ДАННЫХ
    //5 задание
public String blastOff(int start){
    String result = "";
    for (int i = start; i >= 1; i--){
        result += i+ " ";}
    result += "Поехали";

    return result;
}

//6 задание
public boolean hasBug(String[] messages) {
    for (int i = 0; i < messages.length; i++) {
        if (messages[i].equals("Bug")) {
            return true;
        }
    }
    return false;
}

//7 задание
public int sumToN(int n){
    int sum = 0;
    while (n>0){
        sum = sum+n;
        n = n-1;
    }
    return sum;
}

//8 задание
public String getEvenInRange(int start, int end){
   String evenList = "";
    for (int i=start; i<=end; i++){
        if ( i % 2 == 0) {
           evenList += i + " ";
        }
}
    return evenList;

}

//9 задание
public int findMax(int [] arr){
    int max = arr[0];
    for (int i=1; i <arr.length; i++ ){
        if (arr[i]>max){
            max=arr[i];
        }
    } return max;
}

//10 задание (НЕ ПОЛУЧАЕТСЯ)
public  String[] reverse(String[] arr){
    String [] rev = new String[arr.length];
    for (int i =0; i<arr.length; i++){
        rev[i] = arr[arr.length-1-i];
    }
    return rev;
}

//11 задание
public int calcAverage(List<Integer> list){
    int sum = 0;
    for(int i = 0; i<list.size(); i++){
        sum = sum+ list.get(i);
    }
        return sum/list.size();

}

//12 задание
public List<String> removeSpecificName(List<String> list, String nameToRemove){
    List<String> newList = new ArrayList<>();
    if(list.contains(nameToRemove)){
        list.remove(nameToRemove);
        }
        return newList;
    }
}



    public static void main(String[]args){
        DZ1 dz = new DZ1();
        String[] messages = {"Passed", "Fail", "Error", "Bug"}; //массив для 6 задания
        int [] arr = {11,2,222,4,5,6,77,8}; //9 задание
        String[] array = {"Passed", "Fail", "Error"}; //массив для 10 задания
        List<Integer> list = List.of(41,1);//список для 11 задания
        List<String> listString = List.of("raspberry","blueberry","wildberry","blackberry");//список для 12 задания


    //1 задание
        boolean result = dz.isEven(8);
        System.out.println(result);
        System.out.println(dz.isEven(6));
        System.out.println(dz.isEven(5));

    //2 задание
        System.out.println(dz.isPositive(0));
        System.out.println(dz.isPositive(-4));

    //3 задание
        System.out.println(dz.checkAccess(18));
        System.out.println(dz.checkAccess(25));
        System.out.println(dz.checkAccess(4));

    //4 задание
        System.out.println(dz.getGrade(4));
        System.out.println(dz.getGrade(24));
        System.out.println(dz.getGrade(44));
        System.out.println(dz.getGrade(74));
        System.out.println(dz.getGrade(94));

    //5 задание
        System.out.println(dz.blastOff(5));

    //6 задание
        System.out.println(dz.hasBug(messages));

    //7 задание
        System.out.println(dz.sumToN(3));
        System.out.println(dz.sumToN(5));

    //8 задание
        System.out.println(dz.getEvenInRange(1,5));

    //9 задание
        System.out.println(dz.findMax(arr));


    //10 задание
        System.out.println(dz.reverse(array));

    //11 задание
        System.out.println(dz.calcAverage(list));

    //12 задание
        System.out.println(dz.removeSpecificName(listString,"blackberry"));


    }

}








