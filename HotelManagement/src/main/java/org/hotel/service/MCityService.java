/**
 * 
 */
package org.hotel.service;

import java.util.List;

import org.hotel.entity.MCity;
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
public class MCityService implements MCityDao {

	@Autowired
	HibernateTemplate template;

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	@Override
	public void save(MCity mCity) {
		template.save(mCity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MCity> findAll() {
		List<MCity> listMCity = (List<MCity>) template.find("FROM MCity");
		return listMCity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MCity> findAllByDistrict(int dtrId, String ctyActive) {
		List<MCity> listMCity = (List<MCity>) template
				.find("FROM MCity WHERE RDistrict = " + dtrId + " AND cty_active = '" + ctyActive + "'");
		return listMCity;
	}
}
