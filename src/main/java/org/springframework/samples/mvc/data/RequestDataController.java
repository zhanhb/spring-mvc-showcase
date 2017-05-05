package org.springframework.samples.mvc.data;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/data")
public class RequestDataController {

    @GetMapping("param")
    @ResponseBody
    public String withParam(@RequestParam String foo) {
        return "Obtained 'foo' query parameter value '" + foo + "'";
    }

    @GetMapping("group")
    @ResponseBody
    public String withParamGroup(JavaBean bean) {
        return "Obtained parameter group " + bean;
    }

    @GetMapping("path/{var}")
    @ResponseBody
    public String withPathVariable(@PathVariable String var) {
        return "Obtained 'var' path variable value '" + var + "'";
    }

    @GetMapping("{path}/simple")
    @ResponseBody
    public String withMatrixVariable(@PathVariable String path, @MatrixVariable String foo) {
        return "Obtained matrix variable 'foo=" + foo + "' from path segment '" + path + "'";
    }

    @GetMapping("{path1}/{path2}")
    @ResponseBody
    public String withMatrixVariablesMultiple(
            @PathVariable String path1, @MatrixVariable(value = "foo", pathVar = "path1") String foo1,
            @PathVariable String path2, @MatrixVariable(value = "foo", pathVar = "path2") String foo2) {

        return "Obtained matrix variable foo=" + foo1 + " from path segment '" + path1
                + "' and variable 'foo=" + foo2 + " from path segment '" + path2 + "'";
    }

    @GetMapping("header")
    @ResponseBody
    public String withHeader(@RequestHeader String Accept) {
        return "Obtained 'Accept' header '" + Accept + "'";
    }

    @GetMapping("cookie")
    @ResponseBody
    public String withCookie(@CookieValue String openid_provider) {
        return "Obtained 'openid_provider' cookie '" + openid_provider + "'";
    }

    @PostMapping("body")
    @ResponseBody
    public String withBody(@RequestBody String body) {
        return "Posted request body '" + body + "'";
    }

    @PostMapping("entity")
    @ResponseBody
    public String withEntity(HttpEntity<String> entity) {
        return "Posted request body '" + entity.getBody() + "'; headers = " + entity.getHeaders();
    }

}
