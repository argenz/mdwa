package s26;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter(dispatcherTypes = { DispatcherType.REQUEST }, urlPatterns = { "/*" }) 					//tutte le url
public class FilterAllReq implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(FilterAllReq.class);

    @Override
    public void init(FilterConfig fc) throws ServletException {
        // nothing to do here, currently
    }

    @Override
    public void destroy() {
        // nothing to do here, currently
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if (!(request instanceof HttpServletRequest)) {
            logger.info("Strange. Not a HttpServletRequest");
        } else {
            HttpServletRequest hsr = (HttpServletRequest) request;

            StringBuffer url = hsr.getRequestURL();
            String query = hsr.getQueryString();        //sta modificando la query
            if (query != null) {
                url.append("?");
                url.append(query);
            }

            logger.trace("filter all on " + url.toString());
        }
        // ...
        chain.doFilter(request, response);
    }
}
