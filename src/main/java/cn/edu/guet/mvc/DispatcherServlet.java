package cn.edu.guet.mvc;

import cn.edu.guet.ioc.BeanFactory;
import com.google.gson.GsonBuilder;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author liwei
 * @Date 2021-06-24 19:45
 * @Version 1.0
 */
public class DispatcherServlet extends HttpServlet {

    Map<String, ControllerMapping> controllerMapping;

    @Override
    public void init(ServletConfig config) throws ServletException {
        controllerMapping = (Map<String, ControllerMapping>) config.getServletContext().getAttribute("cn.guet.web.controller");
        /*
        对HashMap进行遍历
         */
        System.out.println(controllerMapping);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String uri = request.getRequestURI();
            uri = uri.substring(uri.indexOf("/", 1) + 1);
            System.out.println("真实的客户请求：" + uri);
            ControllerMapping mapping = null;
            if (controllerMapping.containsKey(uri)) {
                mapping = controllerMapping.get(uri);
            }
            Class controllerMappingClass = mapping.getControllerClass();
            Method method = mapping.getHandleMethod();
            Class[] parameterType = method.getParameterTypes();

            List<String> paramterList = new ArrayList<String>();//List的特点：有序可重复
            Parameter[] params = method.getParameters();
            for (Parameter parameter : params) {
                paramterList.add(parameter.getName());
            }
            Object[] parameterValues = new Object[parameterType.length];//获取的参数的值
            for (int i = 0; i < parameterType.length; i++) {
                /*
                8种基本类型
                 */
                if (parameterType[i].isPrimitive()) {
                    if (parameterType[i].getTypeName().equals("int")) {
                        parameterValues[i] = Integer.parseInt(request.getParameter(paramterList.get(i)));
                    }else if(parameterType[i].getTypeName().equals("float")){
                        parameterValues[i]=Float.parseFloat(request.getParameter(paramterList.get(i)));
                    }else if(parameterType[i].getTypeName().equals("double")){
                        parameterValues[i]=Double.parseDouble(request.getParameter(paramterList.get(i)));
                    }else if(parameterType[i].getTypeName().equals("byte")){
                        parameterValues[i]=Byte.parseByte(request.getParameter(paramterList.get(i)));
                    }else if(parameterType[i].getTypeName().equals("short")){
                        parameterValues[i]=Short.parseShort(request.getParameter(paramterList.get(i)));
                    }else if(parameterType[i].getTypeName().equals("long")){
                        parameterValues[i]=Long.parseLong(request.getParameter(paramterList.get(i)));
                    }else if(parameterType[i].getTypeName().equals("boolean")){
                        parameterValues[i]=Boolean.parseBoolean(request.getParameter(paramterList.get(i)));
                    }
                    /*
                     处理String类型
                     */
                } else if (ClassUtils.isAssignable(parameterType[i], String.class)) {
                    parameterValues[i] = request.getParameter(paramterList.get(i));
                } else {
                    //Bean
                    Object pojo = parameterType[i].newInstance();
                    //得到请求里所有的参数：Map<参数名, value>
                    //获取表单里的数据
                    Map<String, String[]> parameterMap = request.getParameterMap();
                    //beanutils会自动将map里的key与bean的属性名进行反射赋值
                    BeanUtils.populate(pojo, parameterMap);
                    parameterValues[i] = pojo;
                }
            }

            Object obj = BeanFactory.getInstance().getBean(controllerMappingClass.getSimpleName());
            Object returnValue = method.invoke(obj, parameterValues);//调用方法处理请求即可
            if (returnValue != null && returnValue instanceof String) { //方法返回的是一个字符串类
                String path = returnValue.toString();
                if (((String) returnValue).startsWith("forward:")) {
                    request.getRequestDispatcher(StringUtils.substringAfter(path, "forward:")).forward(request, response);
                } else if (((String) returnValue).startsWith("redirect:")) {
                    response.sendRedirect(StringUtils.substringAfter(path, "redirect:"));
                }
            } else if (returnValue != null && !(returnValue instanceof String)) {
                response.setContentType("application/json; charset=UTF-8");
                //返回的是一个bean，即客户端发送的是ajax请求，并将该bean转换成json
                String json = new GsonBuilder()
                        .setDateFormat("yyyy-MM-dd HH:mm:ss")
                        .setPrettyPrinting()
                        .create()
                        .toJson(returnValue);
                PrintWriter out = response.getWriter();
                out.write(json);
                out.flush();
                out.close();
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}