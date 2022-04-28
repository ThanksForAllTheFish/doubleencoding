package com.t4atf.doubleencoding;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.util.UriUtils;
import java.net.URI;
import java.nio.charset.Charset;

class DoubleEncodingTest {
	@Test
	void ok() {
		var expected = UriUtils.encode("I+am:ok", Charset.defaultCharset());
		Assertions.assertEquals(
			URI.create("/root?param=" + expected),
			WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MyController.class).test("I+am:ok")).withSelfRel().toUri()
		);
	}

	@Test
	void doubleEncoding() {
		var expected = UriUtils.encode("I+will:be+double+encoded", Charset.defaultCharset());
		Assertions.assertEquals(
			URI.create("/root?param=" + expected),
			WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MyController.class).test("I+will:be+double+encoded")).toUri()
		);
	}
}
