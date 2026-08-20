package studentmanagement;

import java.sql.*;


public class StudentApp {

	
	private Connection connectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/akhiladb","root","Sequel$akl123");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
			return null;
	}
	
	public int insert(Student student) {
		
		String sql = "insert into studentapp (id,name,course,marks) values(?,?,?,?)";
		try(Connection con = connectDB(); 
			PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, student.getId());
			ps.setString(2, student.getName());
			ps.setString(3, student.getCourse());
			ps.setInt(4, student.getMarks());
			
			int nora = ps.executeUpdate();
			return nora;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int delete(int id) {
		String sql = "delete from studentapp where id = ?";
		try (Connection con = connectDB();
			PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, id);
			int nora = ps.executeUpdate();
			
			return nora;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public String display(int id) {
		String sql = "select * from studentapp where id = ?";
		try(Connection con = connectDB();
			PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, id);
			try(ResultSet rs = ps.executeQuery()){
				if(rs.next()) {
					int Id = rs.getInt("id");
					String name = rs.getString("name");
					String course = rs.getString("course");
					int marks = rs.getInt("marks");
					return "Id = "+Id+" | "+" Name = "+name+" | "+" Course = "+course+" | "+" Marks = "+marks;
				}
		   }
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return "No Student Record is there with id " +id;
	}
	
	public String customeDisplay(int id) {
		String sql="select id,name from studentapp where id = ?";
		try(Connection con = connectDB();
			PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, id);
			boolean result = ps.execute();
			
			if(result) {
				try(ResultSet rs=ps.getResultSet()){
					if(rs.next()) {
					return "Id = "+rs.getInt("id")+" |"+" Name = "+rs.getString("name")+" ";
					}
				}
			}
			else {
				int nora = ps.getUpdateCount();
				return nora+" ";
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return "No student record is there with id "+id;
	}
	
	public String updateName(Student student) {
		
		String sql="update studentapp set name = ? where id = ?";
		try(Connection con = connectDB();
			PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1, student.getName());
			ps.setInt(2, student.getId());
			
			int nora = ps.executeUpdate();
			if(nora==0) {
				return "No student record is there to update with id "+student.getId();
			}
			
			return nora+" record updated successfully!";
	
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}
	
	public String updateCourse(Student student) {
		
		String sql="update studentapp set course = ? where id = ?";
		
		try(Connection con = connectDB();
			PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1, student.getCourse());
			ps.setInt(2, student.getId());
			
			int nora = ps.executeUpdate();
			if(nora==0) {
				return "No student record is there to update with id "+student.getId();
			}
			
			return nora+" record updated successfully!";
	
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}
	
	public String updateMarks(Student student) {
		String sql ="update studentapp set marks = ? where id = ?";
		try(Connection con = connectDB();
			PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, student.getMarks());
			ps.setInt(2, student.getId());
			
			int nora = ps.executeUpdate();
			if(nora==0) {
				return "No student record is there to update with id "+student.getId();
			}
			
			return nora+" record updated successfully!";
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
