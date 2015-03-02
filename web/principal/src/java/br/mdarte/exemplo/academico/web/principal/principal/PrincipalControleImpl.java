
// license-header java merge-point
package br.mdarte.exemplo.academico.web.principal.principal;
import br.mdarte.exemplo.academico.util.Constantes;
import org.andromda.presentation.bpm4struts.ViewContainer;
import br.mdarte.exemplo.academico.util.PaginationStrategy;

/**
 * @see br.mdarte.exemplo.academico.web.principal.principal.PrincipalControle
 */
public class PrincipalControleImpl extends PrincipalControle
{
    /**
     * @see br.mdarte.exemplo.academico.web.principal.principal.PrincipalControle#carregaDados(br.mdarte.exemplo.academico.web.principal.principal.CarregaDadosForm)
     */
    public final void carregaDados(br.mdarte.exemplo.academico.web.principal.principal.CarregaDadosForm form, ViewContainer container) throws Exception {
    	/*Caso seja necessario usar paginacao		
    		Integer pagina = ((Double)container.getAttribute(Constantes.PARAMETRO_PAGINA)).intValue();
			br.mdarte.exemplo.academico.util.PaginationDisplaytag paginacao = new br.mdarte.exemplo.academico.util.PaginationDisplaytag(pagina);
		*/	
        // nothing to be done for this operation, there are no properties that can be set
    }

}
