package com.joshtompkins.klisp

class Parser {
  fun tokenize(input: String): List<Token> {
    return input
      .replace("(", " ( ")
      .replace(")", " ) ")
      .split(" ")
      .map { Token(it) }
  }

//  fun listify(input: MutableList<Token>, list: List<Token> = mutableListOf()): List<Any> {
//    val token = input.s
//
//    val parsedInput = mutableListOf<Any>()
//
//    parsedInput.add(tokenizedString.forEach { token ->
//      when (token.type) {
//        TokenType.STRING -> parseString(token)
//        TokenType.NUMBER -> parseNumber(token)
//        TokenType.SYMBOL -> parseSymbol(token)
//        TokenType.LIST -> parseList(token)
//      }
//    })
//
//    return parsedInput
//  }

//  private fun parseString(input: Token): String {
//
//  }
//
//  private fun parseNumber(input: Token): Int {
//
//  }
//
//  private fun parseSymbol(input: Token): Any {
//
//  }
//

}

enum class TokenType {
  STRING, NUMBER, LIST_OPEN, LIST_CLOSE, SYMBOL
}

