package cn.sky.test;

import cn.sky.bean.Bili;
import cn.sky.utils.Tools;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.Scanner;


public class MyTest {
    private Log log = LogFactory.getLog(this.getClass());


    public static void main(String[] args) {
        String separator = File.separator;  //路径分隔符
        File root = null; //根路径
        File out = null;  //输出根路径


        Scanner sc = new Scanner(System.in);
        System.out.println("bili视频根路径\n");
        String input = sc.nextLine();
        root = new File(input);
        System.out.println("输出路径\n");
        input = sc.nextLine();
        out = new File(input);
        System.out.println("root" + root.getAbsolutePath() + "\nout" + out);
        Merpg merpg = new Merpg();

        if (root.exists() && out.exists())
            merpg.start(root, out);


    }


    @Test
    public void test() {

        String separator = File.separator;  //路径分隔符
        File root = null; //根路径
        File out = null;  //输出根路径


        Scanner sc = new Scanner(System.in);
        System.out.println("bili视频根路径\n");
        String input = sc.nextLine();
        root = new File(input);
        System.out.println("输出路径\n");
        input = sc.nextLine();
        out = new File(input);
        System.out.println("root" + root.getAbsolutePath() + "\nout" + out);
        Merpg merpg = new Merpg();
        merpg.start(root, out);


//==============================================================================================
//
//        String json = null;
//        try {
//            File jsFile = ResourceUtils.getFile("classpath:entry.json");
//            json = FileUtils.readFileToString(jsFile, "UTF-8");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        Bili bili = JSONObject.parseObject(json, Bili.class);
//
//
//        //=================================start 创建文件==============================================//
//        String path = "D:\\";
//        System.out.println(path + bili.getTitle());
//        File video = new File(path + bili.getTitle() + separator + bili.getPage_data().getPart() + ".flv");
//        if (!video.exists()) {
//            if (!video.getParentFile().exists()) {
//                video.getParentFile().mkdirs();
//            }
//        }
//
//        System.out.println(video.getAbsolutePath().trim());
//        //=================================end 创建文件==============================================//
//
//        Tools tool = new Tools();
//        //获取路径分隔符
//
//
    }


}
