package com.lv.util;

import java.util.*;
/**
 * Created by simperLv
 * on 2018/08/19 16:09
 *
 * @Description //TODO
 */
public class StreamDemo {
    static String raw = "百度,李彦宏,100\r\n腾讯,马化腾,300\r\n小公司,,30";
    public static void main(String[] args){
       Arrays.asList(raw.split("\r\n")).stream()
               .map(p -> {
                   String[] filed = p.split(",");
                   if (filed.length ==  3){
                       Company company = new Company(filed[0],filed[1],Integer.parseInt(filed[2]));
                       return company;
                   }
                   return new Company();
               })
               .filter(p -> !"".equals(p.name) && !"".equals(p.ceo) && 0 != p.capital)
               .sorted(Comparator.comparing(Company :: getCapital))
               .forEach(p-> System.out.println(p.getName() + p.getCeo() + p.getCapital()));
    }
    static class Company{
        String name,ceo;
        int capital;
        public Company(){
        }
        public Company(String name,String ceo,int capital){
            this.name = name;
            this.ceo = ceo;
            this.capital = capital;
        }
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCeo() {
            return ceo;
        }

        public void setCeo(String ceo) {
            this.ceo = ceo;
        }

        public int getCapital() {
            return capital;
        }

        public void setCapital(int capital) {
            this.capital = capital;
        }
    }
}
