// license-header java merge-point
package br.mdarte.exemplo.academico.web.geral.detalharEstudante;

import java.util.Collection;

import org.andromda.presentation.bpm4struts.ViewContainer;

import br.gov.mdarte.controleacesso.util.Util;
import br.mdarte.exemplo.academico.ServiceLocator;
import br.mdarte.exemplo.academico.cd.Estudante;
import br.mdarte.exemplo.academico.cd.EstudanteImpl;

/**
 * @see br.mdarte.exemplo.academico.web.geral.detalharEstudante.DetalhaEstudanteControle
 */
public class DetalhaEstudanteControleImpl extends DetalhaEstudanteControle
{
	/**
	 * @see br.mdarte.exemplo.academico.web.geral.detalharEstudante.DetalhaEstudanteControle#carregaEstudante(br.mdarte.exemplo.academico.web.geral.detalharEstudante.CarregaEstudanteForm)
	 */
	public final void carregaEstudante(br.mdarte.exemplo.academico.web.geral.detalharEstudante.CarregaEstudanteForm form, ViewContainer container) throws Exception
	{
		if(form.getIdEstudante() == null)
		{
			saveErrorMessage("detalha.estudante.estudante.nao.encontrado", container);
			return;
		}
		
		Estudante estudante = new EstudanteImpl();

		estudante.setId(form.getIdEstudante());

		Collection estudantes = ServiceLocator.instance().getEstudanteHandlerBI().selectEstudante(estudante);

		if(!Util.checkEmpty(estudantes))
		{
			estudante = (Estudante) estudantes.iterator().next();
			
			form.setNome(estudante.getNome());
			form.setMatricula(estudante.getMatricula());
			form.setIdEstudante(estudante.getId());
			form.setSobrenome(estudante.getSobrenome());
		}
	}
}
