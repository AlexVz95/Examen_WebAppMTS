package com.mts.actividad.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.mts.actividad.vo.CitasVO;
import com.mts.actividad.vo.MedicamentosVO;
import com.mts.actividad.vo.MedicosVO;
import com.mts.actividad.vo.PacientesVO;
import com.mts.actividad.vo.SustanciasVO;
import com.mts.domain.CommonInsertPaciente;

import com.mts.domain.Jdbc;

public class ActividadDaoImpl extends Jdbc implements ActividadDao {
	
   private String qryInsertPaciente;
   private String qryPacientes;
   private String qryUpdatePacientes;
   private String qryInsertHomeopata;
   private String qryInsertMedico;
   private String qryMedicos;
   private String qryHomeopatas;
   private String qryMedicamentos;
   private String qryUpdateHomeopata;
   private String qryUpdateMedico;
   private String qryUpdateMedico2;
   private String qryInsertMedicamentos;
   private String qryUpdateMedicamentos;
   private String qrySustancias;
   private String qryInsertCitas;
   private String qryCitas;
   private String qryUpdateCitas;
   //pacientes
   @Override
   public void insertarPaciente(CommonInsertPaciente params){
	   this.jdbcTemplate.update(qryInsertPaciente, new Object []{
				params.getNombre(),
				params.getCedula_ide(),
				params.getTelefono(),
				params.getDireccion(),
				params.getEdad()
		});
   }
   
   @Override
   public void updatePaciente(PacientesVO params) {
	   this.jdbcTemplate.update(qryUpdatePacientes, new Object []{
				params.getNombre(),
				params.getCedula_ide(),
				params.getTelefono(),
				params.getDireccion(),
				params.getEdad(),
				params.getIdPaciente()
		});
   	
   }

   
   @Override
   public List<PacientesVO> nombre(){
	   List<PacientesVO> result =  this.jdbcTemplate.query(qryPacientes,PACIENTES_MAPPER);
	   return result;   
   }
   
   private static final RowMapper<PacientesVO> PACIENTES_MAPPER = new RowMapper<PacientesVO>() {
		@Override
		public PacientesVO mapRow(ResultSet rs, int num) throws SQLException {
			PacientesVO result = new PacientesVO();
			
			result.setIdPaciente(rs.getInt("IdPaciente"));
			result.setNombre(rs.getString("Nombre"));
			result.setCedula_ide(rs.getString("Cedula_Ide"));
			result.setTelefono(rs.getString("Telefono"));
			result.setDireccion(rs.getString("Direccion"));
			result.setEdad(rs.getInt("Edad"));
			return result;
		}
	};
	
	//MedicosHomeopatas
	@Override
	public void insertarMedico(MedicosVO params) {
		this.jdbcTemplate.update(qryInsertMedico, new Object []{
				params.getEspecialidad()
		});
		
	}

	@Override
	public void insertarHomeopata(MedicosVO params) {
		this.jdbcTemplate.update(qryInsertHomeopata, new Object []{
				params.getNombre(),
				params.getCedula_ide(),
				params.getDireccion(),
				params.getTelefono(),
				params.getFecha_inicio()
		});
		
	}
	
	@Override
	public List<MedicosVO> medicos() {
		List<MedicosVO> result =  this.jdbcTemplate.query(qryMedicos,MEDICOS_MAPPER);
		   return result;
	}
	
	private static final RowMapper<MedicosVO> MEDICOS_MAPPER = new RowMapper<MedicosVO>() {
		@Override
		public MedicosVO mapRow(ResultSet rs, int num) throws SQLException {
			MedicosVO result = new MedicosVO();
			
			result.setIdHomeopata(rs.getInt("IdHomeopata"));
			result.setNombre(rs.getString("Nombre"));
			result.setCedula_ide(rs.getString("Cedula_Ide"));
			result.setDireccion(rs.getString("Direccion"));
			result.setTelefono(rs.getString("Telefono"));
			result.setFecha_inicio(rs.getString("Fecha_Inicio"));
			result.setIdMedico(rs.getInt("IdMedico"));
			result.setEspecialidad(rs.getString("Especialidad"));
			return result;
		}
	};
	
	@Override
	public List<MedicosVO> homeopatas() {
		List<MedicosVO> result =  this.jdbcTemplate.query(qryHomeopatas,HOMEOPATAS_MAPPER);
		   return result;
	}
	
