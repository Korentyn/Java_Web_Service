package com.testopa.testopa;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    //@Value("${filesystem.upload-dir}")
    //private String uploadDir;

    // Request mapping (value = "/", method = "RequestMethod.GET") = Route de l'url appelée avec le controller
    @GetMapping("/")
    public String index(Model model){
        //model.addAttribute("msg","jaquie & michel");
        //model.addAttribute("uploadDir",this.uploadDir);
        return "Views/index";
    }
}
