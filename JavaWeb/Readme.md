# JavaWeb

1. jQuery对象本质上是 DOM对象数组 + jQuery封装函数

## Servlet

1. Servlet继承关系: HttpServlet -> GenericServlet -> Servlet

2. Servlet中的核心方法: init(), service(), destroy()

3. 服务方法: 当有请求过来时，service方法会自动响应(其实是Tomcat容器调用)，在HttpServlet中我们去分析请求的方式：Post, Get, Head还是Delete等等...然后再决定调用哪种do方法
在HttpServlet中，这些do方法都是默认的405实现风格，需要子类去具体实现，否则返回405错误

4. 生命周期：

    a) 从出生到死亡对应三个方法：init(), service(), destroy()
    
    b) 默认情况下：

        -第一次接受请求时，这个Servlet会进行实例化（调用构造方法,在Tomcat容器中,通过反射调用构造方法）、
        初始化(init())、然后服务(service())
        -第二次请求开始，每一次都是服务
        -当容器关闭时，其中所有的Servlet实例会被销毁，调用Destroy()

    c) 可以发现：
   1. Servlet实例Tomcat只会创建一个，所有的请求都是从这个实例去响应的
   2. 默认情况下，第一次请求时，Tomcat才会去范式实例化、初始化然后再服务(懒汉式)。可以提高系统的启动速度，但是会拖慢第一个人的响应速度

    d) Servlet初始化时机：
   1. 默认是第一次接受请求时
   2. 可以通过设置web.xml中的<load-on-startup>设置servlet的启动顺序，数字越小，启动越早
   
    e) Servlet在线程中是单例的，**线程不安全**的

### 会话


会话跟踪技术：

- 客户端第一次发请求给服务器，服务器获取session，如果获取不到，则创建新的，然后响应给客户端

- 下次客户端给服务器发请求时，会把sessionID带给服务器，这样服务器就获取到了，服务器可以判断请求是否来自同一客户端
（由于HTTP是无状态的）

- 常用API：

   request.getSession() -> 获取当前会话，没有则创建新的

   request.getSession(true) -> 等于无参的

   request.getSession(false) -> 获取当前会话，没有则返回null，不会创建新的

   session.getId() -> 获取sessionID 全球唯一

   session.isNew() -> 判断session是否是新的

   session.getMaxInactiveInterval() -> session的非激活间隔时长，默认1800s

   session.invalidate() -> 会话强制失效

会话保存作用域:

- session保存作用域是和某一个具体的session对应的

- 常用API:
   
   void session.setAttribute(k, v);

   Object session.getAttribute(k);

   void session.removeAttribute(k);


### 服务器内部转发/客户端重定向

- 服务器内部转发（服务器帮你内部转发）：

   req.getRequestDispatcher("...").forward(req, resp);

- 客户端重定向（给客户端响应，让客户端自己重定向）：

   resp.sendRedirect("...");


## Thymeleaf - 视图模板技术









