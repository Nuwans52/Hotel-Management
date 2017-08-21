/**
 * 
 */
package org.hotel.service;

import java.util.List;

import org.hotel.entity.RDistrict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * @author sandakelums
 *
 */
public class RDistrictService implements RDistrictDao {

	@Autowired
	private HibernateTemplate template;

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	@Override
	public void save(RDistrict rDistrict) {
		template.save(rDistrict);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RDistrict> findAll() {
		List<RDistrict> listRDistrict = (List<RDistrict>) template.find("FROM RDistrict");
		return listRDistrict;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RDistrict> findAllByActive(String state) {
		List<RDistrict> listRDistrict = (List<RDistrict>) template.find("FROM RDistrict WHERE dtrActive = '" + state + "'");
		return listRDistrict;
	}
}
