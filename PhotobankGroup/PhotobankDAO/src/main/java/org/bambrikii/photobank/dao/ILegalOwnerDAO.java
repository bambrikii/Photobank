package org.bambrikii.photobank.dao;

import org.bambrikii.photobank.model.LegalOwner;

public interface ILegalOwnerDAO {

	public abstract LegalOwner getByName(String name);

}