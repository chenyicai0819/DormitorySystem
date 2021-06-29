package cn.edu.guet.mvc;

import cn.edu.guet.mvc.annotaion.Controller;
import cn.edu.guet.mvc.annotaion.RequestMapping;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.MethodUtils;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class Configuration {
    public Map<String,ControllerMapping> config() throws URISyntaxException {
        Map<String,ControllerMapping> controllerMappingMap=new HashMap<String,ControllerMapping>();

        ResourceBundle bundle=ResourceBundle.getBundle("config");//读取config.properties文件
        String controllerPackageName=bundle.getString("controller.package");//读取这个key的内容

        String path=controllerPackageName.replace(".","/");//将包名转换为路径，用"/"替换"."
        URI uri=Configuration.class.getResource("/"+path).toURI();//将路径转换为uri,相当于转换成电脑上C盘路径
        File controllerDirectory=new File(uri);//读取路径

        String[] controllerFilrNames=controllerDirectory.list();//筛选到上面的路径下面的.class文件
        for(String string:controllerFilrNames){
            if(string.endsWith(".class")){
                String fullClassName = controllerPackageName + "." + StringUtils.substringBefore(string, ".class");//筛选出.class文件的全类名
                try {
                    Class controllerClass=Class.forName(fullClassName);
                    //如果类中有Controller注解，才进行语句里的内容（查找有RequestMapping注解的方法）
                    if(controllerClass.isAnnotationPresent(Controller.class)){
                        //找到有requestMapping注解的方法，进入for循环
                        Method methods[]= MethodUtils.getMethodsWithAnnotation(controllerClass, RequestMapping.class);
                        for(Method method:methods){
                            //循环获取到注解的值，url，相当于web.xml中url-pattern中的值
                            RequestMapping annotation=method.getAnnotation(RequestMapping.class);//拿到注解的值，放到annatation中
                            ControllerMapping mapping=new ControllerMapping(controllerClass,method);//
                            controllerMappingMap.put(annotation.value(), mapping);//拿到有注解的方法，然后根据方法名决定从mapping中使用哪个方法
                        }
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        }
        return controllerMappingMap;
    }


}
