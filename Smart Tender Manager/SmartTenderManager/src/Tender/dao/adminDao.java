package Tender.dao;

import java.util.List;

import Tender.Exception.AdminException;
import Tender.Exception.VenderException;
import Tender.Model.Tender;
import Tender.Model.Vender;

public interface adminDao {
	

  public String loginIntoAdmin(String AUsername ,String APassword) throws AdminException;
  
  public String registerVender(Vender vernder) throws AdminException;
  
   public List<Vender>  getAllVender()throws VenderException;
   
   public String CreateNewTender( int TenderId,String TenderName );
   public List<Tender> getAllTender();
 
}
