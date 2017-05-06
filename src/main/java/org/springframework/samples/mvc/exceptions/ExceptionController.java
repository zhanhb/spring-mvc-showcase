package org.springframework.samples.mvc.exceptions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExceptionController {

    @RequestMapping("/exception")
    @ResponseBody
    public String exception() {
        throw new IllegalStateException("Sorry!");
    }

    @RequestMapping("/global-exception")
    @ResponseBody
    public String businessException() throws BusinessException {
        throw new BusinessException();
    }

    @ExceptionHandler
    @ResponseBody
    public String handle(IllegalStateException e) {
        return "IllegalStateException handled!";
    }

}
