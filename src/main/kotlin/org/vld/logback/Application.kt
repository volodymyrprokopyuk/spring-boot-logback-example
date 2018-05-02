package org.vld.logback

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.vld.logback.logging.Logging

@SpringBootApplication
open class Application : CommandLineRunner {

    companion object {
        val logger: Logger = LoggerFactory.getLogger(Application::class.java)
    }

    @Autowired
    private lateinit var logging: Logging

    override fun run(vararg args: String?) {
        logger.debug("ok")
        logging.logAll()
    }
}

fun main(args: Array<String>) = SpringApplication.run(Application::class.java, *args)
