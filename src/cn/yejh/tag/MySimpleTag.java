package cn.yejh.tag;/**
 * @author yejh
 * @create 2019-10_17 15:06
 */

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * @description: TODO
 **/
public class MySimpleTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        JspContext jspContext = getJspContext();
        PageContext pageContext = (PageContext)jspContext;
        //通过pageContext得到session内置对象
        HttpSession session = pageContext.getSession();
        String userName = (String) session.getAttribute("userName");
        if(userName != null){
            getJspBody().invoke(null);
        }

    }
}
