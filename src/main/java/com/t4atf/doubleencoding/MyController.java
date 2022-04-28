package com.t4atf.doubleencoding;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/root")
public class MyController {
    @GetMapping
    public TestModel test(@RequestParam("param") String param) {
        return new TestModel()
                .add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MyController.class).test("I+will:be+double+encoded")).withSelfRel());
    }
}
