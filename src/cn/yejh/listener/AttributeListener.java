package cn.yejh.listener; /**
 * @author yejh
 * @create 2019-10_04 14:30
 * application、session、request属性监听器
 * attributeAdded 添加属性时回调
 * attributeRemoved 删除属性时回调
 * attributeReplaced 更改属性时回调
 */

/*
@WebListener()
public class AttributeListener implements ServletRequestAttributeListener,
        HttpSessionAttributeListener, ServletContextAttributeListener {

    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        String attrName = scae.getName();
        Object attrValue = scae.getServletContext().getAttribute(attrName);
        System.out.println("ServletContext【增加】属性：" + attrName + "---" + attrValue);
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        String attrName = scae.getName();
        System.out.println("ServletContext【删除】属性：" + attrName);
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        String attrName = scae.getName();
        Object attrValue = scae.getServletContext().getAttribute(attrName);
        System.out.println("ServletContext【替换】属性：" + attrName + "---" + attrValue);
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        String attrName = srae.getName();
        Object attrValue = srae.getValue();
        System.out.println("ServletRequest【增加】属性：" + attrName + "---" + attrValue);
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        String attrName = srae.getName();
        System.out.println("ServletRequest【删除】属性：" + attrName);
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        String attrName = srae.getName();
        Object attrValue = srae.getValue();
        System.out.println("ServletRequest【替换】属性：" + attrName + "---" + attrValue);
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        String attrName = httpSessionBindingEvent.getName();
        Object attrValue = httpSessionBindingEvent.getValue();
        System.out.println("HttpSession【增加】属性：" + attrName + "---" + attrValue);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        String attrName = httpSessionBindingEvent.getName();
        System.out.println("HttpSession【删除】属性：" + attrName);
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        String attrName = httpSessionBindingEvent.getName();
        Object attrValue = httpSessionBindingEvent.getValue();
        System.out.println("HttpSession【替换】属性：" + attrName + "---" + attrValue);
    }
}
*/
