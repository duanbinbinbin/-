package com.bin.lookz.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *产生验证码图片
 */
public class CheckCodeServlet extends HttpServlet {

	private static final long serialVersionUID = 650758864976379528L;

	/**
	 * 验证码图片的宽度。
	 */
	private int width = 80;

	/**
	 * 验证码图片的高度。
	 */
	private int height = 30;

	/**
	 * 验证码字符个数
	 */
	private int codeCount = 4;

	/**
	 * xx
	 */
	private int xx = 0;

	/**
	 * 字体高度
	 */
	private int fontHeight;

	/**
	 * codeY
	 */
	private int codeY;

	/**
	 * codeSequence
	 */
	char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J',
			'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
			'X', 'Y', 'Z', '2', '3', '4', '5', '6', '7', '8', '9' };

	/**
	 * 初始化验证图片属性
	 */
	public void init() throws ServletException {
		// 从web.xml中获取初始信息
		// 宽度
		String strWidth = this.getInitParameter("width");
		// 高度
		String strHeight = this.getInitParameter("height");
		// 字符个数
		String strCodeCount = this.getInitParameter("codeCount");

		// 将配置的信息转换成数值
		try {
			if (strWidth != null && strWidth.length() != 0) {
				width = Integer.parseInt(strWidth);
			}
			if (strHeight != null && strHeight.length() != 0) {
				height = Integer.parseInt(strHeight);
			}
			if (strCodeCount != null && strCodeCount.length() != 0) {
				codeCount = Integer.parseInt(strCodeCount);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		//设置字体间距
		xx = (width + 60) / (codeCount + 5);
		//设置字体高度
		fontHeight = height - 10;
		codeY = height - 6;
	}

	/**
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws java.io.IOException
	 */
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, java.io.IOException {

		// 定义图像buffer
		BufferedImage buffImg = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D gd = buffImg.createGraphics();

		// 创建一个随机数生成器类
		Random random = new Random();

		// 将图像填充为白色
		gd.setColor(Color.WHITE);
		gd.fillRect(0, 0, width, height);

		// 创建字体，字体的大小应该根据图片的高度来定。
		Font font = new Font("微软雅黑", Font.PLAIN, fontHeight);
		// 设置字体。
		gd.setFont(font);

		// 画边框。
		gd.setColor(Color.WHITE);
		gd.drawRect(0, 0, width - 1, height - 1);

		// 随机产生16条干扰线，使图象中的认证码不易被其它程序探测到。
		gd.setColor( Color.GRAY );
		for (int i = 0; i < 120; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(3);
			int yl = random.nextInt(3);
			gd.drawLine(x, y, x + xl, y + yl);
		}

		// randomCode用于保存随机产生的验证码，以便用户登录后进行验证。
		StringBuffer randomCode = new StringBuffer();
		int red = 0, green = 0, blue = 0;

		// 随机产生codeCount数字的验证码。
		for (int i = 0; i < codeCount; i++) {
			// 得到随机产生的验证码数字。
			String strRand = String.valueOf(codeSequence[random.nextInt(32)]);
			// 产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。
			red = random.nextInt(200);
			green = random.nextInt(200);
			blue = random.nextInt(200);

			// 用随机产生的颜色将验证码绘制到图像中。
			//gd.setColor(Color.BLACK);
			gd.setColor(new Color(red,green,blue));
			gd.drawString(strRand, (i + 1) * xx, codeY);

			// 将产生的四个随机数组合在一起。
			randomCode.append(strRand);
		}

		// 将四位数字的验证码保存到Session中。
		HttpSession session = req.getSession();
		session.setAttribute("checkCode", randomCode.toString());

		// 禁止图像缓存。
		resp.setHeader("Pragma", "no-cache");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setDateHeader("Expires", 0);
		
		//响应类型为 图片类型
		resp.setContentType("image/jpeg");

		// 将图像输出到Servlet输出流中。
		ServletOutputStream sos = resp.getOutputStream();
		ImageIO.write(buffImg, "jpeg", sos);
		sos.close();

		System.out.println("验证码为: " + randomCode.toString());
	}

}