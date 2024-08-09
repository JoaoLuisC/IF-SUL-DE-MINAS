package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Departaments;
import model.ModelException;
import model.User;
import model.dao.DepartamentsDAO;
import model.dao.UserDAO;
import model.dao.DAOFactory;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/departaments", "/departaments/form", "/departaments/insert", "/departaments/update", "/departaments/delete" })
public class DepartamentsController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getRequestURI();

		switch (action) {
		case "/crud-manager/departaments/form": {
			loadUsers(req);
			req.setAttribute("action", "insert");
			ControllerUtil.forward(req, resp, "/form-departaments.jsp");
			break;
		}
		case "/crud-manager/departaments/update": {
			loadDepartaments(req);
			loadUsers(req);
			req.setAttribute("action", "update");
			ControllerUtil.forward(req, resp, "/form-departaments.jsp");
			break;
		}
		default:
			listDepartaments(req);

			ControllerUtil.transferSessionMessagesToRequest(req);

			ControllerUtil.forward(req, resp, "/departaments.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getRequestURI();

		switch (action) {
		case "/crud-manager/departaments/insert": {
			insertDepartament(req);
			ControllerUtil.redirect(resp, req.getContextPath() + "/departaments");
			break;
		}
		case "/crud-manager/departaments/update": {
			System.out.println("Entrou DoPost Update");
			updateDepartament(req);
			ControllerUtil.redirect(resp, req.getContextPath() + "/departaments");
			break;
		}
		case "/crud-manager/departaments/delete": {
			deleteDepartament(req);
			ControllerUtil.redirect(resp, req.getContextPath() + "/departaments");
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + action);
		}
	}

	private void deleteDepartament(HttpServletRequest req) {
		String departamentIdStr = req.getParameter("id");
		int departamentId = Integer.parseInt(departamentIdStr);

		String departamentName = req.getParameter("entityName");

		DepartamentsDAO dao = DAOFactory.createDAO(DepartamentsDAO.class);

		try {
			if (dao.delete(new Departaments(departamentId))) {
				ControllerUtil.sucessMessage(req, "Departament '" + departamentName + "' excluído com sucesso.");
			} else {
				ControllerUtil.errorMessage(req, "Departament '" + departamentName + "' não pode ser excluído.");
			}
		} catch (ModelException e) {
			ControllerUtil.errorMessage(req, e.getMessage());
		}
	}

	private void updateDepartament(HttpServletRequest req) {
		String departamentIdStr = req.getParameter("departaments_id");
		int departamentId = Integer.parseInt(departamentIdStr);

		Departaments departament = createDepartament(req, departamentId);

		DepartamentsDAO dao = DAOFactory.createDAO(DepartamentsDAO.class);

		try {
			if (dao.update(departament)) {
				ControllerUtil.sucessMessage(req, "Departamento " + departament.getName() + " alterado com sucesso.");
			} else {
				ControllerUtil.errorMessage(req, "Departamento " + departament.getName() + " não pode ser alterado.");
			}
		} catch (ModelException e) {
			e.printStackTrace();
			ControllerUtil.errorMessage(req, e.getMessage());
		}
	}

	private void insertDepartament(HttpServletRequest req) {
		Departaments departaments = createDepartament(req, 0);

		DepartamentsDAO dao = DAOFactory.createDAO(DepartamentsDAO.class);

		try {
			if (dao.save(departaments)) {
				ControllerUtil.sucessMessage(req, "Departamento " + departaments.getName() + " salvo com sucesso.");
			} else {
				ControllerUtil.errorMessage(req, "Departamento " + departaments.getName() + " não pode ser salvo.");
			}
		} catch (ModelException e) {
			e.printStackTrace();
			ControllerUtil.errorMessage(req, e.getMessage());
		}
	}

	private Departaments createDepartament(HttpServletRequest req, int departamentId) {
		
		String departamentName = req.getParameter("departament_name");
		String departamentDescription = req.getParameter("departament_description");
		String departamentEmployeeCount = req.getParameter("departament_employeeCount");
		int departamentEmployeeCountInt = Integer.parseInt(departamentEmployeeCount);
		String departamentPhone = req.getParameter("departament_phone");
		String departamentDepartmentHead = req.getParameter("departament_department_head");
		int departamentHeadId = Integer.parseInt(departamentDepartmentHead);
		
		Departaments departaments;

		if (departamentId == 0) {
			departaments = new Departaments();
		} else {
			departaments = new Departaments(departamentId);
		}

		departaments.setName(departamentName);
		departaments.setDescription(departamentDescription);
		departaments.setEmployeeCount(departamentEmployeeCountInt);
		departaments.setPhone(departamentPhone);
		departaments.setDepartmentHead(new User(departamentHeadId));

		return departaments;
	}

	private void loadDepartaments(HttpServletRequest req) {
		String departamentIdStr = req.getParameter("departamentsId");
		int departamentsId = Integer.parseInt(departamentIdStr);

		DepartamentsDAO dao = DAOFactory.createDAO(DepartamentsDAO.class);

		Departaments departaments = new Departaments(0);

		try {
			departaments = dao.findById(departamentsId);
		} catch (ModelException e) {
			ControllerUtil.errorMessage(req, "Erro ao carregar departaments para edição.");
		}

		req.setAttribute("departamentsToEdit", departaments);
	}

	private void listDepartaments(HttpServletRequest req) {
		DepartamentsDAO dao = DAOFactory.createDAO(DepartamentsDAO.class);

		List<Departaments> departaments = new ArrayList<>();

		try {
			departaments = dao.listAll();
		} catch (ModelException e) {
			ControllerUtil.errorMessage(req, "Erro ao carregar os Departamentos." + e);
			e.printStackTrace();
			
		}

		req.setAttribute("departaments", departaments);
	}

	private void loadUsers(HttpServletRequest req) {
		UserDAO dao = DAOFactory.createDAO(UserDAO.class);
		List<User> users = new ArrayList<>();
		try {
			users = dao.listAll();
		} catch (ModelException e) {
			ControllerUtil.errorMessage(req, "Erro ao carregar usuarios.");
		}
		req.setAttribute("users", users);
	}
}
