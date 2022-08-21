# Java-s

## 几个定义

1. 重载：Overloading. 对方法而言，只看方法名和参数列表，不看返回类型。方法名相同，参数列表不同 就是方法的重载。经典例子：构造函数（空）和包含输入参数的构造函数。

2. 重写：Overwriting. 主要是父子类而言。对子类来说重写同名同参父类方法，要求权限不小于父类、返回类不大于父类。子类不能重写父类的private，显然子类调用不到父类的任何private的东西，你爸有个保险箱有密码。

3. 多态：父类的引用指向了子类的对象 Person p = new Man();

    编译阶段：只能调用父类中写的方法 但是实际运行时用的是子类的方法（重写的）。同时！！堆中是包含父类和子类都的属性。

    大应用：就比如现在有个方法/公共函数是针对Database的 比如是 public DoData(baseSQL)；这边呢有MySql和Orecal两种数据库函数要去调用DoData。就可以是:

    DoData(new MySql) || DoData(new Orecal)

    这时候 内部的method都会根据具体的类去调用针对具体类重写过后的 提高代码复用率就不需要去专门的写MySql和Orecal专门的DoData。
    
3.1 多态plus：举个例子 Person p = new Man(); 其中 Man 是 Person 的子类；那么在堆空间中是包含了同时Man和Person的属性和方法。对属性的调用 只能用Person的 但是 对方法的调用 用的都是最新的方法，指用重写过后的方法。怎么才能不用重写的方法呢？ 那就老老实实Person p = new Person(); 在Man类中不用重写才是super.方法名。


## JavaWeb

1. jQuery对象本质上是 “DOM对象数组” + “jQuery封装函数”
