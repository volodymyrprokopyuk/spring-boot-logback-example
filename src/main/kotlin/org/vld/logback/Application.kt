package org.vld.logback

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.PropertySource
import org.vld.logback.logging.Logging

@SpringBootApplication
@PropertySource(value = ["file:config/configuration.properties", "classpath:configuration.properties"])
open class Application : CommandLineRunner {

    companion object {
        val logger: Logger = LoggerFactory.getLogger(Application::class.java)
    }

    @Autowired
    private lateinit var logging: Logging

    @Value("\${common.internal.property}")
    private lateinit var commonInternalProperty: String

    @Value("\${common.external.property}")
    private lateinit var commonExternalProperty: String

    @Value("\${profile.internal.property}")
    private lateinit var profileInternalProperty: String

    @Value("\${profile.external.property}")
    private lateinit var profileExternalProperty: String

    @Value("\${extra.internal.property}")
    private lateinit var extraInternalProperty: String

    @Value("\${extra.external.property}")
    private lateinit var extraExternalProperty: String

    override fun run(vararg args: String?) {
        logger.debug("ok")
        logging.logAll()

        logger.info("common.internal.property = $commonInternalProperty")
        logger.info("common.external.property = $commonExternalProperty")

        logger.info("profile.internal.property = $profileInternalProperty")
        logger.info("profile.external.property = $profileExternalProperty")

        logger.info("extra.internal.property = $extraInternalProperty")
        logger.info("extra.external.property = $extraExternalProperty")
    }
}

fun main(args: Array<String>) = SpringApplication.run(Application::class.java, *args)
