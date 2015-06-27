package com.zenika.app

import org.scalatra._

class ExtremeStartupStarter extends ScalatraServlet {

  get("/") {
    params("q") match {
      case q: String =>
        log("request: " + q)
        answer(q)
      case _ => pass()
    }
  }

  def answer(req: String): String = {

    val nameRequest = """.*what is your name""".r

    req match {
      case nameRequest() => "<YOUR NAME>"
      case _ =>
        log("Unrecognized question")
        pass()
    }
  }
}
