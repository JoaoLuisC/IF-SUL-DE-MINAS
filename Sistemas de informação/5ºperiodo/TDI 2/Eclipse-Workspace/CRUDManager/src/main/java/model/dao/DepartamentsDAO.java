package model.dao;

import java.util.List;

import model.Departaments;
import model.ModelException;

public interface DepartamentsDAO {

	boolean save(Departaments departaments) throws ModelException;

	boolean update(Departaments departaments) throws ModelException;

	boolean delete(Departaments departaments) throws ModelException;

	List<Departaments> listAll() throws ModelException;

	Departaments findById(int id) throws ModelException;

}