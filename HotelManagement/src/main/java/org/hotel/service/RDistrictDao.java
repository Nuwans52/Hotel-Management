/**
 * 
 */
package org.hotel.service;

import java.util.List;

import org.hotel.entity.MCity;
import org.hotel.entity.RDistrict;

/**
 * @author sandakelums
 *
 */
public interface RDistrictDao {
	/**
	 * Save RDistrict data
	 * 
	 * @param RDistrict
	 */
	void save(RDistrict rDistrict);

	/** 
	 * @return Object list Of all active RDistrict
	 */
	List<RDistrict> findAll();
	
	/**
	 * state 1 is active and 0 is inactive
	 * 
	 * @param state
	 * @return Object list Of all active RDistrict
	 */
	List<RDistrict> findAllByActive(String state);

}
