/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tisconet.scrum.payment;

import java.io.PrintWriter;
import java.io.Writer;
import java.text.DecimalFormat;
//import java.text.I
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author ratanaporn
 */
public class PaymentServiceImpl implements PaymentService{
    public static int[] cards = new int[]{500,100,50,20,10,1};
    private Writer p;
    
    public void setWriter(Writer w){
        this.p  = w;
    }
    
    
    public int getNoOfCardPayment(int input1,Double value){
        int  result = (int) (value/input1);// input1;
        return result;    
    }
    
    public Map<Integer,Integer> processPayment(double value,int[] cards) throws Exception{
         p.write("remain:"+value+"\n");
         p.flush();
        Map<Integer,Integer> map = new LinkedHashMap<Integer,Integer>();
         if (cards!=null && cards.length > 0){
             for(int i=0;i<cards.length;i++){
                 int cardValue = cards[i];
                 int numOfCard = getNoOfCardPayment(cardValue,value);
                 value = value - numOfCard* cardValue;
                 map.put(cardValue,numOfCard);
             };
         };
         return map;
    }
    
    
    public Double getValue(String strValue) throws Exception{
        if (strValue==null ||  strValue.trim().isEmpty()){
            throw new Exception("Not Value");
        };
        if (strValue.indexOf(".")!=-1){
            throw new Exception("point error");
        };
        NumberFormat nFormat = new DecimalFormat("#0");
        Number nValue = nFormat.parse(strValue);
        Double dValue = nValue.doubleValue();
        if (dValue < 0 ){
            throw new Exception("Less than Zero");
        };
        return dValue;
//        return dValue;
    }
    
    public static void main(String[] args){
        System.out.println("test");
        try{
            PaymentServiceImpl service = new PaymentServiceImpl();
            service.setWriter(new PrintWriter(System.out));
    //        int x = service.getNoOfCardPayment(500,new Double(1001));

            Map cardResults = service.processPayment(new Double(89), cards);
    //        System.out.println("value:"+x);
            service.printMap(cardResults);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void printMap(Map<Integer,Integer> map) throws Exception{
        Iterator<Integer> iter = map.keySet().iterator();
        while(iter.hasNext()){
            Integer valueCard = iter.next();
            Integer numCard = map.get(valueCard);
            p.write("card:"+valueCard+" num of card:"+numCard+"\n");
            p.flush();
        }
                
    }
    
}
