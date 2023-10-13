package nangong;

import javax.swing.*;
import java.awt.*;

public class Tips extends JDialog{
    private String title;//弹窗标题
    private JLabel jLabel;//弹窗内容
    private int kuan;//弹窗宽
    private int gao;//弹窗高
    JEditorPane Text;


    Image iconImage = new ImageIcon("image/图标御坂美琴.png").getImage();//弹窗图标

    public Tips(){

    }

    public void jd(){
        this.setTitle(title);//设置弹窗标题
        this.setIconImage(iconImage);//设置弹窗图标
        this.setSize(kuan,gao);//设置弹窗宽高
        this.setAlwaysOnTop(true);//设置弹窗置顶
        this.setLocationRelativeTo(null);//设置弹窗居中
        this.setModal(true);//设置弹窗不关闭无法继续操作
        this.setVisible(true);//设置弹窗显示
    }

    public Tips(String title, JLabel jLabel, int kuan, int gao) {
        this.title = title;
        this.jLabel = jLabel;
        this.kuan = kuan;
        this.gao = gao;
        this.getContentPane().add(jLabel);//将容器加入弹窗
    }

    public Tips(String title, JEditorPane Text, int kuan, int gao) {
        this.title = title;
        this.Text = Text;
        this.kuan = kuan;
        this.gao = gao;
        this.getContentPane().add(Text);//将容器加入弹窗
    }
}
