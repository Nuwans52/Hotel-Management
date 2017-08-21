/**
 * 
 */
package org.hotel.service;

import java.util.List;

import org.hotel.entity.MCity;

/**
 * @author sandakelums
 *
 */
public interface MCityDao {
	/**
	 * Save MCity data
	 * 
	 * @param MCity
	 */
	void save(MCity mCity);

	/**
	 * @return Object list Of all active MCity
	 */
	List<MCity> findAll();

	/**
	 * state 1 is active and 0 is inactive
	 * 
	 * @param state
	 * @return Object list Of all active MCity
	 */
	List<MCity> findAllByDistrict(int dtrId, String ctyActive);
}
