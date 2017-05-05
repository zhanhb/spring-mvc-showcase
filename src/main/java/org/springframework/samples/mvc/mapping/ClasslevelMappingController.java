package org.springframework.samples.mvc.mapping;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/class-mapping/*")
public class ClasslevelMappingController {

    @RequestMapping("/path")
    @ResponseBody
    public String byPath() {
        return "Mapped by path!";
    }

    @GetMapping("/path/*")
    @ResponseBody
    public String byPathPattern(HttpServletRequest request) {
        return "Mapped by path pattern ('" + request.getRequestURI() + "')";
    }

    @GetMapping("/method")
    @ResponseBody
    public String byMethod() {
        return "Mapped by path + method";
    }

    @GetMapping(value = "/parameter", params = "foo")
    @ResponseBody
    public String byParameter() {
        return "Mapped by path + method + presence of query parameter!";
    }

    @GetMapping(value = "/parameter", params = "!foo")
    @ResponseBody
    public String byParameterNegation() {
        return "Mapped by path + method + not presence of query!";
    }

    @GetMapping(value = "/header", headers = "FooHeader=foo")
    @ResponseBody
    public String byHeader() {
        return "Mapped by path + method + presence of header!";
    }

    @GetMapping(value = "/notheader", headers = "!FooHeader")
    @ResponseBody
    public String byHeaderNegation() {
        return "Mapped by path + method + absence of header!";
    }

    @PostMapping(value = "/consumes", consumes = "application/json")
    @ResponseBody
    public String byConsumes(@RequestBody JavaBean javaBean) {
        return "Mapped by path + method + consumable media type (javaBean '" + javaBean + "')";
    }

    @GetMapping(value = "/produces", produces = "application/json")
    @ResponseBody
    public JavaBean byProduces() {
        return new JavaBean();
    }

}
