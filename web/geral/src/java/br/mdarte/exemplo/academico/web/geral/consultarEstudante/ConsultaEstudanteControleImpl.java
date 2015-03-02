// license-header java merge-point
package br.mdarte.exemplo.academico.web.geral.consultarEstudante;

import java.util.ArrayList;
import java.util.Collection;

import org.andromda.presentation.bpm4struts.ViewContainer;

import br.mdarte.exemplo.academico.ServiceLocator;
import br.mdarte.exemplo.academico.action.DefaultFilterAction;
import br.mdarte.exemplo.academico.cd.Estudante;
import br.mdarte.exemplo.academico.cd.EstudanteImpl;
import br.mdarte.exemplo.academico.to.EstudanteTO;
import br.mdarte.exemplo.academico.to.EstudanteTOImpl;
import br.mdarte.exemplo.academico.util.PaginationStrategy;
import br.mdarte.exemplo.academico.util.Util;
import br.mdarte.exemplo.academico.vo.EstudanteVO;

/**
 * @see br.mdarte.exemplo.academico.web.geral.consultarEstudante.ConsultaEstudanteControle
 */
public class ConsultaEstudanteControleImpl extends ConsultaEstudanteControle
{
	/**
	 * @see br.mdarte.exemplo.academico.web.geral.consultarEstudante.ConsultaEstudanteControle#consultaEstudante(br.mdarte.exemplo.academico.web.geral.consultarEstudante.ConsultaEstudanteForm)
	 */
	public final void consultaEstudante(br.mdarte.exemplo.academico.web.geral.consultarEstudante.ConsultaEstudanteForm form, ViewContainer container) throws Exception
	{
		
	}

	@Override
	protected Integer getResultadoConsultaEstudantesTableLength(PaginationStrategy paginacao, String propriedade, Boolean desc, String matricula, String nome, ViewContainer container) throws Exception
	{
		EstudanteTO estudanteTO = new EstudanteTOImpl();

		if (Util.checkEmpty(nome))
			estudanteTO.setNome(nome);
		if (Util.checkEmpty(matricula))
			estudanteTO.setMatricula(matricula);

		Collection estudantes = ServiceLocator.instance().getEstudanteHandlerBI().manipulaEstudante(new EstudanteImpl(), new DefaultFilterAction(estudanteTO, null));
		
		return estudantes.size();
	}

	@Override
	protected Collection loadResultadoConsultaEstudantesTable(PaginationStrategy paginacao, String propriedade, Boolean desc, String matricula, String nome, ViewContainer container) throws Exception
	{	
		//TODO: Bug Fix
		paginacao.setPaginas(1);
		
		EstudanteTO estudanteTO = new EstudanteTOImpl();

		if (!Util.checkEmpty(nome))
			estudanteTO.setNome(nome);
		if (!Util.checkEmpty(matricula))
			estudanteTO.setMatricula(matricula);

		Collection estudantes = ServiceLocator.instance().getEstudanteHandlerBI().manipulaEstudante(new EstudanteImpl(), new DefaultFilterAction(estudanteTO, paginacao));

		ArrayList<EstudanteVO> estudanteVOs = new ArrayList<EstudanteVO>();

		if(!Util.checkEmpty(estudantes))
		{
			for(Estudante estudante:(Collection<Estudante>) estudantes)
			{
				EstudanteVO estudanteVO = new EstudanteVO();
				
				estudanteVO.setNome(estudante.getNome());
				estudanteVO.setIdEstudante(estudante.getId());
				estudanteVO.setMatricula(estudante.getMatricula());
				
				estudanteVOs.add(estudanteVO);
			}
		}
		
		return estudanteVOs;
	}
}
