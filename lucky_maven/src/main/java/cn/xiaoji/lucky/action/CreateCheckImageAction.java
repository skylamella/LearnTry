package cn.xiaoji.lucky.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.xiaoji.lucky.utils.CommonUse;
/**
 * 验证码生成Action
 * @author lamella
 *
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class CreateCheckImageAction extends ActionSupport {
	private ByteArrayInputStream inputStream;

    private static int WIDTH = 100;

    private static int HEIGHT = 32;

	public ByteArrayInputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(ByteArrayInputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	private void drawBackground(Graphics g)
    {
        // 画背景
        g.setColor(new Color(0xDCDCDC));
        g.fillRect(0, 0, WIDTH, HEIGHT);
        // 随机产生 120 个干扰点
        for (int i = 0; i < 120; i++)
        {
            int x = (int) (Math.random() * WIDTH);
            int y = (int) (Math.random() * HEIGHT);
            int red = (int) (Math.random() * 255);
            int green = (int) (Math.random() * 255);
            int blue = (int) (Math.random() * 255);
            g.setColor(new Color(red, green, blue));
            g.drawOval(x, y, 1, 0);
        }
    }
	
	private void drawRands(Graphics g, String rands)
    {
        g.setColor(Color.BLACK);
        g.setFont(new Font(null, Font.ITALIC | Font.BOLD, 18));
        // 在不同的高度上输出验证码的每个字符
        g.drawString("" + rands.charAt(0), 1, 17);
        g.drawString("" + rands.charAt(1), 16, 15);
        g.drawString("" + rands.charAt(2), 31, 18);
        g.drawString("" + rands.charAt(3), 46, 16);
    }
	
    public String createCHKImage() throws Exception
    {
        HttpServletResponse response = ServletActionContext.getResponse();
        // 设置浏览器不要缓存此图片
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        String rands = CommonUse.createRandom(4);
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
                BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        // 产生图像
        drawBackground(g);
        drawRands(g, rands);
        // 结束图像 的绘制 过程， 完成图像
        g.dispose();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpeg", outputStream);
        ByteArrayInputStream input = new ByteArrayInputStream(outputStream
                .toByteArray());
        this.setInputStream(input);
        ActionContext.getContext().getSession().put("checkCode", rands);
        input.close();
        outputStream.close();
        return SUCCESS;
    }
}
