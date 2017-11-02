package com.dzcl.task01;


import java.util.ArrayList;
import java.util.List;


public class CountModule {

    private List<String> list1 ;

    private List<String> list2 ;


    public CountModule(List<String> list1,List<String> list2) {
        this.list1 = list1;
        this.list2 = list2;
    }

    public  List<String> getMax(){
       List<String> max = new ArrayList<>();
       try {
           for (int i = 1; i < list2.size() - 1; i++) {
               if ((Double.valueOf(list2.get(i)) > Double.valueOf(list2.get(i - 1))) &&
                       (Double.valueOf(list2.get(i)) > Double.valueOf(list2.get(i + 1))))
               {
                   max.add(list2.get(i));
               }
           }
       }catch (Exception e){
           e.printStackTrace();
       }
            return max;
    }

    public  List<String> getMin(){
        List<String> min = new ArrayList<>();
        try{
        for(int i = 1;i < list2.size() - 1;i++){
            if((Double.valueOf(list2.get(i))<Double.valueOf(list2.get(i-1)))&&
                    (Double.valueOf(list2.get(i))<Double.valueOf(list2.get(i+1))))
            {
                min.add(list2.get(i));
            }
        }
        }catch (Exception e){
            e.printStackTrace();
        }
        return min;

    }

public  List<String> getMaxAndMin(){
    List<String> mam = new ArrayList<>();
    List<String> max = getMax();
    List<String> min = getMin();
    double ave = getAverageValue();
    int t = Math.min(max.size(),min.size());
    for (int i = 0;i < t;i++) {
         if(Double.valueOf(max.get(i)) - Double.valueOf(min.get(i)) > Math.abs(ave/10)){
             mam.add(max.get(i));
             mam.add(min.get(i));
         }
    }
        return mam;
}

    public double getAverageValue() {
    double sum = 0;
        for (int i = 1; i < list2.size() - 1; i++)
            sum += Double.valueOf(list2.get(i));
        return sum/list2.size();
    }

    public static void main(String[] args) {
       FileTest test = new FileTest();
       CountModule test2 = new CountModule(test.getListx(),test.getListy());
       System.out.println(test2.getMaxAndMin());
       System.out.println(test2.getAverageValue());

   }
}
