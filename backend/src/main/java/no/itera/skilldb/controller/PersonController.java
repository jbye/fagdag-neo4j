package no.itera.skilldb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by john.bye on 10/16/14.
 */
@Controller
public class PersonController {

    @RequestMapping("/javabeer")
    public
    @ResponseBody
    String beer() {
        return "";
    }

}
