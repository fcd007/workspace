package br.univel;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class CustomDs implements JRDataSource {

	private int count;
	ResultSet rs=null;
	
	public CustomDs() {
		try {
			java.sql.Statement st = Connection.getConnection().createStatement();
			rs = st.executeQuery("SELECT * FROM CLIENTE");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Object getFieldValue(JRField arg0) throws JRException {
		if ("Field_1".equals(arg0))
			try {
				return rs.getObject("nome").toString();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if ("Field_2".equals(arg0.getName()))
			return "World" + count;
		return "unknown";
		
	}

	public boolean next() throws JRException {
		try {
			return rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
