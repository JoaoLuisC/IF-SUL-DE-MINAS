package model.dao;

import java.util.ArrayList;
import java.util.List;

import model.Departaments;
import model.Company;
import model.ModelException;

public class MySQLChiefExecutiveOfficerDAO implements ChiefExecutiveOfficerDAO {

	@Override
	public boolean save(Departaments ceo) throws ModelException {
		DBHandler db = new DBHandler();

		String sqlInsert = "INSERT INTO ceos VALUES (DEFAULT, ?, ?, ?, ?, ?);";

		db.prepareStatement(sqlInsert);

		db.setString(1, ceo.getName());
		db.setString(2, ceo.getGender());
		db.setString(3, ceo.getEmail());
		db.setString(4, ceo.getFone());
		db.setInt(5, ceo.getCompany().getId());

		return db.executeUpdate() > 0;
	}

	@Override
	public boolean update(Departaments ceo) throws ModelException {
		DBHandler db = new DBHandler();

		String sqlUpdate = "UPDATE ceos SET name = ?, gender = ?, email = ?, fone = ?, company_id = ? where id = ?";

		db.prepareStatement(sqlUpdate);

		db.setString(1, ceo.getName());
		db.setString(2, ceo.getGender());
		db.setString(3, ceo.getEmail());
		db.setString(4, ceo.getFone());
		db.setInt(5, ceo.getCompany().getId());
		db.setInt(6, ceo.getId());

		return db.executeUpdate() > 0;
	}

	@Override
	public boolean delete(Departaments ceo) throws ModelException {
		DBHandler db = new DBHandler();

		String sqlDelete = "DELETE FROM ceos WHERE id = ?";

		db.prepareStatement(sqlDelete);

		db.setInt(1, ceo.getId());

		return db.executeUpdate() > 0;
	}

	@Override
	public Departaments findById(int id) throws ModelException {
		DBHandler db = new DBHandler();

		String sql = "SELECT * FROM ceos WHERE id = ?";

		db.prepareStatement(sql);

		db.setInt(1, id);
		db.executeQuery();

		Departaments ceo = null;

		while (db.next()) {
			ceo = createCEO(db);
			break;
		}

		return ceo;
	}

	@Override
	public List<Departaments> listAll() throws ModelException {
		DBHandler db = new DBHandler();

		List<Departaments> ceos = new ArrayList<>();

		String sqlQuery = "SELECT c.id as ID, c.name as Name, c.gender as Gender, c.email as Email, c.fone as Fone, cp.id as company_id from ceos c inner join companies cp on c.company_id = cp.id;";

		db.createStatement();

		db.executeQuery(sqlQuery);

		while (db.next()) {
			Departaments ceo = createCEO(db);

			ceos.add(ceo);
		}

		return ceos;
	}

	private Departaments createCEO(DBHandler db) throws ModelException {
		Departaments ceo = new Departaments(db.getInt("id"));
		ceo.setName(db.getString("name"));
		ceo.setGender(db.getString("gender"));
		ceo.setEmail(db.getString("email"));
		ceo.setFone(db.getString("fone"));

		CompanyDAO companyDAO = DAOFactory.createDAO(CompanyDAO.class);

		Company company = companyDAO.findById(db.getInt("company_id"));

		ceo.setCompany(company);

		return ceo;
	}
}
