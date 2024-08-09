package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.Departaments;
import model.ModelException;
import model.User;

public class MySQLDepartamentsDAO implements DepartamentsDAO {

	@Override
	public boolean save(Departaments departaments) throws ModelException {
		DBHandler db = new DBHandler();

		String sqlInsert = "INSERT INTO departaments VALUES (DEFAULT, ?, ?, ?, ?, ?);";

		db.prepareStatement(sqlInsert);

		db.setString(1, departaments.getName());
		db.setString(2, departaments.getDescription());
		db.setInt(3, departaments.getDepartmentHead().getId());		
		db.setInt(4, departaments.getEmployeeCount());
		db.setString(5, departaments.getPhone());
		

		return db.executeUpdate() > 0;
	}

	@Override
	public boolean update(Departaments departaments) throws ModelException {
		DBHandler db = new DBHandler();

		String sqlUpdate = "UPDATE departaments SET name = ?, description = ?, department_head = ?,"
				+ " employee_count = ?, phone = ? where id = ?";

		db.prepareStatement(sqlUpdate);

		db.setString(1, departaments.getName());
		db.setString(2, departaments.getDescription());
		db.setInt(3, departaments.getDepartmentHead().getId());
		db.setInt(4, departaments.getEmployeeCount());
		db.setString(5, departaments.getPhone());
		db.setInt(6, departaments.getId());

		return db.executeUpdate() > 0;
	}

	@Override
	public boolean delete(Departaments departaments) throws ModelException {
		DBHandler db = new DBHandler();

		String sqlDelete = "DELETE FROM departaments WHERE id = ?";

		db.prepareStatement(sqlDelete);

		db.setInt(1, departaments.getId());

		return db.executeUpdate() > 0;
	}

	@Override
	public Departaments findById(int id) throws ModelException {
		DBHandler db = new DBHandler();

		String sql = "SELECT * FROM departaments WHERE id = ?";

		db.prepareStatement(sql);

		db.setInt(1, id);
		db.executeQuery();

		Departaments departaments = null;

		while (db.next()) {
			departaments = createDepartaments(db);
			break;
		}

		return departaments;
	}

	@Override
	public List<Departaments> listAll() throws ModelException {
		DBHandler db = new DBHandler();

		List<Departaments> departaments = new ArrayList<>();

		String sqlQuery = "SELECT * from departaments;";

		db.createStatement();

		db.executeQuery(sqlQuery);

		while (db.next()) {
			Departaments dp = createDepartaments(db);

			departaments.add(dp);
		}

		return departaments;
	}

	private Departaments createDepartaments(DBHandler db) throws ModelException {
		
		Departaments departaments = new Departaments(db.getInt("id"));
		departaments.setName(db.getString("name"));
		departaments.setDescription(db.getString("description"));
		departaments.setEmployeeCount(db.getInt("employee_count"));
		departaments.setPhone(db.getString("phone"));

		UserDAO userDAO = DAOFactory.createDAO(UserDAO.class);

		User user = userDAO.findById(db.getInt("department_head"));

		departaments.setDepartmentHead(user);

		return departaments;
	}
}
