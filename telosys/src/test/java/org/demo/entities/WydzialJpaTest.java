/*
 * Created on 2023-01-03 ( 08:34:11 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 4.0.0
 */
package org.demo.entities;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

import org.demo.jpa.tools.JpaTest;
import org.junit.Test;

public class WydzialJpaTest extends JpaTest {
	
    @Override
    public void initData() {
		// DatabaseData.init(em) has been called before
		// Initialize here other data required for the current test
    }
	
    private Wydzial createEntity() {
    	Wydzial entity = new Wydzial();
		entity.setNazwaWydzialu( "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB" ) ;
    	return entity;
    }

    private Object getEntityKey(Wydzial entity) {
    	return entity.getNazwaWydzialu();
    }

    @Test
    public void testPersistFindRemove() {
    	
    	Wydzial entity = createEntity();
    	Object key = getEntityKey(entity);

    	// if entity doesn't exist yet
    	if ( find(Wydzial.class, key) == null ) {

	    	// Create with 'persist'
    		persistAndRefresh(entity);
    	
			// Find
			Wydzial entity2 = find(Wydzial.class, key);
			assertNotNull(entity2);
        
			// Remove
			remove(entity2);
			assertNull(find(Wydzial.class, key));
		}
    }
    
    @Test
    public void testMergeFindRemove() {
    	
    	Wydzial entity = createEntity();
    	Object key = getEntityKey(entity);

    	// Create or update with 'merge'
    	mergeAndRefresh(entity);
    	
    	// Find
    	Wydzial entity2 = find(Wydzial.class, key);
        assertNotNull(entity2);
        
    	// Remove
    	remove(entity2);
        assertNull(find(Wydzial.class, key));
    }

}
