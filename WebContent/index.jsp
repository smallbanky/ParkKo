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
           
           String payment = request.getParameter("payment");
           
           String receive = request.getParameter("rreceive");
           
           Double paymentValue = service.getValue(payment);
           
           Double receiveValue = service.getValue(receive);
           
           Double remain = paymentValue - receiveValue;
           
           
           Map<Integer,Integer> results = service.processPayment(remain, PaymentServiceImpl.cards);
           
           service.printMap(results);
        %>
    </body>
</html>
