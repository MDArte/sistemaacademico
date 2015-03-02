
<%@ include file="/taglib-imports.jspf" %>
<%@ include file="/layout-configuration.jsp" %>

<div id="messages">
    <logic:messagesPresent message="true" property="org.andromda.bpm4struts.successmessages">
        <div class="messages">
            <html:messages id="message" message="true" property="org.andromda.bpm4struts.successmessages">
                <div class="message">${message}</div>
            </html:messages>
        </div>
    </logic:messagesPresent>
</div>

<script>
	function displayWindow(message)
		    {
		        var w, h, l, t;
		        w = 400;
		        h = 250;
		        l = screen.width/4;
		        t = screen.height/4;
			path = "${layoutPath}/";
       		        displayFloatingDiv('windowcontent', 'dimmingContent', message, w, h, l, t, path);
		    }
</script>

<logic:messagesPresent message="true">
		<div style="width: 600; height: 400;visibility:hidden" id="windowcontent">
		<div class="conteudoDimming" id="dimmingContent">	
			
    			<%Exception e = (Exception)request.getSession().getAttribute(org.apache.struts.Globals.EXCEPTION_KEY); 
   	 	          request.getSession().removeAttribute(org.apache.struts.Globals.EXCEPTION_KEY);
    			          if(e != null){
    			             java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
    			          	   java.io.PrintStream ps = new java.io.PrintStream(baos);
    			          	   e.printStackTrace(ps);
    			          	   String stackTrace = baos.toString();
    			          	   request.getSession().getServletContext().getContext("/sistemaacademico").setAttribute("stackTrace", stackTrace);
					 		           %>
					 		          
					<script> 
    					            function stackTrace(){ 
    				                   	window.open('/sistemaacademico/stackTrace.jsp','StackTrace','width=800,height=600,scrollbars=yes');
    				            	    }	
    				        </script>
    				        <div style="text-align:left;">
    				<a href="javascript:stackTrace();void(0);"\>
    				             <bean:message key="error.stack.trace"/></a>
   			</div> 
    				         
            
    			<%}%>
    			
    			<div id="messages">
    				<logic:messagesPresent message="true" property="org.andromda.bpm4struts.errormessages">
        				<div class="errors">
            					<html:messages id="error" message="true" property="org.andromda.bpm4struts.errormessages">
                					<div class="error">${error}</div>
            					</html:messages>
        				</div>
    				</logic:messagesPresent>

    				<logic:messagesPresent message="true" property="org.andromda.bpm4struts.warningmessages">
        				<div class="warnings">
            					<html:messages id="warning" message="true" property="org.andromda.bpm4struts.warningmessages">
                					<div class="warning">${warning}</div>
            					</html:messages>
        				</div>
    				</logic:messagesPresent>
    			</div>
    		</div>
		</div>
		</logic:messagesPresent>
		
		<%
		org.apache.struts.action.ActionMessages messages = 
			(org.apache.struts.action.ActionMessages)request.getSession().getAttribute(org.apache.struts.Globals.MESSAGE_KEY);
        	
        	if(messages != null && (messages.size("org.andromda.bpm4struts.errormessages") != 0 || messages.size("org.andromda.bpm4struts.warningmessages") != 0)){
        		if(messages.size("org.andromda.bpm4struts.errormessages") != 0){
        	%>
        		<script>
        			var message = '<bean:message key="error.message.window"/>';
        		</script>
        	<%
        	}else{
        	%>
    	        	<script>
        			var message = '<bean:message key="warning.message.window"/>';
        		</script>
        	
    	        <%
    	        }
    	        %>
    	        
    	        <script>
		displayWindow(message);
		</script>
		<%}%>