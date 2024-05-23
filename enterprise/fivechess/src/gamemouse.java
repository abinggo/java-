import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class gamemouse implements MouseListener, ActionListener {
    public int x0 = 50, y0 = 50, size = 50, line = 19, chesssize = 50;
    //x0是设计棋盘时留下的矫正的相对位置
    public int count = 0;
    //存储棋子数据
    public int[][] Q = new int[line][line];
    public int realx = 0, realy = 0;
    //用于记录真正的下棋位置
    public int flag = 0, num = 0, AI_flag = 0;
    public String aiMode;
    //Q数组用于绘制棋子，Q1用于实现悔棋和重绘
    public chess[] Q1 = new chess[line * line];
    private Mpanel mp;
    //引用传递画笔
    public Graphics g;
    public int max = 0, max_x = 0, max_y = 0;
    private AI ai;
    public gamemouse(Graphics g, Mpanel mp) {
        this.g = g;
        this.mp = mp;
        this.mp.Q=Q;
        this.ai=new AI(line,Q,size,chesssize);
    }
    //各类初始化
    public void startinit(){//开始初始化
        flag=1;
        clean();
        count=0;
        num=0;
        AI_flag=0;
        for(int i=0;i< Q1.length;i++)
        {
            Q1[i]=null;
        }
    }
    public void regretinit(){
        if(num>1&&flag==1){
            if(AI_flag==1){
                chess Chess=Q1[num-1];
                Q[Chess.x][Chess.y]=0;
                Chess.flag=0;
                Chess=Q1[num-2];
                Q[Chess.x][Chess.y]=0;
                Chess.flag=0;
                count-=2;
                num-=2;
                mp.repaint();
            }
            else{
                chess Chess=Q1[num-1];
                Q[Chess.x][Chess.y]=0;
                Chess.flag=0;
                count--;
                num--;
                mp.repaint();
            }
        }
    }
    public void reviewinit(){
        clean();
        mp.paint(g);
        for(int i=0;i<=num;i++){
            if(Q1[i]!=null){
                chess Chess=Q1[i];
                try{
                    Thread.sleep(500);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if(Chess.flag==1){
                    g.setColor(Color.BLACK);
                    g.fillOval(Chess.x*size+x0-chesssize/2,Chess.y*size+y0-chesssize/2,chesssize,chesssize);
                    Q[Chess.x][Chess.y]=1;
                }
                if(Chess.flag==2){
                    g.setColor(Color.WHITE);
                    g.fillOval(Chess.x*size+x0-chesssize/2,Chess.y*size+y0-chesssize/2,chesssize,chesssize);
                    Q[Chess.x][Chess.y]=2;
                }
            }
        }
    }
    public void vsmaninit(){
        mp.repaint();
        drawStr("双人对战");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        mp.repaint();

    }
    public void vsaiinit(){
        mp.repaint();
        drawStr("人机对战");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        mp.repaint();
        AI_flag=1;
        Object[] options = {"简单模式", "困难模式"};
        int response = JOptionPane.showOptionDialog(
                null,//父组件
                "请选择游戏模式",//标题
                "人机对战",//也是字符串显示
                JOptionPane.YES_NO_OPTION,//选择
                JOptionPane.QUESTION_MESSAGE,//这是询问
                null,//是否有图标
                options,
                options[0]//默认第一个
        );
        if (response == 0) {
            aiMode = "easy";
        } else if (response == 1) {
            aiMode = "medium";
        }
    }

    public void clean(){
        for (int i=0;i<line;i++){
            for(int j=0;j<line;j++){
                Q[i][j]=0;
            }
        }
        mp.repaint();
    }
    public void drawStr(String m){
        g.setColor(Color.red);
        g.setFont(new Font("楷体",Font.BOLD,90));
        g.drawString(m,mp.getWidth()/2-200,mp.getHeight()/2-40);
    }
    public int is_win(){
        int count=0;
        //判断右边
        for(int i=realx+1;i<line;i++){
            if(Q[i][realy]==Q[realx][realy]){
                count++;
            }else break;
        }
        //判断左边
        for(int i=realx-1;i>=0;i--){
            if(Q[i][realy]==Q[realx][realy]){
                count++;
            }else  break;
        }
        if(count==4){return count;}
        //判断纵向
        count =0;
        for(int j=realy+1;j<line;j++){
            if(Q[realx][j]==Q[realx][realy]){
                count++;
            }else break;
        }
        for(int j=realy-1;j>=0;j--){
            if(Q[realx][j]==Q[realx][realy]){
                count++;
            }else break;
        }
        if(count==4){return count;}
        //判断斜向
        //从左到右主对角线
        count=0;
        for(int i=realx-1,j=realy-1;i>=0&&j>=0;i--,j--){
            if(Q[i][j]==Q[realx][realy]){
                count++;
            }
            else break;
        }
        for(int i=realx+1,j=realy+1;i<line&&j<line;i++,j++){
            if(Q[i][j]==Q[realx][realy]){
                count++;
            }
            else break;
        }//这边是要考虑边界问题记得
        if(count==4){return count;}
        count=0;
        //副对角线
        for(int i=realx-1,j=realy+1;i>=0&&j<line;i--,j++){
            if(Q[i][j]==Q[realx][realy]){
                count++;
            }
            else break;
        }
        for(int i=realx+1,j=realy-1;i<line&&j>=0;i++,j--){
            if(Q[i][j]==Q[realx][realy]){
                count++;
            }
            else break;
        }

        if(count==4){return count;}
        return 0;

    }


    public  void AI(){
        System.out.println("AI开始下棋");

        if(is_win()>=4)
        {
            System.out.println("Black win!");
            flag=0;
            drawStr("恭喜获得胜利！");
            return;
        }
        Point p;
        if(aiMode=="ease"){
             p = ai.easy();
        }
        else{p = ai.medium();}

        //在最大值的位置下棋
        g.setColor(Color.white);
        g.fillOval(p.x*size+x0-chesssize/2,p.y*size+y0-chesssize/2,chesssize,chesssize);
        chess Chess = new chess(p.x,p.y,2);
        Q1[num]=Chess;
        Q[p.x][p.y]=2;
        count++;
        num++;
        realx=p.x;
        realy=p.y;
        if(is_win()>=4)
        {
            System.out.println("判断输赢2");
            System.out.println("White win!");
            flag=0;
            drawStr("失败！");
        }


    }
    @Override
    public void mouseClicked(MouseEvent e) {
        //鼠标点击后，由鼠标监听器获取坐标
        int x = e.getX();
        int y = e.getY();

        if ((x - x0) % size > size / 2)//
        {realx = (x - x0) / size + 1;
            }
        else
            realx=(x-x0)/size;
        if ((y - y0) % size > size / 2)//
        {realy = (y - y0) / size + 1;
            }
        else
            realy = (y - y0) / size;
        System.out.println("realx"+realx);
        System.out.println("realy"+realy);

        if ((Q[realx][realy] == 1 || Q[realx][realy] == 2)) {
            System.out.println("你不能下在这里！");
        } else if (flag == 0) {
            return;
        }//这个是指是否点开始，与落子算法无关
        else {
            if (count % 2 == 0) {
                g.setColor(Color.black);
                g.fillOval(realx * size + x0 - chesssize / 2, realy * size + y0 - chesssize / 2, chesssize, chesssize);//椭圆形的左上角坐标
                chess Chess = new chess(realx, realy, 1);//存储棋子的相关数据
                Q1[num] = Chess;//记录棋子可以复盘和悔棋
                Q[realx][realy] = 1;
            }
            if (count % 2 == 1) {
                g.setColor(Color.white);
                g.fillOval(realx * size + x0 - chesssize / 2, realy * size + y0 - chesssize / 2, chesssize, chesssize);//椭圆形的左上角坐标
                chess Chess = new chess(realx, realy, 2);//存储棋子的相关数据
                Q1[num] = Chess;//记录棋子可以复盘和悔棋
                Q[realx][realy] = 2;
            }
            num++;
            count++;
        }
        if (AI_flag == 1) {
            AI();
        }
        if (AI_flag == 0) {

            if (is_win() >= 4) {
                if (Q[realx][realy] == 1) {
                    System.out.println("黑棋赢");
                    flag = 0;
                    drawStr("黑棋赢！");
                } else if (Q[realx][realy] == 2) {
                    System.out.println("白棋赢");
                    flag = 0;
                    drawStr("白棋赢！");
                }
            }
        }}



    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    @Override
    //按钮监听器
    public void actionPerformed(ActionEvent e) {
        String button = e.getActionCommand();
        switch (button){
            case "悔棋":
                this.regretinit();
                break;
            case "复盘":
                this.reviewinit();
                break;
            case "双人对战":
                this.startinit();
                this.vsmaninit();
                break;
            case "人机对战":
                this.startinit();
                this.vsaiinit();
                break;

        }
    }}


