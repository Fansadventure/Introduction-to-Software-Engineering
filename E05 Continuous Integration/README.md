### Continuous Integration
In this exercise, we want you to try out continuous integration.

#### Part 1: Get familiar
Firstly, you should get familiar with the program. Try to run the app and inspect the source code.
After you have done that we will take a look at the tests. When inspecting the pom.xml file you will notice that a test source directory is specified and the dependency on Mavens' Surefire plugin is given. We want to execute the test cases in two different ways. One time using JUnit and then again with Maven. To do so follow these steps:

**Eclipse:**

- Right-click the test case UniversityAppTest.java —> Run As —> JUnit Test.
- Right-click pom.xml file —> Run As —> Maven Test.

**IntelliJ:**

- Right-click the test case UniversityAppTest.java -> Run 'UniversityAppTest'.
- Go to View -> Tool Windows -> Maven. Here expand L10E03 Continuous Integration -> expand Lifecycle -> double click test.
1. Fix the failing test     
Open UniversityApp.java and change the returned String in line 44 to EIST. Commit and push your changes.

#### Part 2: Configure Maven
Now, we want to configure Maven so that we can create an executable jar file of our application that we can distribute to users.

1. Adapt the pom.xml    
Open pom.xml and add the following into the <plugins> section (within the <build> section). Commit and push your changes.
    
```xml
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-resources-plugin</artifactId>
                <version>3.2.0</version>
                <executions>
                    <execution>
                        <id>copy-resources</id>
                        <phase>validate</phase>
                        <goals>
                            <goal>copy-resources</goal>
                        </goals>
                        <configuration>
                            <outputDirectory>${project.basedir}/target</outputDirectory>
                            <resources>
                                <resource>
                                    <directory>resources</directory>
                                    <filtering>true</filtering>
                                </resource>
                            </resources>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-assembly-plugin</artifactId>
                <!-- mvn clean compile assembly:single -->
                <version>3.3.0</version>
                <configuration>
                    <archive>
                        <manifest>
                            <mainClass>de.tum.in.ase.eist.App</mainClass>
                        </manifest>
                    </archive>
                    <descriptorRefs>
                        <descriptorRef>jar-with-dependencies</descriptorRef>
                    </descriptorRefs>
                </configuration>
            </plugin>
```

Execute the command mvn clean compile assembly:single. To do this follow these steps:

**Eclipse**
1. Right-click the pom.xml
2. Run as -> Maven build...
3. Specify the goals clean compile assembly:single and Run

**IntelliJ**
1. Go to View -> Tool Windows -> Maven
2. ress the Execute Maven Goal button at the top middle
3. Specify the goals clean compile assembly:single and press Enter

Hint: Make sure you completed task 1 already. Otherwise the maven build may fail.

Now search for the executable L10E03-Continuous-Integration-1.0-jar-with-dependencies.jar inside the target folder and execute it to make sure that it can be opened correctly.

#### Part 3: Add Log4j as dependency
Maven also manages dependencies and lets you easily add new libraries and frameworks to your Java project. We want to add logging to the UniversityApp. To save time, we want to reuse an external component, the logging framework Log4j. You can find an overview how Log4j can be used here: https://logging.apache.org/log4j/2.x/manual/api.html.

3.1. Insert the following dependency in the pom.xml. Commit and push your changes afterwards.

```xml
    <dependency>
        <groupId>org.apache.logging.log4j</groupId>
        <artifactId>log4j-core</artifactId>
        <version>2.14.1</version>
    </dependency>
```
Open UniversityApp.java and add

```java
import org.apache.logging.log4j.*;
```
3.2 Log the start of the UniversityApp  
Initialize a logger using LogManager.getLogger(UniversityApp.class) and log an info before the launch of the app. Make sure to configure the logging framework using its Configurator to set the root level to INFO.

Start the application again using your IDE and review if the log appears in the console.