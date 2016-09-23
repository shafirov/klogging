# KLogging

KLogging provides unified logging API, which you can use from Kotlin code targeted for both JVM and Javascript.
The library is inspired by 
- code at [https://github.com/MicroUtils/kotlin-logging] 
- and discussion at [http://stackoverflow.com/questions/34416869/idiomatic-way-of-logging-in-kotlin]
                                              
KLogger class features 5 levels of logging (to mirror that of SLF4J): trace, debug, info, warn, error with 2 flavors each:
                                              
```kotlin
logger.trace("This string will be evaluated regardless if trace enabled = ${logger.isTraceEnabled}")
logger.trace {"This string will not be evaluated unless trace enabled = ${logger.isTraceEnabled}"}
```

To obtain an instance of a logger you need to call one of the `logger()` methods of `KLoggers` 
(please note that JVM version of this class provides more overloads) or use mix it in:
 
```kotlin
class Foo {
    val logger = KLoggers.logger(this)
    
    fun test() {
        logger.info("Have some logging!")    
    }
}

class Bar : WithLogging by KLoggerHolder() {
    fun test() {
        logger.info("Have some logging!")    
    }
}
 
class Baz {
    companion object: WithLogging by KLoggerHolder() 
    
    fun test() {
        logger.info("Have some logging!")    
    }
} 

```

For file-level loggers I recommend following IntelliJ IDEA live template:
```xml
<template name="log" value="private val log = klogging.KLoggers.logger(&quot;$LOGGER_NAME$&quot;)" description="Logger" toReformat="false" toShortenFQNames="true">
  <variable name="LOGGER_NAME" expression="groovyScript(&quot;com.intellij.openapi.module.ModuleUtil.findModuleForFile(_editor.virtualFile, _editor.project).name + \&quot;/\&quot; + _editor.virtualFile.name&quot;) " defaultValue="" alwaysStopAt="false" />
  <context>
    <option name="KOTLIN_TOPLEVEL" value="true" />
  </context>
</template>
```
