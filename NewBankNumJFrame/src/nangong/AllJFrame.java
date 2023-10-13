package nangong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;

public class AllJFrame extends JFrame implements ActionListener, MouseListener {
    ArrayList<User> userList = new ArrayList<>();//队列
    ArrayList<User> userList2 = new ArrayList<>();//过号区
    User getNumberUser = new User();//取号用户
    User callNumberUser = new User();//叫号用户
    static String showStr;//展示区信息
    static int count;//队列号

    public AllJFrame() {
        initView();
        initJFrame();
        this.setVisible(true);//设置显示窗口
    }

    Image iconImage = new ImageIcon("image/图标御坂美琴.png").getImage();//图标

    public void initJFrame() {//初始化窗口
        this.setSize(800, 400);//设置大小
        this.setTitle("银行排队叫号器 v2.0");//设置标题
        this.setIconImage(iconImage);//设置图标
        this.setAlwaysOnTop(true);//设置置顶
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设置关闭模式
        this.setLocationRelativeTo(null);//设置窗口居中
        this.setLayout(null);//设置取消默认排列
    }//初始化窗口

    //创建窗口内组件
    JEditorPane loginUserText = new JEditorPane();//用户名输入框
    JRadioButton rb1 = new JRadioButton("普通用户", true);
    JRadioButton rb2 = new JRadioButton("VIP用户");
    //创建菜单条目
    JMenuItem jmi2 = new JMenuItem("退出系统");
    JMenuItem jmi3 = new JMenuItem("病友群");
    //创建图片按钮
    JLabel jl1 = new JLabel(new ImageIcon("button/取号.png"));
    JLabel jl2 = new JLabel(new ImageIcon("button/叫号.png"));
    JLabel jl3 = new JLabel(new ImageIcon("button/办理.png"));
    JLabel jl4 = new JLabel(new ImageIcon("button/过号.png"));
    JLabel jl5 = new JLabel(new ImageIcon("button/展示区.png"));
    JLabel jl6 = new JLabel(new ImageIcon("button/过号区.png"));
    JLabel jl7 = new JLabel(new ImageIcon("button/查队列.png"));

    public void initView() {//初始化视窗
        //创建菜单栏
        JMenuBar jMenuBar = new JMenuBar();
        //创建菜单选项
        JMenu jm1 = new JMenu("功能");
        JMenu jm2 = new JMenu("关于");
        //将菜单条目添加至菜单选项
        jm1.add(jmi2);
        jm2.add(jmi3);
        //将菜单选项添加至菜单栏
        jMenuBar.add(jm1);
        jMenuBar.add(jm2);
        //将菜单栏添加至窗口容器
        this.setJMenuBar(jMenuBar);

        //对菜单条目进行动作监听
        jmi2.addActionListener(this);
        jmi3.addActionListener(this);

        //设置按钮的位置大小
        jl1.setBounds(93, 220, 230, 50);//取号
        jl2.setBounds(440, 40, 120, 50);//叫号
        jl3.setBounds(440, 130, 120, 50);//办理
        jl4.setBounds(440, 220, 120, 50);//过号
        jl5.setBounds(620, 40, 120, 50);//展示区
        jl6.setBounds(620, 130, 120, 50);//过号区
        jl7.setBounds(620, 220, 120, 50);//查队列
        //对按钮进行动作监听
        jl1.addMouseListener(this);
        jl2.addMouseListener(this);
        jl3.addMouseListener(this);
        jl4.addMouseListener(this);
        jl5.addMouseListener(this);
        jl6.addMouseListener(this);
        jl7.addMouseListener(this);
        //将按钮添加至容器
        this.getContentPane().add(jl1);
        this.getContentPane().add(jl2);
        this.getContentPane().add(jl3);
        this.getContentPane().add(jl4);
        this.getContentPane().add(jl5);
        this.getContentPane().add(jl6);
        this.getContentPane().add(jl7);

        //设置输入框
        loginUserText.setBounds(150, 74, 200, 25);
        this.getContentPane().add(loginUserText);

        //设置单选按钮，确定用户类型
        rb1.setBounds(155, 110, 80, 50);
        rb2.setBounds(245, 110, 80, 50);
        //创建按钮组，确保只有一个能被选中
        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        //将单选按钮添加至容器
        this.getContentPane().add(rb1);
        this.getContentPane().add(rb2);

        //设置登记框背景
        JLabel loginBgi = new JLabel(new ImageIcon("image/登记框.png"));
        loginBgi.setBounds(35, 40, 350, 139);
        this.getContentPane().add(loginBgi);
        //设置整个窗口背景
        JLabel bgi = new JLabel(new ImageIcon("image/背景图片1.png"));
        bgi.setBounds(0, 0, 800, 400);
        this.getContentPane().add(bgi);
    }//初始化视窗

