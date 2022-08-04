package cn.happymaya.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * @author superhsc
 */
public class PreRequestLogFilter extends ZuulFilter {

    private static final Log log = LogFactory.getLog(PreRequestLogFilter.class);

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        log.info(
                String.format(
                        "send %s request to %s",
                        request.getMethod(),
                        request.getRequestURL().toString()
                )
        );
        return null;
    }

    @Override
    public boolean shouldFilter() {
        // 判断是否需要过滤
        return true;
    }

    @Override
    public int filterOrder() {
        // 过滤器的优先级，越大越靠后执行
        return 1;
    }

    @Override
    public String filterType() {
        // 过滤器类型
        return "pre";
    }
}
