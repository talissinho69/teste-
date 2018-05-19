package testefiltro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class gelagua
 */
@WebFilter("/*")
public class gelagua implements Filter {

   
    public gelagua() {
       
    }

	
	
	public void destroy() {
		
	}

	
	
	 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		if(request instanceof HttpServletRequest ){
			HttpServletRequest req = (HttpServletRequest)request;
			HttpServletResponse resp =(HttpServletResponse) response;
			if(
					!req.getRequestURI().equals("/teste/NewFile.jsp") || 
					!req.getRequestURI().equals("/teste/login")){
				String login = (String) req.getSession().getAttribute("usuario");
				if(login == null){
					resp.sendRedirect("/teste/NewFile.jsp");
				}else{
					
		chain.doFilter(request, response);
				}
			}
		}
		System.out.println("ola mundo");
	}
	

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
