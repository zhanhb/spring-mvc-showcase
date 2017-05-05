package org.springframework.samples.mvc.mapping;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MappingController {

    @RequestMapping("/mapping/path")
    @ResponseBody
    public String byPath() {
        return "Mapped by path!";
    }

    @GetMapping("/mapping/path/*")
    @ResponseBody
    public String byPathPattern(HttpServletRequest request) {
        return "Mapped by path pattern ('" + request.getRequestURI() + "')";
    }

    @GetMapping("/mapping/method")
    @ResponseBody
    public String byMethod() {
        return "Mapped by path + method";
    }

    @GetMapping(value = "/mapping/parameter", params = "foo")
    @ResponseBody
    public String byParameter() {
        return "Mapped by path + method + presence of query parameter!";
    }

    @GetMapping(value = "/mapping/parameter", params = "!foo")
    @ResponseBody
    public String byParameterNegation() {
        return "Mapped by path + method + not presence of query parameter!";
    }

    @GetMapping(value = "/mapping/header", headers = "FooHeader=foo")
    @ResponseBody
    public String byHeader() {
        return "Mapped by path + method + presence of header!";
    }

    @GetMapping(value = "/mapping/header", headers = "!FooHeader")
    @ResponseBody
    public String byHeaderNegation() {
        return "Mapped by path + method + absence of header!";
    }

    @PostMapping(value = "/mapping/consumes", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String byConsumes(@RequestBody JavaBean javaBean) {
        return "Mapped by path + method + consumable media type (javaBean '" + javaBean + "')";
    }

    @GetMapping(value = "/mapping/produces", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public JavaBean byProducesJson() {
        return new JavaBean();
    }

    @GetMapping(value = "/mapping/produces", produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public JavaBean byProducesXml() {
        return new JavaBean();
    }

}
