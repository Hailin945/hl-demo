package com.hl.freemarker;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Hailin
 * @date 2019/12/30
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping("/")
    public ModelAndView test() {
        ModelAndView modelAndView = new ModelAndView("/test");
        modelAndView.addObject("name", "老牛");
        return modelAndView;
    }

}
