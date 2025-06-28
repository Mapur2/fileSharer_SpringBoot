package com.fileSharer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UIController {
    @GetMapping("/")
    public String index(){
        return "index";
    }
}
