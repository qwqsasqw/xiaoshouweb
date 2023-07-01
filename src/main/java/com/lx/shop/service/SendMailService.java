package com.lx.shop.service;

import com.lx.shop.dao.pojo.MailRequest;

public interface SendMailService {

    /**
     * 简单文本邮件
     *
     * @param mailRequest
     * @return
     */
    void sendSimpleMail(MailRequest mailRequest);



}
