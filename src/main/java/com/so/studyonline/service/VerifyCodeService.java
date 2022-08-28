package com.so.studyonline.service;

import com.alibaba.fastjson.JSONObject;
import com.so.studyonline.config.ErrorCode;
import com.so.studyonline.entity.SoConfig;
import com.so.studyonline.entity.VerifyCode;
import com.so.studyonline.exception.ExUserException;
import com.so.studyonline.mapper.VerifyCodeMapper;
import io.netty.util.internal.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Random;

@Slf4j
@Service
public class VerifyCodeService {

    private VerifyCodeMapper verifyCodeMapper;

    @Autowired
    public void setVerifyCodeMapper(VerifyCodeMapper verifyCodeMapper) {
        this.verifyCodeMapper = verifyCodeMapper;
    }

    private SoConfigService soConfigService;

    @Autowired
    public void setSoConfigService(SoConfigService soConfigService) {
        this.soConfigService = soConfigService;
    }

    /**
     * 读取请求发送者的IP
     *
     * @param request 请求信息
     * @return IP地址
     */
    public String getIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 校验验证码
     *
     * @param request    请求头
     * @param verifyCode 用户输入的验证码
     * @return false，验证码校验不通过
     */
    public boolean verifyCodeCheck(HttpServletRequest request, String verifyCode) {
        String ip = getIp(request);
        if (StringUtil.isNullOrEmpty(ip)) {
            throw new ExUserException(ErrorCode.VERIFY_CODE_PNG_IP_NULL);
        }
        VerifyCode verifyCodeSearch = verifyCodeMapper.findByIpAndTime(ip);
        long currentTime = System.currentTimeMillis();
        long codeTime = Long.parseLong(verifyCodeSearch.getAddTime());
        SoConfig soConfig = new SoConfig();
        soConfig.setKey("verify_code_valid");
        soConfig.setGroup("app_config");
        soConfig.setStatus("1");
        int value = Integer.parseInt(soConfigService.getConfigValue(soConfig));
        if ((currentTime - codeTime) > 1000 * value || !verifyCodeSearch.getCodeValue().equals(verifyCode)) {
            throw new ExUserException(ErrorCode.VERIFY_CODE_PNG_INVALID);
        }
        return true;
    }

    /**
     * 生成随机验证码图片
     *
     * @param request 用户请求信息
     * @param time    图片生成时间
     * @return 缓冲图片
     */
    public String createImg(HttpServletRequest request, String time) {
        // 1.数据准备
        VerifyCode vc = new VerifyCode();
        String ip = getIp(request);
        if (StringUtil.isNullOrEmpty(ip)) {
            throw new ExUserException(ErrorCode.VERIFY_CODE_PNG_IP_NULL);
        }
        vc.setFindIp(ip); // 插入访问IP
        vc.setAddTime(time); // 插入时间

        int width = 200, height = 60;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics gh = image.getGraphics(); // BasicStroke stroke = new BasicStroke(3);

        // 2.随机数
        Random r = new Random();

        // 填充颜色
        gh.setColor(new Color(r.nextInt(100), r.nextInt(100), r.nextInt(100)));
        gh.fillRect(0, 0, 200, 60);

        String code1 = String.valueOf(r.nextInt(9));
        String code2 = String.valueOf(r.nextInt(9));
        String code3 = String.valueOf(r.nextInt(9));
        String code4 = String.valueOf(r.nextInt(9));
        // 3.验证码插入
        try {
            vc.setCodeValue(code1 + code2 + code3 + code4);
            verifyCodeMapper.insertCode(vc);
            Graphics2D g2 = (Graphics2D) gh;
            Font font = new Font("Consolas", Font.BOLD, r.nextInt(15) + 45); // 字体
            AffineTransform affineTransform = new AffineTransform();
            affineTransform.rotate(Math.toRadians(r.nextInt(60)), 0, 0);
            Font rotatedFont = font.deriveFont(affineTransform);
            g2.setColor(new Color(r.nextInt(155) + 100, r.nextInt(155) + 100, r.nextInt(155) + 100));
            g2.setFont(rotatedFont);
            g2.drawString(code1, r.nextInt(10), r.nextInt(14) + 34);

            font = new Font("Consolas", Font.BOLD, r.nextInt(15) + 45); // 字体
            affineTransform = new AffineTransform();
            affineTransform.rotate(Math.toRadians(r.nextInt(60)), 0, 0);
            rotatedFont = font.deriveFont(affineTransform);
            g2.setColor(new Color(r.nextInt(155) + 100, r.nextInt(155) + 100, r.nextInt(155) + 100));
            g2.setFont(rotatedFont);
            g2.drawString(code2, r.nextInt(10) + 50, r.nextInt(14) + 34);

            font = new Font("Consolas", Font.BOLD, r.nextInt(15) + 45); // 字体
            affineTransform = new AffineTransform();
            affineTransform.rotate(Math.toRadians(r.nextInt(60)), 0, 0);
            rotatedFont = font.deriveFont(affineTransform);
            g2.setColor(new Color(r.nextInt(155) + 100, r.nextInt(155) + 100, r.nextInt(155) + 100));
            g2.setFont(rotatedFont);
            g2.drawString(code3, r.nextInt(10) + 100, r.nextInt(14) + 34);

            font = new Font("Consolas", Font.BOLD, r.nextInt(15) + 45); // 字体
            affineTransform = new AffineTransform();
            affineTransform.rotate(Math.toRadians(r.nextInt(60)), 0, 0);
            rotatedFont = font.deriveFont(affineTransform);
            g2.setColor(new Color(r.nextInt(155) + 100, r.nextInt(155) + 100, r.nextInt(155) + 100));
            g2.setFont(rotatedFont);
            g2.drawString(code4, r.nextInt(10) + 150, r.nextInt(14) + 34);

            for (int i = 0; i < 21; i++) {
                g2.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
                g2.drawLine(r.nextInt(200), r.nextInt(60), r.nextInt(200), r.nextInt(60));
            }
            g2.dispose();
        } catch (Exception e) {
            e.printStackTrace();
            log.info("验证码数据库插入失败：", e);
            gh.drawString("错误！", 30, 40);
            return "";
        }

        String base64Img;
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "png", stream);
            base64Img = "data:image/png;base64," + Base64.getEncoder().encodeToString(stream.toByteArray());
            stream.flush();
            stream.close();
        } catch (IOException io) {
            log.error("图片验证码base64转换失败：", io);
            base64Img = "";
        }
        return base64Img;
    }
}
