<%@ page session="false" %>

<%
pageContext.setAttribute("layout",
org.andromda.presentation.bpm4struts.LayoutConfiguration.instance().getLayoutConfiguration());
%>

<!-- 
Adicionar css usando o seguinte formato:
<link rel="stylesheet" type="text/css" media="screen" href="/contexto/layout/${layout}/<nome_arquivo>.css"/>"></link>
-->

<link rel="stylesheet" type="text/css" media="screen" href="/sistemaacademico/layout/${layout}/dimming/dimming.css"></link>
<link rel="stylesheet" type="text/css" media="screen" href="/sistemaacademico/layout/${layout}/css/bootstrap.css"></link>
<link rel="stylesheet" type="text/css" media="screen" href="/sistemaacademico/layout/${layout}/css/style-default.css"></link>
<link rel="stylesheet" type="text/css" media="screen" href="/sistemaacademico/layout/${layout}/css/datepicker.css"></link>
<link rel="stylesheet" type="text/css" media="screen" href="/sistemaacademico/layout/${layout}/css/jtable.min.css"></link>
<link rel="stylesheet" type="text/css" media="screen" href="/sistemaacademico/layout/${layout}/css/jquery-ui-1.10.3.custom.css"></link>
<link rel="stylesheet" type="text/css" media="screen" href="/sistemaacademico/layout/${layout}/css/jquery-ui-1.10.3.theme.css"></link>
<link rel="stylesheet" type="text/css" media="screen" href="/sistemaacademico/layout/${layout}/css/jquery-ui-1.10.3.ie.css"></link>
