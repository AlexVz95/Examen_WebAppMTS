package com.mts.actividad.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mts.actividad.service.ActividadServiceImpl;
import com.mts.actividad.vo.CitasVO;
import com.mts.actividad.vo.MedicamentosVO;
import com.mts.actividad.vo.MedicosVO;
import com.mts.actividad.vo.PacientesVO;
import com.mts.actividad.vo.SustanciasVO;
import com.mts.domain.CommonInsertPaciente;
import com.mts.domain.CommonResponse;


@Component
@Path("/clinica/")
public class ActividadRest {
	

	@Autowired
	private ActividadServiceImpl actividadService;
	
	private static final Logger LOG = Logger.getLogger(ActividadRest.class);

    @POST
    @Path("/insertarpacientes/")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CommonResponse Insertar(CommonInsertPaciente params){
    	CommonResponse respuesta = new CommonResponse();
    	if(LOG.isDebugEnabled()){
    		LOG.debug("Mensaje con log");
    		LOG.debug(params.getNombre());
    		LOG.debug(params.getCedula_ide());
    		LOG.debug(params.getTelefono());
    		LOG.debug(params.getDireccion());
    		LOG.debug(params.getEdad());
    		
    	}
    	try{
    		actividadService.insertarPaciente(params);
    		respuesta.setMensaje("Datos Insertados");
    		respuesta.setSuccess(true);
    	}catch(Exception e){
    		respuesta.setErrorMensaje("Datos erroneos");
    		respuesta.setSuccess(false);
    	}
    	
    	return respuesta;
    	
    }
    
    @POST
    @Path("/updatepacientes/")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CommonResponse update(PacientesVO params){
    	CommonResponse respuesta = new CommonResponse();
    	
    	if(LOG.isDebugEnabled()){
    		LOG.debug("Mensaje con log");
    		LOG.debug(params.getIdPaciente());
    		LOG.debug(params.getNombre());
    		LOG.debug(params.getCedula_ide());
    		LOG.debug(params.getTelefono());
    		LOG.debug(params.getDireccion());
    		LOG.debug(params.getEdad());
    		
    	}
    	
    	try{
    		actividadService.updatePaciente(params);
    		respuesta.setMensaje("Datos Insertados");
    		respuesta.setSuccess(true);
    	}catch(Exception e){
    		respuesta.setErrorMensaje("Datos erroneos");
    		respuesta.setSuccess(false);
    	}
    	
    	return respuesta;
    	
    	
    	
    }
	
    @POST
    @Path("/pacientes/")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<PacientesVO> pacientes(){
    	
    	return actividadService.nombre();
    	
    }
    
    @POST
    @Path("/insertarmedico/")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CommonResponse Insertar(MedicosVO params){
    	CommonResponse respuesta = new CommonResponse();
    	if(LOG.isDebugEnabled()){
    		LOG.debug("Mensaje con log");
    		LOG.debug(params.getIdHomeopata());
    		LOG.debug(params.getNombre());
    		LOG.debug(params.getCedula_ide());
    		LOG.debug(params.getDireccion());
    		LOG.debug(params.getTelefono());
    		LOG.debug(params.getFecha_inicio());
    		LOG.debug(params.getEsMedico());
    		LOG.debug(params.getIdMedico());
    		LOG.debug(params.getEspecialidad());
    		
    	}
    	
    	
    	try{
    		if(params.getEsMedico().equals("s")){
        		
        		actividadService.insertarHomeopata(params);
        		
        		actividadService.insertarMedico(params);
        		
        	}else{
        		actividadService.insertarHomeopata(params);
        	}
    		respuesta.setMensaje("Datos Insertados");
    		respuesta.setSuccess(true);
    	}catch(Exception e){
    		respuesta.setErrorMensaje("Datos erroneos");
    		respuesta.setSuccess(false);
    	}
    	
    	return respuesta;
    	
    		
    		
    	
    	
    }
    
    @POST
    @Path("/updatemedicos/")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CommonResponse Update(MedicosVO params){
    	
    	if(LOG.isDebugEnabled()){
    		LOG.debug("Mensaje con log");
    		LOG.debug(params.getIdHomeopata());
    		LOG.debug(params.getNombre());
    		LOG.debug(params.getCedula_ide());
    		LOG.debug(params.getDireccion());
    		LOG.debug(params.getTelefono());
    		LOG.debug(params.getFecha_inicio());
    		LOG.debug(params.getEsMedico());
    		LOG.debug(params.getIdMedico());
    		LOG.debug(params.getEspecialidad());
    		
    	}
    	
    	CommonResponse respuesta = new CommonResponse();
    	
    	try{
    		if(params.getEsMedico().equals("s")){
        		actividadService.updateHomeopata(params);
        		
        		actividadService.updateMedico(params);
        		
        	}else{
        		actividadService.updateHomeopata(params);
        	}
    		respuesta.setMensaje("Datos Insertados");
    		respuesta.setSuccess(true);
    	}catch(Exception e){
    		respuesta.setErrorMensaje("Datos erroneos");
    		respuesta.setSuccess(false);
    	}
    	
    	return respuesta;
    	
    }
    
