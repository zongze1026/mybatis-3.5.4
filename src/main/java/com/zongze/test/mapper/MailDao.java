package com.zongze.test.mapper;

import com.zongze.test.entity.Mail;

import java.util.List;

public interface MailDao {

    /**
     * 插入一条邮箱信息
     */
    public long insertMail(Mail mail);

    /**
     * 删除一条邮箱信息
     */
    public int deleteMail(long id);


    /**
     * 查询邮箱列表
     */
    public List<Mail> selectMailList();

    /**
     * 根据主键id查询一条邮箱信息
     */
    public Mail selectMailById(long id);

}
