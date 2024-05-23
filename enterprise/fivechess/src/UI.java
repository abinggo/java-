import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class UI {

        public void  initui(){
            //初始化ui界面
            JFrame jf =new JFrame();
            jf.setSize(1200,900);//设置界面大小
            jf.setLocationRelativeTo(null);//位置显示居中处理,要么是窗口中央，要么是组键中央
            jf.setTitle("五子棋");
            jf.setDefaultCloseOperation(3);//关闭窗口后的操作，0不执行，1隐藏窗口，2如果没有其他窗口打开则退出程序，3退出程序
            //创建一个侧边栏
            //侧边栏用于放置按钮
            JPanel right_panel =new JPanel();
            //设置大小
            right_panel.setPreferredSize(new Dimension(200,0));//高度设置为0不代表没有高度，意味着高度由容器的布局管理器决定
            jf.add(right_panel,BorderLayout.EAST);
            right_panel.setBackground(new Color(92,167,186));
            //添加功能按钮
            //设置字体
//            JButton start=new JButton("开始");
//            start.setFont(new Font("宋体",Font.BOLD,20));
//
            JButton regret = new JButton("悔棋");
            regret.setFont(new Font("宋体", Font.BOLD, 20));
            regret.setPreferredSize(new Dimension(100, 50));

            regret.setBackground(Color.white);
            regret.setForeground(Color.black);
            regret.setMargin(new Insets(5, 5, 5, 5));

            JButton review = new JButton("复盘");
            review.setFont(new Font("宋体", Font.BOLD, 20));
            review.setPreferredSize(new Dimension(100, 50));

            review.setBackground(Color.BLUE);
            review.setForeground(Color.black);
            review.setMargin(new Insets(5, 5, 5, 5));

            JButton vsai=new JButton("人机对战");
            vsai.setFont(new Font("宋体",Font.BOLD,40));
            vsai.setPreferredSize(new Dimension(200, 100));

            vsai.setBackground(Color.BLUE);
            vsai.setForeground(Color.BLACK);
            vsai.setMargin(new Insets(5, 5, 5, 5));

            JButton vsman=new JButton("双人对战");
            vsman.setFont(new Font("宋体",Font.BOLD,40));
            vsman.setPreferredSize(new Dimension(200, 100));

            vsman.setBackground(Color.BLUE);
            vsman.setForeground(Color.black);
            vsman.setMargin(new Insets(5, 5, 5, 5));
           // 设置面板的边框，提供 10 像素的空白区域

            //right_panel.setLayout(new FlowLayout());
            right_panel.setLayout(new BoxLayout(right_panel, BoxLayout.Y_AXIS));
            right_panel.setBorder(new EmptyBorder(10, 10, 10, 10));
            //right_panel.add(start);
            right_panel.add(regret);
            right_panel.add(Box.createRigidArea(new Dimension(0, 10)));
            right_panel.add(review);
            right_panel.add(Box.createRigidArea(new Dimension(0, 10)));
            right_panel.add(vsai);
            right_panel.add(Box.createRigidArea(new Dimension(0, 10)));
            right_panel.add(vsman);
            regret.setAlignmentX(Component.CENTER_ALIGNMENT);
            review.setAlignmentX(Component.CENTER_ALIGNMENT);
            vsai.setAlignmentX(Component.CENTER_ALIGNMENT);
            vsman.setAlignmentX(Component.CENTER_ALIGNMENT);

            //设置棋盘面板
            Mpanel mpanel = new Mpanel();
            jf.add(mpanel,BorderLayout.CENTER);
            mpanel.setBackground(new Color(147,224,255));

            jf.setVisible(true);
            //第二步 画笔绘制
            //绘画画笔从应用组建中获取
            Graphics g = mpanel.getGraphics();
            //第三步 添加鼠标监听器
            gamemouse gm = new gamemouse(g,mpanel);
            mpanel.addMouseListener(gm);

            regret.addActionListener(gm);
            review.addActionListener(gm);
            vsai.addActionListener(gm);
            vsman.addActionListener(gm);
        }
    public void Win()
    {
        JFrame WIN= new JFrame("胜利");
        WIN.setSize(300,300);
        WIN.setLocationRelativeTo(null);
        WIN.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建一个 JLabel，设置文本、字体和颜色
        JLabel label = new JLabel("恭喜你，你赢了！", SwingConstants.CENTER);
        label.setFont(new Font("Serif", Font.BOLD, 24));
        label.setForeground(Color.GREEN);

        // 添加 JLabel 到 JFrame
        WIN.add(label);

        WIN.setVisible(true);
    }

}



