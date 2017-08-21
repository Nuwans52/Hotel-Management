/**
 * 
 */
package org.hotel.service;

import java.util.List;

import org.hotel.entity.MHotels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author sandakelums
 *
 */
@Repository
@Transactional(readOnly = true)
public class MHotelsService implements MHotelsDao {

	@Autowired
	private HibernateTemplate template;

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	@Override
	public void save(MHotels mHotels) {
		template.save(mHotels);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MHotels> findAll() {
		List<MHotels> listMhotels = (List<MHotels>) template.find("FROM MHotels");
		return listMhotels;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MHotels> findAllByCity(int ctyId) {
		List<MHotels> listMhotels = (List<MHotels>) template.find("FROM MHotels WHERE MCity = " + ctyId);
		return listMhotels;
	}
}
