package Tender.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Tender.Exception.VenderException;
import Tender.Model.Tender;
import Tender.Model.Vender;
import Tender.dao.venderDao;
import Tender.utility.Dao;

public class VenderDaoimpl implements venderDao {

	@Override
	public List<Tender> getAllTender() {
		 List<Tender> venders = new ArrayList<>();
			try(Connection conn = Dao.provideConnection()){
				
				PreparedStatement ps = conn.prepareStatement("select * from tender" );
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					int TenderId = rs.getInt("TenderId");
					String TenderName = rs.getString("TenderName");
					
					
					Tender tender = new Tender ();
					tender.setTenderId(TenderId);
					tender.setTenderName(TenderName);
					
					
					venders.add(tender);
					
					
				}
				
//				
//				for (Vender vender : venders) {
//					System.out.println(vender);
//				}
//				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		
				
			}
			
			
			
			return venders;
		
	
		
	
	}

	@Override
	public Vender LoginVender(String username, String Password) throws VenderException {
		Vender  vender = null;
		 
		try(Connection conn = Dao.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from vender where VUsername = ? AND VPassword = ?");
			
				ps.setString(1, username);
				ps.setString(2, Password);
				ResultSet rs = ps.executeQuery();
				
				if (rs.next()) {
					int r = rs.getInt("VID");
					String n = rs.getString("VName");
					String a = rs.getString("VUsername");
					
					
					String p = rs.getString("VPassword");
					
					 vender = new Vender (r,n,a,p);		
				}else {
					throw new VenderException("invalid username and password");
				}
				
		}catch(SQLException e) {
			printStackTrace(e);
			
		}
		
		
		
		
		return vender;
	
	}

	private void printStackTrace(SQLException e) {
		// TODO Auto-generated method stub
		
	}
	
	
}

	
