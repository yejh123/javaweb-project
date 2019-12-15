package cn.yejh.listener;/**
 * @author yejh
 * @create 2019-10_05 0:11
 * 活化钝化监听器
 * 实现了HttpSessionActivationListener接口的JavaBean对象可以感知自己被活化(反序列化)和钝化(序列化)的事件
 *
 * 活化:javabean对象和Session一起被反序列化(活化)到内存中。
 * 钝化:javabean对象存在Session中，当服务器把session序列化到硬盘上时，
 * 如果Session中的javabean对象实现了Serializable接口
 * 那么服务器会把session中的javabean对象一起序列化到硬盘上，
 * javabean对象和Session一起被序列化到硬盘中的这个操作称之为钝化
 */

/**
 * @description: TODO
 **/

/*
@WebListener()
public class BeanActivationListener implements HttpSessionActivationListener, Serializable {

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public BeanActivationListener(String userName) {
        this.userName = userName;
    }

    @Override
    public void sessionWillPassivate(HttpSessionEvent httpSessionEvent) {
        System.out.println("BeanActivationListener随着session对象钝化而钝化");
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent httpSessionEvent) {
        System.out.println("BeanActivationListener随着session对象活化而活化");

    }
}
*/
