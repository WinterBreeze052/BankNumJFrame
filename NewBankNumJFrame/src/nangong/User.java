package nangong;

public class User {
    String userName;
    boolean vip;
    String number;

    public User() {
    }

    public User(String userName, boolean vip, String number) {
        this.userName = userName;
        this.vip = vip;
        this.number = number;
    }

    /**
     * ��ȡ
     *
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * ����
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * ��ȡ
     *
     * @return vip
     */
    public boolean isVip() {
        return vip;
    }

    /**
     * ����
     *
     * @param vip
     */
    public void setVip(boolean vip) {
        this.vip = vip;
    }

    /**
     * ��ȡ
     *
     * @return number
     */
    public String getNumber() {
        return number;
    }

    /**
     * ����
     *
     * @param number
     */
    public void setNumber(String number) {
        this.number = number;
    }

    public String toString() {
        String vipp;
        if (vip) {
            vipp = "VIP�ͻ�";
        } else {
            vipp = "��ͨ�ͻ�";
        }
        return "�û��� : " + userName + "-----" + vipp + "-----" + number;
    }
}
