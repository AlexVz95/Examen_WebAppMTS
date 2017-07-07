package com.mts.actividad.dao;

import java.util.List;

import com.mts.actividad.vo.CitasVO;
import com.mts.actividad.vo.MedicamentosVO;
import com.mts.actividad.vo.MedicosVO;
import com.mts.actividad.vo.PacientesVO;
import com.mts.actividad.vo.SustanciasVO;
import com.mts.domain.CommonInsertPaciente;



public interface ActividadDao {

	void insertarPaciente(CommonInsertPaciente params);

	List<PacientesVO> nombre();

	void updatePaciente(PacientesVO params);

	void insertarMedico(MedicosVO params);

	void insertarHomeopata(MedicosVO params);

	List<MedicosVO> medicos();

	List<MedicosVO> homeopatas();

	List<MedicamentosVO> medicamentos();

	void updateHomeopata(MedicosVO params);

	void updateMedico(MedicosVO params);

	void updateMedico2(MedicosVO params);

	void updateMedicamento(MedicamentosVO params);

	void insertarMedicamento(MedicamentosVO params);

	List<SustanciasVO> sustancias();

	void insertCitas(CitasVO params);

	List<CitasVO> citas();

	void updateCitas(CitasVO params);


	

}
