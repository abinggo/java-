import java.awt.*;
import java.util.HashMap;

public class AI {

    private int Q[][];
    private int line;
    private int size,x0,y0,chesssize;
    public AI(int line,int Q[][],int size,int chesssize){
        this.chesssize=chesssize;
        this.line=line;

        this.Q=Q;

        this.size=size;
    }
    public int score(int blackcoler , int whitecolor){
        //这个是分数权重表
        if(blackcoler>0&&whitecolor>0)//这一行代码有待思考
            return 0;
        if(blackcoler==0&&whitecolor==0)
            return 7;
        if(blackcoler==1)
            return 15;
        if(blackcoler==2)
            return 400;
        if(blackcoler==3)
            return 1800;
        if(blackcoler==4)
            return 100000;
        if(whitecolor==1)
            return 35;
        if(whitecolor==2)
            return 800;
        if(whitecolor==3)
            return 1500;
        if(whitecolor==4)
            return 800000;
        return -1;
    }
    public Point easy(){
       int blackcount=0,whitecount=0;
       int max=0,max_x=0,max_y=0;
       int[][] chessvalue=new int[line][line];
       //判断横的5个是否构成5子
       for(int i=0;i<line;i++){
           for(int j=0;j<line-4;j++){//为什么是减4而不是减5呢
               int k=j;//这是用来遍历后面5颗棋进行统计的
               while (k<j+5){
                   if(Q[i][k]==1){blackcount++;}
                   if(Q[i][k]==2){whitecount++;}
                   k++;
               }
               for(k=j;k<j+5;k++){
                   if(Q[i][k]==0){chessvalue[i][k]+=score(blackcount,whitecount);}
                   //这边记住用加因为这个点可能还有其他方向的加权
               }
               blackcount=0;
               whitecount=0;
           }
       }
       //判断纵向是否有5颗
       for(int i=0;i<line;i++){
           for(int j=0;j<line-4;j++){
               int k=j;
               while(k<j+5){
                   if(Q[k][i]==1){blackcount++;}
                   if(Q[k][i]==2){whitecount++;}
                   k++;
               }
               for(k=j;k<j+5;k++){
                   if(Q[k][i]==0){chessvalue[k][i]+=score(blackcount,whitecount);}
               }
               whitecount=0;
               blackcount=0;
           }
       }
       //主对角线（自己想的 棒棒）
       for(int i=0;i<line-4;i++){
           for(int j=0;j<line-4;j++){
               int k=0;
               while(k<5){
                   if(Q[i+k][j+k]==1){blackcount++;}
                   if(Q[i+k][j+k]==2){whitecount++;}
                   k++;
               }
               for(k=0;k<5;k++){
                   if(Q[i+k][j+k]==0){chessvalue[i+k][j+k]+=score(blackcount,whitecount);}
               }
               blackcount=0;
               whitecount=0;
           }
       }
       //副对角线
       for(int i=line-1;i>=4;i--){
           for(int j=0;j<line-4;j++){
               int k=0;
               while(k<5){
                   if(Q[i-k][j+k]==1){blackcount++;}
                   if(Q[i-k][j+k]==2){whitecount++;}
                   k++;
               }
               for(k=0;k<5;k++){
                   if(Q[i-k][j+k]==0){chessvalue[i-k][j+k]+=score(blackcount,whitecount);}
               }
           }
       }


       //寻找最大值
       for(int i=0;i<line;i++){
           for(int j=0;j<line;j++){
               if(chessvalue[i][j]>max){
                   max=chessvalue[i][j];
                   max_x=i;
                   max_y=j;
               }
           }
       }

       return new Point(max_x,max_y);
   }//比较难的算法，考虑到了比较多的棋型
    chessshape chessShape = new chessshape();
    HashMap<String, int[]> map = chessShape.getQixing();
    HashMap<String, Integer> weights = chessShape.getWeights();

// 使用values...

    public boolean match(int temp[],int target[]){
        for(int i=0;i< target.length;i++){

                if(temp[i]!=target[i]){return false;}

        }
        return true;
    }
    public int value(int[][]Q,int x,int y,int dx,int dy){
         int temp[]=new int[6];//代表连着5个不跳
         temp[0]=2;//因为ai是走白色
         for(int i=1;i<6;i++){
             int nx=x+i*dx;
             int ny=y+i*dy;
             if(nx<0||nx>=line||ny<0||ny>=line){
                 temp[i]=-1;//代表边界
             }
             else{temp[i]=Q[nx][ny];}
         }
         int temp1[]=new int[6];
         for (int i=-1;i<=4;i++){
             int nx=x+i*dx;
             int ny=y+i*dy;
             if(i==0){temp1[i+1]=2;continue;}
             if(nx<0||nx>=line||ny<0||ny>=line){
                 temp1[i+1]=-1;//代表边界
             }
             else{temp1[i+1]=Q[nx][ny];}
         }
        int temp2[]=new int[6];
        for (int i=-2;i<=3;i++){
            int nx=x+i*dx;
            int ny=y+i*dy;
            if(i==0){temp2[i+2]=2;continue;}
            if(nx<0||nx>=line||ny<0||ny>=line){
                temp2[i+2]=-1;//代表边界
            }
            else {temp2[i+2]=Q[nx][ny];}
        }


         int score=0;
         for(String i:map.keySet()){
             if(match(temp,map.get(i))){score+=weights.get(i);}
             if(match(temp1,map.get(i))){score+=weights.get(i);}
             if(match(temp2,map.get(i))){score+=weights.get(i);}
         }

 return score;
        }


   public Point medium(){
        int max=0;
        int max_x=0,max_y=0;
        for(int i=0;i<line;i++){
            for(int j=0;j<line;j++){
                if(Q[i][j]==0){
                    int value=0;
                    for(int dx=-1;dx<=1;dx++){
                        for(int dy=-1;dy<=1;dy++){
                            if(dx!=0||dy!=0){
                                value+=value(Q,i,j,dx,dy);

                            }
                            if(value>max){
                                max = value;
                                max_x = i;
                                max_y = j;
                                System.out.println(max);

                            }
                        }
                    }
                }
            }
        }
    return new Point(max_x,max_y);
   }

}

