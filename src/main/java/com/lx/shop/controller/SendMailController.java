package com.lx.shop.controller;

import com.lx.shop.dao.pojo.MailRequest;
import com.lx.shop.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/send-mail")
@Transactional
public class SendMailController {
    @Resource
    private SendMailService sendMailService;

    @PostMapping("/simple")
    public void SendSimpleMessage(@RequestBody MailRequest mailRequest) {
        System.out.println(mailRequest);
        sendMailService.sendSimpleMail(mailRequest);
    }

}
