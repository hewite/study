import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.*;
import java.util.Properties;

class Person{
    private String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    private Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void show(){
        System.out.println("我是Person类的show方法");
    }
    private void cha(String s){
        System.out.println("我是Person类的cha方法"+s);
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
class Aa {
    public static void main(String[] args) throws Exception{
        Superman superman = new Superman();
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superman);
        System.out.println(proxyInstance.getBelief());
        proxyInstance.eat("火锅");

    }
}

//被代理类
class Superman implements Human{

    @Override
    public String getBelief() {
        return "I believe I can fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃"+food);
    }
}
class SupernamUtil{
    public void method1(){
        System.out.println("方法一");
    }
    public void method(){
        System.out.println("方法二");
    }
}
class ProxyFactory{
    public static Object getProxyInstance(Object obj){
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
        myInvocationHandler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),myInvocationHandler);
    }
}
class  MyInvocationHandler implements InvocationHandler{
    private Object obj;
    public void bind(Object obj) {
        this.obj=obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        SupernamUtil util = new SupernamUtil();
        util.method();
        Object returnValue=method.invoke(obj,args);
        util.method1();
        return returnValue;
    }


}