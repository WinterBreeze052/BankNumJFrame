package nangong;

import javax.swing.*;
import java.awt.*;

public class Tips extends JDialog{
    private String title;//��������
    private JLabel jLabel;//��������
    private int kuan;//������
    private int gao;//������
    JEditorPane Text;


    Image iconImage = new ImageIcon("image/ͼ����������.png").getImage();//����ͼ��

    public Tips(){

    }

    public void jd(){
        this.setTitle(title);//���õ�������
        this.setIconImage(iconImage);//���õ���ͼ��
        this.setSize(kuan,gao);//���õ������
        this.setAlwaysOnTop(true);//���õ����ö�
        this.setLocationRelativeTo(null);//���õ�������
        this.setModal(true);//���õ������ر��޷���������
        this.setVisible(true);//���õ�����ʾ
    }

    public Tips(String title, JLabel jLabel, int kuan, int gao) {
        this.title = title;
        this.jLabel = jLabel;
        this.kuan = kuan;
        this.gao = gao;
        this.getContentPane().add(jLabel);//���������뵯��
    }

    public Tips(String title, JEditorPane Text, int kuan, int gao) {
        this.title = title;
        this.Text = Text;
        this.kuan = kuan;
        this.gao = gao;
        this.getContentPane().add(Text);//���������뵯��
    }
}
