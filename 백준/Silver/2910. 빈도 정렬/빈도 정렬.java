import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        Map<Integer,Pair> map =new HashMap<>();
        st= new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int x= Integer.parseInt(st.nextToken());
            Pair p = map.get(x);
            if(p==null){
                p=new Pair(x, i,0);
                map.put(x,p);
            }
            p.freq+=1;
        }
        
        List<Pair> list = new ArrayList<>();
        for(Map.Entry<Integer,Pair> e:map.entrySet()){
        //    System.out.println(e.getValue().value);
            list.add(e.getValue());
        }
        //System.out.println("as");
        list.sort((x,y)->{
            if(x.freq!=y.freq){
                return Integer.compare(y.freq,x.freq);
            }else{
                return Integer.compare(x.first,y.first);
            }
        });

        for(int i=0;i<list.size();i++){
            Pair p = list.get(i);
           // System.out.println(p.value+" "+p.first+" "+p.freq);
            for(int j=0;j<p.freq;j++){
                bw.write(Integer.toString(p.value));
                bw.write(" ");
            }
        }
        bw.flush();
        bw.close();
            
    }
    

    public static class Pair{
        public int value;
        public int first;
        public int freq;
        public Pair(int value,int first,int freq){
            this.value =value;
            this.first = first;
            this.freq = freq;
        }
    }
    
}