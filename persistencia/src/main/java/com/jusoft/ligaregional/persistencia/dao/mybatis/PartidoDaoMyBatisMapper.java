package com.jusoft.ligaregional.persistencia.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.jusoft.ligaregional.persistencia.modelo.Partido;

public interface PartidoDaoMyBatisMapper extends AbstractDaoMyBatisMapper<Partido, Long>{

	public static final String INSERT_PARTIDO = "insert into Partidos " +
			"(arbitro, local, visitante, fecha, temporada, polideportivo) " +
			"values (#{arbitro.id},#{local.id},#{visitante.id}," +
			"#{fecha},#{temporada.id},#{polideportivo.id})";
	public static final String SELECT_PARTIDO = "select a.* " +
			"from Partidos a where partido_id = #{identificador}";
	public static final String UPDATE_PARTIDO = "update Partidos " +
			"set arbitro = #{arbitro.id}, local = #{local.id}, visitante = #{visitante.id}, " +
			"fecha = #{fecha}, temporada = #{temporada.id}, polideportivo = #{polideportivo.id} " +
			"where partido_id = #{id}";
	public static final String DELETE_PARTIDO = "delete from Partidos where partido_id = #{id}";
	public static final String SELECT_ALL = "select * from Partidos";

	@Options(useGeneratedKeys = true)
	@Insert(INSERT_PARTIDO)
	@Override
	int guardar(Partido partido);
	
	@Select(SELECT_PARTIDO)
	@Results(value = {
			@Result(column = "partido_id", property = "id"),
			@Result(column = "arbitro", property = "arbitro.id"),
			@Result(column = "local", property = "local.id"),
			@Result(column = "visitante", property = "visitante.id"),
			@Result(column = "fecha", property = "fecha"),
			@Result(column = "temporada", property = "temporada.id"),
			@Result(column = "polideportivo", property = "polideportivo.id"),
			@Result(column = "capitan", property = "capitan")
			})
	@Override
	Partido cargar(Long identificador);

	@Update(UPDATE_PARTIDO)
	@Override
	void actualizar(Partido partido);
	
	@Delete(DELETE_PARTIDO)
	@Override
	void borrar(Long id);
	
	@Select(SELECT_ALL)
	@Results(value = {
			@Result(column = "partido_id", property = "id"),
			@Result(column = "arbitro", property = "arbitro.id"),
			@Result(column = "local", property = "local.id"),
			@Result(column = "visitante", property = "visitante.id"),
			@Result(column = "fecha", property = "fecha"),
			@Result(column = "temporada", property = "temporada.id"),
			@Result(column = "polideportivo", property = "polideportivo.id"),
			@Result(column = "capitan", property = "capitan")
			})
	@Override
	List<Partido> obtenerTodos();
}
