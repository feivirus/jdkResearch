package com.feivirus.javassist;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.NotFoundException;

/**
 * 修改类，添加运行时间
 * 运行命令 java -cp C:\work\project\jdk-research\jdk-research\target\classes\com\feivirus\j
avassist\javassist.jar;.   MyStringBuilder
 * @author feivirus
 *
 */

public class JavassistTiming {
    public static void addTiming(CtClass ctClass, String methodName) throws CannotCompileException, NotFoundException {
        CtMethod method = ctClass.getDeclaredMethod(methodName);
        String newMethodName = methodName + "$impl";
        method.setName(newMethodName);
        
        CtMethod newMethod = CtNewMethod.copy(method, methodName, ctClass, null);
        String type = method.getReturnType().getName();
        
        StringBuffer body = new StringBuffer();        
        body.append("{\nlong start = System.currentTimeMillis();\n");
        if (!"void".equals(type)) {
            body.append(type + " result = ");            
        }
        body.append(newMethodName + "($$);\n");        
        body.append("System.out.println(\" Call to method" + methodName +
                        " took\" + \n (System.currentTimeMillis() - start) + " +
                        "\" ms.\");\n");
        if (!"void".equals(type)) {
            body.append("return result;\n");
        }
        body.append("}");
        newMethod.setBody(body.toString());
        ctClass.addMethod(newMethod);
        
        System.out.println("Interceptor method body:");
        System.out.println(body.toString());
    }
    
    public static void main(String[] args) {
        try {
            CtClass classTarget = ClassPool.getDefault().get("MyStringBuilder");
            
            if (classTarget == null) {
                System.out.println("Class MyStringBuilder not found");
            } else {
                addTiming(classTarget, "buildString");
                classTarget.writeFile();
                System.out.println("Added timing to method MyStringBuilder.buildString");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
}
