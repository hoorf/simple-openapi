package org.github.hoorf.openapi.controller;

import org.github.hoorf.openapi.core.bean.OpenApiRequest;
import org.github.hoorf.openapi.core.bean.OpenApiResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenController {

    @PostMapping("/openapi/execute.do")
    public OpenApiResponse execute(@RequestBody OpenApiRequest request) {

    }
}
