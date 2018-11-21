package cn.frode.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class controller {
	@RequestMapping("/hello")
	public String hello(HttpServletRequest req,HttpServletResponse res) throws IOException{
		System.out.println("getRequestURL: "+req.getRequestURL());  
        System.out.println("getRequestURI: "+req.getRequestURI());  
        System.out.println("getQueryString: "+req.getQueryString());  
        System.out.println("getRemoteAddr: "+req.getRemoteAddr());  
        System.out.println("getRemoteHost: "+req.getRemoteHost());  
        System.out.println("getRemotePort: "+req.getRemotePort());  
        System.out.println("getRemoteUser: "+req.getRemoteUser());  
        System.out.println("getLocalAddr: "+req.getLocalAddr());  
        System.out.println("getLocalName: "+req.getLocalName());  
        System.out.println("getLocalPort: "+req.getLocalPort());  
        System.out.println("getMethod: "+req.getMethod());  
        System.out.println("-------request.getParamterMap()-------");  
        Map map = req.getParameterMap();
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
			String[] values = (String[]) map.get(key);
			for (String value : values) {
				System.out.println(key+"="+value);
			}
		 }
        System.out.println("--------request.getHeader()--------");
        //得到请求头的name集合
        Enumeration<String> em = req.getHeaderNames();
        while (em.hasMoreElements()) {
			String name = (String) em.nextElement();
			String value = req.getHeader(name);
			System.out.println(name+"="+value);
		}

		return "hello";
	}
}
