package com.zongze.test.mapper;

import com.zongze.test.entity.Mail;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class MailDaoImpl implements MailDao {

    private static final String NAME_SPACE = "MailDao.";

    private static SqlSessionFactory ssf;

    private static Reader reader;

    static {
        try {
            reader = Resources.getResourceAsReader("config.xml");
            ssf = new SqlSessionFactoryBuilder().build(reader);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public long insertMail(Mail mail) {
        SqlSession ss = ssf.openSession();
        try {
            int rows = ss.insert(NAME_SPACE + "insertMail", mail);
            ss.commit();
            if (rows > 0) {
                return mail.getId();
            }
            return 0;
        } catch (Exception e) {
            ss.rollback();
            return 0;
        } finally {
            ss.close();
        }
    }

    @Override
    public int deleteMail(long id) {
        SqlSession ss = ssf.openSession();
        try {
            int rows = ss.delete(NAME_SPACE + "deleteMail",  id);
            ss.commit();
            return rows;
        } catch (Exception e) {
            ss.rollback();
            return 0;
        } finally {
            ss.close();
        }
    }


    @Override
    public List<Mail> selectMailList() {
        SqlSession ss = ssf.openSession();
        try {
            return ss.selectList(NAME_SPACE + "selectMailList");
        } finally {
            ss.close();
        }
    }

    @Override
    public Mail selectMailById(long id) {
        SqlSession ss = ssf.openSession();
        try {
            return ss.selectOne(NAME_SPACE + "selectMailById", id);
        } finally {
            ss.close();
        }
    }

}
