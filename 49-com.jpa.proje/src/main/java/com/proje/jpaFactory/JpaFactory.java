package com.proje.jpaFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * @author MetinKalinsaz
 */

public interface JpaFactory {

	EntityManager getEntityManager();
	
	EntityTransaction getEntityTransaction();
	
}
