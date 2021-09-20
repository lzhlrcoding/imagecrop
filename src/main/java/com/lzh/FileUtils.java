package com.lzh;

import java.io.File;
import java.io.FilenameFilter;

public class FileUtils {
	public static String[] getImageArray(String path){
		return new File(path).list(new FilenameFilter(){
			@Override
			public boolean accept(File dir, String name) {
				String fileName = name.toUpperCase();
				if(fileName.endsWith(".PNG") || fileName.endsWith(".JPG")){
					return true;
				}
				return false;
			}
		});
	}
	//�����ļ�Ŀ¼
	public static boolean isExsit(String path){
		File filePath = new File(path);
		if(!filePath.exists()){
			return filePath.mkdirs();
		}
		return false;
	}
	//ɾ���ļ����µ��ļ�
	public static void deleteFile(String filePath){
		File file = new File(filePath);
		for(File f : file.listFiles()){
			f.delete();
		}
	}
	
}
