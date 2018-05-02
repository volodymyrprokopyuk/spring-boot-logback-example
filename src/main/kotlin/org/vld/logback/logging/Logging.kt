package org.vld.logback.logging

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class Logging {

    companion object {
        val logger: Logger = LoggerFactory.getLogger(Logging::class.java)
        val auditLogger: Logger = LoggerFactory.getLogger("AUDIT_LOGGER")
    }

    fun logAll() {
        logger.trace("trace")
        logger.debug("debug")
        logger.info("info")
        logger.warn("warn")
        logger.error("error")

        auditLogger.trace("audit trace")
        auditLogger.debug("audit debug")
        auditLogger.info("audit info")
        auditLogger.warn("audit warn")
        auditLogger.error("audit error")
    }
}