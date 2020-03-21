package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Player;
import model.Skill;
import utility.ConnectionManager;

public class PlayerDAO
{
	 static List<Player> list=new ArrayList<Player>();
	public List<Player> getAllPlayers() throws ClassNotFoundException, SQLException, IOException 
	{
		Connection con=ConnectionManager.getConnection();
		 Statement stmt=  con.createStatement();
			
			ResultSet rs =stmt.executeQuery("select * from player natural  JOIN skills ");
		  
			while(rs.next())
		    {
				//System.out.println("hi");
				long skillId=rs.getLong(1);
				long playerId=rs.getLong(1);
				String playerName=rs.getString(3);
				String playerCountry=rs.getString(4);
				//System.out.println(playerCountry);
			
				long teamId=rs.getLong(5);
				String skillName=rs.getString(6);
				
				Skill skill=new Skill(skillId,skillName);
				Player player =new Player(playerId,playerName,playerCountry,skill);
				list.add(player);
				
				
				
			   
		    }
			
			
		
		return list;
		
	}

	
}
