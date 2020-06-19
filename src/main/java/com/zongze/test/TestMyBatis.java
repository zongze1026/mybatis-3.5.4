package com.zongze.test;

import com.zongze.test.entity.Mail;
import com.zongze.test.mapper.MailDao;
import com.zongze.test.mapper.MailDaoImpl;
import java.util.List;

public class TestMyBatis {
    private static MailDao mailDao;

    static {
        mailDao = new MailDaoImpl();
    }

    public static void main(String[] args) {
        testInsert();
    }


    public static void testInsert() {
        Mail mail1 = new Mail(1, "123@sina.com", "个人使用");
        Mail mail2 = new Mail(2, "123@qq.com", "企业使用");
        Mail mail3 = new Mail(3, "123@sohu.com", "注册账号使用");
        System.out.println(mailDao.insertMail(mail1));
        System.out.println(mailDao.insertMail(mail2));
        System.out.println(mailDao.insertMail(mail3));
    }


    public void testDelete() {
        System.out.println(mailDao.deleteMail(1));
    }



    public void testSelectOne() {
        System.out.println(mailDao.selectMailById(2));
    }


    public void testSelectList() {
        List<Mail> mailList = mailDao.selectMailList();
        if (mailList != null && mailList.size() != 0) {
            for (Mail mail : mailList) {
                System.out.println(mail);
            }
        }
    }

}
