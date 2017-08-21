package org.hotel.controller;

import org.hotel.entity.MCity;
import org.hotel.entity.MHotels;
import org.hotel.entity.RDistrict;
import org.hotel.service.MCityDao;
import org.hotel.service.MHotelsDao;
import org.hotel.service.RDistrictDao;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MHotelsController {

	@Autowired
	private MHotelsDao mHotelsDao;
	@Autowired
	private MCityDao mCityDao;
	@Autowired
	private RDistrictDao rDistrictDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String view(Model model) {
		String active = "1"; // Setting active state to active

		model.addAttribute("hotelList", mHotelsDao.findAll());
		model.addAttribute("districtList", rDistrictDao.findAllByActive(active));

		return "view";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/hotel_search", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String hotelSearch(@RequestParam("ctyId") int ctyId, @RequestParam("_") String k,
			Model model) {

		JSONArray jsonArray = new JSONArray();
		JSONArray jsonArraySub;
		JSONObject jsonObject = new JSONObject();

		try {
			for (MHotels mHotels : mHotelsDao.findAllByCity(ctyId)) {
				jsonArraySub = new JSONArray();
				jsonArraySub.add(mHotels.getHtlName());
				jsonArraySub.add(mHotels.getHtlPhoneNo());
				jsonArraySub.add("<a href='mailto:" + mHotels.getHtlEmail() + "'>"
						+ (mHotels.getHtlEmail() == null || mHotels.getHtlEmail().isEmpty() ? "" : mHotels.getHtlEmail()));
				jsonArraySub.add(mHotels.getHtlStreet());
				if (mHotels.getHtlActive().equals("1")) {
					jsonArraySub.add("<span class='label label-success'>Active</span>");
				} else {
					jsonArraySub.add("<span class='label label-warning'>Active</span>");
				}
				jsonArray.add(jsonArraySub);
			}
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
			exception.printStackTrace();
		}
		jsonObject.put("data", jsonArray);

		return jsonObject.toJSONString();
	}

	@RequestMapping(value = "/new_hotel", method = RequestMethod.GET)
	public String beforeAdd(Model model) {
		String active = "1"; // Setting active state to active

		model.addAttribute("newHotel", new MHotels());
		model.addAttribute("districtList", rDistrictDao.findAllByActive(active));

		return "add";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/city_load", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String cityLoad(@RequestParam("dtrId") int dtrId, Model model) {
		String active = "1";// Setting active state to active

		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject;

		try {
			for (MCity mCity : mCityDao.findAllByDistrict(dtrId, active)) {
				jsonObject = new JSONObject();
				jsonObject.put("ctyId", mCity.getCtyId());
				jsonObject.put("ctyName", mCity.getCtyName());
				jsonArray.add(jsonObject);
			}
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
			exception.printStackTrace();
		}

		return jsonArray.toJSONString();
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody String saveHotel(@ModelAttribute("newHotel") MHotels mHotels) {

		mHotelsDao.save(mHotels);

		return "success";
	}

}
