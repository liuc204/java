package com.example.springboot.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.Map;

public class GetJsonInfo {

    public static void main(String[] args) throws Exception {
        String vms = "monitor-sh=virtualization-agent-sh=network-proxy-sh=network-proxy-sh-ansible=kafka1-sh=kafka2-sh=kafka3-sh";
        File file = new File("/Users/lc/workspace/java/springboot/src/main/java/com/example/springboot/json/tmp.json");
        String info = toJson(file);
        getJsonInfo(info, vms);
    }

    public static void getJsonInfo(String info, String vms) {

        JSONObject json = JSONObject.parseObject(info);
        JSONObject jsonObject = JSONObject.parseObject(json.get("result").toString());
        JSONArray jsonArray = JSON.parseArray(jsonObject.get("list").toString());
        System.out.println(jsonArray);
        System.out.println(jsonArray.size());

        Integer totalCpu = 0;
        Integer totalRam = 0;
        Integer totalDataDisk = 0;
        Integer totalSystemDisk = 0;
        Integer num = 0;

        for (Object obj: jsonArray) {
            JSONObject object = JSON.parseObject(obj.toString());
            if (vms.contains(object.get("service_name").toString())){
                continue;
            }
            num++;
            JSONObject image = JSON.parseObject(object.get("image").toString());
            JSONObject dataDisk = JSON.parseObject(object.get("data_disk").toString());
            JSONObject systemDisk = JSON.parseObject(object.get("system_disk").toString());
            JSONObject flavor = JSON.parseObject(object.get("flavor").toString());

            totalCpu += Integer.valueOf(flavor.get("cpu").toString());
            totalRam += Integer.valueOf(flavor.get("ram").toString());
            Integer disk = Integer.valueOf(dataDisk.get("size").toString()) * Integer.valueOf(dataDisk.get("count").toString());
            totalDataDisk += disk;
            totalSystemDisk += Integer.valueOf(systemDisk.get("size").toString());

            System.out.println("分布式服务名：" + object.get("service_name").toString() + " ===创建时间：" +  object.get("created_at") + " ===状态：" + object.get("status").toString() + " ===镜像名：" + image.get("name") + " ===cpu：" + flavor.get("cpu") + "C，===内存：" + flavor.get("ram") + "MB，===数据盘：" + disk + "G，===系统盘：" + Integer.valueOf(systemDisk.get("size").toString()) + "G");
        }
        System.out.println("共有" + num + "台虚机。" + " cpu累计为：" + totalCpu + "C,  内存累计为：" + totalRam + " MB,  数据盘累计为：" + totalDataDisk + " GB,  系统盘累计为：" + totalSystemDisk + " GB");

    }

    public static String toJson(File file) throws Exception {
        FileReader fileReader = new FileReader(file);
        Reader reader = new InputStreamReader(new FileInputStream(file), "UTF-8");
        int ch = 0;
        StringBuffer sb = new StringBuffer();
        while ((ch = reader.read()) != -1){
            sb.append((char)ch);
        }
        fileReader.close();
        reader.close();

        String json = sb.toString();
        return json;
    }

}
