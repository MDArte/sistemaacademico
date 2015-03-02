
// license-header java merge-point
package br.mdarte.exemplo.academico.web.geral.consultarCurso;
import java.util.Collection;

import br.mdarte.exemplo.academico.util.Constantes;

import org.andromda.presentation.bpm4struts.ViewContainer;

import br.mdarte.exemplo.academico.util.PaginationStrategy;

/**
 * @see br.mdarte.exemplo.academico.web.geral.consultarCurso.ConsultaCursoControle
 */
public class ConsultaCursoControleImpl extends ConsultaCursoControle
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 5610549811142961010L;

	/**
     * @see br.mdarte.exemplo.academico.web.geral.consultarCurso.ConsultaCursoControle#consultaCurso(br.mdarte.exemplo.academico.web.geral.consultarCurso.ConsultaCursoForm)
     */
    public final void consultaCurso(br.mdarte.exemplo.academico.web.geral.consultarCurso.ConsultaCursoForm form, ViewContainer container) throws Exception {
    	/*Caso seja necessario usar paginacao		
    		Integer pagina = ((Double)container.getAttribute(Constantes.PARAMETRO_PAGINA)).intValue();
			br.mdarte.exemplo.academico.util.PaginationDisplaytag paginacao = new br.mdarte.exemplo.academico.util.PaginationDisplaytag(pagina);
		*/	
        // nothing to be done for this operation, there are no properties that can be set
    }

	@Override
	protected Integer getResultadoConsultaCursosTableLength(PaginationStrategy paginacao, String propriedade, Boolean desc, String codigo, String nome, ViewContainer container) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Collection loadResultadoConsultaCursosTable(PaginationStrategy paginacao, String propriedade, Boolean desc, String codigo, String nome, ViewContainer container) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

}
