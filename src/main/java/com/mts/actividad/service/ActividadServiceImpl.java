package com.mts.actividad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mts.actividad.dao.ActividadDao;
import com.mts.actividad.vo.CitasVO;
import com.mts.actividad.vo.MedicamentosVO;
import com.mts.actividad.vo.MedicosVO;
import com.mts.actividad.vo.PacientesVO;
import com.mts.actividad.vo.SustanciasVO;
import com.mts.domain.CommonInsertPaciente;


@Service
public class ActividadServiceImpl implements ActividadService {
	
	
	@Autowired
	private ActividadDao actividadDao;
	
	
	
	@Override
	public void insertarPaciente(CommonInsertPaciente params) {
		actividadDao.insertarPaciente(params);
		
	}
	

	@Override
	public List<PacientesVO> nombre() {
		return actividadDao.nombre();
	}

	@Override
	public void updatePaciente(PacientesVO params) {
		actividadDao.updatePaciente(params);
		
	}
			
	
	@Override
	public void insertarMedico(MedicosVO params) {
		actividadDao.insertarMedico(params);
		
	}

	@Override
	public void insertarHomeopata(MedicosVO params) {
		actividadDao.insertarHomeopata(params);
		
	}

	public ActividadDao getActividadDao() {
		return actividadDao;
	}

	public void setActividadDao(ActividadDao actividadDao) {
		this.actividadDao = actividadDao;
	}

	@Override
	public List<MedicosVO> medicos() {
		
		return actividadDao.medicos();
	}

	@Override
	public List<MedicosVO> homeopatas() {
		return actividadDao.homeopatas();
	}

	@Override
	public List<MedicamentosVO> medicamentos() {
		return actividadDao.medicamentos();
	}

	@Override
	public void updateHomeopata(MedicosVO params) {
		actividadDao.updateHomeopata(params);
		
	}

	@Override
	public void updateMedico(MedicosVO params) {
		actividadDao.updateMedico(params);
	}

	@Override
	public void updateMedico2(MedicosVO params) {
		actividadDao.updateMedico2(params);
		
	}

	@Override
	public void updateMedicamento(MedicamentosVO params) {
		actividadDao.updateMedicamento(params);
		
	}

	@Override
	public void insertarMedicamento(MedicamentosVO params) {
		actividadDao.insertarMedicamento(params);
		
	}

	@Override
	public List<SustanciasVO> sustancias() {
		return actividadDao.sustancias();
	}

	@Override
	public void insertCitas(CitasVO params) {
		actividadDao.insertCitas(params);
		
	}

	@Override
	public List<CitasVO> citas() {
		return actividadDao.citas();
	}

	@Override
	public void updateCitas(CitasVO params) {
		actividadDao.updateCitas(params);
		
	}

}
