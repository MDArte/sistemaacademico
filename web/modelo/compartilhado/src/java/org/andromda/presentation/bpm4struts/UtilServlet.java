package org.andromda.presentation.bpm4struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.mdarte.exemplo.academico.UtilServiceHandlerBI;


public class UtilServlet extends javax.servlet.http.HttpServlet
{
	public void doGet(
        final javax.servlet.http.HttpServletRequest request,
        final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException
    {

        doPost(request, response);
    }

    public void doPost(
        final javax.servlet.http.HttpServletRequest request,
        final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException{
        
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        
        if(request.getRequestURL().toString().contains("clearSecondCache")){
        	clearSecondCache(request, response);
        }

		if(request.getRequestURL().toString().contains("reloadAccessControl")){
        	reloadAccessControl(request, response);
        }

        response.sendRedirect("/sistemaacademico");
        
    }

	private void clearSecondCache(HttpServletRequest request, HttpServletResponse response) {
/*
		try {
			UtilServiceHandlerBI utilReloadAcessControl = br.ufrj.coppetec.ServiceLocator.instance().getServiceBI(UtilServiceHandlerBI.class);
			utilReloadAcessControl.clearSecondCache();
		} catch (Exception e) {
			e.printStackTrace();
		}
*/
	}

	private void reloadAccessControl(HttpServletRequest request, HttpServletResponse response) {
		try {
			UtilServiceHandlerBI utilReloadAcessControl = br.ufrj.coppetec.ServiceLocator.instance().getServiceBI(UtilServiceHandlerBI.class);
			utilReloadAcessControl.reloadAccessControl();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}