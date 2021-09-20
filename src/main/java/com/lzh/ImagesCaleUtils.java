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
	public static final String CALEPATH = "E:/专业/放大/";
	public static final String CROPPATH = "E:/02.循环系统图片【公众号：泽哥日志】/";
	
	public static void main(String[] args) throws Exception {
		//先删除文件夹下的文件，在往里面存放文件
		FileUtils.deleteFile(CALEPATH);
		upScale();
	}
	
	public static void upScale() throws Exception{
		FileUtils.isExsit(CALEPATH);//判断路劲是否存在
		String[] imageArray = FileUtils.getImageArray(CROPPATH);//过滤照片
		for (int i = 0; i < imageArray.length; i++) {
			cropImage = ImageIO.read(new File(CROPPATH + imageArray[i]));
			Thumbnails.of(cropImage).scale(1.75f).outputQuality(0.8f).toFile(CALEPATH + imageArray[i]);			
		}
	}		
	
}
