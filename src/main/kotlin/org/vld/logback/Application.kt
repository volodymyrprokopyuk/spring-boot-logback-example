package org.vld.logback

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
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

    @Value("\${internal.property}")
    private lateinit var internalProperty: String

    @Value("\${external.property}")
    private lateinit var externalProperty: String

    override fun run(vararg args: String?) {
        logger.debug("ok")
        logging.logAll()

        logger.info("internal.property = $internalProperty")
        logger.info("external.property = $externalProperty")
    }
}

fun main(args: Array<String>) = SpringApplication.run(Application::class.java, *args)
