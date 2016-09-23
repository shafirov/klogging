package klogging

internal class JSLogger(val name: String, val level: KLoggingLevels): BaseLogger {
    override val isTraceEnabled: Boolean get() = level >= KLoggingLevels.TRACE
    override val isDebugEnabled: Boolean get() = level >= KLoggingLevels.DEBUG
    override val isInfoEnabled: Boolean  get() = level >= KLoggingLevels.INFO
    override val isWarnEnabled: Boolean  get() = level >= KLoggingLevels.WARN
    override val isErrorEnabled: Boolean get() = level >= KLoggingLevels.ERROR

    override fun trace(message: Any?) {
        if (isTraceEnabled) {
            console.log("[$name]: ", message)
        }
    }

    override fun debug(message: Any?) {
        if (isDebugEnabled) {
            console.log("[$name]: ", message)
        }
    }

    override fun info(message: Any?) {
        if (isInfoEnabled) {
            console.info("[$name]: ", message)
        }
    }

    override fun warn(message: Any?) {
        if (isWarnEnabled) {
            console.warn("[$name]: ", message)
        }
    }

    override fun error(message: Any?) {
        if (isErrorEnabled) {
            console.error("[$name]: ", message)
        }
    }

    override fun trace(t: Throwable, message: Any?) {
        if (isTraceEnabled) {
            console.log("[$name]: ", message, t)
        }
    }

    override fun debug(t: Throwable, message: Any?) {
        if (isDebugEnabled) {
            console.log("[$name]: ", message, t)
        }
    }

    override fun info(t: Throwable, message: Any?) {
        if (isInfoEnabled) {
            console.info("[$name]: ", message, t)
        }
    }

    override fun warn(t: Throwable, message: Any?) {
        if (isWarnEnabled) {
            console.warn("[$name]: ", message, t)
        }
    }

    override fun error(t: Throwable, message: Any?) {
        if (isErrorEnabled) {
            console.error("[$name]: ", message, t)
        }
    }
}
