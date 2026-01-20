import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int []arr = new int[n];        
        int []freq= new int[1000001];
        for(int i=0;i<n;i++){
            int value= Integer.parseInt(st.nextToken());
            freq[value]+=1;
            arr[i]=value;
        }
        int []result = new int[1000001];
        int top=-1;
        // 스택에는 값 넣음
        int[] stack = new int[1000001];
        stack[++top]=arr[n-1];
        result[n-1]=-1;
        for(int i=n-2;i>=0;i--){
            int value = arr[i];
            int value_freq= freq[value];
          //  System.out.printf("idx:%d value:%d value_freq:%d\n",i,value,value_freq);

            // 스택에서 최상값 꺼냄
            while(top>-1){
                int topValue = stack[top];
                int top_freq = freq[topValue];
                if(top_freq<=value_freq){
                    top--;
                }else{
                    break;
                }
            }
            if(top==-1){
                result[i]=-1;
            }else{
                result[i]=stack[top];
            }
            stack[++top]=value;
          //  for(int j=0;j<=top;j++){
         //       System.out.print(stack[j]+" ");
         //   }System.out.println();
        }
        StringBuilder sb = new StringBuilder();
        for(int j=0;j<n;j++){
            sb.append(result[j]).append(" ");
        }     
        System.out.println(sb);
    }
}