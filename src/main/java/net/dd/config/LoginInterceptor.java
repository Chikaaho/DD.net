package net.dd.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 * @author Chika
 * @program DDNet
 * @create 2021/4/29 - 10:57
 **/
@Deprecated
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Enumeration<String> attributeNames = session.getAttributeNames();
        String username = null;
        while (attributeNames.hasMoreElements()) {
            username = (String) session.getAttribute(attributeNames.nextElement());
        }
        if (StringUtils.isEmpty(username) || username.trim().length() == 0) {
            response.sendRedirect(request.getContextPath() + "error");
            return false;
        } else {
            return true;
        }
    }
}
