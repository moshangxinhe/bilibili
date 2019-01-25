package cn.sky.utils;


import cn.sky.bean.Bili;
import cn.sky.bean.PageData;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;


public class Tools {

    /**
     * 获取视频名字
     *
     * @param json
     * @return
     */
    public String[] json_getName(String json) {

        Bili bili = JSONObject.parseObject(json, Bili.class);
        String[] names = null;
        if (bili.getPage_data() != null) {
            PageData pageData = bili.getPage_data();
            int page = pageData.getPage();
            //去除不符合命名规则的字符
            String name = nameMatch(pageData.getPart());
            names = new String[]{nameMatch(bili.getTitle()), name};
        } else
            return null;
        return names;
    }

    //删除源文件
    public boolean deleteFolder(File file) {
        if (!file.exists()) {
            return false;
        }
        if (file.isFile() || file.listFiles().length == 0) {
            file.delete();
            return true;
        } else {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                deleteFolder(files[i]);
            }
            file.delete();
            return true;
        }
    }

    //合并文件
    public void doMerge(File in, File out) {
        //1、2、3、4...
        File[] files = in.listFiles();
        //输出路径
        String episode_path = null;
        //循环
        for (File f : files) {
            //视频文件名和分P文件名-如第一话
            String[] names = null;
            //获得所有名为.blv的文件
            File[] ffs = null;
            File[] fs = f.listFiles();
            for (final File ff : fs) {
                if (ff.getName().equals("entry.json")) {
                    String json_name = null;
                    try {
                        BufferedReader reader =
                                new BufferedReader(new InputStreamReader(new FileInputStream(ff), Charset.forName("utf-8")));
                        json_name = reader.readLine();
                        reader.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    names = json_getName(json_name);

                }

                if (ff.isDirectory() && ff.getName().startsWith("lua.")) {
                    //重命名
                    for (int i = 0; i < ff.list().length; i++) {
                        File pathname = ff.listFiles()[i];
                        //0.blv -- 00.blv
                        if (pathname.getName().endsWith(".blv") && pathname.getName().length() == 5) {
                            pathname.renameTo(new File(pathname.getParentFile().getAbsolutePath() + File.separator + "0" + pathname.getName()));
                        }

                        if (pathname.getName().endsWith(".flv") && pathname.getName().length() == 5) {
                            pathname.renameTo(new File(pathname.getParentFile().getAbsolutePath() + File.separator + "0" + pathname.getName()));
                        }

                        //0.blv.bdl -- 00.blv.bdl
                        if (pathname.getName().endsWith(".blv.bdl") && pathname.getName().length() == 9) {
                            pathname.renameTo(new File(pathname.getParentFile().getAbsolutePath() + File.separator + "0" + pathname.getName()));
                        }
                    }

                    //过滤得到视频文件
                    ffs = ff.listFiles(new FileFilter() {

                        public boolean accept(File pathname) {
                            for (int i = 0; i < ff.list().length; i++) {
                                if (pathname.getName().endsWith(".blv") || pathname.getName().endsWith(".flv") || pathname.getName().endsWith(".blv.bdl")) {
                                    return true;
                                }
                            }
                            return false;
                        }
                    });

                    //输出路径
                    episode_path = out.getAbsolutePath() + File.separator + names[0];
                    File episode = new File(episode_path);
                    if (!episode.exists()) {
                        episode.mkdirs();
                    }

                    //合并
                    System.out.println("开始合并" + episode_path);
                    FlvMerge mFlvMerge = new FlvMerge();
                    try {
                        mFlvMerge.merge(ffs, new File(episode_path + File.separator + names[1] + ".flv"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public String nameMatch(String str) {
        String[] fbsArr = {"\\", "<", ">", "/", "\"", "[", "]", "?", "^", "*", "|"};
        for (String key : fbsArr) {
            if (str.contains(key)) {
                str = str.replace(key, "-");
            }
        }
        return str;
    }

}
