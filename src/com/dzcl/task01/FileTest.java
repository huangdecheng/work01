package com.dzcl.task01;

import java.io.*;
import java.util.*;

public class FileTest {

    private String filepath = "D:\\资料\\DATA\\b7.txt";

    private List<String> listx ;

    private List<String> listy ;

    public List<String> getListx() {
        return listx;
    }

    public void setListx(List<String> listx) {
        this.listx = listx;
    }

    public List<String> getListy() {
        return listy;
    }

    public void setListy(List<String> listy) {
        this.listy = listy;
    }

    public  FileTest(){
        File file = new File(filepath);
        listx = new ArrayList<>();
        listy = new ArrayList<>();
        if(file.exists()&&file.isFile()&&file.length()!=0){
        try{
            FileInputStream fr = new FileInputStream(file);
            BufferedReader bufr = new BufferedReader(new InputStreamReader(fr,"UTF-8"));
            String s;
            while (!(s = bufr.readLine()).equals("Time/sec, Current/A, Charge/C")){

            }
            s = bufr.readLine();
            while((s = bufr.readLine()) != null){
                int t = s.lastIndexOf(",");
                 listx.add(s.substring(0,8));
                 listy.add(s.substring(9,t));
            }
            bufr.close();
            fr.close();
        }catch(Exception e){
            e.printStackTrace();
            }
    }else{
            return ;
        }
    }



    public static void main(String[] args) {
        FileTest test = new FileTest();
        System.out.println(test.getListy());
    }
}

