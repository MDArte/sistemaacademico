// license-header java merge-point
/**
 * Generated by: HibernateEntityFactoryImpl.vsl in andromda-hibernate-cartridge.
 */
package br.mdarte.exemplo.academico.cd;

/**
 * <p>
 * Factory class.
 * Is able to find and create objects of type Estudante.
 * The Hibernate <em>subclass</em> inheritance
 * strategy is followed.
 * Those can be described as follows:
 * </p>
 * @see br.mdarte.exemplo.academico.cd.Estudante
 */
import br.mdarte.exemplo.academico.cd.DAOException;
import br.ufrj.coppetec.DataObject;

public class EstudanteDAOImpl extends EstudanteDAO {

    protected Object handleFilter(DataObject vo) throws br.mdarte.exemplo.academico.cd.DAOException {
		return null;
	}
    
    protected org.hibernate.Criteria handleXmlExport(br.ufrj.coppetec.ValueObject vo, org.hibernate.Session session) throws br.mdarte.exemplo.academico.cd.DAOException {
		return null;
    }

}
