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
import model.Company;
import model.ModelException;
import model.dao.ChiefExecutiveOfficerDAO;
import model.dao.CompanyDAO;
import model.dao.DAOFactory;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/ceos", "/ceo/form", "/ceo/insert", "/ceo/update", "/ceo/delete" })
public class ChiefExecutiveOfficerController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getRequestURI();

		switch (action) {
		case "/crud-manager/ceo/form": {
			loadCompanies(req);
			req.setAttribute("action", "insert");
			ControllerUtil.forward(req, resp, "/form-ceo.jsp");
			break;
		}
		case "/crud-manager/ceo/update": {
			loadCEO(req);
			loadCompanies(req);
			req.setAttribute("action", "update");
			ControllerUtil.forward(req, resp, "/form-ceo.jsp");
			break;
		}
		default:
			listCeos(req);

			ControllerUtil.transferSessionMessagesToRequest(req);

			ControllerUtil.forward(req, resp, "/ceos.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getRequestURI();

		switch (action) {
		case "/crud-manager/ceo/insert": {
			insertCEO(req);
			ControllerUtil.redirect(resp, req.getContextPath() + "/ceos");
			break;
		}
		case "/crud-manager/ceo/update": {
			updateCEO(req);
			ControllerUtil.redirect(resp, req.getContextPath() + "/ceos");
			break;
		}
		case "/crud-manager/ceo/delete": {
			deleteCEO(req);
			ControllerUtil.redirect(resp, req.getContextPath() + "/ceos");
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + action);
		}
	}

	private void deleteCEO(HttpServletRequest req) {
		String ceoIdStr = req.getParameter("id");
		int ceoId = Integer.parseInt(ceoIdStr);

		String ceoName = req.getParameter("entityName");

		ChiefExecutiveOfficerDAO dao = DAOFactory.createDAO(ChiefExecutiveOfficerDAO.class);

		try {
			if (dao.delete(new Departaments(ceoId))) {
				ControllerUtil.sucessMessage(req, "CEO '" + ceoName + "' excluído com sucesso.");
			} else {
				ControllerUtil.errorMessage(req, "CEO '" + ceoName + "' não pode ser excluído.");
			}
		} catch (ModelException e) {
			ControllerUtil.errorMessage(req, e.getMessage());
		}
	}

	private void updateCEO(HttpServletRequest req) {
		String ceoIdStr = req.getParameter("ceo_id");
		int ceoId = Integer.parseInt(ceoIdStr);

		Departaments ceo = createCEO(req, ceoId);

		ChiefExecutiveOfficerDAO dao = DAOFactory.createDAO(ChiefExecutiveOfficerDAO.class);

		try {
			if (dao.update(ceo)) {
				ControllerUtil.sucessMessage(req, "CEO " + ceo.getName() + " alterado com sucesso.");
			} else {
				ControllerUtil.errorMessage(req, "CEO " + ceo.getName() + " não pode ser alterado.");
			}
		} catch (ModelException e) {
			e.printStackTrace();
			ControllerUtil.errorMessage(req, e.getMessage());
		}
	}

	private void insertCEO(HttpServletRequest req) {
		Departaments ceo = createCEO(req, 0);

		ChiefExecutiveOfficerDAO dao = DAOFactory.createDAO(ChiefExecutiveOfficerDAO.class);

		try {
			if (dao.save(ceo)) {
				ControllerUtil.sucessMessage(req, "CEO " + ceo.getName() + " salvo com sucesso.");
			} else {
				ControllerUtil.errorMessage(req, "CEO " + ceo.getName() + " não pode ser salvo.");
			}
		} catch (ModelException e) {
			e.printStackTrace();
			ControllerUtil.errorMessage(req, e.getMessage());
		}
	}

	private Departaments createCEO(HttpServletRequest req, int ceoId) {
		String ceoName = req.getParameter("ceo_name");
		String ceoGender = req.getParameter("ceo_gender");
		String ceoEmail = req.getParameter("ceo_email");
		String ceoFone = req.getParameter("ceo_fone");
		String ceoCompany = req.getParameter("ceo_company");
		int ceoCompanyId = Integer.parseInt(ceoCompany);

		Departaments ceo;

		if (ceoId == 0) {
			ceo = new Departaments();
		} else {
			ceo = new Departaments(ceoId);
		}

		ceo.setName(ceoName);
		ceo.setGender(ceoGender);
		ceo.setEmail(ceoEmail);
		ceo.setFone(ceoFone);
		ceo.setCompany(new Company(ceoCompanyId));

		return ceo;
	}

	private void loadCEO(HttpServletRequest req) {
		String ceoIdStr = req.getParameter("ceoId");
		int ceoId = Integer.parseInt(ceoIdStr);

		ChiefExecutiveOfficerDAO dao = DAOFactory.createDAO(ChiefExecutiveOfficerDAO.class);

		Departaments ceo = new Departaments(0);

		try {
			ceo = dao.findById(ceoId);
		} catch (ModelException e) {
			ControllerUtil.errorMessage(req, "Erro ao carregar CEOs para edição.");
		}

		req.setAttribute("ceoToEdit", ceo);
	}

	private void listCeos(HttpServletRequest req) {
		ChiefExecutiveOfficerDAO dao = DAOFactory.createDAO(ChiefExecutiveOfficerDAO.class);

		List<Departaments> ceos = new ArrayList<>();

		try {
			ceos = dao.listAll();
		} catch (ModelException e) {
			ControllerUtil.errorMessage(req, "Erro ao carregar os CEOs.");
		}

		req.setAttribute("ceos", ceos);
	}

	private void loadCompanies(HttpServletRequest req) {
		CompanyDAO dao = DAOFactory.createDAO(CompanyDAO.class);
		List<Company> companies = new ArrayList<>();
		try {
			companies = dao.listAll();
		} catch (ModelException e) {
			ControllerUtil.errorMessage(req, "Erro ao carregar as empresas.");
		}
		req.setAttribute("companies", companies);
	}
}
