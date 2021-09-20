package com.lzh;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.filechooser.FileFilter;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.Thumbnails.Builder;
import net.coobird.thumbnailator.geometry.Positions;

public class ImageCropUtils {
	private static final int BASEHEIGHT = 500;
	private static final String CROPPATH = "F:/רҵ/�ü�/";
	private static final String BASEPATH = "F:/����/";
	private static BufferedImage originalImage = null;
	private static BufferedImage cropImage = null;
	private static int originalWidth;//ԭʼͼƬ�Ŀ��
	private static int originalHeight;//ԭʼͼƬ�ĸ߶�
	private static int hMult;		//3000�ı���
	private static int hDeli;		//��3000����ȡģ����
	
	public static void main(String[] args) throws Exception {
		//ɾ���ü�Ŀ¼�ļ����µ�ͼƬ
		FileUtils.deleteFile(CROPPATH);//bug:���ļ�Ŀ¼��������ʱ���ᱨ��
		String[] imageArray = FileUtils.getImageArray(BASEPATH);
		if(imageArray != null){
			for (int i = 0; i < imageArray.length; i++) {
				originalImage = ImageIO.read(new File(BASEPATH + imageArray[i]));
				originalWidth = originalImage.getWidth();
				originalHeight = originalImage.getHeight();
				hMult = originalHeight / BASEHEIGHT;
				hDeli = originalHeight % BASEHEIGHT;
				
				String imageName = imageArray[i].substring(0, imageArray[i].lastIndexOf("."));
				if(hMult <= 0){//<3000
					getLowTh(imageName);
				}else if(hMult == 1 && hDeli ==0){//=3000
					getEqualTh(imageName);
				}else{//>3000,
					getUpTh(imageName);
				}
			}
		}
	}
	//��ȡ<3000����Ƭ
	private static void getLowTh(String imageName) throws Exception{
		isExsit(CROPPATH);
		Thumbnails.of(originalImage).sourceRegion(0, 0, originalWidth, originalHeight)
			.size(originalWidth, originalHeight)
			.keepAspectRatio(false)
			.toFile(CROPPATH + imageName + "_L3000.png");
		
	}
	//��ȡ==3000����Ƭ
	private static void getEqualTh(String imageName) throws Exception{
		isExsit(CROPPATH);
		Thumbnails.of(originalImage).sourceRegion(0, 0, originalWidth, originalHeight)
			.size(originalWidth, originalHeight)
			.keepAspectRatio(false)
			.toFile(CROPPATH + imageName +"_E3000.png");
	}
	//��ȡ>3000����Ƭ
	private static void getUpTh(String imageName) throws Exception{
		isExsit(CROPPATH);
		for(int i = 0; i <= hMult; i++){
			Thumbnails.of(originalImage).sourceRegion(0, originalHeight - (BASEHEIGHT*(hMult-i) + hDeli), originalWidth, i<hMult?BASEHEIGHT:(BASEHEIGHT*(hMult-i) + hDeli))
				.size(originalWidth, i<hMult?BASEHEIGHT:(BASEHEIGHT*(hMult-i) + hDeli))//i<hMult?BASEHEIGHT:(BASEHEIGHT*(hMult-i) + hDeli)
				.keepAspectRatio(false)
				.toFile(CROPPATH + imageName + "_U3000_" + i + ".png");
    	}
	}
	//�ж�·���Ƿ����
	public static boolean isExsit(String path){
		File filePath = new File(CROPPATH);
		if(!filePath.exists()){
			return filePath.mkdirs();
		}
		return false;
	}
}






