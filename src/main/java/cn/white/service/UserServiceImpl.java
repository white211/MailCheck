package cn.white.service;

import cn.white.dao.UserDao;
import cn.white.entity.User;
import cn.white.util.MailTask;
import cn.white.util.UUIDutils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TaskExecutor taskExecutor;

    public void register(User user) {

        user.setCode(UUIDutils.getUUID());
        user.setState("0");
        userDao.register(user);
        //发送邮件
        taskExecutor.execute(new MailTask(user.getCode(),user.getEmail(),javaMailSender,1));
    }

    public User selectUserByCode(String code) {
         return  userDao.selectUserByCode(code);
    }

    public String updateUserState(String code) {
        User user = selectUserByCode(code);
        if (user != null){
            userDao.updateUserState(code);
            return "激活成功";
        }
        else{
             return "激活码有误，请重新注册";
        }
    }


}
