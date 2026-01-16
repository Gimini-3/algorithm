import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
         String king= st.nextToken();
        int kingX = king.charAt(0);
         int kingY = king.charAt(1);
      //  System.out.println((char)kingX+" "+(char)kingY);
        
        String stone = st.nextToken();        
        int stoneX = stone.charAt(0);
        int stoneY = stone.charAt(1);
      //  System.out.println((char)stoneX+" "+(char)stoneY);
        
        int n = Integer.parseInt(st.nextToken());
        for(int i=0;i<n;i++){
            String str = br.readLine();
          //  System.out.println();
          //  System.out.println(str);
            int moveX=0;
            int moveY=0;
            if(str.equals("R")){
                moveX=1;
                moveY=0;
            }else if(str.equals("L")){
                moveX=-1;
                moveY=0;
            }else if(str.equals("B")){
                moveX=0;
                moveY=-1;
            }else if(str.equals("T")){
                moveX=0;
                moveY=1;
            }else if(str.equals("RT")){
                moveX=1;
                moveY=1;
            }else if(str.equals("LT")){
                moveX=-1;
                moveY=1;
            }else if(str.equals("RB")){
                moveX=1;
                moveY=-1;
            }else if(str.equals("LB")){
                moveX=-1;
                moveY=-1;
            }
            int nextKingX= kingX+moveX;
            int nextKingY=kingY+moveY;
           // System.out.println(nextKingX+" "+nextKingY);
            //System.out.println("A:" +(int)'A'+" H:"+(int)'H'+" 1:"+(int)'1'+" 8:"+(int)'8');
            if(nextKingX<(int)'A'||nextKingX>(int)'H'||nextKingY<(int)'1'||nextKingY>(int)'8')continue;
            if(stoneX==nextKingX&&stoneY==nextKingY){
                int nextStoneX= stoneX+moveX;
                int nextStoneY = stoneY + moveY;
                if(nextStoneX<(int)'A'||nextStoneX>(int)'H'||nextStoneY<(int)'1'||nextStoneY>(int)'8')continue;
                stoneX=nextStoneX;
                stoneY=nextStoneY;
            }
            kingX=nextKingX;
            kingY=nextKingY;
          //   System.out.println((char)kingX+" "+(char)kingY);
        }
        System.out.println(Character.toString(kingX)+Character.toString(kingY));
        System.out.println(Character.toString(stoneX)+Character.toString(stoneY));
        
    }
}