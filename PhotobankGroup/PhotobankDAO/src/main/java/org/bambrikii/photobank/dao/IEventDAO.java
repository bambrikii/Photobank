package org.bambrikii.photobank.dao;

import java.util.List;

import org.bambrikii.photobank.model.Category;
import org.bambrikii.photobank.model.Event;

public interface IEventDAO {

	public abstract List<Event> getEvents(Category parentCategory,
			String order, int start, int length);

	public abstract int getEventCount(Category parentCategory);

}