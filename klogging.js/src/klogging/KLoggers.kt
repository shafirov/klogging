package klogging

actual object KLoggers {
    private val loggers = js("({})")
    private val levels = mutableListOf<Pair<Regex, KLoggingLevels>>()

    var defaultLoggingLevel: KLoggingLevels = KLoggingLevels.INFO

    actual fun logger(owner: Any) = when (owner) {
        is String -> internalLogger(owner)
        else -> internalLogger(owner)
    }

    private fun internalLogger(owner: Any): KLogger {
        val d = owner.asDynamic()
        return d.__logger ?: run {
            val l = logger(owner::class.js.name)
            d.__logger = l
            l
        }
    }

    private fun internalLogger(name: String): KLogger {
        return loggers[name] ?: run {
            val l = KLogger(JSLogger(name, calcLevel(name)))
            loggers[name] = l
            l
        }
    }

    fun loggingLevel(regex: Regex, level: KLoggingLevels) {
        levels.add(regex to level)
    }

    private fun calcLevel(name: String): KLoggingLevels {
        return levels.filter { it.first.matches(name) }.maxBy{ it.second }?.second ?: defaultLoggingLevel
    }
}
