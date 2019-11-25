package com.example.demo.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

public class Uploadphoto {
	public static boolean byteToFile(byte[] bytes,String name)
	{
	   try
	   {
	      // 根据绝对路径初始化文件
		  File file = ResourceUtils.getFile("classpath:img/"+name);
		  System.out.println(file.getAbsolutePath().toString());
	      if (!file.exists())
	      {
	         file.createNewFile();
	      }
	      // 输出流
	      OutputStream os = new FileOutputStream(file);
	      os.write(bytes);
	      os.close();
	      return true;
	   }
	   catch (Exception e)
	   {
	      e.printStackTrace();
	   }
	   return false;
	}
}
