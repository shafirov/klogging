package klogging

interface BaseLogger {
    val isTraceEnabled: Boolean
    val isDebugEnabled: Boolean
    val isInfoEnabled: Boolean
    val isWarnEnabled: Boolean
    val isErrorEnabled: Boolean

    fun trace(message: Any?)
    fun debug(message: Any?)
    fun info(message: Any?)
    fun warn(message: Any?)
    fun error(message: Any?)

    fun trace(t: Throwable, message: Any? = "")
    fun debug(t: Throwable, message: Any? = "")
    fun info(t: Throwable, message: Any? = "")
    fun warn(t: Throwable, message: Any? = "")
    fun error(t: Throwable, message: Any? = "")
}
