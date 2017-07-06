package com.joshtompkins.klisp

class Token(val input: String) {
  companion object {
    val STRING_MATCHER = "\\\".+\\\"$".toRegex()
    val NUMBER_MATCHER = """\d+$""".toRegex()
  }

  val value = input

  val parsedValue: Any
    get() {
      return when(type) {
        TokenType.STRING -> input.drop(1).dropLast(1)
        TokenType.NUMBER -> Integer.parseInt(input)
        else -> value
      }
    }

  val type: TokenType

  init {
    type = when {
      isString() -> TokenType.STRING
      isNumber() -> TokenType.NUMBER
      value == "(" -> TokenType.LIST_OPEN
      value == ")" -> TokenType.LIST_CLOSE
      else -> TokenType.SYMBOL
    }
  }

  private fun isString(): Boolean {
    return value.matches(STRING_MATCHER)
  }

  private fun isNumber(): Boolean {
    return value.matches(NUMBER_MATCHER)
  }
}
