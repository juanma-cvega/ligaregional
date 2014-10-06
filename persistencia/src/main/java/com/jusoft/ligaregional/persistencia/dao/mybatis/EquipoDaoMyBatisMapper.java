package com.jusoft.ligaregional.persistencia.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.jusoft.ligaregional.persistencia.modelo.Equipo;

public interface EquipoDaoMyBatisMapper extends AbstractDaoMyBatisMapper<Equipo, Long>{

	public static final String INSERT_EQUIPO = "insert into Equipos " +
			"(nombre, temporada) " +
			"values (#{nombre},#{temporada.id})";
	public static final String SELECT_EQUIPO = "select a.* " +
			"from Equipos a where equipo_id = #{identificador}";
	public static final String UPDATE_EQUIPO = "update Equipos " +
			"set nombre = #{nombre}, temporada = #{temporada.id} " +
			"where equipo_id = #{id}";
	public static final String DELETE_EQUIPO = "delete from Equipos where equipo_id = #{id}";
	public static final String SELECT_ALL = "select * from Equipos";

	@Options(useGeneratedKeys = true)
	@Insert(INSERT_EQUIPO)
	@Override
	int guardar(Equipo equipo);
	
	@Select(SELECT_EQUIPO)
	@Results(value = {
			@Result(column = "equipo_id", property = "id"),
			@Result(column = "nombre", property = "nombre"),
			@Result(column = "temporada", property = "temporada.id")
			})
	@Override
	Equipo cargar(Long identificador);

	@Update(UPDATE_EQUIPO)
	@Override
	void actualizar(Equipo equipo);
	
	@Delete(DELETE_EQUIPO)
	@Override
	void borrar(Long id);
	
	@Select(SELECT_ALL)
	@Results(value = {
			@Result(column = "equipo_id", property = "id"),
			@Result(column = "nombre", property = "nombre"),
			@Result(column = "temporada", property = "temporada.id")
			})
	@Override
	List<Equipo> obtenerTodos();
}
