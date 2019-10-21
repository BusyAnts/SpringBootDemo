package com.cimc.service.test;

import com.cimc.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * @author chenz
 * @create 2019-10-17 9:40
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MailServiceTest {

    @Autowired
    private MailService mailService;

    @Test
    public void testSimpleMail() {
        mailService.sendSimpleMail("542846618@qq.com", "简单邮件测试", "大家好，这是我的一封简单邮件！");
    }

    @Test
    public void testHtmlMail() throws Exception {
        String content = "<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail("542846618@qq.com", "test simple mail", content);
    }

    @Test
    public void sendAttachmentsMail() {
        String filePath = "D:\\Images\\1.jpg";
        mailService.sendAttachmentsMail("542846618@qq.com", "带附件的邮件", "有附件，请查收！", filePath);
    }


    @Test
    public void sendInlineResourceMail() {
        String rscId = "PIC001";
        String content = "<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "D:\\Images\\1.jpg";

        mailService.sendInlineResourceMail("542846618@qq.com", "主题：这是有图片的邮件", content, imgPath, rscId);
    }

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void sendTemplateMail() {
        //创建邮件正文
        Context context = new Context();
        context.setVariable("id", "006");
        String emailContent = templateEngine.process("emailTemplate", context);

        mailService.sendHtmlMail("542846618@qq.com", "主题：这是模板邮件", emailContent);
    }

}
