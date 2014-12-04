package com.carpg.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		 // 获取uri地址
        HttpServletRequest request=(HttpServletRequest)arg0;
        HttpServletResponse response = (HttpServletResponse) arg1;
        String uri = request.getRequestURI();
        String context=request.getContextPath();
        uri = uri.substring(context.length());
        System.out.println("过滤器"+ request.getSession().getAttribute("sessioninfo"));
        if(null == request.getSession().getAttribute("sessioninfo")) {
            request.setAttribute("message","您没有这个权限");
            System.out.println("权限不够");
            //request.getRequestDispatcher("/JSP/login.jsp").forward(arg0,arg1);
            response.sendRedirect("/JSP/login.jsp");
            return;
        }
        else{
        	//过滤判断成功，将请求继续发到目的地址
        	arg2.doFilter(arg0, arg1);
        }
      //判断admin级别网页的浏览权限
        if(uri.startsWith("/admin")) {
            
        }
        //判断manage级别网页的浏览权限
        if(uri.startsWith("/manage")) {
            //这里省去
            }
        //下面还可以添加其他的用户权限，省去。
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
