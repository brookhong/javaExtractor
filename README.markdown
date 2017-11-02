# JavaExtractor

A CLI java program to extract identifiers from java source code with ANTLR.

# Build & Run
    mvn assembly:assembly -DdescriptorId=jar-with-dependencies
    java -jar target/javaExtractor-1.0-jar-with-dependencies.jar src/main/java/JavaExtractor.java
    java -Xdebug -Xrunjdwp:transport=dt_socket,server=y,address=6789 -jar target/javaExtractor-1.0-jar-with-dependencies.jar src/main/java/JavaExtractor.java

# References
* https://github.com/antlr/antlr4/blob/master/doc/getting-started.md
* http://media.pragprog.com/titles/tpantlr2/listener.pdf
