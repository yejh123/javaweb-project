package cn.yejh.tag;/**
 * @author yejh
 * @create 2019-10_13 11:45
 */

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 * @description: TODO
 **/
public class toUpperCase extends BodyTagSupport {
    //第一步，告诉程序 我要将原来的hello变成大写，即将 doStartTag()的返回值设置成 EVAL_BODY_BUFFER (此步骤，已经在父类默认实现)
    //第二步：获取，并修改


    @Override
    public int doEndTag() throws JspException {
        BodyContent bodyContent = getBodyContent();
        String content = bodyContent.getString();
        System.out.println("缓冲区：" + content);
        content = content.toUpperCase();
        try {
            bodyContent.getEnclosingWriter().write(content);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return super.doEndTag();
    }
}
