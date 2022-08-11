package reto5.controller;

import java.sql.SQLException;
import java.util.List;

import reto5.model.dao.ComprasDao;
import reto5.model.dao.ListaLideresDao;
import reto5.model.dao.ProyectosDao;
import reto5.model.vo.ComprasVo;
import reto5.model.vo.ListaLideresVo;
import reto5.model.vo.ProyectosVo;

//Clase que se encarga de recibir las consultas y enviarlas a la clase encargada de dibujar la ventana, para mostrar sus datos
public class ReportesController {
    private ProyectosDao proyectosDao;
    private ComprasDao comprasDao;
    private ListaLideresDao listaLideresDao;

    public ReportesController(){
        proyectosDao = new ProyectosDao();
        comprasDao = new ComprasDao();
        listaLideresDao = new ListaLideresDao();
    }

    public List<ListaLideresVo> listarLideres() throws SQLException{
        return listaLideresDao.listar();
    }

    public List<ProyectosVo> listarProyectos() throws SQLException{
        return proyectosDao.listar();
    }

    public List<ComprasVo> listarCompras() throws SQLException{
        return comprasDao.listar();
    }    
}

