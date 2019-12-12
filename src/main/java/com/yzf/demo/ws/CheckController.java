package com.yzf.demo.ws;

import com.yzf.demo.util.ApiReturnUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * CheckController
 *
 * @author Administrator
 * @date 2019/12/10
 */
@Controller
@RequestMapping("/check")
public class CheckController {
    //页面请求
    @GetMapping("/socket/{uid}")
    public ModelAndView socket(@PathVariable String uid) {
        ModelAndView mav=new ModelAndView("/socket");
        mav.addObject("uid", uid);
        return mav;
    }
    //推送数据接口
    @RequestMapping("/socket/push/{uid}")
    public @ResponseBody String pushToWeb(@PathVariable String uid,String message) {
        try {
            WebSocketServer.sendInfo(message,uid);
        } catch (IOException e) {
            e.printStackTrace();
            return ApiReturnUtil.error(uid+"#"+e.getMessage());
        }
        return ApiReturnUtil.success(uid);
    }

}
