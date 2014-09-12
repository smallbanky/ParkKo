<%-- 
    Document   : index
    Created on : 11 ก.ย. 2557, 18:40:42
    Author     : ratanaporn
--%>
<%@page import="com.tisconet.scrum.payment.PaymentServiceImpl" %>
<%@page import="java.util.Map" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment</title>
    </head>
    <body>
        <% 
        
        
           PaymentServiceImpl service = new PaymentServiceImpl();
           service.setWriter(out);
           
           String payment = request.getParameter("LoanRate");
           
           String receive = request.getParameter("LoanAmt");
           
           Double paymentValue = service.getValue(payment);
           
           Double receiveValue = service.getValue(receive);
           
           Double remain = paymentValue - receiveValue;
           
           
           Map<Integer,Integer> results = service.processPayment(remain, PaymentServiceImpl.cards);
           
                  %>
        
        
        
        
        <center>
<br><br>
<form NAME="frmInput">
            <table width="60%" border="0" cellpadding="0">
                <tr >
                  <td colspan="3"><h2><font color="black"> Park-Ko (คำนวณเงินทอน) </font></h2><hr color="green" noshade="true"></td>
                </tr>
                <tr >
                  <td width="150">ค่าจอดรถ</td>
                  <td width="150"><input class="align_right_bold" name="LoanAmt" id="Amount" size="18" style="text-align:right" value="<%=receive%>" onkeypress="return handleEnter(this, event)"/></td>
                </tr>
                <tr >
                  <td>รับเงิน</td>
                  <td ><input class="align_right_bold" name="LoanRate" id="Receive" size="18" style="text-align:right" value="<%=payment%>" onkeypress="return handleEnter(this, event)"/></td>
                 <td></td>
				</tr>
				<tr >
					<td colspan="3" align="center">
					<a href="payment.jsp?LoanAmt=0&LoanRate=0">Clear</a>&nbsp;&nbsp;
					<input type="submit" name="btnCalc" id="btnCalc" value=" Calculate " />
					</td>
				</tr>
                <tr >	
				</tr>
				<td colspan="3" >
				<table style="border: 1px solid black;">
				<tr>
                  <td width="150" id="ChangeAmt">เงินทอน</td>
                  <td width="130"><div id="ChangeAmt" align="right"><%=remain%></div></td> &nbsp;&nbsp;
                </tr>
				<tr >

				<tr>
				  <td></td>
                  <td>ธนบัตร &nbsp;&nbsp; 500</td><td> <%= results.get(500)%>  &nbsp;&nbsp; ใบ</td>
                </tr>
                 <tr>
				  <td></td>
                  <td>ธนบัตร &nbsp;&nbsp; 100</td><td><%= results.get(100)%>  &nbsp;&nbsp; ใบ</td>
                </tr>
				<tr >
				  <td></td>
                  <td>ธนบัตร &nbsp;&nbsp; 50</td><td><%= results.get(50)%>  &nbsp;&nbsp; ใบ</td>
                </tr>
				<tr >
				  <td></td>
                  <td>ธนบัตร &nbsp;&nbsp; 20</td><td><%= results.get(20)%>  &nbsp;&nbsp; ใบ</td>
                </tr> 
				<tr >
				  <td></td>
                  <td>เหรียญ &nbsp;&nbsp; 10</td><td><%= results.get(10)%>  &nbsp;&nbsp; เหรียญ</td>
                </tr>
				<tr >
				  <td></td>
                  <td>เหรียญ &nbsp;&nbsp; 1</td><td><%= results.get(1 )%>  &nbsp;&nbsp; เหรียญ</td>
                </tr>

				
				
				
				</table>
				
				
				</td>
				<tr>
                  <td colspan="3"><br><div id="result" style="border-bottom: 3px solid red; border-top: 1px solid white; border-left: 1px solid white; border-right: 1px solid white; width: 100%;"></div></td>
                </tr>
                <tr>

                  <td colspan="3" align="right">
                    <br><font color="gray">โดย Scrum Group 1 <br></font>
                  </td>
                </tr>  
            </table>
        </form>
</center>

        
        
        
    </body>
</html>
