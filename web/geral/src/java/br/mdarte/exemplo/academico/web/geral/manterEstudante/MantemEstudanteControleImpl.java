package br.mdarte.exemplo.academico.web.geral.manterEstudante;

import java.util.Collection;

import br.gov.mdarte.controleacesso.util.Util;
import br.mdarte.exemplo.academico.ServiceLocator;
import br.mdarte.exemplo.academico.cd.Estudante;
import br.mdarte.exemplo.academico.cd.EstudanteImpl;
import br.mdarte.exemplo.academico.util.Constantes;
import br.mdarte.exemplo.academico.vo.EstudanteVO;

import org.andromda.presentation.bpm4struts.ViewContainer;

/**
 * @see br.mdarte.exemplo.academico.web.geral.manterEstudante
 *      .MantemEstudanteControle
 */
public class MantemEstudanteControleImpl extends MantemEstudanteControle
{
	/**
	 * @see br.mdarte.exemplo.academico.web.geral
	 *      .manterEstudante.MantemEstudanteControle
	 *      #carregaEstudante(br.mdarte.exemplo.academico.web.geral.manterEstudante
	 *      .CarregaEstudanteForm)
	 */
	public final void carregaEstudante(br.mdarte.exemplo.academico.web.geral.manterEstudante.CarregaEstudanteForm form, ViewContainer container) throws Exception
	{
		if(form.getIdEstudante() != null)
		{
			Estudante estudante = new EstudanteImpl();

			estudante.setId(form.getIdEstudante());

			Collection estudantes = ServiceLocator.instance().getEstudanteHandlerBI().selectEstudante(estudante);

			if(!Util.checkEmpty(estudantes))
			{
				estudante = (Estudante) estudantes.iterator().next();

				form.setNome(estudante.getNome());
				form.setMatricula(estudante.getMatricula());
				form.setIdEstudante(estudante.getId());
			}
			else
			{
				saveErrorMessage("mantem.estudante.estudante.nao.encontrado", container);
			}
		}
	}

	/**
	 * @see br.mdarte.exemplo.academico.web.geral
	 *      .manterEstudante.MantemEstudanteControle
	 *      #salvaEstudante(br.mdarte.exemplo.academico
	 *      .web.geral.manterEstudante .SalvaEstudanteForm)
	 */
	public final void salvaEstudante(br.mdarte.exemplo.academico.web.geral.manterEstudante.SalvaEstudanteForm form, ViewContainer container) throws Exception
	{
		EstudanteVO estudanteVO = new EstudanteVO();
		
		if(form.getIdEstudante() != null)
			estudanteVO.setIdEstudante(form.getIdEstudante());
		
		if(form.getNome() != null)
			estudanteVO.setNome(form.getNome());

		if(form.getMatricula() != null)
			estudanteVO.setMatricula(form.getMatricula());
		
		Estudante estudante = ServiceLocator.instance().getEstudanteHandlerBI().mantemEstudante(estudanteVO);
		
		if(estudante != null)
		{
			form.setIdEstudante(estudante.getId());
			
			saveSuccessMessage("mantem.estudante.estudante.estudante.salvo", container);
		}
	}
}