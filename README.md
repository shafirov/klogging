# KLogging

[![](https://jitpack.io/v/shafirov/klogging.svg)](https://jitpack.io/#shafirov/klogging)

KLogging provides unified logging API, which you can use from Kotlin code targeted for JVM, Javascript and common kotlin.
The library is inspired by
- code at [https://github.com/MicroUtils/kotlin-logging] 
- and discussion at [http://stackoverflow.com/questions/34416869/idiomatic-way-of-logging-in-kotlin]
                                      
                                      
## Download
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Use these dependencies per kotlin module respectively:
```
compile 'com.github.shafirov.klogging:klogging.common:1.2.10'
compile 'com.github.shafirov.klogging:klogging.js:1.2.10'
compile 'com.github.shafirov.klogging:klogging.jvm:1.2.10'
```                                   
Versions will be updated with same kotlin version 

## Usage                                              
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

Logger is invokable:
```kotlin
class Foo {
    val logger = KLoggers.logger(this)
    
    fun test() {
        logger("Have some logging!")    
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
