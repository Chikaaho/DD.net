//package net.dd.config;
//
//import lombok.Data;
//import lombok.extern.slf4j.Slf4j;
//import net.dd.annotaion.JwtIgnore;
//import net.dd.pojo.Audience;
//import net.dd.utils.JwtTokenUtil;
//import org.apache.commons.lang3.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.BeanFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpMethod;
//import org.springframework.web.context.support.WebApplicationContextUtils;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * @author Chika
// * @program DDNet
// * @create 2021/5/8 - 09:45
// **/
//@Slf4j
//@Data
//public class JwtInterceptor implements HandlerInterceptor {
//
//    private final Logger log = LoggerFactory.getLogger(this.getClass());
//
//    private Audience audience;
//    @Autowired
//    public void setAudience(Audience audience) {
//        this.audience = audience;
//    }
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        // 自定义注解JwtIgnore，忽略带JwtIgnore注解的请求, 不做后续token认证校验
//        if (handler instanceof HandlerMethod) {
//            HandlerMethod handlerMethod = (HandlerMethod) handler;
//            JwtIgnore jwtIgnore = handlerMethod.getMethodAnnotation(JwtIgnore.class);
//            if (jwtIgnore != null) {
//                return true;
//            }
//        }
//        if (HttpMethod.OPTIONS.equals(request.getMethod())) {
//            response.setStatus(HttpServletResponse.SC_OK);
//            return true;
//        }
//        // 获取请求头信息authorization信息
//        final String authHeader = request.getHeader(JwtTokenUtil.AUTH_HEADER_KEY);
//        log.info("## authHeader= {}", authHeader);
//        if (StringUtils.isBlank(authHeader) || !authHeader.startsWith(JwtTokenUtil.TOKEN_PREFIX)) {
//            log.info("### 用户未登录，请先登录 ###");
//            throw new RuntimeException("用户未登录，请先登录");
//        }
//        // 获取token
//        final String token = authHeader.substring(7);
//        if(audience == null){
//            BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
//            audience = (Audience) factory.getBean("audience");
//        }
//        // 验证token是否有效--无效已做异常抛出，由全局异常处理后返回对应信息
//        JwtTokenUtil.parseJWT(token, audience.getBase64Secret());
//        return true;
//    }
//
//}
