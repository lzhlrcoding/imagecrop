package com.lzh;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.Thumbnails.Builder;
import net.coobird.thumbnailator.geometry.Positions;

public class Demo {
	public static final String FILEPATH = "E:/¸¸Ä¿Â¼/×ÓÄ¿Â¼2/";
	public static void main(String[] args) {
		System.out.println(isExsit());
	}
	public static boolean isExsit(){
		File filePath = new File(FILEPATH);
		if(!filePath.exists()){
			return filePath.mkdirs();
		}
		return false;
	}
}
