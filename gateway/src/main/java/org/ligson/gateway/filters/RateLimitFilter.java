package org.ligson.gateway.filters;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

/***
 * 常见的限流算法
 * 漏桶算法：漏桶算法比较简单，就是将流量放入桶中，漏桶同时也按照一定的速率流出，如果流量过快的话就会溢出(漏桶并不会提高流出速率)。溢出的流量则直接丢弃。不能应付暴增流量
 * 令牌桶算法：会以一个恒定的速率向固定容量大小桶中放入令牌，当有流量来时则取走一个或多个令牌。当桶中没有令牌则将当前请求丢弃或阻塞。
 */
@Slf4j
public class RateLimitFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        //每秒qps1000
        RateLimiter limit = RateLimiter.create(1000);
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.debug("访问api：{}", request.getRequestURI());
        double dl = limit.acquire();
        log.debug(dl + "");
        return null;
    }
}
