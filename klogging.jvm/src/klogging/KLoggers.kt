package klogging

import org.slf4j.LoggerFactory
import kotlin.reflect.KClass

actual object KLoggers {
    actual fun logger(owner: Any): KLogger = when (owner) {
        is String -> KLogger(JVMLogger(LoggerFactory.getLogger(owner)))
        is KClass<*> -> logger(owner.java)
        is Class<*> -> KLogger(JVMLogger(LoggerFactory.getLogger(owner)))
        else -> logger(owner.javaClass)
    }
}
