package net.dd.filters;

import io.jsonwebtoken.Claims;
import net.dd.enums.ApiEnum;
import net.dd.exception.GlobalException;
import net.dd.utils.JWTUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JWTTokenFilter extends HandlerInterceptorAdapter {

    /**
     *
     */
    public static final String NOLOGIN = "/user/login,/user/register,/user/code,/product/list,/product/listAll";
    private static final String[] lst = NOLOGIN.split(",");

    /**
     * 这个方法是拦截进入接口前
     * @param request 请求对象
     * @param response 响应对象
     * @param handler 处理
     * @return 是否放行
     * @throws Exception 异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return check(request, response, handler);
    }

    private boolean check(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if(request.getMethod().equals("OPTIONS")){
            return true;
        }
        // 获取JWT信息
        String servletPath = request.getServletPath(); // 接口
        // 判断请求的接口是否需要登录
        for (String s : lst) if (s.equals(servletPath)) return true;
        // 解析
        Claims claims = verifyJWTToken(request);
        if (claims == null) throw new GlobalException(ApiEnum.TOKEN_NOT_MATCH);
        Long userId = claims.get("userId", Long.class);
        String username = claims.get("username", String.class);
        request.setAttribute("userId", userId);
        request.setAttribute("username", username);
        // 鉴权
        // 签名校验
        // 数据解析重取
        return true;
    }

    private Claims verifyJWTToken(HttpServletRequest request) {
        String header = request.getHeader(JWTUtil.HEADER);
        Claims claims;
        try {
            claims = JWTUtil.checkToken(header, null);
        } catch (Exception e) {
            throw new GlobalException(ApiEnum.TOKEN_NOT_MATCH);
        }
        return claims;
    }
}
