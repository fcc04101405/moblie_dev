fragment

特别注意：

要么继承第一种要么继承第二种两者间导入的包不能混用，估计是官方升级后替换掉了，

[android.support.v4.app.FragmentActivity和android.app.Fragment区别](http://blog.csdn.net/duguang77/article/details/17580993)

3.0之前的Activity是不能用fragment的。为了能使用fragment(supportV4中)，才有了FragmentActivity。FragmentActivity继承的Activity。