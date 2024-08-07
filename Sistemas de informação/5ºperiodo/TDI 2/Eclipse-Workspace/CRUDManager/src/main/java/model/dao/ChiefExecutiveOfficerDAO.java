package model.dao;

import java.util.List;

import model.Departaments;
import model.ModelException;

public interface ChiefExecutiveOfficerDAO {

	boolean save(Departaments ceo) throws ModelException;

	boolean update(Departaments ceo) throws ModelException;

	boolean delete(Departaments ceo) throws ModelException;

	List<Departaments> listAll() throws ModelException;

	Departaments findById(int id) throws ModelException;

}