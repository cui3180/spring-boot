package com.cui.spring.web.control;

import com.cui.spring.model.User;
import com.cui.spring.service.fs.UserService;
import com.cui.spring.util.RedisUtil;
import com.cui.spring.util.SendMassage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.*;


/**
 * Created by cjs
 * Date： 2017/7/12.
 * Time： 14:58.
 */
@Controller
@RequestMapping(value="/user")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private SendMassage sendMassage;


    @RequestMapping(value="/getuser")
    public ModelAndView getUser(Long id){
        logger.info("adsfsfid{}",id);
        User user = userService.getUser(5l);
        ModelAndView map =new ModelAndView();
        map.addObject("user",user);
        map.setViewName("/usercenter/userIndex");
        return  map;
    }

    @RequestMapping(value="/redis")
    @ResponseBody
    public  String redis(String user){
        Object o = redisUtil.get("Test" + user);
         if(o != null){
             return "您的请求过于频繁";
         }
        redisUtil.set("Test"+user,user,5l);
        Integer num =(Integer) redisUtil.get("num");
        if(num ==null){
            redisUtil.set("num",10);
       }
       if(num == 0){
            return "已经抢完了";
       }
        User userByName = userService.getUserByName(user);
       if(userByName!=null){
           return "您已经抢到了代金券";
       }
        redisUtil.set("num",num-1);
       try{
           User user1=new User();
           user1.setUserAge("12");
           user1.setUserName(user);
           int i = userService.addUser(user1);
       }catch (Exception e){
       redisUtil.set("num",num+1);
       }
        return "成功";
    }
    @RequestMapping(value="/test")
    public  String test(String username ,String password){

        return "usercenter/testlayui";
    }
    @RequestMapping(value="/login")
    public  String login(HttpServletResponse response, HttpServletRequest request, String username , String password){
    /*    redisUtil.set("maomao","maomaomao3180");
        redisUtil.set("cuicui","cuicuicui3180");*/
        Object maomao = redisUtil.get("maomao");
        Object cuicui = redisUtil.get("cuicui");
        String pass=username+password;
        if(pass.equals(maomao.toString())||pass.equals(cuicui.toString())) {
            Cookie cookie=new Cookie("user",username);
            response.addCookie(cookie);
            return "login";
        }
        return "err";
    }
    /*@RequestMapping(value="/msg")
    @ResponseBody
    public  void sendMassage(HttpServletRequest request,String msg ){
        Cookie[] cookies = request.getCookies();
        String userName="";
        for (int i = 0; i < cookies.length; i++) {
            Cookie cook = cookies[i];
            if(cook.getName().equalsIgnoreCase("user")){ //获取键
                userName=  cook.getValue();  //获取值
            }
        }
        redisUtil.publish(TopicChall.CHALL_MASSAGE_MAOAMO,msg+"%"+userName);
    }
*/
}
