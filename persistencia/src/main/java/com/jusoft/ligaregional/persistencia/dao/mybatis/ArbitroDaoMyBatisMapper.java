package com.jusoft.ligaregional.persistencia.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.jusoft.ligaregional.persistencia.modelo.Arbitro;

public interface ArbitroDaoMyBatisMapper extends AbstractDaoMyBatisMapper<Arbitro, Long>{

	public static final String INSERT_ARBITRO = "insert into Arbitros " +
			"(nombre, apellido1, apellido2, dni, calle, ciudad, provincia, codigo_postal, numero_colegiado) " +
			"values " +
			"(#{persona.nombre},#{persona.apellido1},#{persona.apellido2},#{persona.dni}," +
			"#{direccion.calle},#{direccion.ciudad},#{direccion.provincia},#{direccion.codigoPostal},#{numeroColegiado})";
	public static final String SELECT_ARBITRO = "select a.* " +
			"from Arbitros a where arbitro_id = #{identificador}";
	public static final String UPDATE_ARBITRO = "update Arbitros " +
			"set nombre = #{persona.nombre}, apellido1 = #{persona.apellido1}, apellido2 = #{persona.apellido2}, " +
			"dni = #{persona.dni}, calle = #{direccion.calle}, ciudad = #{direccion.ciudad}, provincia = #{direccion.provincia}, " +
			"codigo_postal = #{direccion.codigoPostal}, numero_colegiado = #{numeroColegiado} " +
			"where arbitro_id = #{id}";
	public static final String DELETE_ARBITRO = "delete from Arbitros where arbitro_id = #{id}";
	public static final String SELECT_ALL = "select * from Arbitros";

	@Options(useGeneratedKeys = true)
	@Insert(INSERT_ARBITRO)
	@Override
	int guardar(Arbitro arbitro);
	
	@Select(SELECT_ARBITRO)
	@Results(value = {
			@Result(column = "arbitro_id", property = "id"),
			@Result(column = "nombre", property = "persona.nombre"),
			@Result(column = "apellido1", property = "persona.apellido1"),
			@Result(column = "apellido2", property = "persona.apellido2"),
			@Result(column = "dni", property = "persona.dni"),
			@Result(column = "calle", property = "direccion.calle"),
			@Result(column = "ciudad", property = "direccion.ciudad"),
			@Result(column = "provincia", property = "direccion.provincia"),
			@Result(column = "codigo_postal", property = "direccion.codigoPostal"),
			@Result(column = "numero_colegiado", property = "numeroColegiado")
			})
	@Override
	Arbitro cargar(Long identificador);

	@Update(UPDATE_ARBITRO)
	@Override
	void actualizar(Arbitro arbitro);
	
	@Delete(DELETE_ARBITRO)
	@Override
	void borrar(Long id);
	
	@Select(SELECT_ALL)
	@Results(value = {
			@Result(column = "arbitro_id", property = "id"),
			@Result(column = "nombre", property = "persona.nombre"),
			@Result(column = "apellido1", property = "persona.apellido1"),
			@Result(column = "apellido2", property = "persona.apellido2"),
			@Result(column = "dni", property = "persona.dni"),
			@Result(column = "calle", property = "direccion.calle"),
			@Result(column = "ciudad", property = "direccion.ciudad"),
			@Result(column = "provincia", property = "direccion.provincia"),
			@Result(column = "codigo_postal", property = "direccion.codigoPostal"),
			@Result(column = "numero_colegiado", property = "numeroColegiado")
			})
	@Override
	List<Arbitro> obtenerTodos();
}