	private static final RowMapper<MedicosVO> HOMEOPATAS_MAPPER = new RowMapper<MedicosVO>() {
		@Override
		public MedicosVO mapRow(ResultSet rs, int num) throws SQLException {
			MedicosVO result = new MedicosVO();
			
			result.setIdHomeopata(rs.getInt("IdHomeopata"));
			result.setNombre(rs.getString("Nombre"));
			result.setCedula_ide(rs.getString("Cedula_Ide"));
			result.setDireccion(rs.getString("Direccion"));
			result.setTelefono(rs.getString("Telefono"));
			result.setFecha_inicio(rs.getString("Fecha_Inicio"));
			return result;
		}
	};
	
	@Override
	public void updateHomeopata(MedicosVO params) {
		this.jdbcTemplate.update(qryUpdateHomeopata, new Object []{
				params.getNombre(),
				params.getCedula_ide(),
				params.getDireccion(),
				params.getTelefono(),
				params.getFecha_inicio(),
				params.getIdHomeopata()
		});
		
		
	}

	@Override
	public void updateMedico(MedicosVO params) {
		this.jdbcTemplate.update(qryUpdateMedico, new Object []{
				params.getEspecialidad(),
				params.getIdHomeopata(),
		});
		
		
	}
	
	@Override
	public void updateMedico2(MedicosVO params) {
		this.jdbcTemplate.update(qryUpdateMedico2, new Object []{
				params.getIdHomeopata(),
				params.getEspecialidad(),
				params.getIdMedico()
		});
		
	}

	//medicamentos
	@Override
	public List<MedicamentosVO> medicamentos() {
		List<MedicamentosVO> result =  this.jdbcTemplate.query(qryMedicamentos,MEDICAMENTOS_MAPPER);
		   return result;
	}
	
	private static final RowMapper<MedicamentosVO> MEDICAMENTOS_MAPPER = new RowMapper<MedicamentosVO>() {
		@Override
		public MedicamentosVO mapRow(ResultSet rs, int num) throws SQLException {
			MedicamentosVO result = new MedicamentosVO();
			
			result.setIdMedicamentos(rs.getInt("IdMedicamentos"));
			result.setNombre(rs.getString("Nombre"));
			result.setCodigo_med(rs.getString("Codigo_Med"));
			return result;
		}
	};
	
	@Override
	public void updateMedicamento(MedicamentosVO params) {
		this.jdbcTemplate.update(qryUpdateMedicamentos, new Object []{
				params.getNombre(),
				params.getCodigo_med(),
				params.getIdMedicamentos()
		});
		
		
	}

	@Override
	public void insertarMedicamento(MedicamentosVO params) {
		this.jdbcTemplate.update(qryInsertMedicamentos, new Object []{
				params.getNombre(),
				params.getCodigo_med()
				
		});
		
	}

	//sustancias
	@Override
	public List<SustanciasVO> sustancias() {
		List<SustanciasVO> result =  this.jdbcTemplate.query(qrySustancias,SUSTANCIAS_MAPPER);
		   return result;
	}
	
	private static final RowMapper<SustanciasVO> SUSTANCIAS_MAPPER = new RowMapper<SustanciasVO>() {
		@Override
		public SustanciasVO mapRow(ResultSet rs, int num) throws SQLException {
			SustanciasVO result = new SustanciasVO();
			
			result.setIdSustancias(rs.getInt("IdSustancias"));
			result.setIdMedicamentos(rs.getInt("IdMedicamentos"));
			result.setNombre(rs.getString("Nombre"));
			result.setCodigo_sus(rs.getString("Codigo_Sus"));
			result.setCombinacion(rs.getBoolean("Combinacion"));
			return result;
		}
	};
	//Citas
	
	@Override
	public void insertCitas(CitasVO params) {
		this.jdbcTemplate.update(qryInsertCitas, new Object []{
				params.getFecha(),
				params.getCosto(),
				params.getHora_consulta(),
				params.getIdHomeopata(),
				params.getIdMedico(),
				params.getIdPaciente()
				
		});
		
	}
	
	@Override
	public List<CitasVO> citas() {
		List<CitasVO> result =  this.jdbcTemplate.query(qryCitas,CITAS_MAPPER);
		return result; 
	}
	
