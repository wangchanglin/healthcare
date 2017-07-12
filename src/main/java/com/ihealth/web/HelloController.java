package com.ihealth.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by changlin on 2017/7/11.
 */
@Controller
@RequestMapping("/api")
public class HelloController {

    @RequestMapping("/user")
    public void getUser(@PathVariable Integer id){

    }

}
