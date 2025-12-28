import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static int size;
    public static int sum;
    public static int num;
    public static int arr[];
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int m= Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int t=0;t<m;t++){
            sum=1;
            num=1;
            arr = new int[30];
            Map<String,List<String>> map = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            for(int i=0;i<n;i++){
                st= new StringTokenizer(br.readLine());
                String str1 = st.nextToken();
                String str2 = st.nextToken();
                List<String> s = map.get(str2);
                if(s==null){
                    s= new ArrayList<>();
                    map.put(str2, s);
                }
                s.add(str1);
            }
            size = map.size();
            Collection<List<String>> values = map.values();
            int k=0;
            for(List<String> s : values){
                arr[k++] = s.size();
            }
          //  System.out.println("size: "+ size);
         //   for(k=0;k<size;k++){
        //       System.out.println(arr[k]);
        //    }

            for(int i=0;i<size;i++){
                sum*=arr[i]+1;
            }

            bw.write(Integer.toString(sum-1));
            bw.newLine();
            
        }
        bw.flush();
    }

    
}    
