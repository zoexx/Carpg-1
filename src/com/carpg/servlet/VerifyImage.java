package com.carpg.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class VerifyImage extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public VerifyImage() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("image/jpeg");    
		response.setHeader("Pragma", "No-cache");    
		response.setHeader("Cache-Control", "no-cache");    
		response.setDateHeader("Expires", 0);    
		HttpSession session = request.getSession();    
		// 在内存中创建图象    
		int width = 75, height = 25;    
		BufferedImage image = new BufferedImage(width, height,    
		        BufferedImage.TYPE_INT_RGB);    
		// 获取图形上下文    
		Graphics g = image.getGraphics();    
		// 生成随机类    
		Random random = new Random();    
		// 设定背景色    
		g.setColor(getRandColor(200, 250));    
		g.fillRect(0, 0, width, height);    
		// 设定字体    
		g.setFont(new Font("Times New Roman", Font.PLAIN, 24));    
		// 画边框    
		g.setColor(getRandColor(160, 200));    
		g.drawRect(0, 0, width - 1, height - 1);    
		// 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到    
		g.setColor(getRandColor(160, 200));    
		for (int i = 0; i < 155; i++) {    
		    int x = random.nextInt(width);    
		    int y = random.nextInt(height);    
		    int xl = random.nextInt(12);    
		    int yl = random.nextInt(12);    
		    g.drawLine(x, y, x + xl, y + yl);    
		}    
		// 取随机产生的认证码(4位数字)    
		String sRand = "";    
		for (int i = 0; i < 4; i++) {    
		    String rand = getStringRandom(1);   
		    sRand += rand;    
		    // 将认证码显示到图象中    
		    g.setColor(new Color(20 + random.nextInt(110), 20 + random    
		            .nextInt(110), 20 + random.nextInt(110)));    
		    // 调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成    
		    g.drawString(rand, 13 * i + 14, 20);    
		} 
		// 将认证码存入SESSION    
		session.setAttribute("vcode", sRand); 
		// 图象生效    
		g.dispose();    
		// 输出图象到页面    
		ImageIO.write(image, "JPEG", response.getOutputStream());
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
	
	Color getRandColor(int fc, int bc) {// 给定范围获得随机颜色    
	    Random random = new Random();    
	    if (fc > 255)    
	        fc = 255;    
	    if (bc > 255)    
	        bc = 255;    
	    int r = fc + random.nextInt(bc - fc);    
	    int g = fc + random.nextInt(bc - fc);    
	    int b = fc + random.nextInt(bc - fc);    
	    return new Color(r, g, b);    
	}  
	
	//生成随机数字和字母,  
    public String getStringRandom(int length) {  
          
        String val = "";  
        Random random = new Random();  
          
        //参数length，表示生成几位随机数  
        for(int i = 0; i < length; i++) {  
              
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";  
            //输出字母还是数字  
            if( "char".equalsIgnoreCase(charOrNum) ) {  
                //输出是大写字母还是小写字母  
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;  
                val += (char)(random.nextInt(26) + temp);  
            } else if( "num".equalsIgnoreCase(charOrNum) ) {  
                val += String.valueOf(random.nextInt(10));  
            }  
        }  
        return val;  
    }

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
