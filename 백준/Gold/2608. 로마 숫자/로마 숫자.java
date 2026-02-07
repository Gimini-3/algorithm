import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner sca =new Scanner(System.in);
        String str1= sca.next();
        String str2 = sca.next();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int x=0;
        for(int i=0;i<str1.length();i++){
            
            char ch1 = str1.charAt(i);
            int a= map.get(ch1);
            if(i==str1.length()-1){
                x+=a;
                break;
            }
            char ch2 = str1.charAt(i+1);
            int b = map.get(ch2);
            if(a>=b){
                x+=a;
            }else{
                x+=(b-a);
                i++;
            }
        }
   //     System.out.println(x);
        int y=0;
        for(int i=0;i<str2.length();i++){
            
            char ch1 = str2.charAt(i);
            int a= map.get(ch1);
            if(i==str2.length()-1){
                y+=a;
                break;
            }
            char ch2 = str2.charAt(i+1);
            int b = map.get(ch2);
            if(a>=b){
                y+=a;
            }else{
                y+=(b-a);
                i++;
            }
        }
      //  System.out.println(y);
        int sum = x+y;
        System.out.println(sum);
        HashMap<Integer,String> map2 = new HashMap<>();
        map2.put(0,"");
        map2.put(1,"I");
        map2.put(2,"II");
        map2.put(3,"III");
        map2.put(4,"IV");
        map2.put(5,"V");
        map2.put(6,"VI");
        map2.put(7,"VII");
        map2.put(8,"VIII");
        map2.put(9,"IX");
        map2.put(10,"X");
        map2.put(20,"XX");
        map2.put(30,"XXX");
        map2.put(40,"XL");
        map2.put(50,"L");
        map2.put(60,"LX");
        map2.put(70,"LXX");
        map2.put(80,"LXXX");
        map2.put(90,"XC");
        map2.put(100,"C");
        map2.put(200,"CC");
        map2.put(300,"CCC");
        map2.put(400,"CD");
        map2.put(500,"D");
        map2.put(600,"DC");
        map2.put(700,"DCC");
        map2.put(800,"DCCC");
        map2.put(900,"CM");
        map2.put(1000,"M");
        map2.put(2000,"MM");
        map2.put(3000,"MMM");
        
        StringBuilder sb = new StringBuilder();
        
        int b1= sum%1000;
        int a1= sum-b1;
        int b2=b1%100;
        int a2=b1-b2;
        int b3=b2%10;
        int a3=b2-b3;
        int a4=b3;
        //System.out.printf("a1:%d a2:%d a3:%d a4:%d\n",a1,a2,a3,a4);
        sb.append(map2.get(a1)).append(map2.get(a2)).append(map2.get(a3)).append(map2.get(a4));
        System.out.println(sb);
    }
}