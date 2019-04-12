package 反射;

import org.junit.Test;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest{

    @Test
    public void a1(){
        //1.得到Class对象
        Class clazz=Person.class;
        //2.返回字段的数组
        Field[] fields=clazz.getDeclaredFields();
        for (Field field:fields) {
            System.out.println(field.getName());
        }
    }

    /**
     * 获取Class对象的三种方式
     * 1.通过类名获取  类名.class
     * 2.通过对象获取  对象名.getClass()
     * 3.通过全类名获取  Class.forName(全类名)
     */
    @Test
    public void testClass() throws ClassNotFoundException {
        Class clazz=null;

        //1.通过类名
        clazz=Person.class;
        System.out.println("Person.class："+clazz);

        //2.通过对象名
        //这种方式是在传来一个对象，却不知道对象类型的时候用的
        Person person=new Person();
        clazz=person.getClass();
        //上面这个例子意义不大，因为已经知道person是Person类，所以没必要这样写了
        //如果传进来是一个Object类，这种做法就有意义了
        Object object=new Person();
        clazz=object.getClass();
        System.out.println("object.getClass()："+clazz);

        //3.通过全类名（会抛出异常）
        //一般框架开发中这种用得比较多，因为配置文件中一般配的都是全类名，通过这种方式可以得到Class实例
        String className="反射.Person";
        clazz=Class.forName(className);
        System.out.println("Class.forName(className)："+clazz);
       }

    //Class类的newInstance()方法：返回该Class对象的一个实例
    @Test
    public void testNewInstance() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //1.获取Class对象
        String className="反射.Person";
        Class clazz=Class.forName(className);

        //2.利用Class对象的newInstance方法创建一个类的实例
        Object object=clazz.newInstance();
        System.out.println(object);
    }

    //ClassLoader：类加载器是用来把类装载进JVM的
    @Test
    public void testClassLoader() throws ClassNotFoundException {
        //1.获取一个系统的类加载器（可以获取当前这个类ReflectionTest就是他加载的）
        ClassLoader classLoader=ClassLoader.getSystemClassLoader();
        System.out.println("ClassLoader.getSystemClassLoader()："+classLoader);

        //2.获取系统类加载器的父类加载器（扩展类加载器，可以获取）
        classLoader=classLoader.getParent();
        System.out.println("classLoader.getParent()："+classLoader);

        //3.获取扩展类加载器的父类加载器（引导类加载器，不可获取）
        classLoader=classLoader.getParent();
        System.out.println("classLoader.getParent().getParent()："+classLoader);

        //4.测试当前类由哪个类加载器进行加载（系统类加载器）
        classLoader=Class.forName("反射.ReflectionTest").getClassLoader();
        System.out.println("Class.forName('反射.ReflectionTest').getClassLoader()："+classLoader);

        //5.测试JDK提供的Object类由哪个类加载器
        classLoader=Class.forName("java.lang.Object").getClassLoader();
        System.out.println("Class.forName('java.lang.Object').getClassLoader()："+classLoader);

        //6.使用ClassLoader获取当前类目录下的文件

        //(1).src目录下，直接加载
        InputStream inputStream=null;
        inputStream=this.getClass().getClassLoader().getResourceAsStream("com/shiro/controller/AdminController.java");
        System.out.println(inputStream);
   }

    /**
     * 反射：Reflection(反射)Java被视为动态语言的关键，反射机制允许程序在执行期借助于Reflection API取得任何类的内部信息，并能直接操作任意对象的内部属性及方法
     * Java反射机制主要提供了一下功能：
     *   ·在运行时构造任意一个类的对象
     *   ·在运行时获取任意一个类所具有的成员变量和方法
     *   ·在运行时调用任意一个对象的方法（属性）
     *   ·生成动态代理
     */

    //Reflection--Method
    @Test
    public void testMethod() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class clazz=Class.forName("反射.Person");

        //一丶获取方法
        //1.getMethods：获取clazz对应类中所有方法，不能获取private方法，去获取从父类继承来的所有方法
        Method[] methods=clazz.getMethods();
        System.out.print("getMethods()：");
        for (Method m:methods) {
            System.out.print(" "+m.getName());
        }
        System.out.println();

        //2.getDeclareMethods()：获取clazz对应类中所有的方法，且之获取当前类的方法
        methods=clazz.getDeclaredMethods();
        System.out.print("getDeclareMethods()：");
        for (Method m: methods) {
            System.out.print(" "+m.getName());
        }
        System.out.println();

        //3.getDeclaredMethod(name,parameterType)：获取指定的方法
        Method method=clazz.getDeclaredMethod("setAge", int.class);
        System.out.println(method);

        //二丶使用方法
        //返回class的实例对象
        Object object=clazz.newInstance();
        //如果方法是私有的，需要设置访问权限
        method.setAccessible(true);
        //invoke(Object,args)：执行反射得到的方法，第一个参数表示执行哪个对象的方法，剩下的参数是执行方法时需要传入的参数
        method.invoke(object,2);

    }

    //Reflection--Field
    @Test
    public void testField() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Class clazz=Class.forName("反射.Person");

        //一.获取字段

        //1.getDeclaredFields()：获取clazz对应的类所有的属性
        Field[] fields=clazz.getDeclaredFields();
        System.out.print("getDeclaredFields：");
        for (Field f:fields) {
            System.out.print(" "+f.getName());
        }
        System.out.println();

        //2.getDeclaredField(FieldName)：获取指定属性
        Field field=clazz.getDeclaredField("name");
        System.out.println("getDeclareField('name')："+field.getName());

        //二丶使用字段

        //注意：如果字段是private修饰的，使用field时需要设置field的访问权限
        field.setAccessible(true);

        //1.field.get(person)：获取指定对象的指定属性的值
        Person person=new Person("张三",18);
        Object val=field.get(person);
        System.out.println("field.get(person)："+val);

        //2.field.set(person)：设置制定对象的指定属性的值
        field.set(person,"李四");
        System.out.println("Age："+person.getName());

    }

    //reflection--Constructor
    @Test
    public void testConstructor() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz=Class.forName("反射.Person");

        //1.getDeclaredConstructors()：获取全部Constructor
        Constructor<Person>[] constructors=clazz.getDeclaredConstructors();
        System.out.print("getDeclaredConstrctors()：");
        for (Constructor<Person> c:constructors) {
            System.out.print(" "+c);
        }
        System.out.println();

        //2.getDeclaredConstructor(ParameterTypes)：获取指定Constructor
        Constructor<Person> constructor=clazz.getDeclaredConstructor(String.class,int.class);
        System.out.println("getDeclaredConstructor(String.class,int.class)："+constructor);

        //3.调用构造器的newInstance()方法创建对象
        Object object=constructor.newInstance("赵六",100);
        System.out.println("constructor.nweInstance('赵六',100)："+object);
    }

}