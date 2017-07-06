package com.joshtompkins.klisp

import org.junit.Test
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.assertThat

class TokenTest {
  @Test
  fun itTokenizesAString() {
    val token = Token("\"a string\"")

    assertThat(token.type, equalTo(TokenType.STRING))
    assertThat<Any>(token.parsedValue, equalTo("a string"))
  }

  @Test
  fun itTokenizesANumber() {
    val token = Token("1")

    assertThat(token.type, equalTo(TokenType.NUMBER))
    assertThat<Any>(token.parsedValue, equalTo(1))
  }

  @Test
  fun itTokenizesASymbol() {
    val token = Token("a_symbol")

    assertThat(token.type, equalTo(TokenType.SYMBOL))
    assertThat<Any>(token.parsedValue, equalTo("a_symbol"))
  }

  @Test
  fun itTokenizesAnOpeningParens() {
    val token = Token("(")

    assertThat(token.type, equalTo(TokenType.LIST_OPEN))
    assertThat<Any>(token.parsedValue, equalTo("("))
  }

  @Test
  fun itTokenizesAClosingParens() {
    val token = Token(")")

    assertThat(token.type, equalTo(TokenType.LIST_CLOSE))
    assertThat<Any>(token.parsedValue, equalTo(")"))
  }
}
