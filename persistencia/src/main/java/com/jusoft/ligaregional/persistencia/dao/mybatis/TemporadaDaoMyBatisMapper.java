package com.jusoft.ligaregional.persistencia.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.jusoft.ligaregional.persistencia.modelo.Temporada;

public interface TemporadaDaoMyBatisMapper extends AbstractDaoMyBatisMapper<Temporada, Long>{

	public static final String INSERT_TEMPORADA = "insert into Temporadas " +
			"(fecha_inicio, fecha_fin) " +
			"values (#{fechaInicio},#{fechaFin})";
	public static final String SELECT_TEMPORADA = "select a.* " +
			"from Temporadas a where temporada_id = #{identificador}";
	public static final String UPDATE_TEMPORADA = "update Temporadas " +
			"set fecha_inicio = #{fechaInicio}, fecha_fin = #{fechaFin} " +
			"where temporada_id = #{id}";
	public static final String DELETE_TEMPORADA = "delete from Temporadas where temporada_id = #{id}";
	public static final String SELECT_ALL = "select * from Temporadas";

	@Options(useGeneratedKeys = true)
	@Insert(INSERT_TEMPORADA)
	@Override
	int guardar(Temporada temporada);
	
	@Select(SELECT_TEMPORADA)
	@Results(value = {
			@Result(column = "temporada_id", property = "id"),
			@Result(column = "fecha_inicio", property = "fechaInicio"),
			@Result(column = "fecha_fin", property = "fechaFin")
			})
	@Override
	Temporada cargar(Long identificador);

	@Update(UPDATE_TEMPORADA)
	@Override
	void actualizar(Temporada temporada);
	
	@Delete(DELETE_TEMPORADA)
	@Override
	void borrar(Long id);

	@Select(SELECT_ALL)
	@Results(value = {
			@Result(column = "temporada_id", property = "id"),
			@Result(column = "fecha_inicio", property = "fechaInicio"),
			@Result(column = "fecha_fin", property = "fechaFin")
			})
	@Override
	List<Temporada> obtenerTodos();
	
}
