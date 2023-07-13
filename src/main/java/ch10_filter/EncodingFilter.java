package ch10_filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter("/ch10/*")
public class EncodingFilter extends HttpFilter implements Filter {
    public EncodingFilter() {
        super();
        System.out.println("EncodingFilter 생성자");
    }

	public void destroy() {
		System.out.println("EncodingFilter destroy()");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		request.setCharacterEncoding("utf-8");
		System.out.println("EncodingFilter doFilter()");
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("EncodingFilter init()");
	}

}
