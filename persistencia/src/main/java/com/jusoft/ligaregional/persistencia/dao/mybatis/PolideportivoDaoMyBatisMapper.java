package com.jusoft.ligaregional.persistencia.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.jusoft.ligaregional.persistencia.modelo.Polideportivo;

public interface PolideportivoDaoMyBatisMapper extends AbstractDaoMyBatisMapper<Polideportivo, Long>{

	public static final String INSERT_POLIDEPORTIVO = "insert into Polideportivos " +
			"(nombre, calle, ciudad, provincia, codigo_postal, campos_disponibles) " +
			"values (#{nombre},#{direccion.calle},#{direccion.ciudad}," +
			"#{direccion.provincia},#{direccion.codigoPostal},#{camposDisponibles})";
	public static final String SELECT_POLIDEPORTIVO = "select a.* " +
			"from Polideportivos a where polideportivo_id = #{identificador}";
	public static final String UPDATE_POLIDEPORTIVO = "update Polideportivos " +
			"set nombre = #{nombre}, calle = #{direccion.calle}, ciudad = #{direccion.ciudad}," +
			"provincia = #{direccion.provincia}, codigo_postal = #{direccion.codigoPostal}, " +
			"campos_disponibles = #{camposDisponibles} " +
			"where polideportivo_id = #{id}";
	public static final String DELETE_POLIDEPORTIVO = "delete from Polideportivos where polideportivo_id = #{id}";
	public static final String SELECT_ALL = "select * from Polideportivos";

	@Options(useGeneratedKeys = true)
	@Insert(INSERT_POLIDEPORTIVO)
	@Override
	int guardar(Polideportivo partido);
	
	@Select(SELECT_POLIDEPORTIVO)
	@Results(value = {
			@Result(column = "polideportivo_id", property = "id"),
			@Result(column = "calle", property = "direccion.calle"),
			@Result(column = "ciudad", property = "direccion.ciudad"),
			@Result(column = "provincia", property = "direccion.provincia"),
			@Result(column = "codigo_postal", property = "direccion.codigoPostal"),
			@Result(column = "campos_disponibles", property = "camposDisponibles")
			})
	@Override
	Polideportivo cargar(Long identificador);

	@Update(UPDATE_POLIDEPORTIVO)
	@Override
	void actualizar(Polideportivo partido);
	
	@Delete(DELETE_POLIDEPORTIVO)
	@Override
	void borrar(Long id);
	
	@Select(SELECT_ALL)
	@Results(value = {
			@Result(column = "polideportivo_id", property = "id"),
			@Result(column = "calle", property = "direccion.calle"),
			@Result(column = "ciudad", property = "direccion.ciudad"),
			@Result(column = "provincia", property = "direccion.provincia"),
			@Result(column = "codigo_postal", property = "direccion.codigoPostal"),
			@Result(column = "campos_disponibles", property = "camposDisponibles")
			})
	@Override
	List<Polideportivo> obtenerTodos();
}
