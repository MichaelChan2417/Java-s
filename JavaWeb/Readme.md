# JavaWeb

1. jQuery对象本质上是 DOM对象数组 + jQuery封装函数

## Servlet

1. Servlet继承关系: HttpServlet -> GenericServlet -> Servlet

2. Servlet中的核心方法: init(), service(), destroy()

3. 服务方法: 当有请求过来时，service方法会自动响应(其实是Tomcat容器调用)，在HttpServlet中我们去分析请求的方式：Post, Get, Head还是Delete等等...然后再决定调用哪种do方法
在HttpServlet中，这些do方法都是默认的405实现风格，需要子类去具体实现，否则返回405错误

4. 生命周期：
  a) 从出生到死亡对应三个方法：init(), service(), destroy()
  
