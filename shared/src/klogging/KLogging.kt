package klogging

interface WithLogging {
    val logger: KLogger
}

class KLoggerHolder : WithLogging {
    override val logger by lazy(LazyThreadSafetyMode.NONE) {
        KLoggers.logger(this)
    }
}
