package com.jl;

import com.jl.pojo.User;
import com.jl.util.CookieUtil;
import com.jl.util.IPUtil;
import com.jl.util.ObjectMapperUtil;
import com.jl.util.UserThreadLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import redis.clients.jedis.JedisCluster;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: jl
 * @author: JL
 * @create: 2019-11-19 16:13
 * @description:
 **/
@Component    //表示交给Spring容器管理
public class UserInterceptor implements HandlerInterceptor {
    @Autowired
    private JedisCluster jedisCluster;


    /**
     * boolean: true 放行
     * false 拦截 必须配合重定向使用.
     * 业务思路:
     * 如何判断用户是否登录???
     * 步骤:
     * 1.动态获取Cookie中的JT_TICKET中的值.
     * 2.获取用户的IP地址,校验数据.
     * 3.查询redis服务器是否有数据.
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1.获取Cookie数据
        Cookie cookie = CookieUtil.getCookie(request, "JL_TICKET");
        if (cookie != null) {
            String ticket = cookie.getValue();
            //2.判断token是否有数据
            if (!StringUtils.isEmpty(ticket)) {
                //2.1判断redis集群中是否有数据
                if (jedisCluster.exists(ticket)) {
                    //2.2 校验IP
                    String nowIP = IPUtil.getIpAddr(request);
                    String realIP = jedisCluster.hget(ticket, "JL_USER_IP");
                    if (nowIP.equals(realIP)) {
                        String userJSON = jedisCluster.hget(ticket, "JL_USER");
                        User user = ObjectMapperUtil.toObject(userJSON, User.class);
                        //利用ThreadLocal方式动态获取数据
                        UserThreadLocal.setUser(user);
                        return true;//表示放行
                    }
                }
            }
        }
        response.sendRedirect("/user/login.html");
        return false;//表示拦截
    }

    /**
     * 在拦截器最后一步,实现数据清空
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        UserThreadLocal.remove();
    }
}
