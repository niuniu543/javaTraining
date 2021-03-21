package com.work01;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

public class HelloClassLoader extends ClassLoader{
    private String pathDir;
    public  static void main(String[] arges) throws Exception{
        HelloClassLoader dcl=new HelloClassLoader("D:\\workspace");
        Class<?> aClass = dcl.loadClass("Hello.xlass");
        Object o = aClass.newInstance();
        aClass.getMethod("hello",null).invoke(o,null);
    }

    public HelloClassLoader(String pathDir) {
        this.pathDir = pathDir;
    }
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String classFileName = pathDir + "\\" + name.substring(0,name.lastIndexOf(".")) + ".xlass";
        System.out.println(classFileName);
        try{
            FileInputStream fis = new FileInputStream(classFileName);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int b = -1;
            while ((b = fis.read()) != -1) {
                bos.write(b ^ 0xff);
            }
            fis.close();
            byte[] bytes = bos.toByteArray();
            return defineClass(null,bytes,0,bytes.length);
        }catch (Exception e){
            e.printStackTrace();
        }
        return super.findClass(name);
    }
}
