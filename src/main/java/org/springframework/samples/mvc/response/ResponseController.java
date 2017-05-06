package org.springframework.samples.mvc.response;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/response")
public class ResponseController {

    @GetMapping("/annotation")
    @ResponseBody
    public String responseBody() {
        return "The String ResponseBody";
    }

    @GetMapping("/charset/accept")
    @ResponseBody
    public String responseAcceptHeaderCharset() {
        return "\u3053\u3093\u306b\u3061\u306f\u4e16\u754c\uff01 (\"Hello world!\" in Japanese)";
    }

    @GetMapping(value = "/charset/produce", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String responseProducesConditionCharset() {
        return "\u3053\u3093\u306b\u3061\u306f\u4e16\u754c\uff01 (\"Hello world!\" in Japanese)";
    }

    @GetMapping("/entity/status")
    public ResponseEntity<String> responseEntityStatusCode() {
        return new ResponseEntity<>("The String ResponseBody with custom status code (403 Forbidden)",
                HttpStatus.FORBIDDEN);
    }

    @GetMapping("/entity/headers")
    public ResponseEntity<String> responseEntityCustomHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        return new ResponseEntity<>("The String ResponseBody with custom header Content-Type=text/plain",
                headers, HttpStatus.OK);
    }

}
