/**
 * 
 */
package org.hotel.service;

import java.util.List;

import org.hotel.entity.MHotels;

/**
 * @author sandakelums
 *
 */
public interface MHotelsDao {
	/**
	 * Save MHotels data
	 * 
	 * @param MHotels
	 */
	void save(MHotels mHotels);

	/**
	 * @return Object list Of all MHotels
	 */
	List<MHotels> findAll();

	/**
	 * @param ctyId
	 * @return Object list Of all MHotels
	 */
	List<MHotels> findAllByCity(int ctyId);
}
