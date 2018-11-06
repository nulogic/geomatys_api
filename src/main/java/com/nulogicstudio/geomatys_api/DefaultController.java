package com.nulogicstudio.geomatys_api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;;

@CrossOrigin
@Controller
public class DefaultController {

    @RequestMapping()
    public String def(){
        return "redirect:/";
    }
  
}