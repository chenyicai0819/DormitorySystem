package cn.edu.guet.ioc;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 读取
 *
 * @Author liwei
 * @Date 2021-06-30 19:43
 * @Version 1.0
 */
public class BeanFactory {
    private static BeanFactory instance = new BeanFactory();

    private BeanFactory() {

    }

    public static BeanFactory getInstance() {
        return instance;
    }
    public Object getBean(String id){
        return map.get(id);
    }

    public static Map<String, Object> map = new HashMap<String, Object>();

    public static void parseElement(Element ele) {
        try {
            /**
             * 通过反射创建对象
             */
            Object beanObj = null;
            Class clazz = null;
            String id = ele.attributeValue("id");
            if (map.get(id) == null) {
                clazz = Class.forName(ele.attributeValue("class"));
                beanObj = clazz.newInstance();
                map.put(id, beanObj);
            }
            Object obj = null;
            String ref = "";
            List<Element> childElements = ele.elements();//得到ele的子元素集合
            for (Element childEle : childElements) {
                ref = childEle.attributeValue("ref");
                obj = map.get(ref);
                if (obj == null) {
                    for (Element el : list) {
                        String ids = el.attributeValue("id");
                        if (ids.equals(ref)) {
                            parseElement(el);// 递归处理  第一次循环el表示permissionDao
                        }
                    }
                }
                obj = map.get(ref);
                if (clazz != null) {
                    Method methods[] = clazz.getDeclaredMethods();//通过反射获取类的方法
                    for (Method m : methods) {
                        if (m.getName().startsWith("set") && m.getName().toLowerCase().contains(ref.toLowerCase())) {
                        /*
                        反射调用类的setXXX方法实现bean的自动注入
                         */
                            m.invoke(beanObj, obj);
                        }
                    }
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    static List<Element> list;

    static {
        try {
            SAXReader reader = new SAXReader();
            InputStream in = Class.forName("cn.edu.guet.ioc.BeanFactory")
                    .getResourceAsStream("/applicationContext.xml");
            Document doc = reader.read(in);
            // xPathExpression：xPath表达式
            list = doc.selectNodes("/beans/bean");
            for (Element ele : list) {
                parseElement(ele);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
