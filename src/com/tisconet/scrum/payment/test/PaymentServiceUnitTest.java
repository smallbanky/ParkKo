/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tisconet.scrum.payment.test;

import com.tisconet.scrum.payment.PaymentServiceImpl;
import java.io.PrintWriter;
import java.util.Map;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author ratanaporn
 */
public class PaymentServiceUnitTest {
    
    private PaymentServiceImpl s ;
    
    public PaymentServiceUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        s = new PaymentServiceImpl();
        s.setWriter(new PrintWriter(System.out));
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void remain89(){
         try{
            doTest(new Double(89),new int[]{0,0,1,1,1,9});
         }catch(Exception ex){
            ex.printStackTrace();
            fail("exception");
//            throw ex;
        
         }
    }
    
    @Test
    public void remain101(){
         try{
             Double d = new Double(1);
            
            doTest(new Double(101),new int[]{0,1,0,0,0,1});
         }catch(Exception ex){
            ex.printStackTrace();
            fail("exception");
//            throw ex;
        
         }
    }
  
      @Test
    public void strValue(){
         try{
             String s100 = "a100";
            Double d100 = s.getValue(s100);
            assertEquals("100 is positive",d100,new Double(s100));
            fail("exception");
         }catch(Exception ex){
//            ex.printStackTrace();
            assertTrue(true);
//            throw ex;
        
         }
    }
    
        @Test
    public void symbolValue(){
         try{
             String s100 = "1,000";
            Double d100 = s.getValue(s100);
            assertEquals("100 is positive",d100,new Double(s100));
            fail("exception");
         }catch(Exception ex){
//            ex.printStackTrace();
            assertTrue(true);
//            throw ex;
        
         }
    }
    
          @Test
    public void pointValue(){
         try{
             String s100 = "100.00";
            Double d100 = s.getValue(s100);
            assertEquals("100 is positive",d100,new Double(s100));
            fail("exception");
         }catch(Exception ex){
//            ex.printStackTrace();
            assertTrue(true);
//            throw ex;
        
         }
    }
        
    @Test
    public void negativeValue(){
         try{
             String s100 = "-100";
            Double d100 = s.getValue(s100);
            assertEquals("100 is positive",d100,new Double(s100));
            fail("exception");
         }catch(Exception ex){
//            ex.printStackTrace();
            assertTrue(true);
//            throw ex;
        
         }
    }
         
    @Test
    public void positiveValue(){
         try{
             String s100 = "100";
            Double d100 = s.getValue("100");
            assertEquals("100 is positive",d100,new Double(s100));
         }catch(Exception ex){
            ex.printStackTrace();
            fail("exception");
//            throw ex;
        
         }
         
    }
    
    public void doTest(Double remain,int[] numCards)throws Exception{
        try{
            Map<Integer,Integer> results = s.processPayment(remain, s.cards);
            s.printMap(results);
            assertEquals("500-Card: is "+numCards[0]+" cards",new Double(results.get(500)),new Double( numCards[0]));
            assertEquals("100-Card: is "+numCards[1]+" cards",new Double(results.get(100)),new Double( numCards[1]));
            assertEquals("50-Card: is "+numCards[2]+" cards",new Double(results.get(50)),new Double( numCards[2]));
            assertEquals("20-Card: is "+numCards[3]+" cards",new Double(results.get(20)),new Double( numCards[3]));
            assertEquals("10-Card: is "+numCards[4]+" cards",new Double(results.get(10)),new Double( numCards[4]));
            assertEquals("1-Card: is "+numCards[5]+" cards",new Double(results.get(1)),new Double( numCards[5]));
        }catch(Exception ex){
            ex.printStackTrace();
            throw ex;
        }
    }
}
