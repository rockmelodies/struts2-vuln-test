# Struts2 Vulnerability Test Project

This is a sample Struts2 vulnerability testing project, designed to demonstrate potential security issues within Struts2 version 6.3.0.2. The project is set up to use Struts2's `.action` route and basic JSP pages.

## Project Setup

### Prerequisites

- **Java**: JDK 8 or above
- **Maven**: 3.0 or above
- **IDE**: IntelliJ IDEA, Eclipse, or any IDE that supports Maven-based Java projects.
- **Tomcat**: Optional (if you choose to run on a standalone Tomcat server)

### Installation

1. **Clone the repository**:
    ```bash
    git clone https://github.com/yourusername/struts2-vuln-test.git
    ```

2. **Navigate to the project directory**:
    ```bash
    cd struts2-vuln-test
    ```

3. **Build the project with Maven**:
    ```bash
    mvn clean install
    ```

4. **Run the project**:
   You can run the project either with an embedded Tomcat server (via Spring Boot) or deploy it to a standalone Tomcat server.

    - If you want to run it with **Tomcat**, build the project and deploy the `.war` file into your Tomcat `webapps` folder:
      ```bash
      mvn clean package
      # Copy the generated .war file to Tomcat's webapps folder
      ```

    - If using **Spring Boot** to run an embedded Tomcat server, configure your `application.properties` file for embedded configuration (optional).

### Project Structure

- **struts.xml**: Contains action mappings and configurations for the Struts2 framework.
- **WEB-INF/jsp/**: Contains JSP pages for the views.
- **src/main/java**: Contains Java classes for actions.

### Example Action

The project uses **Struts2 Action** to handle requests and map them to views.

#### `IndexAction.java`

```java
@Action(value = "index", results = {
    @Result(name = "success", location = "/WEB-INF/jsp/index.jsp")
})
public class IndexAction extends ActionSupport {
    private String message;

    public String execute() {
        message = "Hello, Struts2!";
        return SUCCESS;
    }

    public String getMessage() {
        return message;
    }
}
```

```xml
<struts>
    <package name="default" extends="struts-default">
        <action name="index" class="com.example.IndexAction">
            <result name="success">/WEB-INF/jsp/index.jsp</result>
        </action>
    </package>
</struts>
```

```jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <body>
    <h1>${message}</h1> <!-- Using Expression Language (EL) -->
  </body>
</html>
```
Dependencies
The following dependencies are used in the project:

Struts2 Core: Version 6.3.0.2 (specified version)
Servlet API: Version 4.0.1
JSP API: Version 2.3.3
If you're not using JSTL, you can omit it from the project dependencies.

pom.xml Configuration
Here is the configuration for the pom.xml to work with Struts2:

```java
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.example</groupId>
    <artifactId>struts2-vuln-test</artifactId>
    <packaging>war</packaging>
    <version>1.0-SNAPSHOT</version>
    <name>struts2-vuln-test Maven Webapp</name>
    <url>http://maven.apache.org</url>

    <dependencies>
        <!-- Struts2 Core -->
        <dependency>
            <groupId>org.apache.struts</groupId>
            <artifactId>struts2-core</artifactId>
            <version>6.3.0.2</version>
        </dependency>

        <!-- Servlet API -->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>4.0.1</version>
            <scope>provided</scope>
        </dependency>

        <!-- JSP API -->
        <dependency>
            <groupId>javax.servlet.jsp</groupId>
            <artifactId>javax.servlet.jsp-api</artifactId>
            <version>2.3.3</version>
            <scope>provided</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <!-- Maven War Plugin -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-war-plugin</artifactId>
                <version>3.3.1</version>
            </plugin>
        </plugins>
    </build>

</project>
```

Security Note
This project is intentionally configured with Struts2 6.3.0.2, which contains known vulnerabilities. Please be cautious when using this version in any production environment. This version is for testing and educational purposes only.

Additional Information
Struts2 Vulnerability: This version contains vulnerabilities like OGNL injection, which is a known security risk. Make sure to only use it in a controlled environment.


### 说明

1. **项目概述**：简要介绍了项目用途以及为什么使用特定版本的 **Struts2**。并且明确声明该项目用于测试漏洞，因此应小心使用。
2. **依赖说明**：列出了项目所依赖的 Maven 包，包括 **Struts2 Core**, **Servlet API**, 和 **JSP API** 等。
3. **配置示例**：包含了基本的 **Action** 类、**struts.xml** 配置以及 **JSP** 页面样例，演示了如何通过 `.action` 路由进行请求处理。
4. **安全提醒**：提醒使用者该版本存在已知的漏洞，应该仅在受控环境中进行使用。
5. **构建与启动**：提供了详细的构建和运行步骤，帮助用户从拉取代码到运行项目。

希望这份 `README.md` 对你有所帮助！如果你有其他要求或修改，可以随时告诉我。