package org.nuytsm.HibernateDtoDuplicateTableMapping;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nuytsm.HibernateDtoDuplicateTableMapping.springconfig.SpringOrmConfig;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringOrmConfig.class})
@ActiveProfiles(profiles = "LOCAL")
public class OrmTest {

	@Test
	public void seeWetherOrmSucceeds() {
		
	}

}
