package com.jusoft.ligaregional.persistencia.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.jusoft.ligaregional.persistencia.modelo.Jugador;

public interface JugadorDaoMyBatisMapper extends AbstractDaoMyBatisMapper<Jugador, Long>{

	public static final String INSERT_JUGADOR = "insert into Jugadores " +
			"(nombre, apellido1, apellido2, dni, temporada, equipo, capitan) " +
			"values (#{persona.nombre},#{persona.apellido1},#{persona.apellido2}," +
			"#{persona.dni},#{temporada.id},#{equipo.id},#{capitan})";
	public static final String SELECT_JUGADOR = "select a.* " +
			"from Jugadores a where jugador_id = #{identificador}";
	public static final String UPDATE_JUGADOR = "update Jugadores " +
			"set nombre = #{persona.nombre}, apellido1 = #{persona.apellido1}, apellido2 = #{persona.apellido2}," +
			"dni = #{persona.dni}, temporada = #{temporada.id}, equipo = #{equipo.id}, capitan = #{capitan} " +
			"where jugador_id = #{id}";
	public static final String DELETE_JUGADOR = "delete from Jugadores where jugador_id = #{id}";
	public static final String SELECT_ALL = "select * from Jugadores";

	@Options(useGeneratedKeys = true)
	@Insert(INSERT_JUGADOR)
	@Override
	int guardar(Jugador jugador);
	
	@Select(SELECT_JUGADOR)
	@Results(value = {
			@Result(column = "jugador_id", property = "id"),
			@Result(column = "nombre", property = "persona.nombre"),
			@Result(column = "apellido1", property = "persona.apellido1"),
			@Result(column = "apellido2", property = "persona.apellido2"),
			@Result(column = "dni", property = "persona.dni"),
			@Result(column = "equipo", property = "equipo.id"),
			@Result(column = "temporada", property = "temporada.id"),
			@Result(column = "capitan", property = "capitan")
			})
	@Override
	Jugador cargar(Long identificador);

	@Update(UPDATE_JUGADOR)
	@Override
	void actualizar(Jugador jugador);
	
	@Delete(DELETE_JUGADOR)
	@Override
	void borrar(Long id);
	
	@Select(SELECT_ALL)
	@Results(value = {
			@Result(column = "jugador_id", property = "id"),
			@Result(column = "nombre", property = "persona.nombre"),
			@Result(column = "apellido1", property = "persona.apellido1"),
			@Result(column = "apellido2", property = "persona.apellido2"),
			@Result(column = "dni", property = "persona.dni"),
			@Result(column = "equipo", property = "equipo.id"),
			@Result(column = "temporada", property = "temporada.id"),
			@Result(column = "capitan", property = "capitan")
			})
	@Override
	List<Jugador> obtenerTodos();
}