    @POST
    @Path("/updatemedico/")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CommonResponse Update2(MedicosVO params){
    	
    	if(LOG.isDebugEnabled()){
    		LOG.debug("Mensaje con log");
    		LOG.debug(params.getIdHomeopata());
    		LOG.debug(params.getNombre());
    		LOG.debug(params.getCedula_ide());
    		LOG.debug(params.getDireccion());
    		LOG.debug(params.getTelefono());
    		LOG.debug(params.getFecha_inicio());
    		LOG.debug(params.getEsMedico());
    		LOG.debug(params.getIdMedico());
    		LOG.debug(params.getEspecialidad());
    		
    	}
    	
    	
    	CommonResponse respuesta = new CommonResponse();
    	
    	try{
    		actividadService.updateMedico2(params);
        	respuesta.setMensaje("Datos Insertados");
    		respuesta.setSuccess(true);
    	}catch(Exception e){
    		respuesta.setErrorMensaje("Datos erroneos");
    		respuesta.setSuccess(false);
    	}
    	
    	return respuesta;
    	
    }
    
    @POST
    @Path("/medicos/")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<MedicosVO> medicos(){
    	
    	
    	return actividadService.medicos();
    	
    }
    
    @POST
    @Path("/homeopatas/")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<MedicosVO> homeopatas(){
    	
    	
    	return actividadService.homeopatas();
    	
    }
    
    @POST
    @Path("/medicamentos/")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<MedicamentosVO> medicamentos(){
    	
    	
    	return actividadService.medicamentos();
    	
    }
	
    @POST
    @Path("/insertarmedicamento/")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CommonResponse insertarMedicamento(MedicamentosVO params){
    	
    	if(LOG.isDebugEnabled()){
    		LOG.debug("Mensaje con log");
    		LOG.debug(params.getIdMedicamentos());
    		LOG.debug(params.getNombre());
    		LOG.debug(params.getCodigo_med());
    	}
    	CommonResponse respuesta = new CommonResponse();
    	
    	try{
    		actividadService.insertarMedicamento(params);
        	respuesta.setMensaje("Datos Insertados");
    		respuesta.setSuccess(true);
    	}catch(Exception e){
    		respuesta.setErrorMensaje("Datos erroneos");
    		respuesta.setSuccess(false);
    	}
    	
    	return respuesta;
    	
    	
    }
    
    @POST
    @Path("/updatemedicamento/")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CommonResponse updateMedicamento(MedicamentosVO params){
    	
    	if(LOG.isDebugEnabled()){
    		LOG.debug("Mensaje con log");
    		LOG.debug(params.getIdMedicamentos());
    		LOG.debug(params.getNombre());
    		LOG.debug(params.getCodigo_med());
    	}
    	CommonResponse respuesta = new CommonResponse();
    	
    	try{
    		actividadService.updateMedicamento(params);
        	respuesta.setMensaje("Datos Insertados");
    		respuesta.setSuccess(true);
    	}catch(Exception e){
    		respuesta.setErrorMensaje("Datos erroneos");
    		respuesta.setSuccess(false);
    	}
    	
    	return respuesta;
    		
    }
    	
    @POST
    @Path("/combinacion/")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<SustanciasVO> sustancias(){
    	
    	
    	return actividadService.sustancias();
    	
    }
	
    @POST
    @Path("/insertcita/")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CommonResponse citas(CitasVO params){
    	if(LOG.isDebugEnabled()){
    		LOG.debug("Mensaje con log");
    		LOG.debug(params.getIdConsulta());
    		LOG.debug(params.getFecha());
    		LOG.debug(params.getCosto());
    		LOG.debug(params.getHora_consulta());
    		LOG.debug(params.getIdHomeopata());
    		LOG.debug(params.getIdMedico());
    		LOG.debug(params.getIdPaciente());
    		
    	}
    	CommonResponse respuesta = new CommonResponse();
    	
    	try{
    		actividadService.insertCitas(params);
    		respuesta.setMensaje("Datos Insertados");
    		respuesta.setSuccess(true);
    	}catch(Exception e){
    		respuesta.setErrorMensaje("Datos erroneos");
    		respuesta.setSuccess(false);
    	}
    	
    	return respuesta;
    	
    	
    	
    }
    
    @POST
    @Path("/updatecita/")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CommonResponse updateCitas(CitasVO params){
    	if(LOG.isDebugEnabled()){
    		LOG.debug("Mensaje con log");
    		LOG.debug(params.getIdConsulta());
    		LOG.debug(params.getFecha());
    		LOG.debug(params.getCosto());
    		LOG.debug(params.getHora_consulta());
    		LOG.debug(params.getIdHomeopata());
    		LOG.debug(params.getIdMedico());
    		LOG.debug(params.getIdPaciente());
    		
    	}
    	CommonResponse respuesta = new CommonResponse();
    	
    	try{
    		actividadService.updateCitas(params);
        	respuesta.setMensaje("Datos Insertados");
    		respuesta.setSuccess(true);
    	}catch(Exception e){
    		respuesta.setErrorMensaje("Datos erroneos");
    		respuesta.setSuccess(false);
    	}
    	
    	return respuesta;
    	
    }
    
    
    @POST
    @Path("/citas/")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<CitasVO> citas(){
    	
    	
    	return actividadService.citas();
    	
    }
	
   	public ActividadServiceImpl getActividadService() {
		return actividadService;
	}

	public void setActividadService(ActividadServiceImpl actividadService) {
		this.actividadService = actividadService;
	}


}
