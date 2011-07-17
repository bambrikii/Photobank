<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleServiceSoapProxyid" scope="session" class="com.roboxchange.merchant.WebService.ServiceSoapProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleServiceSoapProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleServiceSoapProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleServiceSoapProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        com.roboxchange.merchant.WebService.ServiceSoap getServiceSoap10mtemp = sampleServiceSoapProxyid.getServiceSoap();
if(getServiceSoap10mtemp == null){
%>
<%=getServiceSoap10mtemp %>
<%
}else{
        if(getServiceSoap10mtemp!= null){
        String tempreturnp11 = getServiceSoap10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String merchantLogin_1id=  request.getParameter("merchantLogin18");
            java.lang.String merchantLogin_1idTemp = null;
        if(!merchantLogin_1id.equals("")){
         merchantLogin_1idTemp  = merchantLogin_1id;
        }
        String language_2id=  request.getParameter("language20");
            java.lang.String language_2idTemp = null;
        if(!language_2id.equals("")){
         language_2idTemp  = language_2id;
        }
        com.roboxchange.merchant.WebService.PaymentMethodsList getPaymentMethods13mtemp = sampleServiceSoapProxyid.getPaymentMethods(merchantLogin_1idTemp,language_2idTemp);
if(getPaymentMethods13mtemp == null){
%>
<%=getPaymentMethods13mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">methods:</TD>
<TD>
<%
if(getPaymentMethods13mtemp != null){
com.roboxchange.merchant.WebService.Method[] typemethods16 = getPaymentMethods13mtemp.getMethods();
        String tempmethods16 = null;
        if(typemethods16 != null){
        java.util.List listmethods16= java.util.Arrays.asList(typemethods16);
        tempmethods16 = listmethods16.toString();
        }
        %>
        <%=tempmethods16%>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 22:
        gotMethod = true;
        String merchantLogin_3id=  request.getParameter("merchantLogin27");
            java.lang.String merchantLogin_3idTemp = null;
        if(!merchantLogin_3id.equals("")){
         merchantLogin_3idTemp  = merchantLogin_3id;
        }
        String language_4id=  request.getParameter("language29");
            java.lang.String language_4idTemp = null;
        if(!language_4id.equals("")){
         language_4idTemp  = language_4id;
        }
        com.roboxchange.merchant.WebService.CurrenciesList getCurrencies22mtemp = sampleServiceSoapProxyid.getCurrencies(merchantLogin_3idTemp,language_4idTemp);
if(getCurrencies22mtemp == null){
%>
<%=getCurrencies22mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">groups:</TD>
<TD>
<%
if(getCurrencies22mtemp != null){
com.roboxchange.merchant.WebService.PaymentMethodGroup[] typegroups25 = getCurrencies22mtemp.getGroups();
        String tempgroups25 = null;
        if(typegroups25 != null){
        java.util.List listgroups25= java.util.Arrays.asList(typegroups25);
        tempgroups25 = listgroups25.toString();
        }
        %>
        <%=tempgroups25%>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 31:
        gotMethod = true;
        String merchantLogin_5id=  request.getParameter("merchantLogin36");
            java.lang.String merchantLogin_5idTemp = null;
        if(!merchantLogin_5id.equals("")){
         merchantLogin_5idTemp  = merchantLogin_5id;
        }
        String incCurrLabel_6id=  request.getParameter("incCurrLabel38");
            java.lang.String incCurrLabel_6idTemp = null;
        if(!incCurrLabel_6id.equals("")){
         incCurrLabel_6idTemp  = incCurrLabel_6id;
        }
        String outSum_7id=  request.getParameter("outSum40");
            java.math.BigDecimal outSum_7idTemp = null;
        if(!outSum_7id.equals("")){
         outSum_7idTemp  = new java.math.BigDecimal(outSum_7id);
        }
        String language_8id=  request.getParameter("language42");
            java.lang.String language_8idTemp = null;
        if(!language_8id.equals("")){
         language_8idTemp  = language_8id;
        }
        com.roboxchange.merchant.WebService.RatesList getRates31mtemp = sampleServiceSoapProxyid.getRates(merchantLogin_5idTemp,incCurrLabel_6idTemp,outSum_7idTemp,language_8idTemp);
if(getRates31mtemp == null){
%>
<%=getRates31mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">groups:</TD>
<TD>
<%
if(getRates31mtemp != null){
com.roboxchange.merchant.WebService.PaymentMethodGroup[] typegroups34 = getRates31mtemp.getGroups();
        String tempgroups34 = null;
        if(typegroups34 != null){
        java.util.List listgroups34= java.util.Arrays.asList(typegroups34);
        tempgroups34 = listgroups34.toString();
        }
        %>
        <%=tempgroups34%>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 44:
        gotMethod = true;
        String merchantLogin_9id=  request.getParameter("merchantLogin75");
            java.lang.String merchantLogin_9idTemp = null;
        if(!merchantLogin_9id.equals("")){
         merchantLogin_9idTemp  = merchantLogin_9id;
        }
        String invoiceID_10id=  request.getParameter("invoiceID77");
        int invoiceID_10idTemp  = Integer.parseInt(invoiceID_10id);
        String signature_11id=  request.getParameter("signature79");
            java.lang.String signature_11idTemp = null;
        if(!signature_11id.equals("")){
         signature_11idTemp  = signature_11id;
        }
        com.roboxchange.merchant.WebService.OperationStateResponse opState44mtemp = sampleServiceSoapProxyid.opState(merchantLogin_9idTemp,invoiceID_10idTemp,signature_11idTemp);
if(opState44mtemp == null){
%>
<%=opState44mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">state:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">description:</TD>
<TD>
<%
if(opState44mtemp != null){
com.roboxchange.merchant.WebService.OperationState tebece0=opState44mtemp.getState();
if(tebece0 != null){
java.lang.String typedescription49 = tebece0.getDescription();
        String tempResultdescription49 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescription49));
        %>
        <%= tempResultdescription49 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">code:</TD>
<TD>
<%
if(opState44mtemp != null){
com.roboxchange.merchant.WebService.OperationState tebece0=opState44mtemp.getState();
if(tebece0 != null){
%>
<%=tebece0.getCode()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">stateDate:</TD>
<TD>
<%
if(opState44mtemp != null){
com.roboxchange.merchant.WebService.OperationState tebece0=opState44mtemp.getState();
if(tebece0 != null){
java.util.Calendar typestateDate53 = tebece0.getStateDate();
        java.text.DateFormat dateFormatstateDate53 = java.text.DateFormat.getDateInstance();
        java.util.Date datestateDate53 = typestateDate53.getTime();
        String tempResultstateDate53 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatstateDate53.format(datestateDate53));
        %>
        <%= tempResultstateDate53 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">requestDate:</TD>
<TD>
<%
if(opState44mtemp != null){
com.roboxchange.merchant.WebService.OperationState tebece0=opState44mtemp.getState();
if(tebece0 != null){
java.util.Calendar typerequestDate55 = tebece0.getRequestDate();
        java.text.DateFormat dateFormatrequestDate55 = java.text.DateFormat.getDateInstance();
        java.util.Date daterequestDate55 = typerequestDate55.getTime();
        String tempResultrequestDate55 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatrequestDate55.format(daterequestDate55));
        %>
        <%= tempResultrequestDate55 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">info:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">paymentMethod:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="0" ALIGN="LEFT">description:</TD>
<TD>
<%
if(opState44mtemp != null){
com.roboxchange.merchant.WebService.OperationInfo tebece0=opState44mtemp.getInfo();
if(tebece0 != null){
com.roboxchange.merchant.WebService.OperationPaymentMethod tebece1=tebece0.getPaymentMethod();
if(tebece1 != null){
java.lang.String typedescription61 = tebece1.getDescription();
        String tempResultdescription61 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescription61));
        %>
        <%= tempResultdescription61 %>
        <%
}}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="0" ALIGN="LEFT">code:</TD>
<TD>
<%
if(opState44mtemp != null){
com.roboxchange.merchant.WebService.OperationInfo tebece0=opState44mtemp.getInfo();
if(tebece0 != null){
com.roboxchange.merchant.WebService.OperationPaymentMethod tebece1=tebece0.getPaymentMethod();
if(tebece1 != null){
java.lang.String typecode63 = tebece1.getCode();
        String tempResultcode63 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typecode63));
        %>
        <%= tempResultcode63 %>
        <%
}}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">incAccount:</TD>
<TD>
<%
if(opState44mtemp != null){
com.roboxchange.merchant.WebService.OperationInfo tebece0=opState44mtemp.getInfo();
if(tebece0 != null){
java.lang.String typeincAccount65 = tebece0.getIncAccount();
        String tempResultincAccount65 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeincAccount65));
        %>
        <%= tempResultincAccount65 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">outSum:</TD>
<TD>
<%
if(opState44mtemp != null){
com.roboxchange.merchant.WebService.OperationInfo tebece0=opState44mtemp.getInfo();
if(tebece0 != null){
java.math.BigDecimal typeoutSum67 = tebece0.getOutSum();
        String tempResultoutSum67 = org.eclipse.jst.ws.util.JspUtils.markup(typeoutSum67.toString());
        %>
        <%= tempResultoutSum67 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">outCurrLabel:</TD>
<TD>
<%
if(opState44mtemp != null){
com.roboxchange.merchant.WebService.OperationInfo tebece0=opState44mtemp.getInfo();
if(tebece0 != null){
java.lang.String typeoutCurrLabel69 = tebece0.getOutCurrLabel();
        String tempResultoutCurrLabel69 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeoutCurrLabel69));
        %>
        <%= tempResultoutCurrLabel69 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">incSum:</TD>
<TD>
<%
if(opState44mtemp != null){
com.roboxchange.merchant.WebService.OperationInfo tebece0=opState44mtemp.getInfo();
if(tebece0 != null){
java.math.BigDecimal typeincSum71 = tebece0.getIncSum();
        String tempResultincSum71 = org.eclipse.jst.ws.util.JspUtils.markup(typeincSum71.toString());
        %>
        <%= tempResultincSum71 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">incCurrLabel:</TD>
<TD>
<%
if(opState44mtemp != null){
com.roboxchange.merchant.WebService.OperationInfo tebece0=opState44mtemp.getInfo();
if(tebece0 != null){
java.lang.String typeincCurrLabel73 = tebece0.getIncCurrLabel();
        String tempResultincCurrLabel73 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeincCurrLabel73));
        %>
        <%= tempResultincCurrLabel73 %>
        <%
}}%>
</TD>
</TABLE>
<%
}
break;
}
} catch (Exception e) { 
%>
exception: <%= e %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>