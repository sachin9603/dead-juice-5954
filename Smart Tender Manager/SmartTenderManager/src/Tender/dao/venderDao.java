package Tender.dao;

import java.util.List;



import Tender.Exception.VenderException;
import Tender.Model.Tender;
import Tender.Model.Vender;

public interface venderDao {
	
	public List <Tender> getAllTender();
	public Vender  LoginVender (String username,String Password) throws VenderException ;
	
 
}
