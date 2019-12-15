package dao;/**
 * @author yejh
 * @create 2019-09_22 22:56
 */

/**
 * @description: TODO
 **/
public class StudentUser {
    private int id;
    private String userName;
    private String userPassword;

    public StudentUser(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
