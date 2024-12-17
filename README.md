# struts2-vuln-test



`mvn archetype:generate -DgroupId=com.example -DartifactId=struts2-vuln -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false
`

#### 解释：
-DgroupId=com.example：设置项目的 groupId，这是 Maven 项目的唯一标识符，通常是你公司或组织的域名反转形式。
-DartifactId=struts2-vuln：设置项目的 artifactId，即项目的名称。
-DarchetypeArtifactId=maven-archetype-webapp：指定项目使用的 Maven archetype（项目模板），这里是 Web 应用程序模板。
-DinteractiveMode=false：关闭交互式模式，避免 Maven 提示你输入项目信息（如 groupId、artifactId 等）。

#### 运行结果：
该命令会生成一个基本的 Web 项目结构，你可以进一步在此基础上添加 Struts2 相关配置和依赖。

完成命令后，你应该会在当前目录下看到一个名为 struts2-vuln 的文件夹，其中包含项目结构。你可以进入该目录并开始添加 Struts2 的相关配置。

在完成了通过 Maven 创建项目并添加 Struts2 依赖后，接下来是配置和启动你的 Struts2 项目。以下是启动项目的步骤。

步骤 1: 配置 web.xml
Struts2 项目需要在 web.xml 文件中配置相关的过滤器和监听器，确保 Struts2 的框架可以正常工作。

在 src/main/webapp/WEB-INF/web.xml 文件中，添加以下内容：

```xml 
<web-app xmlns="http://java.sun.com/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
                             http://java.sun.com/xml/ns/javaee/web-app_3_1.xsd"
         version="3.1">

    <!-- Struts2 Filter -->
    <filter>
        <filter-name>struts2</filter-name>
        <filter-class>org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter</filter-class>
    </filter>
    <filter-mapping>
        <filter-name>struts2</filter-name>
        <url-pattern>/</url-pattern>
    </filter-mapping>

</web-app>
```

StrutsPrepareAndExecuteFilter 是 Struts2 的核心过滤器，它处理请求并分发到适当的 Action。

步骤 2: 配置 struts.xml
你还需要在 src/main/resources 目录下创建 struts.xml 配置文件，这个文件是 Struts2 框架的核心配置文件，用来定义 Action 类和视图等。

创建一个 struts.xml 文件，内容如下：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<struts>
    <!-- Define a default package -->
    <package name="default" extends="struts-default">
        <!-- Action mapping -->
        <action name="hello" class="com.example.HelloAction">
            <result>/WEB-INF/jsp/hello.jsp</result>
        </action>
    </package>
</struts>
```
package 标签：定义了一个默认的包（default），它继承了 Struts2 默认的配置。
action 标签：定义了一个名为 hello 的 Action，类 com.example.HelloAction 和对应的视图 hello.jsp。

步骤 3: 创建 Action 类
在 src/main/java/com/example 目录下创建一个名为 HelloAction.java 的类：
```java
package com.example;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport {

    private String message;

    @Override
    public String execute() throws Exception {
        message = "Hello, Struts2!";
        return SUCCESS;
    }

    public String getMessage() {
        return message;
    }
}
```
HelloAction 类继承自 ActionSupport 类，表示这是一个 Struts2 的 Action 类。
execute() 方法返回 SUCCESS，表示 Action 执行成功，并传递 message 数据到 JSP 页面。

步骤 4: 创建 JSP 页面
在 src/main/webapp/WEB-INF/jsp/ 目录下创建一个 hello.jsp 页面，内容如下：

```jsp
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head><title>Hello Struts2</title></head>
<body>
    <h1>${message}</h1>
</body>
</html>
```
该 JSP 页面通过 ${message} 显示从 Action 类传递过来的 message 数据。

步骤 5: 使用 Maven 构建项目
现在你已经完成了配置，可以使用 Maven 构建项目。

```java
mvn clean install
```
这将构建项目并下载所需的依赖项。

步骤 6: 配置 Tomcat 启动
你可以使用 Tomcat 来运行这个项目。假设你已经安装了 Tomcat，你需要将项目打包为 .war 文件并将其部署到 Tomcat 中。

a. 修改 pom.xml 文件，确保使用 maven-war-plugin 来构建 .war 文件：

```java
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-war-plugin</artifactId>
            <version>3.3.1</version>
        </plugin>
    </plugins>
</build>
```
b. 打包项目：
使用 Maven 打包项目：

```mvn clean package
```

这会生成一个 struts2-vuln.war 文件，位于 target 目录下。

c. 部署到 Tomcat：
将 struts2-vuln.war 文件复制到 Tomcat 的 webapps 目录。
启动 Tomcat。
访问 http://localhost:8080/struts2-vuln/hello.action 来测试项目。

步骤 7: 测试
在浏览器中访问：

`
http://localhost:8080/struts2-vuln/hello.action
`
如果一切配置正确，你应该会看到页面显示：

Hello, Struts2!

总结：
配置 web.xml 和 struts.xml。
创建 Action 类和对应的 JSP 页面。
使用 Maven 构建并打包项目。
将项目部署到 Tomcat 并启动。
通过以上步骤，你就能够启动一个基本的 Struts2 项目，并通过浏览器访问它。
