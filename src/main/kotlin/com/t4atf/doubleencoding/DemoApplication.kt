package com.t4atf.doubleencoding

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.hateoas.RepresentationModel
import org.springframework.hateoas.server.mvc.linkTo
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}

@RestController
@RequestMapping("/root")
class MyController {
	@GetMapping
	fun test(@RequestParam("param") param: String) : TestModel =
		TestModel().add(linkTo<MyController> { test("I+will:be+double+encoded") }.withSelfRel())
}

open class TestModel : RepresentationModel<TestModel>()