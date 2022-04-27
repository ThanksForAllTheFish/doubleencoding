package com.t4atf.doubleencoding

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.hateoas.server.mvc.linkTo
import org.springframework.web.util.UriUtils
import java.net.URI
import java.nio.charset.Charset

class DoubleEncodingTest {
	@Test
	fun ok() {
		Assertions.assertEquals(
			URI.create("/root?param=${UriUtils.encode("I+am:ok", Charset.defaultCharset())}"),
			linkTo<MyController> { test("I+am:ok") }.withSelfRel().toUri()
		)
	}

	@Test
	fun doubleEncoding() {
		Assertions.assertEquals(
			URI.create("/root?param=${UriUtils.encode("I+will:be+double+encoded", Charset.defaultCharset())}"),
			linkTo<MyController> { test("I+will:be+double+encoded") }.toUri()
		)
	}
}
