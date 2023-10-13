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
     * 获取
     *
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取
     *
     * @return vip
     */
    public boolean isVip() {
        return vip;
    }

    /**
     * 设置
     *
     * @param vip
     */
    public void setVip(boolean vip) {
        this.vip = vip;
    }

    /**
     * 获取
     *
     * @return number
     */
    public String getNumber() {
        return number;
    }

    /**
     * 设置
     *
     * @param number
     */
    public void setNumber(String number) {
        this.number = number;
    }

    public String toString() {
        String vipp;
        if (vip) {
            vipp = "VIP客户";
        } else {
            vipp = "普通客户";
        }
        return "用户名 : " + userName + "-----" + vipp + "-----" + number;
    }
}
