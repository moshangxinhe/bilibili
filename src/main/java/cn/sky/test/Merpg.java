package cn.sky.test;

import cn.sky.bean.Bili;
import cn.sky.utils.Tools;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Merpg {


    public static void main(String[] args) {

        Tools tool = new Tools();
        //获取路径分隔符
        String separator = File.separator;

        System.out.println("欢迎使用Bilibili客户端下载视频自动合并");
        System.out.println("请输入bilibili客户端下载文件全路径，多个文件夹用英文逗号分隔：");
        File out;
        File[] in = null;
        while (true) {
            boolean isBreak = true;
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            if (line == null || line.length() == 0) {
                System.out.println("输入不为空，请重试：");
                isBreak = false;
            } else {
                String[] lines = line.split(",");
                in = new File[lines.length];
                for (int i = 0; i < lines.length; i++) {
                    in[i] = new File(lines[i]);
                    if (!in[i].exists()) {
                        System.out.println(in[i].getAbsolutePath() + "文件夹不存在，请重试：");
                        isBreak = false;
                        break;
                    }
                }
            }
            if (isBreak) {
                break;
            }
        }

        System.out.println("请输入输出路径：");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            out = new File(line);
            if (!out.exists()) {
                System.out.println("文件夹不存在，请重试：");
            } else {
                boolean isEquals = true;
                for (int i = 0; i < in.length; i++) {
                    if (out.getAbsolutePath().equals(in[i].getAbsolutePath())) {
                        isEquals = false;
                        System.out.println("输出路径和某个输入路径相同，请重试：");
                        break;
                    }
                }
                if (isEquals) {
                    break;
                }
            }
        }

        //循环合并in[]
        for (int i = 0; i < in.length; i++) {
            //在合并中有读取json操作，得到播放文件名，如"(日剧)夺爱之冬" 的操作已于合并中进行
            String path = in[i].listFiles()[0].getAbsolutePath() + separator + "entry.json";
            String line = null;
            try {
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(new FileInputStream(path), Charset.forName("utf-8")));
                line = reader.readLine();
                reader.close();
                System.out.println("json=" + line);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //输出路径
            String[] names = tool.json_getName(line);
            String episode_path = out.getAbsolutePath() + separator + names[0];
            File episode = new File(episode_path);
            if (!episode.exists()) {
                episode.mkdirs();
            }
            System.out.println("输出：" + episode_path);
            //合并
//            tool.doMerge(in[i], out);
        }

//        //删除
//        System.out.println("删除源文件...");
//        for (int i = 0; i < in.length; i++) {
//            tool.deleteFolder(in[i]);
//        }

        //完成
        System.out.println("合并完成");
    }


    //启动
    public void start(File root, File path) {
        File[] files = root.listFiles();
        List<String> entryJsons = new ArrayList<>();
        for (File file : files) {
            findEntryJson(file, entryJsons);
        }
        System.out.println(entryJsons.size());
        try {
            startMerpg(entryJsons);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Bili> bilis = new ArrayList<>();

//        for (String entryJson : entryJsons) {
//
//        }
    }

    /*查询Entry.json 文件 */
    public void findEntryJson(File find, List<String> entryJsons) {
        if (find != null && !find.isHidden()) {
            if (find.getName().equals("entry.json")) {
                System.out.println(find.getAbsolutePath());
                entryJsons.add(find.getAbsolutePath());
            }
            if (find.isDirectory() && find.listFiles().length > 0) {
                for (File file : find.listFiles())
                    findEntryJson(file, entryJsons);
            }
        }
    }


    public void startMerpg(List<String> entryJsons) throws Exception {
        File file = null;
        for (String entryJson : entryJsons) {
            file = ResourceUtils.getFile(entryJson);
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),Charset.forName("UTF-8")));
            String line = reader.readLine();
            System.out.println("line--"+line);


        }
    }





}

