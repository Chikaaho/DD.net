package net.dd.service.impl;

import net.dd.service.MailService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;


/**
 * @author Chika
 * @program DDNet
 * @create 2021/4/19 - 16:31
 **/
@Service
public class MailServiceImpl implements MailService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    JavaMailSenderImpl javaMailSender;

    @Autowired(required = false)
    public void setJavaMailSender(JavaMailSenderImpl javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Value("${spring.mail.username}")
    private String from;

    @Override
    public void sendMimeMail(String to, String subject, String content) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setSubject(subject);
            helper.setTo(to);
            helper.setText(content, true);
            javaMailSender.send(message);
            logger.info("邮件已发送。");
        } catch (MessagingException e) {
            logger.error("邮件发送时发生异常导致发送失败。");
        }

    }

    @Override
    public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setSubject(subject);
            helper.setTo(to);
            helper.setText(content, true);

            FileSystemResource fileSystemResource = new FileSystemResource(new File(rscPath));
            helper.addInline(rscId, fileSystemResource);

            javaMailSender.send(message);
        } catch (MessagingException e) {
            logger.error("邮件发送时发生异常导致发送失败。");
        }
    }
}
