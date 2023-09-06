package isa.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import isa.entity.Ad;
import isa.entity.AdDto;
import isa.entity.User;

public class AdDtoDao {
	
	private AdDao adDao;
	private UserDao userDao;
	
	public AdDtoDao() {
		
		adDao = new AdDao();
		userDao = new UserDao();
	}
	
	public List<AdDto> list() throws ClassNotFoundException, SQLException {
		
		ArrayList<AdDto> list = new ArrayList<>();
		ArrayList<Ad> adList = (ArrayList<Ad>) adDao.list();
		
		for(Ad ad : adList) {
			
			User user = userDao.getById(ad.getUserId());
			AdDto adDto = new AdDto(ad, user);
			list.add(adDto);
		}
		
		return list;		
	}

	public List<AdDto> search(String keyWords) throws ClassNotFoundException, SQLException {
		
		ArrayList<AdDto> list = new ArrayList<>();
		ArrayList<Ad> adList = (ArrayList<Ad>) adDao.search(keyWords);
		
		for(Ad ad : adList) {
			
			User user = userDao.getById(ad.getUserId());
			AdDto adDto = new AdDto(ad, user);
			list.add(adDto);
		}
		
		return list;		
	}
}
