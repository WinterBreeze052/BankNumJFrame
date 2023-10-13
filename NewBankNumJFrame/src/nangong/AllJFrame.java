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
    ArrayList<User> userList = new ArrayList<>();//����
    ArrayList<User> userList2 = new ArrayList<>();//������
    User getNumberUser = new User();//ȡ���û�
    User callNumberUser = new User();//�к��û�
    static String showStr;//չʾ����Ϣ
    static int count;//���к�

    public AllJFrame() {
        initView();
        initJFrame();
        this.setVisible(true);//������ʾ����
    }

    Image iconImage = new ImageIcon("image/ͼ����������.png").getImage();//ͼ��

    public void initJFrame() {//��ʼ������
        this.setSize(800, 400);//���ô�С
        this.setTitle("�����Ŷӽк��� v2.0");//���ñ���
        this.setIconImage(iconImage);//����ͼ��
        this.setAlwaysOnTop(true);//�����ö�
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//���ùر�ģʽ
        this.setLocationRelativeTo(null);//���ô��ھ���
        this.setLayout(null);//����ȡ��Ĭ������
    }//��ʼ������

    //�������������
    JEditorPane loginUserText = new JEditorPane();//�û��������
    JRadioButton rb1 = new JRadioButton("��ͨ�û�", true);
    JRadioButton rb2 = new JRadioButton("VIP�û�");
    //�����˵���Ŀ
    JMenuItem jmi2 = new JMenuItem("�˳�ϵͳ");
    JMenuItem jmi3 = new JMenuItem("����Ⱥ");
    //����ͼƬ��ť
    JLabel jl1 = new JLabel(new ImageIcon("button/ȡ��.png"));
    JLabel jl2 = new JLabel(new ImageIcon("button/�к�.png"));
    JLabel jl3 = new JLabel(new ImageIcon("button/����.png"));
    JLabel jl4 = new JLabel(new ImageIcon("button/����.png"));
    JLabel jl5 = new JLabel(new ImageIcon("button/չʾ��.png"));
    JLabel jl6 = new JLabel(new ImageIcon("button/������.png"));
    JLabel jl7 = new JLabel(new ImageIcon("button/�����.png"));

    public void initView() {//��ʼ���Ӵ�
        //�����˵���
        JMenuBar jMenuBar = new JMenuBar();
        //�����˵�ѡ��
        JMenu jm1 = new JMenu("����");
        JMenu jm2 = new JMenu("����");
        //���˵���Ŀ������˵�ѡ��
        jm1.add(jmi2);
        jm2.add(jmi3);
        //���˵�ѡ��������˵���
        jMenuBar.add(jm1);
        jMenuBar.add(jm2);
        //���˵����������������
        this.setJMenuBar(jMenuBar);

        //�Բ˵���Ŀ���ж�������
        jmi2.addActionListener(this);
        jmi3.addActionListener(this);

        //���ð�ť��λ�ô�С
        jl1.setBounds(93, 220, 230, 50);//ȡ��
        jl2.setBounds(440, 40, 120, 50);//�к�
        jl3.setBounds(440, 130, 120, 50);//����
        jl4.setBounds(440, 220, 120, 50);//����
        jl5.setBounds(620, 40, 120, 50);//չʾ��
        jl6.setBounds(620, 130, 120, 50);//������
        jl7.setBounds(620, 220, 120, 50);//�����
        //�԰�ť���ж�������
        jl1.addMouseListener(this);
        jl2.addMouseListener(this);
        jl3.addMouseListener(this);
        jl4.addMouseListener(this);
        jl5.addMouseListener(this);
        jl6.addMouseListener(this);
        jl7.addMouseListener(this);
        //����ť���������
        this.getContentPane().add(jl1);
        this.getContentPane().add(jl2);
        this.getContentPane().add(jl3);
        this.getContentPane().add(jl4);
        this.getContentPane().add(jl5);
        this.getContentPane().add(jl6);
        this.getContentPane().add(jl7);

        //���������
        loginUserText.setBounds(150, 74, 200, 25);
        this.getContentPane().add(loginUserText);

        //���õ�ѡ��ť��ȷ���û�����
        rb1.setBounds(155, 110, 80, 50);
        rb2.setBounds(245, 110, 80, 50);
        //������ť�飬ȷ��ֻ��һ���ܱ�ѡ��
        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        //����ѡ��ť���������
        this.getContentPane().add(rb1);
        this.getContentPane().add(rb2);

        //���õǼǿ򱳾�
        JLabel loginBgi = new JLabel(new ImageIcon("image/�Ǽǿ�.png"));
        loginBgi.setBounds(35, 40, 350, 139);
        this.getContentPane().add(loginBgi);
        //�����������ڱ���
        JLabel bgi = new JLabel(new ImageIcon("image/����ͼƬ1.png"));
        bgi.setBounds(0, 0, 800, 400);
        this.getContentPane().add(bgi);
    }//��ʼ���Ӵ�

    public static void sort(ArrayList<User> UserList) {//����
        if (UserList.get(UserList.size() - 1).isVip()) {//�ж�ĩβ�Ƿ���vip
            for (int i = UserList.size() - 1; i > 0; i--) {//ѭ������-1��
                if (!UserList.get(i - 1).isVip()) {//�ж�ǰ��һ�������ǲ���VIP
                    Collections.swap(UserList, i, i - 1);//���Ǿͽ���
                } else {
                    return;//�Ǿ�ֹͣѭ������
                }
            }
        }
    }//����

    public String getAreaString(ArrayList<User> list) {//��ö����ַ���
        StringBuilder sb = new StringBuilder();
        if (list.size() == 0) {
            return null;
        }
        for (int i = 0; i < list.size(); i++) {
            sb.append(i + 1 + "  ").append(list.get(i).toString()).append("\n");
        }
        return sb.toString();
    }//��ö����ַ���

    @Override
    public void actionPerformed(ActionEvent e) {//��������
        Object obj = e.getSource();
        if (obj == jmi2) {
            System.exit(0);
        } else if (obj == jmi3) {
            JLabel jLabel = new JLabel(new ImageIcon("image/����Ⱥ��ά��.png"));
            jLabel.setSize(238, 250);//238,250
            Tips withJd = new Tips("����Ⱥ", jLabel, 300, 300);
            withJd.jd();
        }
    }//��������

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {//������-����ɿ�
        Object obj = e.getSource();
        if (obj == jl1) {//ȡ��
            String UserName = loginUserText.getText();
            String str = "\\w{5,20}";
            if (!UserName.matches(str)) {
                JLabel jLabel = new JLabel("  �û������Ϸ���5-20λ��������A-Z������a-z������0-9������_����");
                Tips tip = new Tips("��ʾ", jLabel, 350, 80);
                tip.jd();
                return;
            }
            count++;
            String number;
            if (rb2.isSelected()) {
                number = "V" + count + "��";
                JLabel jLabel = new JLabel("    ȡ�õĺ���Ϊ" + number);
                Tips tip = new Tips("��ʾ", jLabel, 200, 80);
                tip.jd();
            } else {
                number = "A" + count + "��";
                JLabel jLabel = new JLabel("    ȡ�õĺ���Ϊ" + number);
                Tips tip = new Tips("��ʾ", jLabel, 200, 80);
                tip.jd();
            }
            getNumberUser.setUserName(UserName);
            getNumberUser.setVip(rb2.isSelected());
            getNumberUser.setNumber(number);
            userList.add(getNumberUser);
            getNumberUser = new User();
            sort(userList);
        } else if (obj == jl2) {//�к�
            if (userList.size() == 0) {
                JLabel jLabel = new JLabel("  ��ǰû���Ŷӵ��û����к�ʧ�ܣ�");
                Tips tip = new Tips("��ʾ", jLabel, 250, 80);
                tip.jd();
                return;
            }
            showStr = "�� " + userList.get(0).getNumber() + " �ͻ�����̨����ҵ��";
            JLabel jLabel = new JLabel(showStr);
            Tips tip = new Tips("��ʾ", jLabel, 350, 80);
            tip.jd();
            callNumberUser = userList.get(0);//��Ӷ����е�һ���ͻ�Ϊ�к��û�
        } else if (obj == jl3) {//����
            if (userList.size() == 0) {
                JLabel jLabel = new JLabel("  ��ǰû�нкŵ��û�������ʧ�ܣ�");
                Tips tip = new Tips("��ʾ", jLabel, 250, 80);
                tip.jd();
                return;
            }
            if (callNumberUser.getNumber() != null) {//�ж��Ƿ����ѽкŵĿͻ�
                showStr = userList.get(0).getNumber() + " �ͻ����ڰ���";
                JLabel jLabel = new JLabel(showStr);
                Tips tip = new Tips("��ʾ", jLabel, 350, 80);
                tip.jd();
                userList.remove(0);//ɾ������
                callNumberUser = new User();//�����ڰ�����û����
            } else {//û������ʾ
                JLabel jLabel = new JLabel("  ��ǰû�нкŵĿͻ�����ȴ��кţ�");
                Tips tip = new Tips("��ʾ", jLabel, 250, 80);
                tip.jd();
            }
        } else if (obj == jl4) {//����
            if (userList.size() == 0) {
                JLabel jLabel = new JLabel("  ��ǰû�нкŵ��û�������ʧ�ܣ�");
                Tips tip = new Tips("��ʾ", jLabel, 250, 80);
                tip.jd();
                return;
            }
            if (callNumberUser.getNumber() != null) {//�ж��Ƿ����ѽкŵĿͻ�
                JLabel jLabel = new JLabel(userList.get(0).getNumber() + " �ѹ��ţ�������ȡ�ţ�");//�������
                Tips tip = new Tips("��ʾ", jLabel, 350, 80);
                tip.jd();
                userList2.add(callNumberUser);//���˴νкŵĿͻ����������
                userList.remove(0);//������ɾ���˴νкŵĿͻ�
                callNumberUser = new User();
            } else {
                JLabel jLabel = new JLabel("  ��ǰû�нкŵĿͻ�������ʧ�ܣ�");//û�������ʧ��
                Tips tip = new Tips("��ʾ", jLabel, 250, 80);
                tip.jd();
            }
        } else if (obj == jl5) {
            if (showStr == null) {
                JLabel jLabel = new JLabel("  չʾ��û�����ݣ�");
                Tips tip = new Tips("��ʾ", jLabel, 100, 80);
                tip.jd();
                return;
            }
            JLabel jLabel = new JLabel(showStr);
            Tips tip = new Tips("չʾ��", jLabel, 350, 80);
            tip.jd();
        } else if (obj == jl6) {
            String passStr = getAreaString(userList2);
            if (passStr == null) {
                JLabel jLabel = new JLabel("  ������û�����ݣ�");
                Tips tip = new Tips("��ʾ", jLabel, 100, 80);
                tip.jd();
                return;
            }
            JEditorPane passText = new JEditorPane();//����������
            passText.setText(passStr);
            passText.setEditable(false);
            Tips tip = new Tips("������", passText, 350, 400);
            tip.jd();
        } else if (obj == jl7) {
            String passStr = getAreaString(userList);
            if (passStr == null) {
                JLabel jLabel = new JLabel("  ������û�пͻ���");
                Tips tip = new Tips("��ʾ", jLabel, 100, 80);
                tip.jd();
                return;
            }
            JEditorPane passText = new JEditorPane();//����������
            passText.setText(passStr);
            passText.setEditable(false);
            Tips tip = new Tips("�����", passText, 350, 400);
            tip.jd();
        }
    }//������-����ɿ�

    @Override
    public void mouseEntered(MouseEvent e) {//������-��껮��
        Object obj = e.getSource();
        if (obj == jl1) {
            jl1.setIcon(new ImageIcon("button/�����룩ȡ��.png"));
        } else if (obj == jl2) {
            jl2.setIcon(new ImageIcon("button/�����룩�к�.png"));
        } else if (obj == jl3) {
            jl3.setIcon(new ImageIcon("button/�����룩����.png"));
        } else if (obj == jl4) {
            jl4.setIcon(new ImageIcon("button/�����룩����.png"));
        } else if (obj == jl5) {
            jl5.setIcon(new ImageIcon("button/�����룩չʾ��.png"));
        } else if (obj == jl6) {
            jl6.setIcon(new ImageIcon("button/�����룩������.png"));
        } else if (obj == jl7) {
            jl7.setIcon(new ImageIcon("button/�����룩�����.png"));
        }
    }//������-��껮��

    @Override
    public void mouseExited(MouseEvent e) {//������-��껮��
        Object obj = e.getSource();
        if (obj == jl1) {
            jl1.setIcon(new ImageIcon("button/ȡ��.png"));
        } else if (obj == jl2) {
            jl2.setIcon(new ImageIcon("button/�к�.png"));
        } else if (obj == jl3) {
            jl3.setIcon(new ImageIcon("button/����.png"));
        } else if (obj == jl4) {
            jl4.setIcon(new ImageIcon("button/����.png"));
        } else if (obj == jl5) {
            jl5.setIcon(new ImageIcon("button/չʾ��.png"));
        } else if (obj == jl6) {
            jl6.setIcon(new ImageIcon("button/������.png"));
        } else if (obj == jl7) {
            jl7.setIcon(new ImageIcon("button/�����.png"));
        }
    }//������-��껮��

}