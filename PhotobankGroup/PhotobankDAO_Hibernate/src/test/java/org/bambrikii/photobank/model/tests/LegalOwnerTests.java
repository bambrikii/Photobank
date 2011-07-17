package org.bambrikii.photobank.model.tests;

import java.util.List;

import org.bambrikii.photobank.dao.LegalOwnerDAO;
import org.bambrikii.photobank.model.LegalOwner;
import org.bambrikii.photobank.tests.core.DAOTestBase;
import org.junit.Assert;
import org.junit.Test;

public class LegalOwnerTests extends DAOTestBase<LegalOwnerDAO> {
	@Test
	public void listOwners() {
		List<LegalOwner> list = dao.getList();
		for (LegalOwner lo : list) {
			System.out.printf(" %s, %s, %s, %s, %s\n", lo.getId(),
					lo.getName(), lo.getIptcMarker1(), lo.getIptcMarker2(),
					lo.getIptcMarker2Name());
		}
		Assert.assertTrue(
				"There should be more than 0 elements in legalOwner total list!",
				list.size() > 0);
	}
}