    public static void sort(ArrayList<User> UserList) {//排序
        if (UserList.get(UserList.size() - 1).isVip()) {//判断末尾是否是vip
            for (int i = UserList.size() - 1; i > 0; i--) {//循环长度-1次
                if (!UserList.get(i - 1).isVip()) {//判断前面一个索引是不是VIP
                    Collections.swap(UserList, i, i - 1);//不是就交换
                } else {
                    return;//是就停止循环返回
                }
            }
        }
    }//排序

    public String getAreaString(ArrayList<User> list) {//获得队列字符串
        StringBuilder sb = new StringBuilder();
        if (list.size() == 0) {
            return null;
        }
        for (int i = 0; i < list.size(); i++) {
            sb.append(i + 1 + "  ").append(list.get(i).toString()).append("\n");
        }
        return sb.toString();
    }//获得队列字符串

    @Override
    public void actionPerformed(ActionEvent e) {//动作监听
        Object obj = e.getSource();
        if (obj == jmi2) {
            System.exit(0);
        } else if (obj == jmi3) {
            JLabel jLabel = new JLabel(new ImageIcon("image/交流群二维码.png"));
            jLabel.setSize(238, 250);//238,250
            Tips withJd = new Tips("交流群", jLabel, 300, 300);
            withJd.jd();
        }
    }//动作监听

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {//鼠标监听-鼠标松开
        Object obj = e.getSource();
        if (obj == jl1) {//取号
            String UserName = loginUserText.getText();
            String str = "\\w{5,20}";
            if (!UserName.matches(str)) {
                JLabel jLabel = new JLabel("  用户名不合法！5-20位（包含“A-Z”，“a-z”，“0-9”，“_”）");
                Tips tip = new Tips("提示", jLabel, 350, 80);
                tip.jd();
                return;
            }
            count++;
            String number;
            if (rb2.isSelected()) {
                number = "V" + count + "号";
                JLabel jLabel = new JLabel("    取得的号码为" + number);
                Tips tip = new Tips("提示", jLabel, 200, 80);
                tip.jd();
            } else {
                number = "A" + count + "号";
                JLabel jLabel = new JLabel("    取得的号码为" + number);
                Tips tip = new Tips("提示", jLabel, 200, 80);
                tip.jd();
            }
            getNumberUser.setUserName(UserName);
            getNumberUser.setVip(rb2.isSelected());
            getNumberUser.setNumber(number);
            userList.add(getNumberUser);
            getNumberUser = new User();
            sort(userList);
        } else if (obj == jl2) {//叫号
            if (userList.size() == 0) {
                JLabel jLabel = new JLabel("  当前没有排队的用户，叫号失败！");
                Tips tip = new Tips("提示", jLabel, 250, 80);
                tip.jd();
                return;
            }
            showStr = "请 " + userList.get(0).getNumber() + " 客户到柜台办理业务！";
            JLabel jLabel = new JLabel(showStr);
            Tips tip = new Tips("提示", jLabel, 350, 80);
            tip.jd();
            callNumberUser = userList.get(0);//添加队列中第一个客户为叫号用户
        } else if (obj == jl3) {//办理
            if (userList.size() == 0) {
                JLabel jLabel = new JLabel("  当前没有叫号的用户，办理失败！");
                Tips tip = new Tips("提示", jLabel, 250, 80);
                tip.jd();
                return;
            }
            if (callNumberUser.getNumber() != null) {//判断是否有已叫号的客户
                showStr = userList.get(0).getNumber() + " 客户正在办理！";
                JLabel jLabel = new JLabel(showStr);
                Tips tip = new Tips("提示", jLabel, 350, 80);
                tip.jd();
                userList.remove(0);//删除队列
                callNumberUser = new User();//将正在办理的用户清空
            } else {//没有则提示
                JLabel jLabel = new JLabel("  当前没有叫号的客户，请等待叫号！");
                Tips tip = new Tips("提示", jLabel, 250, 80);
                tip.jd();
            }
        } else if (obj == jl4) {//过号
            if (userList.size() == 0) {
                JLabel jLabel = new JLabel("  当前没有叫号的用户，过号失败！");
                Tips tip = new Tips("提示", jLabel, 250, 80);
                tip.jd();
                return;
            }
            if (callNumberUser.getNumber() != null) {//判断是否有已叫号的客户
                JLabel jLabel = new JLabel(userList.get(0).getNumber() + " 已过号，请重新取号！");//有则过号
                Tips tip = new Tips("提示", jLabel, 350, 80);
                tip.jd();
                userList2.add(callNumberUser);//将此次叫号的客户加入过号区
                userList.remove(0);//队列中删除此次叫号的客户
                callNumberUser = new User();
            } else {
                JLabel jLabel = new JLabel("  当前没有叫号的客户，过号失败！");//没有则过号失败
                Tips tip = new Tips("提示", jLabel, 250, 80);
                tip.jd();
            }
        } else if (obj == jl5) {
            if (showStr == null) {
                JLabel jLabel = new JLabel("  展示区没有内容！");
                Tips tip = new Tips("提示", jLabel, 100, 80);
                tip.jd();
                return;
            }
            JLabel jLabel = new JLabel(showStr);
            Tips tip = new Tips("展示区", jLabel, 350, 80);
            tip.jd();
        } else if (obj == jl6) {
            String passStr = getAreaString(userList2);
            if (passStr == null) {
                JLabel jLabel = new JLabel("  过号区没有内容！");
                Tips tip = new Tips("提示", jLabel, 100, 80);
                tip.jd();
                return;
            }
            JEditorPane passText = new JEditorPane();//过号区内容
            passText.setText(passStr);
            passText.setEditable(false);
            Tips tip = new Tips("过号区", passText, 350, 400);
            tip.jd();
        } else if (obj == jl7) {
            String passStr = getAreaString(userList);
            if (passStr == null) {
                JLabel jLabel = new JLabel("  队列中没有客户！");
                Tips tip = new Tips("提示", jLabel, 100, 80);
                tip.jd();
                return;
            }
            JEditorPane passText = new JEditorPane();//过号区内容
            passText.setText(passStr);
            passText.setEditable(false);
            Tips tip = new Tips("查队列", passText, 350, 400);
            tip.jd();
        }
    }//鼠标监听-鼠标松开

