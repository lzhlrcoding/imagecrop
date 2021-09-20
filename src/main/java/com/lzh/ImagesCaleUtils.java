package com.lzh;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.Thumbnails.Builder;

public class ImagesCaleUtils {
	public static Builder<BufferedImage> cropImageBuilder = null;
	public static BufferedImage cropImage = null;
	public static final String CALEPATH = "E:/רҵ/�Ŵ�/";
	public static final String CROPPATH = "E:/02.ѭ��ϵͳͼƬ�����ںţ������־��/";
	
	public static void main(String[] args) throws Exception {
		//��ɾ���ļ����µ��ļ��������������ļ�
		FileUtils.deleteFile(CALEPATH);
		upScale();
	}
	
	public static void upScale() throws Exception{
		FileUtils.isExsit(CALEPATH);//�ж�·���Ƿ����
		String[] imageArray = FileUtils.getImageArray(CROPPATH);//������Ƭ
		for (int i = 0; i < imageArray.length; i++) {
			cropImage = ImageIO.read(new File(CROPPATH + imageArray[i]));
			Thumbnails.of(cropImage).scale(1.75f).outputQuality(0.8f).toFile(CALEPATH + imageArray[i]);			
		}
	}		
	
}
