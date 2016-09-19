package klogging

import org.slf4j.LoggerFactory
import kotlin.reflect.KClass

object KLoggers {
    fun logger(name: String): KLogger =  KLogger(JVMLogger(LoggerFactory.getLogger(name)))
    fun logger(owner: Any): KLogger = logger(owner.javaClass)
    fun logger(klass: KClass<*>):KLogger = logger(klass.java)
    fun logger(klass: Class<*>):KLogger = KLogger(JVMLogger(LoggerFactory.getLogger(klass)))
}