    @Override
    public void mouseEntered(MouseEvent e) {//鼠标监听-鼠标划入
        Object obj = e.getSource();
        if (obj == jl1) {
            jl1.setIcon(new ImageIcon("button/（划入）取号.png"));
        } else if (obj == jl2) {
            jl2.setIcon(new ImageIcon("button/（划入）叫号.png"));
        } else if (obj == jl3) {
            jl3.setIcon(new ImageIcon("button/（划入）办理.png"));
        } else if (obj == jl4) {
            jl4.setIcon(new ImageIcon("button/（划入）过号.png"));
        } else if (obj == jl5) {
            jl5.setIcon(new ImageIcon("button/（划入）展示区.png"));
        } else if (obj == jl6) {
            jl6.setIcon(new ImageIcon("button/（划入）过号区.png"));
        } else if (obj == jl7) {
            jl7.setIcon(new ImageIcon("button/（划入）查队列.png"));
        }
    }//鼠标监听-鼠标划入

    @Override
    public void mouseExited(MouseEvent e) {//鼠标监听-鼠标划出
        Object obj = e.getSource();
        if (obj == jl1) {
            jl1.setIcon(new ImageIcon("button/取号.png"));
        } else if (obj == jl2) {
            jl2.setIcon(new ImageIcon("button/叫号.png"));
        } else if (obj == jl3) {
            jl3.setIcon(new ImageIcon("button/办理.png"));
        } else if (obj == jl4) {
            jl4.setIcon(new ImageIcon("button/过号.png"));
        } else if (obj == jl5) {
            jl5.setIcon(new ImageIcon("button/展示区.png"));
        } else if (obj == jl6) {
            jl6.setIcon(new ImageIcon("button/过号区.png"));
        } else if (obj == jl7) {
            jl7.setIcon(new ImageIcon("button/查队列.png"));
        }
    }//鼠标监听-鼠标划出

}