	private static final RowMapper<CitasVO> CITAS_MAPPER = new RowMapper<CitasVO>() {
		@Override
		public CitasVO mapRow(ResultSet rs, int num) throws SQLException {
			CitasVO result = new CitasVO();
			
			result.setIdConsulta(rs.getInt("IdConsulta"));
			result.setFecha(rs.getString("Fecha"));
			result.setCosto(rs.getInt("Costo"));
			result.setHora_consulta(rs.getString("Hora_Consulta"));
			result.setIdHomeopata(rs.getInt("idHomeopata"));
			result.setIdMedico(rs.getInt("idMedico"));
			result.setIdPaciente(rs.getInt("idPaciente"));
			
			return result;
		}
	};
	
	@Override
	public void updateCitas(CitasVO params) {
		this.jdbcTemplate.update(qryUpdateCitas, new Object []{
				params.getFecha(),
				params.getCosto(),
				params.getHora_consulta(),
				params.getIdHomeopata(),
				params.getIdMedico(),
				params.getIdPaciente(),
				params.getIdConsulta()
				
		});
		
	}
public String getQryInsertPaciente() {
	return qryInsertPaciente;
}

public void setQryInsertPaciente(String qryInsertPaciente) {
	this.qryInsertPaciente = qryInsertPaciente;
}

public String getQryPacientes() {
	return qryPacientes;
}

public void setQryPacientes(String qryPacientes) {
	this.qryPacientes = qryPacientes;
}

public String getQryUpdatePacientes() {
	return qryUpdatePacientes;
}

public void setQryUpdatePacientes(String qryUpdatePacientes) {
	this.qryUpdatePacientes = qryUpdatePacientes;
}

public String getQryInsertHomeopata() {
	return qryInsertHomeopata;
}

public void setQryInsertHomeopata(String qryInsertHomeopata) {
	this.qryInsertHomeopata = qryInsertHomeopata;
}

public String getQryInsertMedico() {
	return qryInsertMedico;
}

public void setQryInsertMedico(String qryInsertMedico) {
	this.qryInsertMedico = qryInsertMedico;
}


public String getQryMedicos() {
	return qryMedicos;
}

public void setQryMedicos(String qryMedicos) {
	this.qryMedicos = qryMedicos;
}

public String getQryHomeopatas() {
	return qryHomeopatas;
}

public void setQryHomeopatas(String qryHomeopatas) {
	this.qryHomeopatas = qryHomeopatas;
}

public String getQryMedicamentos() {
	return qryMedicamentos;
}

public void setQryMedicamentos(String qryMedicamentos) {
	this.qryMedicamentos = qryMedicamentos;
}

public String getQryUpdateHomeopata() {
	return qryUpdateHomeopata;
}

public void setQryUpdateHomeopata(String qryUpdateHomeopata) {
	this.qryUpdateHomeopata = qryUpdateHomeopata;
}

public String getQryUpdateMedico() {
	return qryUpdateMedico;
}

public void setQryUpdateMedico(String qryUpdateMedico) {
	this.qryUpdateMedico = qryUpdateMedico;
}

public String getQryUpdateMedico2() {
	return qryUpdateMedico2;
}

public void setQryUpdateMedico2(String qryUpdateMedico2) {
	this.qryUpdateMedico2 = qryUpdateMedico2;
}

public String getQryInsertMedicamentos() {
	return qryInsertMedicamentos;
}

public void setQryInsertMedicamentos(String qryInsertMedicamentos) {
	this.qryInsertMedicamentos = qryInsertMedicamentos;
}

public String getQryUpdateMedicamentos() {
	return qryUpdateMedicamentos;
}

public void setQryUpdateMedicamentos(String qryUpdateMedicamentos) {
	this.qryUpdateMedicamentos = qryUpdateMedicamentos;
}

public String getQrySustancias() {
	return qrySustancias;
}

public void setQrySustancias(String qrySustancias) {
	this.qrySustancias = qrySustancias;
}

public String getQryInsertCitas() {
	return qryInsertCitas;
}

public void setQryInsertCitas(String qryInsertCitas) {
	this.qryInsertCitas = qryInsertCitas;
}

public String getQryCitas() {
	return qryCitas;
}

public void setQryCitas(String qryCitas) {
	this.qryCitas = qryCitas;
}

public String getQryUpdateCitas() {
	return qryUpdateCitas;
}

public void setQryUpdateCitas(String qryUpdateCitas) {
	this.qryUpdateCitas = qryUpdateCitas;
}





















   

   
}
