package com.kwdz.eureka.zuul.filter;

import com.kwdz.eureka.zuul.oauth2.SsoFeign;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.util.ZuulRuntimeException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * 服务网关过滤器
 */
@Component
public class AccessFilter extends ZuulFilter {

    @Autowired
    private SsoFeign ssoFeign;


    /**
     * 返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型：
     * pre：可以在请求被路由之前调用
     * route：在路由请求时候被调用
     * post：在route和error过滤器之后被调用
     * error：处理请求时发生错误时被调用
     *
     * @return
     */
    @Override
    public String filterType() {
        // PreDecoration之前运行
        return PRE_TYPE;
    }

    /**
     * 通过int值来定义过滤器的执行顺序
     */
    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER - 1;
    }


    /**
     * 返回一个boolean类型来判断该过滤器是否要执行
     */
    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        return request.getRequestURL().indexOf("v2/") < 0;
    }

    /**
     * 过滤器具体逻辑
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulRuntimeException {

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        HttpServletResponse response = ctx.getResponse();

        //访问路径
        String url = request.getRequestURL().toString();

        //从cookie里面取值（Zuul丢失Cookie的解决方案：https://blog.csdn.net/lindan1984/article/details/79308396）
        String accessToken = request.getParameter("accessToken");
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                if ("accessToken".equals(cookie.getName())) {
                    accessToken = cookie.getValue();
                }
            }
        }
        //过滤规则：cookie有令牌且存在于Redis，或者访问的是登录页面、登录请求则放行
        if (url.contains("sso-server/sso/loginPage") || url.contains("sso-server/sso/login") || (!StringUtils.isEmpty(accessToken) && ssoFeign.hasKey(accessToken))) {
            ctx.setSendZuulResponse(true);
            ctx.setResponseStatusCode(200);
            return null;
        } else {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            //重定向到登录页面
            try {
                response.sendRedirect("//http://118.24.203.80:8001/sso-server/sso/loginPage?url=" + url);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}